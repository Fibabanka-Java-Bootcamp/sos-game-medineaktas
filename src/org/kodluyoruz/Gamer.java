package org.kodluyoruz;

abstract class Gamer {

    private char character;
    private int score;
    public abstract char play();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

}
