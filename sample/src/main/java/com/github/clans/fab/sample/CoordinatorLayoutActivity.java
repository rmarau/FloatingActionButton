package com.github.clans.fab.sample;

import com.github.fab.sample.R;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Locale;

public class CoordinatorLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatorlayout_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.fab).setOnClickListener(this);
        findViewById(R.id.fab1).setOnClickListener(this);
        findViewById(R.id.fab2).setOnClickListener(this);
        findViewById(R.id.fab3).setOnClickListener(this);

        View.OnClickListener clickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.lorem_ipsum, Snackbar.LENGTH_SHORT).show();
            }
        };
        findViewById(R.id.faba).setOnClickListener(clickListener);
        findViewById(R.id.fabb).setOnClickListener(clickListener);
        findViewById(R.id.fabc).setOnClickListener(clickListener);
        findViewById(R.id.fabd).setOnClickListener(clickListener);
        findViewById(R.id.fabe).setOnClickListener(clickListener);
        findViewById(R.id.fabf).setOnClickListener(clickListener);

        Locale[] availableLocales = Locale.getAvailableLocales();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LanguageAdapter(availableLocales));
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, R.string.lorem_ipsum, Snackbar.LENGTH_SHORT).show();
    }

}
