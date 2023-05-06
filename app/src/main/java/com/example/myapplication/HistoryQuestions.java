package com.example.myapplication;

public class HistoryQuestions {
    public String questions[]={
            "Sumer and Egypt were similar in all of the following ways EXCEPT",
            "A follower of the Chinese philosophy of Daoism would MOST agree with which statement?",
            "Which of these was NOT a characteristic of early humans in the Paleolithic Age?",
            "Buddhism was founded in part as a response to questions about which faith?",
            "The Kush city of Meroe rose to prominence mainly because of its natural supply of",
            "Who split the Roman Empire into two halves?"
    };

    private String choices[][]={
            {"belief in a polytheistic religion centered on deities of nature", "enjoyment of protection from invasion by natural barriers", "development of distinct systems of written language"},
            {"Government intrusiveness should be kept to a minimum.", "Government should be focused on strengthening the state.", "Governments that allow too much freedom are doomed to fail."},
            {"Tendency to live in permanent settlements", "Reliance on hunting and gathering techniques", "Propensity for creating artistic cave drawings"},
            {"Daoism", "Judaism", "Hinduism"},
            {"salt", "iron", "gold"},
            {"Augustus", "Diocletian", "Constantine"}
    };

    private String correctChoices[]={
            "enjoyment of protection from invasion by natural barriers",
            "Government intrusiveness should be kept to a minimum.",
            "Tendency to live in permanent settlements",
            "Hinduism",
            "iron",
            "Diocletian"
    };

    public String getQuestion(int i) {
        return questions[i];
    }

    public String getChoice1(int i) {
        return choices[i][0];
    }

    public String getChoice2(int i) {
        return choices[i][1];
    }

    public String getChoice3(int i) {
        return choices[i][2];
    }

    public String getCorrectChoice(int i) {
        return correctChoices[i];
    }

}
