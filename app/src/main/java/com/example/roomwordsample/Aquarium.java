package com.example.roomwordsample;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Aquarium {

    public Aquarium(final Application app,Lifecycle lifecycle) {
        lifecycle.addObserver(new LifecycleObserver() {

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public void start() {
                Toast.makeText(app, "LIGHTS ON", Toast.LENGTH_SHORT).show();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void stop(){
                Toast.makeText(app, "LIGHTS OFF", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
