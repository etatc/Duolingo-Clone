package com.christian.togstudyapp.ui.activity.lessonlistactivity

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.christian.togstudyapp.Data.Repository
import com.christian.togstudyapp.R
import com.christian.togstudyapp.Utils.ActivityNavigation
import com.christian.togstudyapp.Utils.InjectionSelector
import com.christian.togstudyapp.databinding.ActivityLessonListBinding

class LessonListActivity: AppCompatActivity() {

    lateinit var repository: Repository

    private lateinit var binding: ActivityLessonListBinding;

    //val handler = Looper.getMainLooper()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            com.christian.togstudyapp.databinding.ActivityLessonListBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.empty_view)
        }

        Log.d("look here! ", InjectionSelector.repo.toString());
        initData()
    }

    private fun initData() {
        binding.basicBar.setOnClickListener {
            InjectionSelector.repo = 1;
            ActivityNavigation(this)::class.java

        }
        binding.phrasesBar.setOnClickListener {
            InjectionSelector.repo = 2;
            ActivityNavigation(this)::class.java;
        }

        binding.greetingBar.setOnClickListener {
            InjectionSelector.repo = 3;
            ActivityNavigation(this)::class.java;
        }

        binding.foodBar.setOnClickListener {
            InjectionSelector.repo = 4;
            ActivityNavigation(this)::class.java;
        }

        binding.animalBar.setOnClickListener {
            InjectionSelector.repo = 5;
            ActivityNavigation(this)::class.java;
        }

        binding.clothingBar.setOnClickListener {
            InjectionSelector.repo = 6;
            ActivityNavigation(this)::class.java;
        }
        binding.acoutramentsBar.setOnClickListener {
            InjectionSelector.repo = 7;
            ActivityNavigation(this)::class.java;
        }
        binding.brunchMenuBar.setOnClickListener {
            InjectionSelector.repo = 8;
            ActivityNavigation(this)::class.java;
        }
        binding.brunchMenuBar.setOnClickListener {
            InjectionSelector.repo = 9;
            ActivityNavigation(this)::class.java;
        }
        binding.lunchMenuBar.setOnClickListener {
            InjectionSelector.repo = 10;
            ActivityNavigation(this)::class.java;
        }
        binding.dinnerAppsBar.setOnClickListener {
            InjectionSelector.repo = 11;
            ActivityNavigation(this)::class.java;
        }
        binding.entreesBar.setOnClickListener {
            InjectionSelector.repo = 12;
            ActivityNavigation(this)::class.java;
        }
        binding.sidesMenuBar.setOnClickListener {
            InjectionSelector.repo = 13;
            ActivityNavigation(this)::class.java;
        }
        binding.acoutramentsMenuBar.setOnClickListener {
            InjectionSelector.repo = 14;
            ActivityNavigation(this)::class.java;
        }
        binding.mainAlcoholsBar.setOnClickListener {
            InjectionSelector.repo = 15;
            ActivityNavigation(this)::class.java;
        }
    }
}
