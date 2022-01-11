package utils;

import java.util.Random;

public class RandomRatePerDay {
    private String[] strArr = {"100000", "150000", "75000", "50000"};

    public String getRatePerDay() {
        Random rand = new Random();
        int res = rand.nextInt(strArr.length);
        return strArr[res];
    }
}
