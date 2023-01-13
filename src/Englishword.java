

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Englishword {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        String pathEnglish = "C:\\Users\\Home\\dev\\englishwaord\\src\\aaa.txt";
        String pathAnother = "C:\\Users\\Home\\dev\\englishwaord\\src\\bbb.txt";



        System.out.println("What do you want?");
        System.out.println("1: Add a new word");
        System.out.println("2: Start a new remember mode game");
        System.out.println("3: Start a new translate mode game");
        System.out.println("4: Open setting");

        BufferedReader bfMainMenu = new BufferedReader(new InputStreamReader(System.in));
        String MainMenu = bfMainMenu.readLine();

        switch (MainMenu) {
            case "1":
                WriteNewWord.startWrite(pathEnglish, pathAnother);
                break;
            case "2":
                ReadAndGame.startRemember(pathEnglish);
                break;
            case "3":
                ReadAndGame.startTranslate(pathEnglish, pathAnother);
                break;
            case "4":
                Setting.mainMenu(pathEnglish, pathAnother);
        }

    }

}
