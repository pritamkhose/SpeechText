package com.pritam.speechtext;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

public class MyApps extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // http://truelogic.org/wordpress/2016/04/23/how-to-send-app-crash-reports-in-android/
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//
//            @Override
//            public void uncaughtException(Thread thread, Throwable ex) {
//                handleUncaughtException(thread, ex);
//            }
//        });
    }

    public void handleUncaughtException (Thread thread, Throwable e)
    {
        String stackTrace = Log.getStackTraceString(e);
        String message = e.getMessage();

        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra (Intent.EXTRA_EMAIL, new String[] {"myemail@email.com"});
        intent.putExtra (Intent.EXTRA_SUBJECT, "MyApp Crash log file");
        intent.putExtra (Intent.EXTRA_TEXT, message +"\n\n"+stackTrace);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // required when starting from Application
        startActivity(intent);


    }


}
