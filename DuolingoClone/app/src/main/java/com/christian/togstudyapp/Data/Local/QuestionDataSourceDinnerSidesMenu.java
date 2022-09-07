package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceDinnerSidesMenu implements DataSource.Local {

    private static QuestionDataSourceDinnerSidesMenu INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceDinnerSidesMenu getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceDinnerSidesMenu();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What are the ingredients for the Side of Mac & Cheese with Bacon?");
        question.add("What are the ingredients for the Side of Mac & Cheese with Lobster?");
        question.add("What are the ingredients for the Side of Mac & Cheese's Morney Sauce?");
        question.add("What are the ingredients for the Side of Yukon Gold Mashed Potatoes?");
        question.add("What are the ingredients for the Side of Yukon Gold Mashed Potatoes' Parmesan Crust?");
        question.add("What are the ingredients for the Side of Tater Tots");
        question.add("What are the ingredients for the Side of Tater Tots' Remoulade");
        question.add("What are the ingredients for the Side of Brussels Sprouts?");
        question.add("What are the ingredients for the Side of Sweet Corn Pudding?");
        question.add("What are the ingredients for the Side of Parmesan Truffle Fries?");
        question.add("What are the ingredients for the Side of Parmesan Truffle Fries' Bacon Jalapeno Fry Sauce?");
        question.add("What are the ingredients for the Side of Creamed Spinach?");
        question.add("What are the ingredients for the Side of Asparagus?");
        question.add("What are the ingredients for the Side of Market Vegetables?");
        question.add("What are the ingredients for the Side of Confit Mushrooms?");

        //Answer
        answer.add("Morney-Sauce Pasta White-Cheddar Parmesan Gruyere Bacon");
        answer.add("Morney-Sauce Pasta White-Cheddar Parmesan Gruyere Lobster Lobster-Bisque");
        answer.add("Butter Garlic Onion Thyme Flour Milk Cheddar Fontal Asiago Salt Black-Pepper");
        answer.add("Yukon-Potatoes Idaho-Potatoes Butter Heavy-Cream Salt Black-Pepper Parmesan-Crust");
        answer.add("Parmesan Panko Butter Salt");
        answer.add("Idaho-Potatoes Cheddar Monterey Salt Black-Pepper Remoulade");
        answer.add("Mayo Poblano Fresno-chili Jalapeno Lemon Cilantro Scallion Paprika Cayenne Salt Black-Pepper");
        answer.add("Brussels-Sprouts Cured-Pork-Belly Red-Onion Brown-Sugar Crushed-Red-Pepper White-Balsamic Maple-Syrup");
        answer.add("Half&Half Butter Corn-Puree Sugar Corn-Meal Corn-Kernels Salt Chive");
        answer.add("Idaho-Potatoes Parmesan Chive Truffle-Oil Salt Fry-Sauce");
        answer.add("Ketchup Mayo Pickled-Jalapenos Bacon Mustard-Seeds Salt Black-Pepper Sugar Apple-Cider-Vinegar");
        answer.add("Morney-Sauce Milk Spinach Spinach-Cream Pernod Crispy-Shallots");
        answer.add("Asparagus Olive-Oil Lemon Lemon-Zest Salt");
        answer.add("Green-Beans Snow-Peas Sweet-Peas Onion Garlic Garlic-Oil Butter Herbs Salt Shallots");
        answer.add("Button-Mushroom Chestnut-Mushroom Bacon Shallots Garlic Red-Wine-Vinegar Better Thyme Goat-Cheese Herbs Vegetable-Oil");
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
