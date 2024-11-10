package ru.Bykovets.beards;

import java.util.Random;

public class kukushka extends Beard {
    private Random random = new Random();

    @Override
    public void songes(){
        int count = random.nextInt(10) + 1;

        for(int i = 0; i < count; i++){
            System.out.println("ку-ку ");
        }
    }
}
