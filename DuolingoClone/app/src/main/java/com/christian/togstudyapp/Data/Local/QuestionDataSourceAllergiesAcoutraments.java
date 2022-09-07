package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceAllergiesAcoutraments implements DataSource.Local {

    private static QuestionDataSourceAllergiesAcoutraments INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceAllergiesAcoutraments getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceAllergiesAcoutraments();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What's the allergins in the STK Sauce?");
        question.add("What's the allergins in the STK Bold Sauce?");
        question.add("What's the allergins in the Red Wine Sauce?");
        question.add("What's the allergins in the Horseradish Sauce?");
        question.add("What's the allergins in the Au Poivre Sauce?");
        question.add("What's the allergins in the Bearnaise Sauce?");
        question.add("What's the allergins in the Bleu Cheese Sauce?");
        question.add("What's the allergins in the Chimichuri?");
        question.add("What's the allergins in the Truffle Butter?");
        question.add("What's the allergins in the Lobster Butter");
        question.add("What's the allergins in the Wagyu Umami Butter?");
        question.add("What's the allergins in the King Crab Oscar Topping?");
        question.add("What's the allergins in the Shrimp Topping?");
        question.add("What's the allergins in the Lobster Tails Topping?");
        question.add("What's the allergins in the Fresh Shaved Truffles Topping?");
        question.add("What's the allergins in the Peppercorn Crust Topping?");
        question.add("What's the allergins in the Zingy Rub Topping?");

        //Answer
        answer.add("Fish Onion");
        answer.add("Fish Onion Citrus Chili");
        answer.add("Garlic Onion Mushrooms Dairy");
        answer.add("Egg Fish Soy Dairy");
        answer.add("Dairy Onion");
        answer.add("Egg Dairy Onion");
        answer.add("Dairy Onion");
        answer.add("Garlic Onion");
        answer.add("Dairy");
        answer.add("Shellfish Dairy Onion");
        answer.add("Dairy Fish Garlic Onion");
        answer.add("Shellfish Dairy Egg Onion");
        answer.add("Shellfish Dairy Garlic");
        answer.add("Shellfish Dairy");
        answer.add("None");
        answer.add("None");
        answer.add("None");
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
