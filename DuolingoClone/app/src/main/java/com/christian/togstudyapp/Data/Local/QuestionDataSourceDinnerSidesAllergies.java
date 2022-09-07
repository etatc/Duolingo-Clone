package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceDinnerSidesAllergies implements DataSource.Local {

    private static QuestionDataSourceDinnerSidesAllergies INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceDinnerSidesAllergies getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceDinnerSidesAllergies();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What's the allergins in the Side of Mac & Cheese with Bacon?");
        question.add("What's the allergins in the Side of Mac & Cheese with Lobster?");
        question.add("What's the allergins in the Side of Yukon Gold Mashed Potatoes?");
        question.add("What's the allergins in the Side of Tater Tots");
        question.add("What's the allergins in the Side of Brussels Sprouts?");
        question.add("What's the allergins in the Side of Sweet Corn Pudding?");
        question.add("What's the allergins in the Side of Parmesan Truffle Fries?");
        question.add("What's the allergins in the Side of Creamed Spinach?");
        question.add("What's the allergins in the Side of Asparagus?");
        question.add("What's the allergins in the Side of Market Vegetables?");
        question.add("What's the allergins in the Side of Confit Mushrooms?");

        //Answer
        answer.add("Gluten Dairy Egg Garlic Onion Pork");
        answer.add("Gluten Dairy Egg Garlic Onion Crustacean Shellfish");
        answer.add("Dairy(crust) Gluten(crust)");
        answer.add("Dairy Egg Gluten Onion Shellfish Mollusk");
        answer.add("Onion Pork Dairy Gluten Mollusk");
        answer.add("Dairy Onion");
        answer.add("Egg(fry-sauce) Gluten Shellfish Mollusk");
        answer.add("Dairy Gluten Onion Garlic Shellfish(R) Mollusk(R)");
        answer.add("Citrus");
        answer.add("Dairy Onion Garlic Gluten(R) Mollusk(R) Shellfish(R)");
        answer.add("Dairy Pork Onion Garlic Alcohol");
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
