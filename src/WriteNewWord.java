
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteNewWord {

    // TODO add support PATH instead of FILE

    public static void startWrite(String pathEnglish, String pathAnother) {
        // public static void startWrite(){
        try {

            
            File fileEnglish = new File(pathEnglish);
            fileEnglish.createNewFile(); // если файл существует - команда игнорируется
            FileOutputStream fileOutputStreamEnglish = new FileOutputStream(fileEnglish, true);
            // false -> true, если надо продолжать писать в файл при его наличии, с false
            // файл будет очищен
            Writer writeEglish = new OutputStreamWriter(fileOutputStreamEnglish, StandardCharsets.UTF_8);

            File fileAnother = new File(pathAnother);
            fileAnother.createNewFile(); // если файл существует - команда игнорируется
            FileOutputStream fileOutputStreamAnother = new FileOutputStream(fileAnother, true);
            // false -> true, если надо продолжать писать в файл при его наличии, с false
            // файл будет очищен
            Writer writeAnother = new OutputStreamWriter(fileOutputStreamAnother);

            // FileWriter writeEglish = new FileWriter(pathEnglish);
            // FileWriter writeAnother = new FileWriter(pathAnother, "Cp1251");
            // PrintWriter writeAnother = new PrintWriter(pathAnother, "Cp1251");

            System.out.println("Write English world: ");

            BufferedReader bfenglish = new BufferedReader(new InputStreamReader(System.in));
            String englishWord = bfenglish.readLine();

            System.out.println(englishWord);

            writeEglish.write(englishWord + System.getProperty("line.separator"));

            writeEglish.flush();

            writeEglish.close();

            System.out.println("Write Another world: ");

            BufferedReader bfAnother = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
            String anotherWord = bfAnother.readLine();

            System.out.println(anotherWord);

            writeAnother.write(anotherWord + System.getProperty("line.separator"));
            // writeAnother.println(anotherWord);

            writeAnother.flush();

            writeAnother.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
