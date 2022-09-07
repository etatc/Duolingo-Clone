package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceLunchMenu implements DataSource.Local {

    private static QuestionDataSourceLunchMenu INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceLunchMenu getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceLunchMenu();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What are the ingredients for the Maple Rub Salmon?");
        question.add("What are the ingredients for the Maple Rub Salmon's Maple Rub?");
        question.add("What are the ingredients for the Maple Rub Salmon's Black Olive Mix?");
        question.add("What are the ingredients for the Free Range Chicken?");
        question.add("What are the ingredients for the Braised Shortrib Quesadilla?");
        question.add("What are the ingredients for the Grilled Chicken Breast Sandwich?");
        question.add("What are the ingredients for the Wagyu Burger & Fries?");
        question.add("What are the ingredients for the Buttermilk Fried Chicken Thigh?");
        question.add("What are the ingredients for the Wagyu Meatballs?");
        question.add("What are the ingredients for the Shrimp Scampi?");
        question.add("What are the ingredients for the STK Sandwich?");
        question.add("What are the ingredients for the STK Sandwich's Coffee Rub?");
        question.add("What are the ingredients for the Crispy Shrimp Po' Boy");
        question.add("What are the ingredients for the Steak Frites?");

        //Answer
        answer.add("Salmon-7oz Maple-Rub Pickled-Cherry-Tomatoes Broccolini Black-Olive-Mix Mirin");
        answer.add("Salt Brown-Sugar Paprika Black-Pepper Coriander Garlic Chili");
        answer.add("Black-Olives Capers Anchovies Garlic Oil-Blend Red-Wine-Vinegar Thyme");
        answer.add("Green-Beans Peas Garlic Mustard-Chicken-Jus White-Wine Chicken");
        answer.add("Flour-Tortilla glazed-beef-5oz Fontina Pepper-Rellish Mustard-Cream-Sauce Chimichuri Tomato ");
        answer.add("Garlic Herbs Chicken Bacon Tomato Lettuce Ranch Cheddar French-Fries");
        answer.add("Wagyu-Beef-7oz Sesame-Seed-Bun American-Cheese Lettuce Tomato Red-Onion Pickles Special-Sauce French Fries");
        answer.add("2-Fried-Chicken Lime Coleslaw Honney-BBQ Pickles French-Fries Tobasco");
        answer.add("5-Wagyu-Meatballs Tomato-Sauce Spaghetti Parmesan");
        answer.add("5-Shrimp Linguini Cherry-Tomatoes Garlic-White-Wine-Sauce Chili-Flakes");
        answer.add("Shaved-Coffee-Ribeye Onion Gruyere Horseradish-Cream French-Fries");
        answer.add("Brown-Sugar Paprika Chili-Powder Mustard-Powder Coffee-Grounds Black-Pepper");
        answer.add("Fried-Shrimp Baguette Coleslaw Remoulade Lettuce Tomatoes Avocado-Mix Calamari-Seasoning French-Fries");
        answer.add("Ribeye-8oz Choice-of-Sauce French-Fries Salt Black-Pepper");


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
