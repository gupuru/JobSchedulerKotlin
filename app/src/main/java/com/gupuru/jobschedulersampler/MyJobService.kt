package com.gupuru.jobschedulersampler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

/**
 * JobService
 */
class MyJobService : JobService() {

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("MyJobService", "onStartJob")
        val mJobParam = p0
        Thread(Runnable {
            try {
                Log.d("MyJobService", "sleep")
                Thread.sleep(10000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            Log.d("MyJobService", "jobFinished")
            jobFinished(mJobParam, false)
        }).start()

        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        jobFinished(p0, false)
        return false
    }

}