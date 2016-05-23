package com.datarak.vehiclemaintenancereminder.injection;

import android.content.Context;

import com.datarak.vehiclemaintenancereminder.Constants;
import com.datarak.vehiclemaintenancereminder.MaintenanceApp;
import com.datarak.vehiclemaintenancereminder.api.EdmundsApiService;
import com.datarak.vehiclemaintenancereminder.views.AddVehicleInfoFragment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raheel on 5/16/16.
 */
@Module
public class NetworkModule {
    public static final HttpUrl EDMUNDS_API_URL = HttpUrl.parse("https://api.edmunds.com");

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor requestParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                HttpUrl originalHttpUrl = originalRequest.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("fmt", "json")
                        .addQueryParameter("api_key", Constants.EDMUNDS_API_KEY)
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        .url(url)
                        .method(originalRequest.method(), originalRequest.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };


        OkHttpClient.Builder builder =   new OkHttpClient.Builder();
        builder
                .addInterceptor(requestParameterInterceptor)
                .addInterceptor(loggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

        return builder.build();
    }

    @Provides
    @Singleton
    EdmundsApiService provideEdmundsApiService(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(EDMUNDS_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(EdmundsApiService.class);
    }

    @Provides
    public Context provideContext() {
        return MaintenanceApp.getInstance().getApplicationContext();
    }
}
