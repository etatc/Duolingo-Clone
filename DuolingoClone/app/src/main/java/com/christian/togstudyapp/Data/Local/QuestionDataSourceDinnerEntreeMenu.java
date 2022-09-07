package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceDinnerEntreeMenu implements DataSource.Local {

    private static QuestionDataSourceDinnerEntreeMenu INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceDinnerEntreeMenu getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceDinnerEntreeMenu();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What are the ingredients for the Maple Rub Ora King Salmon?");
        question.add("What are the ingredients for the Free Range Chicken");
        question.add("What are the ingredients for the Braised Beef Short Rib?");
        question.add("What are the ingredients for the Main Lobster Linguini?");
        question.add("What are the ingredients for the Mushroom & Truffle Tagliatelle?");
        question.add("What are the ingredients for the Mushroom & Truffle Tagliatelle's Mixed Mushrooms?");
        question.add("What are the ingredients for the Mushroom & Truffle Tagliatelle's Mushroom-Cream?");
        question.add("What are the ingredients for the Miso Glazed Chilean Sea Bass?");
        question.add("What are the ingredients for the Roasted Lamb Rack");

        //Answer
        answer.add("Salmon Salt Brown-Sugar Paprika Black-Pepper Coriander Juniper-Berries Garlic Chili Cherry-Tomatoes Mirin Rice-Vinegar Honey Broccolini Black-Olive Olive-Oil");
        answer.add("Chicken Garlic Peas Beans Confit-Garlic Demi-Glace Mustard-Seeds Jus White-Wine Thyme");
        answer.add("Creamed-Potatoes Roasted-Pepper-Relish Crispy-Shallots Red-Wine-Glaze");
        answer.add("Lobster Linguini Cherry-Tomatoes Shallots Garlic Red-Pepper-Flakes White-Wine Lobster-Bisque Heavy-Cream Butter Lemon Chive Parmesan ");
        answer.add("Tagliatelle Mixed-Mushroom Spinach Mushroom-Cream Pecorino Truffle Truffle-Oil");
        answer.add("Button-Mushroom King-Oyster-Mushroom Oyster-Mushroom Chestnut-Mushroom");
        answer.add("Heavy-Cream Button-Mushroom Thyme Bay-Leaves Salt Black-Pepper Horseradish");
        answer.add("Sake Mirin Soy Ginger Sugar Miso Seabass Bok-Choy Togarashi Chili-Thread Crispy-Shallots");
        answer.add("Lamb Honey Carrot Kale Rosemary-Jus Rosemary-Tips Vegetable-Oil Butter Salt Black-Pepper");
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
