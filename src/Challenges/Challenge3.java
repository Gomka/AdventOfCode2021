package Challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Challenge3 implements IChallenge {

    @Override
    public String runChallenge() {

        return ("Challenge 3: \n"+
                "   Part one: " + partOne() +"\n" +
                "   Part two: " + partTwo());
    }

    public int partOne() {
        String gamma = "", epsilon = "";
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
        String oxygenRating = "0", co2Rating = "0";
        List<String> startsWithOne = new LinkedList<String>();
        List<String> startsWithZero = new LinkedList<String>();


        try (BufferedReader br = new BufferedReader(new FileReader("data/Challenge3Input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                if(line.charAt(0) == '0') {
                    startsWithZero.add(line);
                } else {
                    startsWithOne.add(line);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (startsWithOne.size() >= startsWithZero.size()) {
            oxygenRating = findRating(startsWithOne, true);
            co2Rating = findRating(startsWithZero, false);
        } else {
            oxygenRating = findRating(startsWithZero, true);
            co2Rating = findRating(startsWithOne, false);
        }

        return Integer.parseInt(oxygenRating, 2) * Integer.parseInt(co2Rating, 2);
    }

    public String findRating(List<String> values, boolean oxygen) {

        for (int i = 1; i < 12; i++) {
            int countOnes = 0;
            int countZeroes = 0;

            for (String str:values) {
                if (str.charAt(i) == '1') {
                    countOnes++;
                } else countZeroes++;
            }

            List<String> stringsToRemove = new LinkedList<>();
            for (String str:values) {
                if (str.charAt(i) == '0' && ((countOnes >= countZeroes && oxygen) || (countOnes < countZeroes && !oxygen))) {
                    stringsToRemove.add(str);
                } else if (str.charAt(i) == '1' && ((countOnes < countZeroes && oxygen) || (countOnes >= countZeroes && !oxygen))){
                    stringsToRemove.add(str);
                }
            }

            for (String str:stringsToRemove) {
                values.remove(str);
            }

            if (values.size() == 1) break;

        }

        return values.get(0);
    }
}
