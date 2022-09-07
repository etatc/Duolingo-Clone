package com.christian.togstudyapp.ui.tasks.WordTask;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
//import com.christian.togstudyapp.Data.RepositoryMainAlcohols;
//import com.christian.togstudyapp.Utils.InjectionMainAlcohols;
import com.christian.togstudyapp.Utils.InjectionSelector;
import com.christian.togstudyapp.databinding.ActivityWordTaskBinding;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.christian.togstudyapp.Data.Repository;
import com.christian.togstudyapp.Model.QuestionModel;
import com.christian.togstudyapp.R;
import com.christian.togstudyapp.ui.tasks.CustomWord;
import com.christian.togstudyapp.Utils.ActivityNavigation;
import com.christian.togstudyapp.Utils.Injection;

public class WordTaskActivity extends AppCompatActivity {

    private static final String TAG = "WordTaskActivity";

    private ActivityWordTaskBinding binding;

    private CustomWord customWord;

    private CustomLayout customLayout;

    QuestionModel questionModel;

    ArrayList<String> words = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();

    Random random = new Random();

    int progressBarValue;

    Context context = WordTaskActivity.this;

    ActivityNavigation activityNavigation;

    Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWordTaskBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.empty_view));
        }

        initCustomLayout();
        initData();
    }

    private void onClick(View view) {

        StringBuilder answer = new StringBuilder();

        if (binding.checkButton.getText().equals("check")) {
            List<String> alpha = new ArrayList<String>();
            List<String> beta = new ArrayList<String>();
            List<String> delta = new ArrayList<String>();
            for (int i = 0; i < binding.sentenceLine.getChildCount(); i++) {

                customWord = (CustomWord) binding.sentenceLine.getChildAt(i);


                alpha.add(customWord.getText().toString());
                answer.append(customWord.getText().toString()).append(" ");
            }
            /*String[] split = questionModel.getAnswer().split( " ");
            for (int i = 0; i < questionModel.getAnswer().length(); i++){

            }
            beta.add(questionModel.getAnswer().split(" "));*/

            Collections.sort(alpha);
            //Collections.sort(beta);
            String[] gamma = new String[0];

            gamma = questionModel.getAnswer().split(" ");

            //gamma = beta.get(0).split("//s+", 1);
            //String[] epsilon = delta.split(" ");
            //delta.add(beta.get(0).split("//s+"));
            for (int i = 0; i < gamma.length; i++) {
                delta.add(gamma[i]);
            }

            Collections.sort(delta);

            Log.d("here", alpha.toString());
            Log.d("here too", delta.toString());

            //if (answer.toString().equals(questionModel.getAnswer() + " ")) {
            if (alpha.toString().equals(delta.toString())) {
                binding.uright.setText("You Said\n");
                binding.uanswer.setText(alpha.toString() + "\n");


                binding.right.setText("You are correct!\n");
                binding.answer.setText(questionModel.getAnswer() + "\n");
                //Toast.makeText(WordTaskActivity.this, "You Are Correct!", Toast.LENGTH_SHORT).show();

                progressBarValue += 10;

            } else {
                binding.uright.setText("You Said\n");
                binding.uanswer.setText(alpha.toString() + "\n");

                binding.right.setText("Not quite.\n");
                binding.answer.setText(questionModel.getAnswer() + "\n");
                //Toast.makeText(WordTaskActivity.this, "That's Not Correct. \n" + questionModel.getAnswer(), Toast.LENGTH_SHORT).show();

                if (progressBarValue > 10) {

                    progressBarValue -= 10;

                } else {

                    progressBarValue = 0;
                }

            }
            binding.taskProgressBar.setProgress(progressBarValue);
            Hawk.put("progressBarValue", progressBarValue);
            lockViews();

            binding.checkButton.setVisibility(View.GONE);
            binding.answerPopup.setVisibility(View.VISIBLE);
            binding.continueButton.setText("continue");
            binding.continueButton.setBackground(getDrawable(R.drawable.button_task_continue));
            binding.continueButton.setTextColor(ContextCompat.getColor(context, R.color.button_task_continue));

        }/* else if (binding.continueButton.getText().equals("continue")) {

            if (progressBarValue < 100) {

                activityNavigation.takeToRandomTask();

            } else {

                progressBarValue = 0;

                //activityNavigation.lessonCompleted();

                Hawk.put("progressBarValue", progressBarValue);
            }
        }*/

    }

    private void onClick2 (View view1) {
        if (binding.continueButton.getText().equals("continue")) {

            if (progressBarValue < 100) {

                activityNavigation.takeToRandomTask();

            } else {

                progressBarValue = 0;

                //activityNavigation.lessonCompleted();

                Hawk.put("progressBarValue", progressBarValue);
            }
        }
    }

    private class TouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN && !customLayout.empty()) {

                customWord = (CustomWord) view;
                customWord.goToViewGroup(customLayout, binding.sentenceLine);

                checkChildCount();

                return true;
            }

            return false;
        }
    }

    private void initData() {

        binding.closeTask.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onBackPressed();
            }
        });

        binding.checkButton.setEnabled(false);

        repository = Injection.provideRepository(InjectionSelector.repo);

        answers = repository.getAnswer();
        questionModel = repository.getRandomQuestionObj();

        Hawk.init(this).build();

        progressBarValue = 0;

        if (Hawk.get("progressBarValue") != null) {

            progressBarValue = Hawk.get("progressBarValue");

            binding.taskProgressBar.setProgress(progressBarValue);
        }

        binding.question.setText(questionModel.getQuestion());

        randomizeCustomWords();

        activityNavigation = ActivityNavigation.getInstance(this);

        checkAnswer();
        continueOn();
    }

    private void initCustomLayout() {

        customLayout = new CustomLayout(this);
        customLayout.setGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        binding.answerContainer.addView(customLayout, params);
    }


    private void sortAnswer(){
        List[] beta = {Collections.singletonList("what")};
        String[] alpha = {};
        int[] arr = {89,90,78,56};
        String[] arr2 = {"this","is", "a", "test"};
        if(arr != null) {
            Arrays.sort(arr);
            Arrays.sort(arr2);
            Arrays.sort(beta);
        }
    }

    private void checkAnswer() {



         binding.checkButton.setOnClickListener(this::onClick);
    }
    private void continueOn() {
        binding.continueButton.setOnClickListener(this::onClick2);
    }

    private void checkChildCount() {

        if (binding.sentenceLine.getChildCount() > 0) {

            binding.checkButton.setBackground(getDrawable(R.drawable.button_task_continue));
            binding.checkButton.setTextColor(ContextCompat.getColor(context, R.color.button_task_continue));

            binding.checkButton.setEnabled(true);

        } else {

            binding.checkButton.setBackground(getDrawable(R.drawable.button_task_check));
            binding.checkButton.setTextColor(ContextCompat.getColor(context, R.color.button_task_check));

            binding.checkButton.setEnabled(false);
        }
    }

    private void lockViews() {

        for (int i = 0; i < binding.sentenceLine.getChildCount(); i++) {

            customWord = (CustomWord) binding.sentenceLine.getChildAt(i);

            customWord.setEnabled(false);
        }

        for (int i = 0; i < customLayout.getChildCount(); i++) {

            customWord = (CustomWord) customLayout.getChildAt(i);

            customWord.setEnabled(false);
        }

    }

    private void randomizeCustomWords() {

        String[] wordsFromSentence = questionModel.getAnswer().split(" ");

        Collections.addAll(words, wordsFromSentence);

        int sentenceWordsCount = wordsFromSentence.length;

        //Declare how many words left to complete our layout
        int leftSize = sentenceWordsCount;

        //Pick a random number from "leftSize" and add 2
        int leftRandom = random.nextInt(leftSize) + 2;

        while (words.size() - leftSize < leftRandom) {

            addArrayWords();
        }

        Collections.shuffle(words);

        for (String word : words) {

            CustomWord customWord = new CustomWord(getApplicationContext(), word);

            customWord.setOnTouchListener(new TouchListener());

            customLayout.push(customWord);
        }
    }

    private void addArrayWords() {

        String[] wordsFromAnswerArray = answers.get(random.nextInt(answers.size())).split(" ");

        for (int i = 0; i < 2; i++) {

            String word = wordsFromAnswerArray[random.nextInt(wordsFromAnswerArray.length)];

            if (!words.contains(word)) {

                words.add(word);
            }
        }
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
