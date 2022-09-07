package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceDinnerEntreeAllergies implements DataSource.Local {

    private static QuestionDataSourceDinnerEntreeAllergies INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceDinnerEntreeAllergies getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceDinnerEntreeAllergies();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What's the allergins in the Maple Rub Ora King Salmon?");
        question.add("What's the allergins in the Free Range Chicken");
        question.add("What's the allergins in the Braised Beef Short Rib?");
        question.add("What's the allergins in the Main Lobster Linguini?");
        question.add("What's the allergins in the Mushroom & Truffle Tagliatelle?");
        question.add("What's the allergins in the Miso Glazed Chilean Sea Bass?");
        question.add("What's the allergins in the Roasted Lamb Rack");

        //Answer
        answer.add("Fish Garlic Alcohol(mirin)");
        answer.add("Dairy Garlic Alcohol");
        answer.add("Dairy Gluten Garlic Onion Alcohol");
        answer.add("Dairy Gluten Egg Shellfish Garlic Onion Alcohol");
        answer.add("Dairy Egg Gluten Garlic");
        answer.add("Gluten Fish Soy Onion Alcohol Sesame-Seed(togarashi)");
        answer.add("Dairy");
        int randomIndex = random.nextInt(question.size());

        questionModel = new QuestionModel(
                question.get(randomIndex),
                answer.get(randomIndex));

        return questionModel;
    }

    @Override
    public ArrayList<PairModel> getPairs() {

        ArrayList<PairModel> pairs = new ArrayList<>();

        pairs.add(new PairModel("manzanas", "apple"));
        pairs.add(new PairModel("leche", "milk"));
        pairs.add(new PairModel("bread", "pan"));
        pairs.add(new PairModel("boy", "nino"));
        pairs.add(new PairModel("ella", "she"));
        pairs.add(new PairModel("a", "un"));
        pairs.add(new PairModel("he", "el"));
        pairs.add(new PairModel("girl", "nina"));
        pairs.add(new PairModel("la", "the"));
        pairs.add(new PairModel("tu", "you"));
        pairs.add(new PairModel("bebes", "drink"));
        pairs.add(new PairModel("agua", "water"));

        return pairs;
    }

    @Override
    public ArrayList<String> getAnswer() {
        return answer;
    }
}
