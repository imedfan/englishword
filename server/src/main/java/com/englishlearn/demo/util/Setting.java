package com.englishlearn.demo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;

public class Setting {

    public static void mainMenu(String pathDic, String pathEnglish, String pathAnother)
            throws IOException, IllegalAccessException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Setting");
        System.out.println("--------------------------------");
        System.out.println(" ");
        System.out.println("What do you want?");
        System.out.println(" ");
        System.out.println("1: Create dictonary file");
        System.out.println("2: Delete dictonary file");
        System.out.println("0: Back to menu");

        String sureAnswer = "DELETE";
        String sureAnswer2 = "delete";
        String sureAnswer3 = "Delete";

        BufferedReader bfsetting = new BufferedReader(new InputStreamReader(System.in));
        String settingChoose = bfsetting.readLine();

        switch (settingChoose) {
            case "2":
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Are you sure you want to delete?");
                System.out.println("You should print DELETE");
                System.out.println(" ");
                BufferedReader bfsureDelete = new BufferedReader(new InputStreamReader(System.in));
                String sureDelete = bfsureDelete.readLine();
                if (sureDelete.equals(sureAnswer) || sureDelete.equals(sureAnswer2) || sureDelete.equals(sureAnswer3)) {
                    deleteDicFile(pathDic, pathEnglish, pathAnother);
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("You don't print DELETE. Please try again");
                    System.out.println(" ");
                }
                break;
            case "1":
                createDicFile(pathDic, pathEnglish, pathAnother);
                break;
            case "0":
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menu.startMenu();
                break;
        }
    }

    public static void deleteDicFile(String pathDic, String pathEnglish, String pathAnother) {
        File pathD = new File(pathDic);
        File fileEnglish = new File(pathEnglish);
        File fileAnother = new File(pathAnother);
        if (fileEnglish.exists() == true || fileAnother.exists() == true) {
            fileEnglish.delete();
            fileAnother.delete();
            pathD.delete();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("You dictonary deleted successfully");
            System.out.println(" ");
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("You can't delete not exist file");
            System.out.println(" ");

        }

    }

    public static void createDicFile(String pathDic, String pathEnglish, String pathAnother) throws IOException {

        File pathD = new File(pathDic);
        pathD.mkdir();
        File fileEnglish = new File(pathEnglish);
        File fileAnother = new File(pathAnother);

        if (fileEnglish.exists() == true || fileAnother.exists() == true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Files already exists");
            System.out.println(" ");
        } else {
            fileEnglish.createNewFile();
            fileAnother.createNewFile();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("New dictonary files created");
            System.out.println(" ");
        }

    }

}
