package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceDinnerAppAllergies implements DataSource.Local {

    private static QuestionDataSourceDinnerAppAllergies INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceDinnerAppAllergies getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceDinnerAppAllergies();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What's the allergins in the baby Gem Cesar?");
        question.add("What's the allergins in the Blue Iceburg");
        question.add("What's the allergins in the Burrata?");
        question.add("What's the allergins in the Maple & Bourbon Nueske's Bacon?");
        question.add("What's the allergins in the Tuna Tartare?");
        question.add("What's the allergins in the Crispy Calamari?");
        question.add("What's the allergins in the LIL BRGS?");
        question.add("What's the allergins in the Jumbo Lump Crab Cake?");
        question.add("What's the allergins in the Oysters On A Half Shell?");
        question.add("What's the allergins in the Jalapeno Pickled Shrimp Cocktail");
        question.add("What's the allergins in the Alaskan King Red Crab?");
        question.add("What's the allergins in the Ceviche?");
        question.add("What's the allergins in the Oysters-Ceviche-Mussels Platter?");
        question.add("What's the allergins in the Clams-Jalpeno Pickled Shrimp Platter?");
        question.add("What's the allergins in the Dungeness Crab Salad-Atlantic Lobster Platter?");

        //Answer
        answer.add("Dairy Egg Gluten Fish Garlic Onion");
        answer.add("Dairy Egg Onion Pork Fish Soy");
        answer.add("Dairy Gluten Garlic Onion");
        answer.add("Egg Mustard-seed Pork Alcohol");
        answer.add("Gluten Fish Soy Shellfish Mollusk");
        answer.add("Egg Gluten Fish Shellfish Mollusk Dairy Garlic");
        answer.add("Dairy Egg Gluten Sesame Onion");
        answer.add("Dairy Egg Gluten Shellfish Onion Sesame");
        answer.add("Shellfish Mollusk Fish(R) Soy(R) Onion(R)");
        answer.add("Shellfish Crustacean Onion Fish(R) Soy(R)");
        answer.add("Shellfish Crustacean Egg(R)");
        answer.add("Fish Onion Gluten(taro-chips)");
        answer.add("Shellfish Mollusk Crustacean Onion(R) Fish(R) Soy(R) Egg(R)");
        answer.add("Mollusk Shellfish Crustacean Fish(R) Soy(R) Egg(R)");
        answer.add("Dairy Shellfish Crustacean Fish Fish(R) Soy(R) Egg");
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
