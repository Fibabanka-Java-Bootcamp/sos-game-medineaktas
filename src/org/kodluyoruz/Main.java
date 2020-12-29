package org.kodluyoruz;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int size ;
    static char[][] table;
    public static void main(String[] args) {
        size = getSize();

        table = new char[size][size];


        boolean tableIsCheck = true;
        BoardTable bordTable = new BoardTable(size, table);
        bordTable.createTable();
        bordTable.showTable();
        ComputerGamer pcGamer = new ComputerGamer();
        PeopleGamer peopleGamer = new PeopleGamer();
        Random rand = new Random();

        int randInt = rand.nextInt(2);


        if (randInt == 0){
            pcGamer.setCharacter(pcGamer.play());
            if (pcGamer.getCharacter() == 'S') {
                System.out.println("O harfini aldınız");

                peopleGamer.setCharacter('0');

            }
            else{
                System.out.println("S harfini aldınız");
                peopleGamer.setCharacter('S');

            }
            while (pcGame(pcGamer,bordTable,tableIsCheck)) {


                if (peopleGame( peopleGamer, bordTable, tableIsCheck)) {


                }
            }

        }
        else {
            peopleGamer.setCharacter(peopleGamer.play());
            if (peopleGamer.getCharacter() == 'S') {
                pcGamer.setCharacter('0');
                System.out.println("S harfini aldınız");

            }
            else{
                pcGamer.setCharacter('S');
                System.out.println("O harfini aldınız");


            }
            while (peopleGame( peopleGamer, bordTable, tableIsCheck)) {

                if (pcGame(pcGamer,bordTable,tableIsCheck)) {

                }
            }

        }



        System.out.println("------------------------------------------");
        System.out.println("Oyun Bitti!");
        System.out.println("Bilgisayar Puanı " +pcGamer.getScore());
        System.out.println("Oyuncu Puanı " +peopleGamer.getScore());


    }

    public static boolean pcGame(ComputerGamer pcGamer, BoardTable bordTable,boolean tableIsCheck ){
        int pcGamerX = -1, pcGamerY = -1;

        boolean tableCoorCheckPc = true;
        System.out.println("Bilgisayar hamlesini yapıyor!");
        while (tableCoorCheckPc) {
            pcGamerX = pcGamer.randomCoordinateXY(size);
            pcGamerY = pcGamer.randomCoordinateXY(size);
            tableCoorCheckPc = bordTable.tableCoordinateCheck(pcGamerX, pcGamerY);
        }
        bordTable.play(pcGamerX, pcGamerY, pcGamer.getCharacter());
        bordTable.showTable();
        pcGamer.setScore(bordTable.score(pcGamer.getCharacter(),pcGamerX,pcGamerY)+pcGamer.getScore());
        System.out.println("Bilgisayar Puanı " +pcGamer.getScore());
        tableIsCheck = bordTable.tableIsCheck();

        return tableIsCheck;
    }


    public static boolean peopleGame(PeopleGamer peopleGamer,BoardTable bordTable,boolean tableIsCheck){
        int peopleGamerX = -1, peopleGamerY = -1;
        boolean tableCoorCheckPeople = true;

        System.out.println("Sıra Sizde!");
        tableCoorCheckPeople = true;
        while (tableCoorCheckPeople) {
            int[] peopleCoor = peopleGamer.coordinate(size);
            peopleGamerX = peopleCoor[0];
            peopleGamerY = peopleCoor[1];

            tableCoorCheckPeople = bordTable.tableCoordinateCheck(peopleGamerX, peopleGamerY);
            bordTable.showTable();
            System.out.println("Lutfen boş alana karakter girişi yapın");
        }
        bordTable.play(peopleGamerX, peopleGamerY, peopleGamer.getCharacter());
        bordTable.showTable();
        peopleGamer.setScore(bordTable.score(peopleGamer.getCharacter(),peopleGamerX,peopleGamerY)+peopleGamer.getScore());
        System.out.println("Oyuncu Puanı " +peopleGamer.getScore());

        return tableIsCheck = bordTable.tableIsCheck();

    }

    public static int  controlSize(){
        Scanner scan = new Scanner(System.in);
        int size = 0;
        while (!scan.hasNextInt()) {
            System.out.println("Lutfen tam sayı değeri giriniz!");
            scan.nextLine();
        }
        size= scan.nextInt();
        return  size ;
    }
    public static int getSize(){
        int size  = 0;
        do{

            System.out.println("Lutfen boyut için 3 ile 7 arasında değer giriniz! ");
            size = controlSize();
        }
        while (size < 3 || size > 7);


        return size;
    }


}


