package bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOutputMethods {

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int integer;
        while (true) {
            try {
                integer = scanner.nextInt();
                return integer;
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Type integer value!");
            }
        }
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float floatValue;
        while (true) {
            try {
                floatValue = scanner.nextFloat();
                return floatValue;
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Type float value!");
            }
        }
    }

    public static void stringToFile(String textToWrite, String fileName) {

        BufferedWriter bw = null;
        try {
            String outputString = textToWrite;
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file); // new FileWriter(file , true) - true oznacza, ze zamiast nadpisania pliku to dopisuje string
            bw = new BufferedWriter(fw);
            bw.write(outputString);
            if (bw != null) bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
