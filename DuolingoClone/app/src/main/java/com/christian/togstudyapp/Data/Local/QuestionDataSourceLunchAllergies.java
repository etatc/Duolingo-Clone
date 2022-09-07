package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceLunchAllergies implements DataSource.Local {

    private static QuestionDataSourceLunchAllergies INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceLunchAllergies getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceLunchAllergies();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What's the allergins in the Maple Rub Salmon?");
        question.add("What's the allergins in the Free Range Chicken?");
        question.add("What's the allergins in the Braised Shortrib Quesadilla?");
        question.add("What's the allergins in the Grilled Chicken Breast Sandwich?");
        question.add("What's the allergins in the Wagyu Burger & Fries?");
        question.add("What's the allergins in the Buttermilk Fried Chicken Thigh?");
        question.add("What's the allergins in the Wagyu Meatballs?");
        question.add("What's the allergins in the Shrimp Scampi?");
        question.add("What's the allergins in the STK Sandwich?");
        question.add("What's the allergins in the Crispy Shrimp Po' Boy");
        question.add("What's the allergins in the Steak Frites?");

        //Answer
        answer.add("Fish Garlic Alcohol(mirin) Chili");
        answer.add("Garlic Dairy Mustard Alcohol");
        answer.add("Dairy Gluten Egg Allium");
        answer.add("Garlic Sesame Gluten Dairy Pork Egg(ranch)");
        answer.add("Dairy Gluten Sesame Onion Special-Sauce(R)");
        answer.add("Dairy Egg Gluten Citrus(R)");
        answer.add("Dairy Gluten Egg Onion");
        answer.add("Shellfish Allium Alcohol Chili(R) Dairy Egg Gluten");
        answer.add("Gluten Onion Dairy Chili Mustard");
        answer.add("Dairy Shellfish Onion Egg Gluten Chili(remoulade)");
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
