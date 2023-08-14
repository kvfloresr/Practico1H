package com.example.practico1h;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ejercicio10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej10);

        performTextSearch();
    }

    private void performTextSearch() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<String> documents = getSimulatedDocuments();
        String searchText = "Lorem";

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < documents.size(); i++) {
            final String document = documents.get(i);
            tasks.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return countOccurrences(document, searchText);
                }
            });
        }

        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            int totalOccurrences = 0;

            for (Future<Integer> future : futures) {
                totalOccurrences += future.get();
            }

            System.out.println("Total occurrences of '" + searchText + "': " + totalOccurrences);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private List<String> getSimulatedDocuments() {
        List<String> documents = new ArrayList<>();
        documents.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        documents.add("Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        documents.add("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.");
        return documents;
    }

    private int countOccurrences(String document, String searchText) {
        int count = 0;
        int index = document.indexOf(searchText);
        while (index != -1) {
            count++;
            index = document.indexOf(searchText, index + 1);
        }
        return count;
    }
}
