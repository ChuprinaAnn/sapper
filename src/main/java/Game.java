import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setOut;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int progressGame = 15;
//        System.out.println("Обезвредьте все бомбы менее, чем за " + progressGame + " ходов!");
        System.out.println("Генерация карты");
        System.out.println("Введите размер поля:");
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("[ | | | | ]");
        }
        ArrayList<Bomb> bombs = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            x.add(i,0);
        }
        ArrayList<Integer> y = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            y.add(i,0);
        }
        Map map = new Map(x,y);
        int max = (int) (1+Math.random() * 5);//количество бомб
        while (bombs.size() < max) {
            bombs.add(new Bomb((int)(Math.random() * 5), (int)(Math.random() * 5))); //создадим случайную бомбу
        }
        for (int i = 0; i < x.size(); i++) {
            for (int j = 0; j < bombs.size(); j++) {
                if (i == bombs.get(j).getX()) {
                    x.remove(i);
                    x.add(i, 1);
                }
            }
        }
        for (int i = 0; i < y.size(); i++) {
            for (int j = 0; j < bombs.size(); j++) {
                if (i == bombs.get(j).getY()) {
                    y.remove(i);
                    y.add(i, 1);
                }
            }
        }
        String[][] matrixA;
        matrixA = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixA[i][j]="0";
            }
            
        }
        int progress = 0; int countBomb = 0;
        do {
            progress+=1;
            System.out.println("Вводите числа от 1 до 5. Поле задаётся координатами х и у. " + "Всего на поле бомб: " + max +
                    " Введите x:");
            int userX = in.nextInt() - 1;
            System.out.println("Введите y:");
            int userY = in.nextInt() - 1;
            int a=0;
            if (x.get(userX-1) == 1 && y.get(userY-1) == 1) {
                a+=1;
            }
            if (x.get(userX) == 1 && y.get(userY-1) == 1) {
                a+=1;
            }
            if (x.get(userX+1) == 1 && y.get(userY-1) == 1) {
                a+=1;
            }
            if (x.get(userX-1) == 1 && y.get(userY) == 1) {
                a+=1;
            }
            if (x.get(userX+1) == 1 && y.get(userY) == 1) {
                a+=1;
            }
            if (x.get(userX-1) == 1 && y.get(userY+1) == 1) {
                a+=1;
            }
            if (x.get(userX) == 1 && y.get(userY+1) == 1) {
                a+=1;
            }
            if (x.get(userX+1) == 1 && y.get(userY+1) == 1) {
                a+=1;
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(matrixA[i][j] + "|");
                } System.out.println();
            }System.out.println(" ");
            System.out.println(" ");
            int X = 0; //счётчик х
            int Y = 0;// счётчик y
                if (x.get(userX) == 1)
                    X+=1;

                if (y.get(userY) == 1)
                    Y+=1;
            if (X==1 && Y==1) { countBomb +=1;
                System.out.println("Взрыв!");
                matrixA[userX][userY]="B";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrixA[i][j] + "|");
                    } System.out.println();
                }System.out.println(" ");
                break;
            }

            else {
                System.out.println("Мимо! " + countBomb + "/" + max + " бомб обезврежено.");
                matrixA[userX][userY] = "X";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrixA[i][j] + "|");
                    } System.out.println();
                }System.out.println(" ");
            }
            if (countBomb == max) {
                System.out.println("Вы обезвредели все бомбы! Вы выиграли!");
                break;
            }
        } while (countBomb<max);
    }
}
