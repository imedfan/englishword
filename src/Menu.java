import java.io.*;

public class Menu {
    
    public static void  printMenu(){
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
        System.out.println("What do you want?");
        System.out.println("1: Add a new word");
        System.out.println("2: Start a new remember mode game");
        System.out.println("3: Start a new translate mode game");
        System.out.println("4: Open setting");
        System.out.println(" ");
    }

    public static void startMenu(String pathDic, String pathEnglish, String pathAnother) throws IOException, IllegalAccessException{
        String mainMenu = new String();
        do{
            printMenu();

            BufferedReader bfMainMenu = new BufferedReader(new InputStreamReader(System.in));
            mainMenu = bfMainMenu.readLine();

            switch (mainMenu) {
                case "1":
                    WriteNewWord.startWrite(pathDic, pathEnglish, pathAnother);
                    startMenu(pathDic, pathEnglish, pathAnother);
                case "2":
                    ReadAndGame.startRemember(pathDic, pathEnglish, pathAnother);
                    startMenu(pathDic, pathEnglish, pathAnother);
                case "3":
                    ReadAndGame.startTranslate(pathEnglish, pathAnother);
                    startMenu(pathDic, pathEnglish, pathAnother);
                case "4":
                    Setting.mainMenu(pathDic, pathEnglish, pathAnother);
                    startMenu(pathDic, pathEnglish, pathAnother);
                default: 
                    System.out.println("You need choose menu option");
                    startMenu(pathDic, pathEnglish, pathAnother);
                case "e": 
                    System.exit(0);
            }


        } while (mainMenu.equals("e"));
    }

}
