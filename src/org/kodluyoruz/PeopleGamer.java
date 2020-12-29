package org.kodluyoruz;

import java.util.Random;
import java.util.Scanner;

public class PeopleGamer extends Gamer{


    Scanner scan = new Scanner(System.in);
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



    public int[] coordinate(int size){
        int[] coor =  new int[2];
        System.out.println("Lutfen X  kordinatını giriniz!");
        while (!scan.hasNextInt()) {
            System.out.println("Lutfen X  icin tam sayı değeri giriniz!");
            scan.nextLine();
        }
        int coorX = scan.nextInt();
        System.out.println("Lutfen Y kordinatını  giriniz!");
        while (!scan.hasNextInt()) {
            System.out.println("Lutfen Y koordinatı icin tam sayı değeri giriniz!");
            scan.nextLine();
        }
        int coorY = scan.nextInt();
        boolean sizeIsCheckX, sizeIsCheckY;
        sizeIsCheckX = coorSizeIsCheck(coorX, size);
        sizeIsCheckY = coorSizeIsCheck(coorY,size);
        while (sizeIsCheckX || sizeIsCheckY){
            if(sizeIsCheckX) {
                System.out.println("Lutfen geçerli bir X kordinat değeri girin");
                while (!scan.hasNextInt()) {
                    System.out.println("Lutfen X koordinatı icin tam sayı değeri giriniz!");
                    scan.nextLine();
                }
                coorX = scan.nextInt();
                sizeIsCheckX = coorSizeIsCheck(coorX,size);
            }
            else{
                System.out.println("Lutfen geçerli bir Y kordinat değeri girin");
                while (!scan.hasNextInt()) {
                    System.out.println("Lutfen Y koordinatı icin tam sayı değeri giriniz!");
                    scan.nextLine();
                }
                coorY = scan.nextInt();
                sizeIsCheckY = coorSizeIsCheck(coorY,size);


            }

        }


        coor[0] = coorX;
        coor[1] = coorY;

        return coor;
    }






    public boolean coorSizeIsCheck(int coor, int size){
        boolean isCheck = false;

        if (coor>size-1 || coor<0){
            isCheck = true;

        }


        return isCheck;

    }
}
