package com.christian.togstudyapp.ui.tasks.TapPairTask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.christian.togstudyapp.Utils.InjectionSelector;
import com.christian.togstudyapp.databinding.ActivityTapPairBinding;
import com.christian.togstudyapp.databinding.TasksProgressBarBinding;
import com.christian.togstudyapp.ui.activity.lessonlistactivity.LessonListActivity;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.christian.togstudyapp.Data.Repository;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.ui.tasks.CustomWord;
import com.christian.togstudyapp.R;
import com.christian.togstudyapp.Utils.ActivityNavigation;
import com.christian.togstudyapp.Utils.Injection;

/**
 * Created by Rick on 3/3/2018.
 */

public class TapPairActivity extends AppCompatActivity{

    private static final String TAG = "TapPairActivity";

    private ActivityTapPairBinding binding;

    ArrayList<PairModel> pairs;
    ArrayList<CustomWord> compareWords = new ArrayList<>();

    boolean searchingPair = false;

    CustomWord customWord;

    int progressBarValue;
    int pairsFormed;
    int randomN;

    Context context = TapPairActivity.this;

    Random random = new Random();

    Repository repository;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTapPairBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Log.d("look here! ",  String.valueOf(InjectionSelector.repo));

        initData();
    }

    private void initData() {

        binding.checkButton.setEnabled(false);

        repository = Injection.provideRepository(InjectionSelector.repo);


        pairs = repository.getPairs();

        Hawk.init(this).build();

        progressBarValue = 0;

        if (Hawk.get("progressBarValue") != null) {

            progressBarValue = Hawk.get("progressBarValue");

            binding.taskProgressBar.setProgress(progressBarValue);
        }

        randomizePair();

        checkButtonListener();
    }

    private void randomizePair() {

        int randomIndex1;
        int randomIndex2;

        //We can use map here as well but it was hard to make it work as I wanted

        Collections.shuffle(pairs);

        randomN = random.nextInt(3) + 4;

        for (int i = 0; i < randomN; i++) {

            PairModel pair = pairs.get(i);

            String pair1 = pair.getPair1();
            String pair2 = pair.getPair2();

            CustomWord customWord1 = new CustomWord(this, pair1);
            CustomWord customWord2 = new CustomWord(this, pair2);

            customWord1.setTag(i);
            customWord2.setTag(i);

            customWord1.setOnTouchListener(new TouchListener());
            customWord2.setOnTouchListener(new TouchListener());

            if (binding.flowLayout.getChildCount() != 0) {

                randomIndex1 = random.nextInt(binding.flowLayout.getChildCount());
                randomIndex2 = random.nextInt(binding.flowLayout.getChildCount());

                binding.flowLayout.addView(customWord1, randomIndex1);
                binding.flowLayout.addView(customWord2, randomIndex2);

            } else {

                binding.flowLayout.addView(customWord1);
                binding.flowLayout.addView(customWord2);
            }
        }
    }

    private class TouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            customWord = (CustomWord) view;

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                if (!isSearchingPair()) {

                    compareWords.add(customWord);

                    view.setBackground(getDrawable(R.drawable.custom_word_selected));

                    setSearchingPair(true);

                } else {

                    CustomWord previousWord = compareWords.get(0);

                    if (previousWord != view) {

                        if (previousWord.getTag() == view.getTag()) {

                            Toast.makeText(TapPairActivity.this, "Correct Pair", Toast.LENGTH_SHORT).show();

                            previousWord.setEnabled(false);
                            view.setEnabled(false);

                            previousWord.setBackground(getDrawable(R.drawable.custom_word_border));
                            previousWord.setTextColor(ContextCompat.getColor(context, R.color.grey_button));

                            view.setBackground(getDrawable(R.drawable.custom_word_border));
                            customWord.setTextColor(ContextCompat.getColor(context, R.color.grey_button));

                            setSearchingPair(false);

                            compareWords.clear();

                            checkCompleteness();

                        } else {

                            Toast.makeText(TapPairActivity.this, "Wrong Pair", Toast.LENGTH_SHORT).show();

                            previousWord.setBackground(getDrawable(R.drawable.custom_word_border));
                            view.setBackground(getDrawable(R.drawable.custom_word_border));

                            setSearchingPair(false);

                            compareWords.clear();
                        }

                    } else {

                        previousWord.setBackground(getDrawable(R.drawable.custom_word_border));
                        view.setBackground(getDrawable(R.drawable.custom_word_border));

                        setSearchingPair(false);

                        compareWords.clear();
                    }
                }

                return true;
            }

            return false;
        }
    }

    private void checkButtonListener() {

        binding.checkButton.setOnClickListener(view -> {

            if (progressBarValue < 100) {

                ActivityNavigation.getInstance(context).takeToRandomTask();

            } else {

                progressBarValue = 0;

                Hawk.put("progressBarValue", progressBarValue);
            }
        });
    }

    private void checkCompleteness() {

        pairsFormed ++;

        if (pairsFormed == randomN) {

            Toast.makeText(TapPairActivity.this, "Congratulations, you found all pairs", Toast.LENGTH_SHORT).show();

            progressBarValue += 10;

            binding.taskProgressBar.setProgress(progressBarValue);

            Hawk.put("progressBarValue", progressBarValue);

            binding.checkButton.setEnabled(true);
            binding.checkButton.setText("continue");
            binding.checkButton.setTextColor(ContextCompat.getColor(context, R.color.button_task_continue));
            binding.checkButton.setBackground(getDrawable(R.drawable.button_task_continue));
        }
    }

    public boolean isSearchingPair() {
        return searchingPair;
    }

    public void setSearchingPair(boolean searchingPair) {
        this.searchingPair = searchingPair;
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
