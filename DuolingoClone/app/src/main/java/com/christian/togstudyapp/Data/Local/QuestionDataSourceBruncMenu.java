package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceBruncMenu implements DataSource.Local {

    private static QuestionDataSourceBruncMenu INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceBruncMenu getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceBruncMenu();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What are the ingredients for the Chicken & Waffle?");
        question.add("What are the ingredients for the Truffle Steak & Egg?");
        question.add("What are the ingredients for the Cinnamon French Toast?");
        question.add("What are the ingredients for the Smoked Pork Belly Benedict?");
        question.add("What are the ingredients for the Lobster & Eggs Benedict?");
        question.add("What are the ingredients for the Eggs & Avocado on Toast?");
        question.add("What are the ingredients for the Wagyu Burger BFKT?");
        question.add("What are the ingredients for the Egg White Omelet?");

        //Answer
        answer.add("Waffles Spicy-chicken-thigh Coleslaw Pickles Maple-BBQ-Sauce Chili Coriander");
        answer.add("Wagyu-flat-iron-8oz Brioche-with-egg-center Truffle-butter Potatoes Truffles");
        answer.add("Brioche-toast Berries Raspberry-coulis Cream-cheese-icing Maple-syrup");
        answer.add("Maple-Bacon English-Muffin Poached-eggs Hollandaise Shishito-peppers Chilis Cilantro");
        answer.add("Engish-muffin Spinach Poached-eggs Hollandaise Caviar Lobster-claws Cilantro");
        answer.add("Sourdough Avacado-mix Poached-eggs Cilantro Fresno-chili Pumpkin-seeds");
        answer.add("Bun Wagyu-beef LTO Special-sauce Sweet-pickles Fried-egg Bacon");
        answer.add("Egg-whites Pepper-relish Onions Spinach Mushrooms Swiss-cheese Omelet-salad");

        
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
