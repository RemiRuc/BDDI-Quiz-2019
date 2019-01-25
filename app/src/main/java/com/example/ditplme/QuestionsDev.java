package com.example.ditplme;

public class QuestionsDev {

    public String[] Questions = {
            "Quel a été ton cours préféré ?",
            "Quelle techno maîtrise-tu le plus ?",
            "Pour faire de la 3D, tu préfére utiliser...",
            "A quoi sert la carte blanche au Uno ?",
            "Que fais-tu si David te dis de ne pas manger en salle ?",
            "Parmi ces 4 propositions, qui n'est pas développeur ?",
            "Combien coûte un poulet Franprix ?",
            "Quelle est l'une des conditions pour passer au niveau supérieur de rémunération ?",
            "Où est An ?",
            "Combien es-tu prêt à payer Thierry pour obtenir ton diplôme ?",
    };

    private String mChoice[][] = {

            {"Swift","Les jeudis matins","Symfony","Les soirées au bar"},
            {"Jquery","Flash","Objective C","WordPress"},
            {"Three JS","Babylon JS","Remy 3D","Des legos"},
            {"À rien","À faire chier deux autres personnes","À trouver son chemin","Je ne sais pas jouer au Uno"},
            {"Remi","Remy","Remy","Remy"},
            {"8,90 Francs","25,582 Francs","Je préfére le McDo","Demandez à Damien"},
            {"Avoir plus de 21 ans","Être développeur","Ne pas payer la CVEC","S'appeler Mathias"},
            {"Entre 0 et 3 centimes","Je préfére travailler dur","J'ai déjà payé la CVEC","On ne paie pas Tyty"},
    };

    private String mCorrectAnswer[] = {
            "Symfony","Objective C","Three JS","Je ne sais pas jouer au Uno","Je ferme la salle","Remy","25,582 Francs","Avoir plus de 21 ans","Au bar","Je préfére travailler dur"
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
