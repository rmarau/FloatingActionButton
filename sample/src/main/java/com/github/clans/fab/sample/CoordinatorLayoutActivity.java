package com.github.clans.fab.sample;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.github.fab.sample.R;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;

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

        ((FloatingActionButton)findViewById(R.id.fab)).setShowAnimation(AnimationUtils.loadAnimation(this, R.anim.show_from_bottom));
        ((FloatingActionButton)findViewById(R.id.fab)).setHideAnimation(AnimationUtils.loadAnimation(this, R.anim.hide_to_bottom));

        ((FloatingActionMenu)findViewById(R.id.fam)).setMenuButtonShowAnimation(AnimationUtils.loadAnimation(this, R.anim.show_from_bottom));
        ((FloatingActionMenu)findViewById(R.id.fam)).setMenuButtonHideAnimation(AnimationUtils.loadAnimation(this, R.anim.hide_to_bottom));

        Locale[] availableLocales = Locale.getAvailableLocales();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LanguageAdapter(availableLocales));
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(findViewById(R.id.coordinator), R.string.lorem_ipsum, Snackbar.LENGTH_SHORT).show();
    }

}
