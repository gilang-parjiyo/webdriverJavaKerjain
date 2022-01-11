package utils;

import java.util.Random;

public class RandomSpeciality {
    private String[] strArr = {"Construction", "Painter", "Cleaning"};

    public String getRandomJob() {
        Random rand = new Random();
        int res = rand.nextInt(strArr.length);
        return strArr[res];
    }
}
