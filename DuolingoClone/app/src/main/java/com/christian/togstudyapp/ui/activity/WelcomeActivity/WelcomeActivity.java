package com.christian.togstudyapp.ui.activity.WelcomeActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;


import com.christian.togstudyapp.databinding.ActivityWelcomeBinding;
import com.christian.togstudyapp.ui.activity.SelectLanguageActivity.SelectLanguageActivity;
import com.christian.togstudyapp.ui.activity.SignInActivity.SignInActivity;

/**
 * Created by Rick on 3/6/2018.
 */

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initData();
    }

    private void initData() {

        binding.getStartedButton.setOnClickListener(view -> goToGetStartedScreen());

        binding.logInLink.setOnClickListener(view -> goToSignInScreen());
    }

    private void goToSignInScreen() {

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    private void goToGetStartedScreen() {

        Intent intent = new Intent(this, SelectLanguageActivity.class);
        startActivity(intent);
    }
}
