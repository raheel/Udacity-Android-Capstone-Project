package com.datarak.vehiclemaintenancereminder.job;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * Created by raheel on 5/23/16.
 */
public class MaintenanceJobCreator implements JobCreator {
    @Override
    public Job create(String tag) {
        switch (tag) {
            case MaintenanceJob.TAG:
                return new MaintenanceJob();
            default:
                return null;
        }
    }
}
