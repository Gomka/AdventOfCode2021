package Challenges;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Challenge1 implements IChallenge {

    @Override
    public String runChallenge() {

        int numIncrements = 0, previousDepth = -1;
        boolean firstLine = true;


        try (BufferedReader br = new BufferedReader(new FileReader("data/Challenge1Input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                if(firstLine) {
                    previousDepth = Integer.parseInt(line);
                    firstLine = false;
                } else {
                    if(Integer.parseInt(line) > previousDepth) {
                        numIncrements ++;
                    }
                    previousDepth = Integer.parseInt(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ("Challenge 1: " + numIncrements);
    }
}
