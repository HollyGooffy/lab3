package ru.Bykovets.beards;

import java.util.Random;

public class popugai extends Beard {
    private String text;
    private Random random = new Random();

    public popugai(String text) {
        this.text = text;
    }

    @Override
    public void songes() {
        int n = random.nextInt(text.length() + 1);
        System.out.println(text.substring(0,n));
    }
}

