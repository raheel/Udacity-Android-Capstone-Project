package com.datarak.vehiclemaintenancereminder.injection;

import com.datarak.vehiclemaintenancereminder.api.EdmundsApiService;

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
public class NetworkModule {
    public static final HttpUrl IMGUR_API_URL = HttpUrl.parse("https://developer.edmunds.com");

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder =   new OkHttpClient.Builder();
        builder
                .addInterceptor(loggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

        return builder.build();
    }

    @Provides
    @Singleton
    EdmundsApiService provideEdmundsApiService(HttpUrl imgurBaseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(imgurBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(EdmundsApiService.class);
    }


}
