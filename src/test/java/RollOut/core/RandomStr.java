package RollOut.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomStr {
    private static String AlfEng = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String AlfRus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static String AlfRusEng = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static char[] sumb = AlfEng.toCharArray();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printStr(Integer.parseInt(reader.readLine()));
    }

    public static void printStr(int leng) throws IOException {
        for (int i = 0; i < leng; i++) {
            System.out.print(sumb[(int) (Math.random() * AlfEng.length())]);
        }
    }

    public static String getStr(int leng) {
        String line = "";
        for (int i = 0; i < leng; i++) {
            line += (sumb[(int) (Math.random() * AlfEng.length())]);
        }
        return line;
    }
    public static String getRusStr(int leng) {
        String line = "";
        for (int i = 0; i < leng; i++) {
            line += (sumb[(int) (Math.random() * AlfRus.length())]);
        }
        return line;
    }

    public static String getStrDomain(int leng) {
        String line = "";
        for (int i = 0; i < leng; i++) {
            if (i == 63 || i == 127 || i == 191) {
                line += ".";
            } else {
                line += (sumb[(int) (Math.random() * AlfEng.length())]);
            }
        }
        return line;
    }
}
