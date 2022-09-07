package com.christian.togstudyapp.Data.Local;

import java.util.ArrayList;
import java.util.Random;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceHappyHourAllergies implements DataSource.Local {

    private static QuestionDataSourceHappyHourAllergies INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceHappyHourAllergies getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceHappyHourAllergies();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What's the allergins on the oysters?");
        question.add("What's the allergins on the Tuna Tartare?");
        question.add("What's the allergins on the Jalapeno Shrimp Cocktail?");
        question.add("What's the allergins on the Calamari?");
        question.add("What's the allergins on the Beef Tartare");
        question.add("What's the allergins on the Lil Burger & Truffle Fries?");
        question.add("What's the allergins on the Salmon Cucumber Stilleto?");
        question.add("What's the allergins on the Short Rib Quesadilla?");
        question.add("What's the allergins on the Fried Popcorn Chicken?");
        question.add("What's the allergins on the Wagyu Meatballs?");
        question.add("What's the allergins on the Steak Parmesan Fries?");
        question.add("What's the allergins on the Felafel & Chili Tahini?");
        question.add("What's the allergins on the Tater Tots?");

        //Answer
        answer.add("Fish Shellfish Allium Soy Mullusk");
        answer.add("Glutin Fish Shellfish Soy Mullusk");
        answer.add("Fish Shellfish Allium Soy");
        answer.add("Dairy Egg Gluten Shellfish Allium Mullusk");
        answer.add("Dairy Egg Gluten Shellfish Allium Sesame Mullusk");
        answer.add("Dairy Egg Gluten Shellfish Allium Sesame Mullusk");
        answer.add("Fish");
        answer.add("Dairy Egg Gluten Allium");
        answer.add("Dairy Gluten Shellfish Allium Mullusk");
        answer.add("Dairy Egg Gluten Allium");
        answer.add("Dairy Egg Gluten Shellfish Allium Mullusk");
        answer.add("Egg Gluten Shellfish Allium Seasame Mullusk");
        answer.add("Dairy Egg Gluten Shellfish Allium Mullisk");

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
