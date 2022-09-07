package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceAcoutramentsMenu implements DataSource.Local {

    private static QuestionDataSourceAcoutramentsMenu INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceAcoutramentsMenu getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceAcoutramentsMenu();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What are the ingredients for the STK Sauce and is it Hot or Cold ?");
        question.add("What are the ingredients for the STK Bold Sauce and is it Hot or Cold?");
        question.add("What are the ingredients for the Red Wine Sauce and is it Hot or Cold?");
        question.add("What are the ingredients for the Horseradish Sauce and is it Hot or Cold?");
        question.add("What are the ingredients for the Au Poivre Sauce and is it Hot or Cold?");
        question.add("What are the ingredients for the Bearnaise Sauce and is it Hot or Cold?");
        question.add("What are the ingredients for the Bleu Cheese Sauce and is it Hot or Cold?");
        question.add("What are the ingredients for the Chimichuri and is it Hot or Cold?");
        question.add("What are the ingredients for the Truffle Butter?");
        question.add("What are the ingredients for the Lobster Butter");
        question.add("What are the ingredients for the Wagyu Umami Butter?");
        question.add("What are the ingredients for the King Crab Oscar Topping?");
        question.add("What are the ingredients for the Shrimp Topping?");
        question.add("What are the ingredients for the Lobster Tails Topping?");
        question.add("What are the ingredients for the Fresh Shaved Truffles Topping?");
        question.add("What are the ingredients for the Peppercorn Crust Topping?");
        question.add("What are the ingredients for the Zingy Rub Topping?");

        //Answer
        answer.add("Ketchup Red-Wine-Vinegar Tamarind Red-Onion Star-Anise Brown-Sugar Garlic Chili-Flakes Oil-Blend Anchovies Cold");
        answer.add("Ketchup Red-Wine-Vinegar Tamarind Red-Onion Star-Anise Brown-Sugar Garlic Chili-Flakes Oil-Blend Anchovies Worcestershire Sriracha Lemon Cold");
        answer.add("Red-Wine-Reduction Port-Wine-Reduction Veal-Stock Shallots Thyme Bay-Leaves Mushrooms Garlic Sugar Peppercorn Butter Warm");
        answer.add("Sour-Cream Atomic-Horseradish Red-Wine-Vinegar Mayo Worcestershire Cold");
        answer.add("Brandy-Reduction Veal-Stock Chicken-Stock Heavy-Cream Onion Peppercorn");
        answer.add("Egg-Yolk White-Wine-Vinegar Shallots Terragon Lemon Butter Warm");
        answer.add("Bleu-Cheese Parsley Shallots Lemon Butter Salt Sugar Chives");
        answer.add("Red-Onion Garlic Parsley Oregano Olive-Oil Lime White-Wine-Vinegar Chili-Flakes");
        answer.add("Truffle Butter Herbs");
        answer.add("Lobster Butter Herbs Onion");
        answer.add("Wagyu-Tallow Butter Herbs Onion Anchovies Garlic");
        answer.add("Crab Bearnaise Asparagus");
        answer.add("Shrimp Butter Garlic Herbs");
        answer.add("Lobster Butter Salt");
        answer.add("Truffles");
        answer.add("Black-Peppercorn White-Peppercorn Pink-Peppercorn");
        answer.add("Spices");
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
