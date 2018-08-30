package com.evon.sample.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.evon.sample.R;
import com.evon.sample.view_model.AddViewModel;
import com.evon.sample.room_database.entity.Model;

/**
 * The type Add activity.
 */
public class AddActivity extends AppCompatActivity {

    private EditText itemEditText;
    private EditText nameEditText;
    private AddViewModel addViewModel;
    private CoordinatorLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init();
    }

    /**
     * Setting up the activity UI
     */
    private void init() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        itemEditText = findViewById(R.id.itemName);
        nameEditText = findViewById(R.id.personName);
        mainLayout = findViewById(R.id.main);


        addViewModel = ViewModelProviders.of(this).get(AddViewModel.class);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemEditText.getText().toString().isEmpty() || nameEditText.getText().toString().isEmpty()) {
                    Snackbar.make(mainLayout, getString(R.string.missing_fields), Snackbar.LENGTH_LONG).show();
                } else {
                    addViewModel.addItem(new Model(itemEditText.getText().toString(), nameEditText.getText().toString()));
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
