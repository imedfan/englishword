
import java.io.IOException;

public class Englishword {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        // String pathEnglish = "C:\\Users\\Home\\dev\\englishwaord\\src\\aaa.txt";
        String pathDic = "src\\dic\\";
        String pathEnglish = "src\\dic\\english.txt";
        String pathAnother = "src\\dic\\another.txt";

        Menu.startMenu(pathDic, pathEnglish, pathAnother);

    }

}
