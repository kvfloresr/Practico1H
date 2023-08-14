package com.example.practico1h;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ClimateViewModel extends ViewModel {
    private NetworkManager networkManager = new NetworkManager();
    private ScheduledExecutorService executorService;

    public void startFetchingClimateData() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                ClimateDataResponse response = networkManager.fetchClimateData();
                // Update UI or process the response as needed
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 60, TimeUnit.SECONDS);
    }

    public void stopFetchingClimateData() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}