package com.example.firebasejobdispatcherdemo;

import android.app.job.JobParameters;
import android.os.AsyncTask;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobService;

public class MyService extends JobService {

    BackgroudTask backgroudTask;

    @Override
    public boolean onStartJob(final com.firebase.jobdispatcher.JobParameters job) {
        backgroudTask = new BackgroudTask() {

            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(getApplicationContext(), "Menssage from background Task: " + s, Toast.LENGTH_SHORT).show();
                jobFinished(job, false);
            }
        };

        backgroudTask.execute();

        return true;
    }

    @Override
    public boolean onStopJob(com.firebase.jobdispatcher.JobParameters job) {
        return true;
    }

    public static class BackgroudTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            return "Hello from background job";
        }
    }

}
