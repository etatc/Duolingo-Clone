package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceDinnerAppMenu implements DataSource.Local {

    private static QuestionDataSourceDinnerAppMenu INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceDinnerAppMenu getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceDinnerAppMenu();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("What are the ingredients for the baby Gem Cesar?");
        question.add("What are the ingredients for the baby Gem Cesar's Cesar Dressing?");
        question.add("What are the ingredients for the Blue Iceburg");
        question.add("What are the ingredients for the Blue Iceburg's Bleu Cheese Dressing");
        question.add("What are the ingredients for the Burrata?");
        question.add("What are the ingredients for the Burrata's Pickled Shallots?");
        question.add("What are the ingredients for the Maple & Bourbon Nueske's Bacon?");
        question.add("What are the ingredients for the Maple & Bourbon Nueske's Bacon's Apple Coleslaw?");
        question.add("What are the ingredients for the Maple & Bourbon Nueske's Bacon's Glaze?");
        question.add("What are the ingredients for the Maple & Bourbon Nueske's Bacon's Pickled Mustard Seeds?");
        question.add("What are the ingredients for the Tuna Tartare?");
        question.add("What are the ingredients for the Tuna Tartare's Avocado Mix?");
        question.add("What are the ingredients for the Tuna Tartare's Soy Honey Emulsion?");
        question.add("What are the ingredients for the Crispy Calamari?");
        question.add("What are the ingredients for the Crispy Calamari's Asian Chili Sauce?");
        question.add("What are the ingredients for the Crispy Calamari Garlic & Lime Aioli?");
        question.add("What are the ingredients for the LIL BRGS?");
        question.add("What are the ingredients for the LIL BRGS's Secret Sauce?");
        question.add("What are the ingredients for the Jumbo Lump Crab Cake?");
        question.add("What are the ingredients for the Jumbo Lump Crab Cake's Mustard Cream Sauce?");
        question.add("What are the ingredients for the Jumbo Lump Crab Cake Cucumber Salad?");
        question.add("What are the ingredients for the Oysters On A Half Shell?");
        question.add("What are the ingredients for the Oysters On A Half Shell's Mignonette?");
        question.add("What are the ingredients for the Oysters On A Half Shell's Cocktail Sauce?");
        question.add("What are the ingredients for the Jalapeno Pickled Shrimp Cocktail");
        question.add("What are the ingredients for the Alaskan King Red Crab?");
        question.add("What are the ingredients for the Alaskan King Red Crab's Lemon Dijonaise?");
        question.add("What are the ingredients for the Ceviche?");
        question.add("What are the ingredients for the Oysters-Ceviche-Mussels Platter?");
        question.add("What are the ingredients for the Oysters-Ceviche-Mussels Platter's Marinated Mussels?");
        question.add("What are the ingredients for the Clams-Jalpeno Pickled Shrimp Platter?");
        question.add("What are the ingredients for the Clams-Jalpeno Pickled Shrimp Platter Marinated Clams?");
        question.add("What are the ingredients for the Dungeness Crab Salad-Atlantic Lobster Platter?");
        question.add("What are the ingredients for the Dungeness Crab Salad-Atlantic Lobster Platter's Crab Salad?");

        //Answer
        answer.add("Chopped-Lettuce Cesar-Dressing Ciabatta-Herb-Croutons");
        answer.add("Soft-Boiled-Eggs Red-Wine-Vinegar Sherry-Vinegar Dijon-Mustard Garlic Black-Pepper Vegetable-Oil Olive-Oil Parmesan Anchovy");
        answer.add("Bacon Bleu-Cheese Cherry-Tomatoes Lettuce Chives");
        answer.add("Bleu-Cheese Sour-Cream Buttermilk Mayo Red-Wine_Vinegar Worcestershire Tobasco");
        answer.add("Burrata Roasted-Beets Pickled-Shallots Sourdough-Croutons Basil-Oil");
        answer.add("Shallots Sherry-Vinegar Sugar Salt Juniper-Berries Bay-Leaves Coriander-Seeds");
        answer.add("Bacon Apple-Colesaw Pickled-Mustard-Seeds Jalapenos Herbs");
        answer.add("Apple Carrot Cabbage Mustard-Seeds Jalapenos Herbs");
        answer.add("Bourbon Maple-syrup Tomato-Paste Rosemary Salt Black-Pepper Tobasco");
        answer.add("Tuna Avocado-Mix Soy-Honey-Emulsion Chili-Oil Taro-Chips");
        answer.add("Avocado Jalepeno Lime Olive-Oil Salt Black-Pepper");
        answer.add("Soy-Sauce Dijon-Mustard Honey Yuzu");
        answer.add("Calamari Basil Shishito Garlic-Lime-Aioli Asian-Chili-Sauce");
        answer.add("Fish-Sauce Rice-Vinegar Chili-Flakes Garlic Lime Sugar");
        answer.add("Mayo Garlic Lime");
        answer.add("Wagyu-Beef White-Cheddar Onion Special-Sauce Sesame-Seed-Bun Tomato Pickles");
        answer.add("Katchup Mayo Pickles Shallot Chive Truffle-Oil Pickle-Juice");
        answer.add("Crab Panko Mayo Egg-Yolk Leeks Butter Parsley Mustard Lemon Old-Bay Cayenne Vegetable-Oil Mustard-Cream-Sauce Cucumber-Salad");
        answer.add("Mayo Sour-Cream Mustard Lemon Lemon-Zest Old-Bay Tobasco Salt");
        answer.add("Cucumber Rice-Vinegar Mustard-Seeds Pink-Pepper Sugar Sesame-Oil Salt");
        answer.add("Oysters Mignonette Cocktail-Sauce Lemon");
        answer.add("Sherry-Vinegar Shallots Black-Pepper Red-Wine-Vinegar ");
        answer.add("Ketchup Worcestershire Tobasco Lemon Horseradish Salt");
        answer.add("Pickled-Shrimp Jalapeno Champagne-Vinegar Fresno-Pepper Shallots Lemon Cocktail Sauce");
        answer.add("Crab-Legs Lemon-Dijonnaise");
        answer.add("Dijon-Mustard Mayo Lemon");
        answer.add("Fish Citrus Chili Red-Onion Cilantro Olive-Oil Taro-Chips");
        answer.add("Fish Onion Gluten(taro-chips)");
        answer.add("Oysters Cocktail-Sauce Marinated-Mussels Ceviche");
        answer.add("Cilantro Piquillo-Pepper Pepper-Relish Lime Orange-Juice Cayenne Vegetable-Oil Salt Black-Pepper");
        answer.add("Marinated-Clams Pickled-Shrimp Lemon Lemon-Dijonaise Cocktail-Sauce Mignonette");
        answer.add("Cilantro Piquillo-Pepper Pepper-Relish Lime Orange-Juice Cayenne Vegetable-Oil Salt Black-Pepper");
        answer.add("Crab-Salad Lobster Lemon-Dijonaise Cocktail-Sauce Lemon");
        answer.add("Celery Jalapeno Mayo Horseradish-Cream-Sauce Horseradish Lime Salt");
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
