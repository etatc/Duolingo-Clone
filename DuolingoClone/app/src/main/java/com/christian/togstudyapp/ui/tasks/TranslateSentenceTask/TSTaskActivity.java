package com.christian.togstudyapp.ui.tasks.TranslateSentenceTask;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.christian.togstudyapp.Utils.InjectionSelector;
import com.christian.togstudyapp.databinding.TranslateSentenceActivityBinding;
import com.christian.togstudyapp.ui.activity.lessonlistactivity.LessonListActivity;
import com.orhanobut.hawk.Hawk;

import com.christian.togstudyapp.Data.Repository;
import com.christian.togstudyapp.R;
import com.christian.togstudyapp.Model.QuestionModel;
import com.christian.togstudyapp.Utils.ActivityNavigation;
import com.christian.togstudyapp.Utils.Injection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rick on 3/2/2018.
 */

public class TSTaskActivity extends AppCompatActivity{

    private TranslateSentenceActivityBinding binding;

    QuestionModel questionModel;

    int progressBarValue;

    Repository repository;

    Context context = TSTaskActivity.this;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TranslateSentenceActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.empty_view));
        }

        initData();
    }


    private void initData() {

        binding.closeTask.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onBackPressed();
            }
        });

        binding.checkButton.setEnabled(false);

        repository = Injection.provideRepository(InjectionSelector.repo);

        questionModel = repository.getRandomQuestionObj();

        progressBarValue = 0;

        Hawk.init(this).build();

        if (Hawk.get("progressBarValue") != null) {

            progressBarValue = Hawk.get("progressBarValue");

            binding.taskProgressBar.setProgress(progressBarValue);
        }

        binding.question.setText(questionModel.getQuestion());

        checkAnswer();
        continueOn();
        enableButton();
    }





    private void checkAnswer() {

        binding.checkButton.setOnClickListener(view -> {

            String userAnswer = binding.userAnswer.getText().toString();
            List<String> alpha = new ArrayList<String>();
            List<String> beta = new ArrayList<String>();

            if (binding.checkButton.getText().equals("check")) {
                String[] gamma = new String[0];
                gamma = userAnswer.split(" ");
                String[] delta = new String[0];
                delta = questionModel.getAnswer().split(" ");

                for(int i=0; i< gamma.length; i++){
                    alpha.add(gamma[i]);
                }
                for(int i=0; i< delta.length; i++){
                    beta.add(delta[i]);
                }
                Collections.sort(alpha);
                Collections.sort(beta);

                Log.d("here", alpha.toString());
                Log.d("here too", beta.toString());

                //if (questionModel.getAnswer().toLowerCase().equals(userAnswer.toLowerCase())) {
                if (alpha.equals(beta)) {
                    binding.right.setText("You are correct!\n");
                    binding.answer.setText(questionModel.getAnswer() + "\n");
                    //Toast.makeText(context, "You Are Correct!", Toast.LENGTH_SHORT).show();

                    progressBarValue += 10;

                } else {

                    binding.right.setText("Not quite.\n");
                    binding.answer.setText(questionModel.getAnswer() + "\n");
                    //Toast.makeText(context, "That's not correct!" + questionModel.getAnswer(), Toast.LENGTH_SHORT).show();

                    if (progressBarValue > 10) {

                        progressBarValue -= 10;

                    } else {

                        progressBarValue = 0;
                    }

                }
                binding.taskProgressBar.setProgress(progressBarValue);
                Hawk.put("progressBarValue", progressBarValue);
                lockEditText();

                binding.checkButton.setVisibility(View.GONE);
                binding.answerPopup.setVisibility(View.VISIBLE);
                binding.continueButton.setText("continue");
                binding.continueButton.setBackground(getDrawable(R.drawable.button_task_continue));
                binding.continueButton.setTextColor(ContextCompat.getColor(context, R.color.button_task_continue));

            } /*else if (binding.checkButton.getText().equals("continue")) {

                if (progressBarValue < 100) {

                    ActivityNavigation.getInstance(context).takeToRandomTask();

                } else {

                    progressBarValue = 0;

                    Hawk.put("progressBarValue", progressBarValue);
                }

            }*/
        });
    }
    private void continueOn() {
        binding.continueButton.setOnClickListener(this::onClick2);
    }
    private void onClick2 (View view1) {
        if (binding.continueButton.getText().equals("continue")) {

            if (progressBarValue < 100) {

                ActivityNavigation.getInstance(context).takeToRandomTask();

            } else {

                progressBarValue = 0;

                //activityNavigation.lessonCompleted();

                Hawk.put("progressBarValue", progressBarValue);
            }
        }
    }

    private void lockEditText() {

        binding.userAnswer.setEnabled(false);
    }

    private void enableButton() {

        binding.userAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (i2 > 0) {

                    binding.checkButton.setBackground(getDrawable(R.drawable.button_task_continue));
                    binding.checkButton.setTextColor(ContextCompat.getColor(context, R.color.button_task_continue));

                    binding.checkButton.setEnabled(true);

                } else {

                    binding.checkButton.setBackground(getDrawable(R.drawable.button_task_check));
                    binding.checkButton.setTextColor(ContextCompat.getColor(context, R.color.button_task_check));

                    binding.checkButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        new MaterialDialog.Builder(this)
                .title("Are you sure about that?")
                .content("All progress in this lesson will be lost.")
                .positiveText("QUIT")
                .onPositive((dialog, which) -> {

                    progressBarValue = 0;

                    Hawk.put("progressBarValue", progressBarValue);

                    finish();
                })
                .negativeText("CANCEL")
                .show();
    }

    @Override
    protected void onStop() {

        progressBarValue = 0;

        Hawk.put("progressBarValue", progressBarValue);

        finish();

        super.onStop();
    }

}

