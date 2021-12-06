package Challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Challenge1 implements IChallenge {

    @Override
    public String runChallenge() {

        return ("Challenge 1: \n"+
                "   Part one: " + partOne() +"\n" +
                "   Part two: " + partTwo());
    }

    public int partOne() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numIncrements;
    }

    public int partTwo() {
        int numIncrements = 0, previousDepth = -1;
        Stack<Integer> st = new Stack<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/Challenge1Input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                st.push(Integer.parseInt(line));

                if(st.size() >= 3) {
                    if(previousDepth < 0) {
                        previousDepth = st.get(0) + st.get(1) + st.get(2);
                    } else {
                        if (previousDepth < st.get(0) + st.get(1) + st.get(2)) {
                            numIncrements++;
                        }
                        previousDepth = st.get(0) + st.get(1) + st.get(2);
                    }

                    st.remove(0);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numIncrements;
    }
}
