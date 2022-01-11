package utils;

import java.util.Random;

public class RandomCity {
    private String[] strArr = {"Banten", "DI Yogyakarta", "Jawa Barat", "Jawa Tengah"};

    public String getRandomCity() {
        Random rand = new Random();
        int res = rand.nextInt(strArr.length);
        return strArr[res];
    }
}
