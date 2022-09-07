package com.christian.togstudyapp.Utils;

import com.christian.togstudyapp.Data.Local.QuestionDataSourceAcoutramentsMenu;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceBruncMenu;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceBrunchAllergies;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceDinnerAppMenu;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceDinnerEntreeMenu;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceDinnerSidesMenu;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceHappyHourAllergies;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceAllergiesAcoutraments;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceDinnerAppAllergies;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceDinnerEntreeAllergies;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceDinnerSidesAllergies;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceHappyHourMenu;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceLunchAllergies;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceLunchMenu;
import com.christian.togstudyapp.Data.Local.QuestionDataSourceMainAlcohols;
//import com.christian.togstudyapp.Data.Remote.FirebaseDatabaseHelper;
import com.christian.togstudyapp.Data.Repository;

/**
 * Created by Rick on 3/6/2018.
 */

public class Injection {


    public static int repository;

    public static Repository provideRepository(int repository) {
        if (repository == 1) {
            return Repository.getInstance(
                    QuestionDataSourceBrunchAllergies.getInstance());
            //FirebaseDatabaseHelper.getHelperInstance());
        } else if (repository == 2) {
            return Repository.getInstance(
                    QuestionDataSourceHappyHourAllergies.getInstance());
        } else if(repository == 3) {
            return Repository.getInstance(
                    QuestionDataSourceLunchAllergies.getInstance());
        } else if(repository == 4) {
            return Repository.getInstance(
                    QuestionDataSourceDinnerAppAllergies.getInstance());
        }else if(repository == 5) {
            return Repository.getInstance(
                    QuestionDataSourceDinnerEntreeAllergies.getInstance());
        }else if(repository == 6) {
            return Repository.getInstance(
                    QuestionDataSourceDinnerSidesAllergies.getInstance());
        } else if(repository == 7) {
            return Repository.getInstance(
                    QuestionDataSourceAllergiesAcoutraments.getInstance());
        } else if(repository == 8) {
            return Repository.getInstance(
                    QuestionDataSourceBruncMenu.getInstance());
        } else if(repository == 9) {
            return Repository.getInstance(
                    QuestionDataSourceHappyHourMenu.getInstance());
        } else if(repository == 8) {
            return Repository.getInstance(
                    QuestionDataSourceLunchMenu.getInstance());
        }else if(repository == 11) {
            return Repository.getInstance(
                    QuestionDataSourceDinnerAppMenu.getInstance());
        }else if(repository == 12) {
            return Repository.getInstance(
                    QuestionDataSourceDinnerEntreeMenu.getInstance());
        }else if(repository == 13) {
            return Repository.getInstance(
                    QuestionDataSourceDinnerSidesMenu.getInstance());
        }else if(repository == 14) {
            return Repository.getInstance(
                    QuestionDataSourceAcoutramentsMenu.getInstance());
        } else if(repository == 15) {
            return Repository.getInstance(
                    QuestionDataSourceMainAlcohols.getInstance());
        }else {
            return null;
        }
    }
}
/*
    public static FirebaseAuthHelper providesAuthHelper() {

        return FirebaseAuthHelper.getClassInstance();
    }
}*/