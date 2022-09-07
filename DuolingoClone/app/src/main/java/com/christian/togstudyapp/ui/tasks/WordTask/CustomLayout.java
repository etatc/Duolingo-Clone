package com.christian.togstudyapp.ui.tasks.WordTask;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.core.content.ContextCompat;

import com.nex3z.flowlayout.FlowLayout;

import java.util.ArrayList;

import com.christian.togstudyapp.ui.tasks.CustomWord;
import com.christian.togstudyapp.R;

/**
 * Created by Rick on 2/26/2018.
 */

public class CustomLayout extends FlowLayout {

    CustomWord customWord;

    private static final String TAG = "CustomLayout";

    private ArrayList<View> words = new ArrayList<>();

    public CustomLayout(Context context) {
        super(context);
    }

    public void push(View word) {

        words.add(word);

        addView(word);
    }

    public void removeViewCustomLayout(View view) {

        customWord = new CustomWord(getContext(), "");

        Context context1 = customWord.getContext();
        customWord.setBackgroundColor(ContextCompat.getColor(context1, R.color.empty_view));

        ScrollView.LayoutParams params = new ScrollView.LayoutParams(view.getWidth(), view.getHeight());

        params.setMargins(15, 15,15, 0);

        customWord.setLayoutParams(params);

        removeView(view);

        addView(customWord, words.indexOf(view));
    }

    public void addViewAt(View view) {

        if (getChildAt(words.indexOf(view)) != null) {

            removeViewAt(words.indexOf(view));
            addView(view, words.indexOf(view));

        } else {

            addView(view, getChildCount());
        }
    }

    public boolean empty() {
        return words.isEmpty();
    }
}
