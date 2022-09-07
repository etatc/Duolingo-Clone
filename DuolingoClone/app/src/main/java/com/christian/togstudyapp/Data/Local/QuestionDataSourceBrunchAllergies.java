package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceBrunchAllergies implements DataSource.Local {

    private static QuestionDataSourceBrunchAllergies INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceBrunchAllergies getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceBrunchAllergies();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What's the allergins in the Hot Chicken & Waffle?");
        question.add("What's the allergins in the Truffle Steak & Egg?");
        question.add("What's the allergins in the Cinnamon French Toast?");
        question.add("What's the allergins in the Smoked Pork Belly Benedict?");
        question.add("What's the allergins in the Lobster & Eggs Benedict?");
        question.add("What's the allergins in the Eggs & Avocado on Toast?");
        question.add("What's the allergins in the Wagyu Burger BFKT?");
        question.add("What's the allergins in the Egg White Omelet?");

        //Answer
        answer.add("Dairy Egg Gluten Allium");
        answer.add("Egg Gluten Dairy Mushroom");
        answer.add("Dairy Gluten Egg ");
        answer.add("Egg Gluten Dairy Pork Chili");
        answer.add("Dairy Gluten Egg Fish Crustacean");
        answer.add("Dairy Egg Gluten Onion Chili");
        answer.add("Dairy Gluten Egg Onion Pork Sesame");
        answer.add("Dairy Egg Onion Chili Mushrooms Citrus");

        
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
