package com.gupuru.jobschedulersampler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private val JOB_ID = 0x01
    private val JOB_SERVICE_NAME = ComponentName("com.gupuru.jobschedulersampler",
            "com.gupuru.jobschedulersampler.MyJobService")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_main.button_start.setOnClickListener {
            val scheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            val jobInfo = JobInfo.Builder(JOB_ID, JOB_SERVICE_NAME)
                    .setMinimumLatency(1000)
                    .setOverrideDeadline(60000)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .build()
            scheduler.schedule(jobInfo)
        }

    }

    override fun onStop() {
        super.onStop()
    }

}