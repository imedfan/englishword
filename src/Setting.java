import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.processing.SupportedAnnotationTypes;

public class Setting {

    public static void mainMenu(String pathEnglish, String pathAnother) throws IOException{
        System.out.println("Setting");
        System.out.println("--------------------------------");
        System.out.println(" ");
        System.out.println("What do you want?");
        System.out.println(" ");
        System.out.println("1: Delete dictonary file");
        System.out.println("2: Create dictonary file");

        String sureAnswer = "DELETE";
        String sureAnswer2 = "delete";
        String sureAnswer3 = "Delete";

        BufferedReader bfsetting = new BufferedReader(new InputStreamReader(System.in));
        String settingChoose = bfsetting.readLine();

        switch(settingChoose){
            case "1": 
            System.out.println("Are you sure you want to delete?");
            System.out.println("You should print DELETE");
            BufferedReader bfsureDelete = new BufferedReader(new InputStreamReader(System.in));
            String sureDelete = bfsureDelete.readLine();
            if (sureDelete.equals(sureAnswer) || sureDelete.equals(sureAnswer2) || sureDelete.equals(sureAnswer3)){
                deleteDicFile(pathEnglish, pathAnother);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("You dictonary deleted successfully");
            } else {
                System.out.println("You don't print DELETE. Please try again");
            }
            break;
            case "2": createDicFile(pathEnglish, pathAnother);
            break;
        }
    }

    public static void deleteDicFile(String pathEnglish, String pathAnother){
        File fileEnglish = new File(pathEnglish);
        File fileAnother = new File(pathAnother);

        fileEnglish.delete();
        fileAnother.delete();
    } 

    public static void createDicFile(String pathEnglish, String pathAnother) throws IOException{
        File fileEnglish = new File(pathEnglish);
        File fileAnother = new File(pathAnother);

        if (fileEnglish.exists() == true || fileAnother.exists() == true){
            System.out.println("Files already exists");
        } else {
            fileEnglish.createNewFile();
            fileAnother.createNewFile();   
        }


    
    } 
    
}
