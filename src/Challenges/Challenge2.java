package Challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Challenge2 implements IChallenge{

    @Override
    public String runChallenge() {

        return ("Challenge 2: \n"+
                "   Part one: " + partOne() +"\n" +
                "   Part two: " + partTwo());
    }

    @Override
    public int partOne() {
        int horizontal = 0, depth = 0;
        String[] components = new String[2];

        try (BufferedReader br = new BufferedReader(new FileReader("data/Challenge2Input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                components = line.split(" ");

                switch (components[0]) {
                    case "forward": horizontal += Integer.parseInt(components[1]); break;
                    case "down": depth += Integer.parseInt(components[1]); break;
                    case "up": depth -= Integer.parseInt(components[1]); break;
                    default: break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return horizontal * depth;
    }

    @Override
    public int partTwo() {
        return 0;
    }

}
