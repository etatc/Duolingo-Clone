package com.christian.togstudyapp.Data.Local;

import com.christian.togstudyapp.Data.DataSource;
import com.christian.togstudyapp.Model.PairModel;
import com.christian.togstudyapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rick on 3/2/2018.
 */

public class QuestionDataSourceMainAlcohols implements DataSource.Local {

    private static QuestionDataSourceMainAlcohols INSTANCE;

    QuestionModel questionModel;

    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    Random random = new Random();

    public static QuestionDataSourceMainAlcohols getInstance() {

        if (INSTANCE == null) {

            INSTANCE = new QuestionDataSourceMainAlcohols();
        }

        return INSTANCE;
    }

    public QuestionModel getRandomQuestionObj() {

        //Question
        question.add("what's alcoholic in the Cucumber Stilleto?");
        question.add("what's alcoholic in the Spiced Watermelon?");
        question.add("what's alcoholic in the Not Your Daddy's Old Fashioned?");
        question.add("what's alcoholic in the Strawberry Cobbler?");
        question.add("what's alcoholic in the STK Mule");
        question.add("what's alcoholic in the Nigroni?");
        question.add("what's alcoholic in the Dirty Pearls?");
        question.add("what's alcoholic in the Mojito?");
        question.add("what's alcoholic in the Perfect Margarita?");
        question.add("what's alcoholic in the Jack Me?");
        question.add("what's alcoholic in the Bullfighter?");
        question.add("what's alcoholic in the French Love?");
        question.add("what's alcoholic in the El Toro Rojo?");
        question.add("what's alcoholic in the Paloma Bucket?");

        //Answer
        answer.add("Grey-goose-Le-Citron St.Germain");
        answer.add("Patron-Silver St.Germain");
        answer.add("Woodford-Reserve Angostura-Bitters");
        answer.add("Belvedere-Vodka");
        answer.add("Belvedere-Ginger-zest Yellow-Chartreuse");
        answer.add("Botanist-Gin Cinzano-Sweet-vermouth Campari");
        answer.add("Kettle-One Dry-Vermouth");
        answer.add("Bacardi");
        answer.add("Milagro-Silver-Tequila Cointreau");
        answer.add("Gentlemen-Jack");
        answer.add("Glenmorangie-X Cinzano-Sweet-Vermouth");
        answer.add("Hendrick's-Gin Chandon-Brut");
        answer.add("Volcan-Silver-Tequila Campari");
        answer.add("Espalon-Tequila");
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
