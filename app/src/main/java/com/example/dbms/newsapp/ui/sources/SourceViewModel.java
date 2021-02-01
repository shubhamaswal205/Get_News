package com.example.dbms.newsapp.ui.sources;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.dbms.newsapp.data.NewsRepository;
import com.example.dbms.newsapp.models.Source;
import com.example.dbms.newsapp.models.Specification;

import java.util.List;

public class SourceViewModel extends AndroidViewModel {
    private final NewsRepository newsRepository;

    public SourceViewModel(@NonNull Application application) {
        super(application);
        this.newsRepository = NewsRepository.getInstance(application.getApplicationContext());
    }

    LiveData<List<Source>> getSource(Specification specification) {
        return newsRepository.getSources(specification);
    }
}
