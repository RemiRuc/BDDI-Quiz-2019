package com.example.ditplme;

public class Question {

    public String[] Questions = {
            "Quel a été ton cours préféré ?",
            "Quel logiciel maîtrise-tu le plus ?",
            "Pour faire de la 3D, tu préfére utiliser...",
            "A quoi sert la carte blanche au Uno ?",
            "Parmi ces 4 propositions, qui n'est pas développeur ?",
            "Combien coûte un poulet Franprix ?",
            "Quelle est l'une des conditions pour passer au niveau supérieur de rémunération ?",
            "Combien es-tu prêt à payer Thierry pour obtenir ton diplôme ?",
    };

    private String mChoice[][] = {

            {"HTML/CSS","Les jeudis matins","La pause Déj","Les soirées au bar"},
            {"Paint","Movie Maker","Photofiltre","J'achète des visuels sur les banques d'images"},
            {"Cinema 4D","Cinema 3D","Remy 3D","Des legos"},
            {"À rien","À faire chier deux autres personnes","À trouver son chemin","Je ne sais pas jouer au Uno"},
            {"Remi","Remy","Remy","Remy"},
            {"8,90 Francs","25,582 Francs","Je préfére le McDo","Demandez à Damien"},
            {"Avoir plus de 21 ans","Être développeur","Ne pas payer la CVEC","S'appeler Mathias"},
            {"Entre 0 et 3 centimes","Je préfére travailler dur","J'ai déjà payé la CVEC","On ne paie pas Tyty"},
    };

    private String mCorrectAnswer[] = {
            "HTML/CSS","Paint","Cinema 4D","Je ne sais pas jouer au Uno","Remy","25,582 Francs","Avoir plus de 21 ans","Je préfére travailler dur"
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
