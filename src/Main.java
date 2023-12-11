import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        String r = null;
        System.out.println(calc(r));
    }
        public static String calc(String input) {
            String finich;
            Scanner s = new Scanner(System.in);
            input = s.nextLine();
            String[] w = input.split("(?=[+\\-*/])|(?<=[+\\-*/])");
            int d = w.length;
            if (d>3){
                throw new IllegalArgumentException("Данная математическая операция не удовлетворяет заданию");
            } else if (d<3) {
                throw new IllegalArgumentException("Выражение не является математической операцией");
            }
            String r = w[0];
            String y = w[2];
            String e = w[1];
            String[] a = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",};
            String[] b = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",};
            Calkulat colc = new Calkulat(r, y, e);
            if ((Arrays.asList(a).contains(r)) && (Arrays.asList(a).contains(y))) {
                finich = (colc.arabInRom());
            } else if ((Arrays.asList(b).contains(r)) && (Arrays.asList(b).contains(y))) {
                finich = String.valueOf((colc.arab()));
            } else {
                if (((Arrays.asList(a).contains(r)) && (Arrays.asList(b).contains(y))) || ((Arrays.asList(b).contains(r)) && (Arrays.asList(a).contains(y)))) {
                    throw new IllegalArgumentException  ("Разные системы счисления");
                } else {
                    throw new IllegalArgumentException("не подходит");
                }
            }
            return finich;
        }
}
class Calkulat {

    private String r;
    private String y;
    private String e;
    private String[] a = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public Calkulat(String r, String y, String e) {
        this.r = r;
        this.y = y;
        this.e = e;
    }

    int convertRom1() {
        int num = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(r)) {
                num = i + 1;
                break;
            }
        }

        if (num == -1) {
            throw new IllegalArgumentException("Не верный формат ввода");
        }

        return num;
    }

    int convertRom2() {
        int num1 = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(y)) {
                num1 = i + 1;
                break;
            }
        }

        if (num1 == -1) {
            throw new IllegalArgumentException("Не верный формат ввода");
        }

        return num1;
    }


    int calkRom() {
        int rom1 = convertRom1();
        int rom2 = convertRom2();
        int result = 0;
        switch (e) {
            case "+":
                result = (rom1 + rom2);
                break;
            case "-":
                result = (rom1 - rom2);
                break;
            case "*":
                result = (rom2 * rom1);
                break;
            case "/":
                result = (rom1 / rom2);
                break;
        }
        return result;

    }

    String arabInRom() {
        int x = calkRom();
        if (x <= 0) {

            throw new IllegalArgumentException("в римской системе нет отрицательных чисел и нуля");
        }
        String[] romanNumerals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (x >= values[i]) {
                x -= values[i];
                roman.append(romanNumerals[i]);
            }
        }
        return roman.toString();
    }

    int arab() {
        int num = Integer.parseInt(r);
        int num2 = Integer.parseInt(y);
        int result = 0;
        if (num >= 1 && num <= 10 && num2 >= 1 && num2 <= 10) {
            switch (e) {
                case "+":
                    result = num + num2;
                    break;
                case "-":
                    result = num - num2;
                    break;
                case "*":
                    result = num * num2;
                    break;
                case "/":
                    result = num / num2;
                    break;
            }
        } else {
            throw new IllegalArgumentException("Не верный формат ввода");
        }
        return result;
    }

}
