package com.nhce.saloni.saloniproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.nhce.saloni.saloniproj.data.model.Movie;
import com.nhce.saloni.saloniproj.data.table.Movies;

import java.util.HashMap;
import java.util.stream.Collectors;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setListActivityObserver();

    }

    private void setListActivityObserver() {
        Movies.getInstance().datatableObservableSubject.subscribe(new Observer<HashMap<String, Movie>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(HashMap<String, Movie> movies) {
                ((TextView) findViewById(R.id.MovieDeals)).setText(
                        movies.keySet().stream().map(id -> movies.get(id).getTitle()).collect(Collectors.joining(", \n"))
                );
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
            }
        });
    }
}