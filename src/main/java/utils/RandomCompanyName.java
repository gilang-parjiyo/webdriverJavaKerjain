package utils;

import java.util.Random;

public class RandomCompanyName {
    private String[] strArr = {"Apple inc", "Microsoft inc", "Tesla inc"};

    public String getRandomName(){
        Random rand = new Random();
        int res = rand.nextInt(strArr.length);
        return strArr[res];
    }
}


