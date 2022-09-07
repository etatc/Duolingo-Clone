/*package com.christian.togstudyapp.ui.activity.LessonCompletedActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.christian.togstudyapp.databinding.ActivityLessonCompletedBinding;
import com.christian.togstudyapp.databinding.WeekProgressBarBinding;
import com.orhanobut.hawk.Hawk;

import com.christian.togstudyapp.Data.Repository;
import com.christian.togstudyapp.ui.activity.lessonlistactivity.LessonListActivity;
import com.christian.togstudyapp.Utils.Injection;
*/
/**
 * Created by Rick on 3/4/2018.
 */
/*
public class LessonCompletedActivity extends AppCompatActivity{

    private ActivityLessonCompletedBinding binding;
    private WeekProgressBarBinding binding1;

    Repository repository;

    int mondayProgress,
            tuesdayProgress,
            wednesdayProgress,
            thursdayProgress,
            fridayProgress,
            saturdayProgress,
            sundayProgress;

    int dailyGoal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonCompletedBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initData();
    }

    private void initData() {

        Hawk.init(this).build();

        repository = Injection.provideRepository(1);

        dailyGoal = Hawk.get("dailyGoal");

        binding.continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LessonCompletedActivity.this, LessonListActivity.class);
                startActivity(intent);
            }
        });

        setupProgressBar();
        setupWeekBar();
    }

    private void setupProgressBar() {

        int dailyXp;

        String lesson = Hawk.get("lesson");

        repository.setLessonComplete(lesson, true);
        repository.getWeekXp();

        if (Hawk.get("dailyXp") != null) {

            dailyXp = Hawk.get("dailyXp");

            dailyXp += 10;

            Hawk.put("dailyXp", dailyXp);
            repository.setDailyXp(dailyXp);

        } else {

            dailyXp = 10;

            Hawk.put("dailyXp", dailyXp);
            repository.setDailyXp(dailyXp);
        }

        binding.userProgressBar.setMax(dailyGoal);
        binding.userProgressBar.setProgressWithAnimation(dailyXp, 2000);
    }

    private void setupWeekBar() {

        if (Hawk.get("mondayXp") != null) {
            mondayProgress = (int) Hawk.get("mondayXp");
        } else {
            mondayProgress = 0;
        }
        if (Hawk.get("tuesdayXp") != null) {
            tuesdayProgress = (int) Hawk.get("tuesdayXp");
        } else {
            tuesdayProgress = 0;
        }
        if (Hawk.get("wednesdayXp") != null) {
            wednesdayProgress = (int) Hawk.get("wednesdayXp");
        } else {
            wednesdayProgress = 0;
        }
        if (Hawk.get("thursdayXp") != null) {
            thursdayProgress = (int) Hawk.get("thursdayXp");
        } else {
            thursdayProgress = 0;
        }
        if (Hawk.get("fridayXp") != null) {
            fridayProgress = (int) Hawk.get("fridayXp");
        } else {
            fridayProgress = 0;
        }
        if (Hawk.get("saturdayXp") != null) {
            saturdayProgress = (int) Hawk.get("saturdayXp");
        } else {
            saturdayProgress = 0;
        }
        if (Hawk.get("sundayXp") != null) {
            sundayProgress = (int) Hawk.get("sundayXp");
        } else {
            sundayProgress = 0;
        }

        binding1.mondayBar.setProgress(mondayProgress);
        binding1.tuesdayBar.setProgress(tuesdayProgress);
        binding1.wednesdayBar.setProgress(wednesdayProgress);
        binding1.thursdayBar.setProgress(thursdayProgress);
        binding1.fridayBar.setProgress(fridayProgress);
        binding1.saturdayBar.setProgress(saturdayProgress);
        binding1.sundayBar.setProgress(sundayProgress);

        binding1.mondayBar.setMax(dailyGoal);
        binding1.tuesdayBar.setMax(dailyGoal);
        binding1.wednesdayBar.setMax(dailyGoal);
        binding1.thursdayBar.setMax(dailyGoal);
        binding1.fridayBar.setMax(dailyGoal);
        binding1.saturdayBar.setMax(dailyGoal);
        binding1.sundayBar.setMax(dailyGoal);
    }
}
*/