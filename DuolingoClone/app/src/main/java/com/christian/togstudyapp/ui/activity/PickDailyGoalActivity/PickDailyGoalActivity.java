package com.christian.togstudyapp.ui.activity.PickDailyGoalActivity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

import com.christian.togstudyapp.Data.Repository;
import com.christian.togstudyapp.Utils.Injection;
import com.christian.togstudyapp.databinding.ActivityPickDailyGoalBinding;

/**
 * Created by Rick on 3/9/2018.
 */

public class PickDailyGoalActivity extends AppCompatActivity {

    private ActivityPickDailyGoalBinding binding;

    ArrayList<RadioButton> radioButtonArray = new ArrayList<>();

    int checkedButton;

    Repository repository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPickDailyGoalBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        repository = Injection.provideRepository(1);

        setRadioButton();
        binding.regularGoal.setChecked(true);

        continueListener();
    }

    private void setRadioButton() {

        radioButtonArray.add(binding.casualGoal);
        radioButtonArray.add(binding.regularGoal);
        radioButtonArray.add(binding.seriousGoal);
        radioButtonArray.add(binding.insaneGoal);

        for (int i = 0; i < radioButtonArray.size(); i++) {

            final int finalIndex = i;

            radioButtonArray.get(i).setOnClickListener(v -> {

                checkedButton = finalIndex;

                ArrayList<Integer> buttonIdx = new ArrayList<>();

                buttonIdx.add(0);
                buttonIdx.add(1);
                buttonIdx.add(2);
                buttonIdx.add(3);

                buttonIdx.remove(finalIndex);

                radioButtonArray.get(finalIndex).setChecked(true);

                for (int index : buttonIdx) {

                    radioButtonArray.get(index).setChecked(false);
                }
            });
        }
    }

    private void continueListener() {

        binding.continueButton.setOnClickListener(v -> {

            int dailyGoal;

            if(checkedButton == 3) dailyGoal = 50; else dailyGoal = (checkedButton + 1) * 10;

            //repository.setDailyGoal(dailyGoal);
        });
    }
}
