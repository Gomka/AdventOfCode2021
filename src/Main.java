import Challenges.Challenge1;
import Challenges.Challenge2;
import Challenges.Challenge3;
import Challenges.Challenge4;

public class Main {
    public static void main(String[] args) {

        Challenge1 ch1= new Challenge1();
        System.out.println(ch1.runChallenge() + "\n");

        Challenge2 ch2= new Challenge2();
        System.out.println(ch2.runChallenge() + "\n");

        Challenge3 ch3= new Challenge3();
        System.out.println(ch3.runChallenge() + "\n");

        Challenge4 ch4= new Challenge4();
        System.out.println(ch4.runChallenge() + "\n");
    }
}
