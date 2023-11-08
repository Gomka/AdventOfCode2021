package Challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Challenge4 implements IChallenge {

    @Override
    public String runChallenge() {

        return ("Challenge 4: \n"+
                "   Part one: " + partOne() +"\n" +
                "   Part two: " + partTwo());
    }

    public int partOne() {

        try (BufferedReader br = new BufferedReader(new FileReader("data/Challenge4Input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int partTwo() {

        return 0;
    }

}
