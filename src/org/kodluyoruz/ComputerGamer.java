package org.kodluyoruz;

import java.util.Random;

public class ComputerGamer extends Gamer {




    @Override
    public char play() {
        Random rand = new Random();

        int randInt = rand.nextInt(2);
        if (randInt == 0){
            setCharacter('S');

        }
        else{
            setCharacter('O');
        }

    return getCharacter();


    }

    public int randomCoordinateXY(int size){
        Random rand = new Random();
        int randInt = rand.nextInt(size);

        return randInt;


    }

}
