package utils;

import java.util.Random;

public class RandomSeniority {
    private String[] strArr = {"1", "2", "3", "4", "5"};

    public String getSeniority() {
        Random rand = new Random();
        int res = rand.nextInt(strArr.length);
        return strArr[res];
    }
}
