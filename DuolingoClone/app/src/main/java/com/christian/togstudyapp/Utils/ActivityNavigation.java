package com.christian.togstudyapp.Utils;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Random;

//import com.christian.togstudyapp.ui.activity.LessonCompletedActivity.LessonCompletedActivity;
import com.christian.togstudyapp.ui.tasks.TranslateSentenceTask.TSTaskActivity;
import com.christian.togstudyapp.ui.tasks.WordTask.WordTaskActivity;

/**
 * Created by Rick on 3/2/2018.
 */

public class ActivityNavigation {

    static ActivityNavigation INSTANCE;

    Context context;

    ArrayList<Class> activities = new ArrayList<>();

    Random random = new Random();

    public ActivityNavigation(Context context) {
        this.context = context;

        initData();
        takeToRandomTask();
    }

    public static ActivityNavigation getInstance(Context context) {

        if (INSTANCE == null) {

            INSTANCE = new ActivityNavigation(context);
        }

        return INSTANCE;
    }

    private void initData() {
        activities.add(WordTaskActivity.class);
        //activities.add(TSTaskActivity.class);
        //activities.add(TapPairActivity.class);
    }

    public void takeToRandomTask() {

        int randomIndex = random.nextInt(activities.size());

        Intent intent = new Intent(context, activities.get(randomIndex));
        context.startActivity(intent);
    }


  /*  public void lessonCompleted() {

        Intent intent = new Intent(context, LessonCompletedActivity.class);
        context.startActivity(intent);
    }*/
}
