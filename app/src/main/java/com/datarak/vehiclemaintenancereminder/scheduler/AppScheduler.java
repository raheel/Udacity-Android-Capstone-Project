package com.datarak.vehiclemaintenancereminder.scheduler;

import rx.Scheduler;

/**c
 * Created by raheel on 5/18/16.
 */
public interface AppScheduler {
    Scheduler getNewThread();
    Scheduler getMainThread();
}
