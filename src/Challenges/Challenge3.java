package Challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Challenge3 implements IChallenge {

    @Override
    public String runChallenge() {

        return ("Challenge 3: \n"+
                "   Part one: " + partOne() +"\n" +
                "   Part two: " + partTwo());
    }

    public int partOne() {
        String gamma = "", epsilon = "1";
        int[][] digits = new int[12][2];

        try (BufferedReader br = new BufferedReader(new FileReader("data/Challenge3Input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == '0') {
                        digits[i][0]++;
                    } else {
                        digits[i][1]++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 12; i++) {
            if(digits[i][0] > digits[i][1]) {
                gamma += '0';
            } else {
                gamma += '1';
            }
        }

        int i = Integer.parseInt(gamma, 2); // we convert the string to binary and flip it
        i = ~i;
        epsilon = Integer.toBinaryString(i);
        epsilon = epsilon.substring(20); // we remove the first 20 characters since it's length is 32

        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
    }

    public int partTwo() {
        return 0;
    }
}
