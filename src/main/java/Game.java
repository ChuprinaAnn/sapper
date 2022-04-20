import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setOut;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int progressGame = 15;
        System.out.println("Обезвредьте все бомбы менее, чем за " + progressGame + " ходов!");
        System.out.println("Генерация карты");
        ArrayList<Bomb> bombs = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            x.add(i,0);
        }
        ArrayList<Integer> y = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
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
        int progress = 0;
        do {
            progress+=1;
            int countBomb = 0;
            System.out.println("Вводите числа от 1 до 5. Поле задаётся координатами х и у. " + "Всего на поле бомб: " + max +
                    " Введите x:");
            int userX = in.nextInt() - 1;
            System.out.println("Введите y:");
            int userY = in.nextInt() - 1;
            int X = 0; //счётчик х
            int Y = 0;// счётчик y
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) == userX)
                    X+=1;
            }
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i) == userY)
                    Y+=1;
            }
            if (X==1 && Y==1) { countBomb +=1;
                System.out.println(countBomb + "/" + max + " бомб обезврежено. У вас осталось " + (progressGame-progress) + "ходов");
            }
            else {
                System.out.println("Мимо! " + countBomb + "/" + max + " бомб обезврежено. У вас осталось " + (progressGame-progress) + " ходов");
            }
            if (countBomb == max) {
                System.out.println("Вы обезвредели все бомбы! Вы выиграли!");
                break;
            }
            if (progress == 15) {
                System.out.println("Вы проиграли!");
            }
        } while (progress < 15);
    }
}
