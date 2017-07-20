package anil.com.tingwork;

public class Questions {
    //question are stored in array of string
    private String mquestions[]={
            "Who won the Best Footballer 2016 in the World?",
            "who is the current indian captain in cricket?",
            "Who is the God of Cricket in India?",
            "who is called as The wall of Indian cricket?"};
    // choices are stored in array of string
    private String mchoice[][]= {
            {"Cristiano Ronaldo","Sachin Tendulkar","David Beckham"},
            {"MS Dhoni","Virat Kohil", "Rohit Sharma"},
            {"Ravi Sastri","Rahul Dravid","Sahin R Tendulkar"},
            {"MS Dhoni","Rahul Dravid","VVS Laxman"}};

    //correct answer are stored in array of string.
    private String mcorrect_answer[]={"Cristiano Ronaldo","Virat Kohil","Sahin R Tendulkar","Rahul Dravid"};

    //method to get question from array
    public String getquestion(int a)
    {
        String question =mquestions[a];
        return question;
    }
    //method to get choices from array

    public String getchoice1(int a)
    {
        String choice0 =mchoice[a][0];
        return choice0 ;
    }
    public String getchoice2(int a)
    {
        String choice1 =mchoice[a][1];
        return choice1 ;
    }
    public String getchoice3(int a)
    {
        String choice2 =mchoice[a][2];
        return choice2 ;
    }

    public String getCorrectAnswer(int a)
    {
        String answer = mcorrect_answer[a];
        return answer;
    }

}
