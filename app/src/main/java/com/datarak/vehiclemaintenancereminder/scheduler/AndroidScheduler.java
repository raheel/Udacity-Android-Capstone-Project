package com.datarak.vehiclemaintenancereminder.scheduler;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by raheel on 5/18/16.
 */
public class AndroidScheduler implements AppScheduler {

    @Inject
    public AndroidScheduler() {
    }

    @Override
    public Scheduler getNewThread() {
        return Schedulers.newThread();
    }

    @Override
    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }
}
