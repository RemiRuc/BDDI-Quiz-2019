package com.example.ditplme;

public class QuestionsDev {

    public String[] Questions = {
            "What is the first number in numbers?",
            "What is the second number in numbers?",
            "What is the third number in numbers?",
            "What is the four number in numbers?",
            "What is the five number in numbers?",
            "What is the six number in numbers?",
            "What is the seven number in numbers?",
            "What is the eight number in numbers?",
    };

    private String mChoice[][] = {

            {"0","1","2","3"},
            {"0","13","23","3"},
            {"0","1","24","3"},
            {"0","12","243","3"},
            {"0","13","26","3"},
            {"0","145","42","3"},
            {"0","14","23","3"},
            {"0","1","2","3"},
    };

    private String mCorrectAnswer[] = {
            "0","13","3","243","0","145","14","3"
    };

    public String getQuestion(int a) {
        String question = Questions[a];
        return question;
    }

    public String getChoice(int a){
        String choice = mChoice[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoice[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoice[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoice[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }
}
