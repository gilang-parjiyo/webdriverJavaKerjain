package utils;

import java.util.Random;

public class RandomDOB {
    private String[] strArr = {"09-07-1994", "06-05-2000", "06-05/1980", "06-05-1985"};

    public String randomDOB() {
        Random rand = new Random();
        int res = rand.nextInt(strArr.length);
        return strArr[res];
    }
}
