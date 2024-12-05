package org.kodluyoruz;

public class BoardTable {

    private int size;
    public static char table[][];



    public BoardTable(int size, char[][] table) {
        this.size = size;
        this.table = table;

    }

    public void showTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print(i+" ");
            for (int  j = 0; j < table.length; j++) {


                if (j == 0 && i == 0){
                    for (int k = 0; k <table.length ; k++) {
                        System.out.print(k+" ");

                    }
                    System.out.println();

                }
                if(i == 0 && j == 0){
                       System.out.print("0"+" "+table[i][j]+" ");
                }
                else {
                    System.out.print(table[i][j] + " ");

                }



            }

            System.out.println();

        }
    }

    public void createTable() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                table[i][j] = '-';



            }

        }


    }

    public boolean tableCoordinateCheck(int xCoor, int yCoor) {
        boolean isCheck = true;
        if (table[xCoor][yCoor] == ('-')) {
            isCheck = false;

        }
        return isCheck;


    }

    public char[][] play(int xCoor, int yCoor, char charecter) {
        table[xCoor][yCoor] = charecter;

        return table;
    }

    public boolean tableIsCheck() {
        boolean isCheck = false;
        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == '-') {
                    count += 1;
                }
            }
        }

        if (count > 0) {
            isCheck = true;
        }

        return isCheck;
    }

    public int score(char character, int x, int y) {
        int scor = 0;
        if (character == 'S') {
            if ((x < size && y + 2 < size)) {
                if (table[x][y + 1] == 'O' && table[x][y + 2] == 'S') {
                    System.out.println(" S harfi yana dogru sos yapıldı");
                    scor+=1;
                }
            }
            if (x + 2 < size && y < size) {
                if (table[x + 1][y] == 'O' && table[x + 2][y] == 'S') {
                    System.out.println("S harfi asagı dogru sos yapıldı");
                    scor+=1;

                }
            }
            if (x - 2 >= 0 && y < size) {
                if (table[x - 1][y] == 'O' && table[x - 2][y] == 'S') {
                    System.out.println("S harfi yukarı dogru sos yapıldı");
                    scor+=1;

                }
            }
            if (x < size && y - 2 >= 0) {
                if (table[x][y - 1] == 'O' && table[x][y - 2] == 'S') {
                    System.out.println("S harfi yana geri sos yapıldı");
                    scor+=1;

                }
            }
            if (x - 2 >= 0 && y - 2 >= 0) {
                if (table[x - 1][y - 1] == 'O' && table[x - 2][y - 2] == 'S') {
                    System.out.println("S harfi capraz geri sos yapıldı");
                    scor+=1;

                }
            }
            if (x + 2 < size && y + 2 < size) {
                if (table[x + 1][y + 1] == 'O' && table[x + 2][y + 2] == 'S') {
                    System.out.println("S harfi capraz ileri sos yapıldı");
                    scor+=1;

                }
            }
            if (x - 2 >= 0 && y + 2 < size) {
                if (table[x - 1][y + 1] == 'O' && table[x - 2][y + 2] == 'S') {
                    System.out.println("S harfi capraz ileri sos yapıldı");
                    scor+=1;

                }
            }
            if (y - 2 >= 0 && x + 2 < size) {
                if (table[x + 1][y - 1] == 'O' && table[x + 2][y - 2] == 'S') {
                    System.out.println("S harfi capraz ileri sos yapıldı");
                    scor+=1;

                }
            }

        }


        if (character == 'O') {
            if (x < size && y + 1 < size && y - 1 >= 0) {
                if (table[x][y + 1] == 'S' && table[x][y - 1] == 'S') {
                    System.out.println("O harfi yatay sos");
                    scor+=1;

                }
            }
            if (x + 1 < size && y < size && x - 1 >= 0) {
                if (table[x - 1][y] == 'S' && table[x + 1][y] == 'S') {
                    System.out.println("O harfi dikey sos");
                    scor+=1;

                }
            }
            if (x - 1 >= 0 && y + 1 < size && x + 1 < size && y - 1 >= 0) {
                if (table[x - 1][y + 1] == 'S' && table[x + 1][y - 1] == 'S') {
                    System.out.println("O harfi   çapraz sos");
                    scor+=1;

                }
            }
            if (x - 1 >= 0 && y - 1 >= 0 && x + 1 < size && y + 1 < size) {
                if (table[x - 1][y - 1] == 'S' && table[x + 1][y + 1] == 'S') {
                    System.out.println("O harfi   çapraz sos");
                    scor+=1;

                }
            }
        }
        return scor;
    }
}


