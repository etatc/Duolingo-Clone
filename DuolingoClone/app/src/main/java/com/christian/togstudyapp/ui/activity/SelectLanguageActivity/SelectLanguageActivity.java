package com.christian.togstudyapp.ui.activity.SelectLanguageActivity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View;

import com.christian.togstudyapp.R;
import com.christian.togstudyapp.databinding.ActivitySelectCourseBinding;

/**
 * Created by Rick on 3/8/2018.
 */

public class SelectLanguageActivity extends AppCompatActivity {

    private ActivitySelectCourseBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectCourseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initData();
    }

    private void initData() {

        LanguageAdapter languageAdapter = new LanguageAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RvDividerItemDecoration itemDecoration = new RvDividerItemDecoration(getDrawable(R.drawable.recycler_view_divider));

        binding.recyclerView.setAdapter(languageAdapter);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.addItemDecoration(itemDecoration);

        binding.backButton.setOnClickListener(v -> onBackPressed());
    }
}
