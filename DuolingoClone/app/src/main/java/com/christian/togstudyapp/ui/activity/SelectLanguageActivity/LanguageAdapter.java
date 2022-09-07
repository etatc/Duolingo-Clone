package com.christian.togstudyapp.ui.activity.SelectLanguageActivity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.christian.togstudyapp.Data.Repository;
import com.christian.togstudyapp.databinding.SelectCourseItemBinding;
import com.christian.togstudyapp.ui.activity.PickDailyGoalActivity.PickDailyGoalActivity;
import com.christian.togstudyapp.R;
import com.christian.togstudyapp.Utils.Injection;

/**
 * Created by Rick on 3/8/2018.
 */

public class LanguageAdapter<language> extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    private SelectCourseItemBinding binding;

    private static final String TAG = "LanguageAdapter";

    String[] languages = {
            "Spanish", "Portuguese", "Swedish", "French",
            "German", "Chinese", "Japanese", "Korean", "Italian",
            "Dutch", "Irish", "Danish"};

    Repository repository;
    Context context;

    public LanguageAdapter(Context context) {

        repository = Injection.provideRepository(1);
        this.context = context;
    }

    @Override
    public LanguageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_course_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LanguageAdapter.ViewHolder holder, final int position) {

        final String language = languages[position];

        binding.language.setText(language);

        binding.mainItemLayout.setOnClickListener(v -> {

            //repository.setNewLanguage(language.toLowerCase());

            Intent intent = new Intent(context, PickDailyGoalActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return languages.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
