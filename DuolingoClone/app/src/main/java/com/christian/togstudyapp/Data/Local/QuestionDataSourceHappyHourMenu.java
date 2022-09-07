package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceHappyHourMenu implements DataSource.Local {

    private static QuestionDataSourceHappyHourMenu INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceHappyHourMenu getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceHappyHourMenu();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What are the ingredients for the oysters?");
        question.add("What are the ingredients for the Tuna Tartare?");
        question.add("What are the ingredients for the Jalapeno Shrimp Cocktail?");
        question.add("What are the ingredients for the Calamari?");
        question.add("What are the ingredients for the Beef Tartare");
        question.add("What are the ingredients for the Lil Burger & Truffle Fries?");
        question.add("What are the ingredients for the Salmon Cucumber Stilleto?");
        question.add("What are the ingredients for the Short Rib Quesadilla?");
        question.add("What are the ingredients for the Fried Popcorn Chicken?");
        question.add("What are the ingredients for the Wagyu Meatballs?");
        question.add("What are the ingredients for the Steak Parmesan Fries?");
        question.add("What are the ingredients for the Felafel & Chili Tahini?");
        question.add("What are the ingredients are the Tater Tots Served With?");
        question.add("What are the ingredients in the Tater Tots?");

        //Answer
        answer.add("Oyster Lemon Mignonette Tobasco Cocktail-Sauce");
        answer.add("Tuna-1.5-oz Olive-Oil Salt Black-Pepper Avocado-Mix Lime Jalapeno Soy-Honey-Emulsion Chili-Oil Cilantro");
        answer.add("Shrimp-2pcs Cocktail-Sauce Lemon");
        answer.add("Calamari Shishito-Pepper Basil-Crisps Thai-Chili Lemon-Garlic-Lime-Aioli ");
        answer.add("Beef Sesame-Wonton-Chips Terragon-Dressing Herbs ");
        answer.add("Lil-BRG-1 Special-Sauce French-Fries Truffle");
        answer.add("Salmon-Vodka-Cured-3pcs Cucumber Dill");
        answer.add("Short-Rib-4pcs Pepper-Relish Mustard-Cream-Sauce");
        answer.add("Chicken-5pcs Buttermilk Herbs Paprika Garlic Honey-BBQ Lime");
        answer.add("Meatballs-2 Tomato-Sauce Basil Parmesan");
        answer.add("Ribeye-3pcs Truffle-Fries Bearnaise Chives Parmesan");
        answer.add("Felafel-4pcs Pickled-Fresno-Chili Tahini-Sauce");
        answer.add("Tater-Tots-4pcs Remoulade");
        answer.add("Potato White-Cheddar Parmesan");

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
