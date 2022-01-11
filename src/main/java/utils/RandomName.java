package utils;

import java.util.Random;

public class RandomName {
    private String[] strArr = {"gilang romadhan", "geelang tester", "gilang parjiyo"};

    public String getRandomName(){
        Random rand = new Random();
        int res = rand.nextInt(strArr.length);
        return strArr[res];
    }
}


