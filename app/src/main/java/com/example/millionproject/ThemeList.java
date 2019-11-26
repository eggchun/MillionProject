package com.example.millionproject;

import java.io.Serializable;
import java.util.ArrayList;

public class ThemeList {
    private int themeCount = 0;
    private ArrayList<Theme> themeList = new ArrayList<>();

    public ThemeList(){
        init();
    }

    /**
     * Hardcode question
     */
    public void init(){
        ArrayList<Question> christmasQuestions = new ArrayList<>();
        christmasQuestions.add(new Question("In Finland, each family will do this activity before the night in Christmas. What is it?",new Answer[]{new Answer("Sing", false), new Answer("Swim", false), new Answer("Sauna", true), new Answer("Drink", false)}));
        christmasQuestions.add(new Question("In Finland, there is a special meal in the dinner that hiding a almond and someone can make a wish if he/she eats the right one. What is it?", new Answer[]{new Answer("Rice", false), new Answer("Noodle", false), new Answer("Cake", false), new Answer("Gruel", true)}));
        christmasQuestions.add(new Question("How many reindeer(s) is/are helping Santa Claus to send the gift?", new Answer[]{new Answer("12", true), new Answer("11", false), new Answer("10", false), new Answer("9", false)}));
        christmasQuestions.add(new Question("What is the name of the reindeer which has a red nose??", new Answer[]{new Answer("Cupid", false), new Answer("Rudolph", true), new Answer("Donner", false), new Answer("Olive", false)}));
        christmasQuestions.add(new Question("In Western, which three colors are the color of Christmas?", new Answer[]{new Answer("Red, White, Green", true), new Answer("Red, Gold, Green", false), new Answer("White, Green, Yellow", false), new Answer("White, Green, Black", false)}));
        christmasQuestions.add(new Question("Christmas is the celebration of Jesus born. So where is Jesus born?", new Answer[]{new Answer("Jerusalem", false), new Answer("Galilee", false), new Answer("Nazareth", false), new Answer("Bethlehem", true)}));
        christmasQuestions.add(new Question("What is the date of Christmas?", new Answer[]{new Answer("December 23", false), new Answer("December 24", false), new Answer("December 25", true), new Answer("December 26", false)}));
        christmasQuestions.add(new Question("Where did Maria give birth of Jesus?", new Answer[]{new Answer("Home", false), new Answer("Stable", true), new Answer("Hospital", false), new Answer("Church", false)}));
        christmasQuestions.add(new Question("In the Orthodox regions of Coptic, Jerusalem, Russia, Serbia and Georgia, what is the date of Christmas for them?", new Answer[]{new Answer("May to January", false), new Answer("June to January", false), new Answer("July to January", true), new Answer("August to January", false)}));
        christmasQuestions.add(new Question("In generally, where is the home of Santa Claus?", new Answer[]{new Answer("Finland", true), new Answer("Iceland", false), new Answer("Sweden", false), new Answer("Norway", false)}));

        themeList.add(new Theme("Christmas", christmasQuestions));
        themeCount++;

        ArrayList<Question> hongKongQuestions = new ArrayList<>();
        hongKongQuestions.add(new Question("How far do tram can go?", new Answer[]{new Answer("HK Island to KL Island", false), new Answer("KL Island to New Territories", false), new Answer("HK Island to New Territories", false), new Answer("Only HK Island", true    )}));
        hongKongQuestions.add(new Question("How many region distributed in Hong Kong?", new Answer[]{new Answer("17", false), new Answer("18", true), new Answer("19", false), new Answer("20", false)}));
        hongKongQuestions.add(new Question("How many cross-harbour tunnel has in Hong Kong?", new Answer[]{new Answer("1", false), new Answer("2", false), new Answer("3", true), new Answer("4", false)}));
        hongKongQuestions.add(new Question("How many airport runway does Hong Kong have before 2023?", new Answer[]{new Answer("1", false), new Answer("2", true), new Answer("3", false), new Answer("4", false)}));
        hongKongQuestions.add(new Question("How many funding university in Hong Kong?", new Answer[]{new Answer("8", true), new Answer("9", false), new Answer("10", false), new Answer("11", false)}));
        hongKongQuestions.add(new Question("What is the skyscraper ranking of the International Commerce Centre in Hong Kong?", new Answer[]{new Answer("9", false), new Answer("10", false), new Answer("11", false), new Answer("12", true)}));
        hongKongQuestions.add(new Question("Which building below is not in Hong Kong?", new Answer[]{new Answer("IMG", false), new Answer("IMG", false), new Answer("IMG", true), new Answer("IMG", false)}));
        hongKongQuestions.add(new Question("Which country blow has ruled Hong Kong in the past?", new Answer[]{new Answer("United Kingdom", true), new Answer("Russia", false), new Answer("Taiwan", false), new Answer("U.S.A.", false)}));
        hongKongQuestions.add(new Question("Which country dollar is pegged to HK dollar?", new Answer[]{new Answer("TWD", false), new Answer("USD", true), new Answer("JPY", false), new Answer("GBP", false)}));
        hongKongQuestions.add(new Question("How many people live in Hong Kong? (around)", new Answer[]{new Answer("10 million", false), new Answer("9 million", false), new Answer("8 million", false), new Answer("7 million", true)}));

        themeList.add(new Theme("Hong Kong", hongKongQuestions));
        themeCount++;

        ArrayList<Question> animalQuestion = new ArrayList<>();
        animalQuestion.add(new Question("A group of wolves is called as _____?", new Answer[]{new Answer("Destruction", false), new Answer("Pack", true), new Answer("Band", false), new Answer("Troop", false)}));
        animalQuestion.add(new Question("Which animal has the highest blood pressure?", new Answer[]{new Answer("Buffalo", false), new Answer("Dolphin", false), new Answer("Horse", false), new Answer("Giraffe", true)}));
        animalQuestion.add(new Question("How many hearts does an octopus have?", new Answer[]{new Answer("3", true), new Answer("5", false), new Answer("2", false), new Answer("4", false)}));
        animalQuestion.add(new Question("How long can a snail sleep for?", new Answer[]{new Answer("10 days", false), new Answer("3 years", true), new Answer("2 months", false), new Answer("1 years", false)}));
        animalQuestion.add(new Question("What is a group of elephant called?", new Answer[]{new Answer("Herd", true), new Answer("Colony", false), new Answer("Troop", false), new Answer("Family", false)}));
        animalQuestion.add(new Question("Which animal does not drink water?", new Answer[]{new Answer("Garden snail", false), new Answer("Honey bee", false), new Answer("Kangaroo rat", true), new Answer("Bullfrog", false)}));
        animalQuestion.add(new Question("What is a baby alpaca called?", new Answer[]{new Answer("Joey", false), new Answer("Calf", false), new Answer("Cria", true), new Answer("Whelp", false)}));
        animalQuestion.add(new Question("Which mammal has the longest gestation period?", new Answer[]{new Answer("Giraffe", false), new Answer("Rhinoceros", false), new Answer("Hippopotamus", false), new Answer("Elephant", true)}));
        animalQuestion.add(new Question("What are female dolphins called?", new Answer[]{new Answer("Bulls", false), new Answer("Cows", true), new Answer("Calves", false), new Answer("Doe", false)}));
        animalQuestion.add(new Question("How many eyes does honey bee have?", new Answer[]{new Answer("5", true), new Answer("4", false), new Answer("2", false), new Answer("3", false)}));

        themeList.add(new Theme("Animal", animalQuestion));
        themeCount++;

        ArrayList<Question> festivalQuestion = new ArrayList<>();
        festivalQuestion.add(new Question("What activity will we do in Chung Yeung Festival?", new Answer[]{new Answer("Swimming", false), new Answer("Hiking", true), new Answer("Picnic", false), new Answer("Travelling", false)}));
        festivalQuestion.add(new Question("What activity that we will not do in Chinese New Year?", new Answer[]{new Answer("IMG", false), new Answer("IMG", false), new Answer("IMG", false), new Answer("IMG", true)}));
        festivalQuestion.add(new Question("What we will eat in Dragon Boat Festival?", new Answer[]{new Answer("Sweet", false), new Answer("Dumpling", true), new Answer("Noodle", false), new Answer("Meat", false)}));
        festivalQuestion.add(new Question("What is the symbol animal of Easter?", new Answer[]{new Answer("Chicken", false), new Answer("Squirral", false), new Answer("Rabbit", true), new Answer("Tiger", false)}));
        festivalQuestion.add(new Question("How many holiday do Hong Kong has in Christmas generally?", new Answer[]{new Answer("2", true), new Answer("3", false), new Answer("4", false), new Answer("5", false)}));
        festivalQuestion.add(new Question("What is the date of Valentine's Day?", new Answer[]{new Answer("11-Feb", false), new Answer("12-Feb", false), new Answer("13-Feb", false), new Answer("14-Feb", true)}));
        festivalQuestion.add(new Question("What flower we will give in Mother's day?", new Answer[]{new Answer("Carnation", true), new Answer("Rose", false), new Answer("Chrysanthemum", false), new Answer("Peony", false)}));
        festivalQuestion.add(new Question("Which country does Hou Li Festival belong to?", new Answer[]{new Answer("China", false), new Answer("Malaysia", false), new Answer("India", true), new Answer("Indonesia", false)}));
        festivalQuestion.add(new Question("Which country does Songkran Water Festival belong to?", new Answer[]{new Answer("Japan", false), new Answer("TaiWan", false), new Answer("Philippines", false), new Answer("Thailand", true)}));
        festivalQuestion.add(new Question("How old is a person to be an adult in Coming of Age Day of Japan?", new Answer[]{new Answer("18", false), new Answer("19", false), new Answer("20", true), new Answer("21", false)}));

        themeList.add(new Theme("Festival", festivalQuestion));
        themeCount++;
    }

    public ArrayList<Theme> getThemeList() {
        return themeList;
    }

    public int getThemeCount() {
        return themeCount;
    }
}
