package game;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteNewWord {

    // TODO add support PATH instead of FILE

    public static void startWrite(String pathDic, String pathEnglish, String pathAnother)
            throws IOException, IllegalAccessException {

        File fileEnglish = new File(pathEnglish);
        File fileAnother = new File(pathAnother);

        if (fileEnglish.exists() == true || fileAnother.exists() == true) {
            try {

                FileOutputStream fileOutputStreamEnglish = new FileOutputStream(fileEnglish, true);
                // false -> true, если надо продолжать писать в файл при его наличии, с false
                // файл будет очищен
                Writer writeEglish = new OutputStreamWriter(fileOutputStreamEnglish, StandardCharsets.UTF_8);

                FileOutputStream fileOutputStreamAnother = new FileOutputStream(fileAnother, true);
                // false -> true, если надо продолжать писать в файл при его наличии, с false
                // файл будет очищен
                Writer writeAnother = new OutputStreamWriter(fileOutputStreamAnother);

                // FileWriter writeEglish = new FileWriter(pathEnglish);
                // FileWriter writeAnother = new FileWriter(pathAnother, "Cp1251");
                // PrintWriter writeAnother = new PrintWriter(pathAnother, "Cp1251");

                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Write English world: (or press CC for cancel) ");
                System.out.println(" ");

                BufferedReader bfenglish = new BufferedReader(new InputStreamReader(System.in));
                String englishWord = bfenglish.readLine();

                if (englishWord.equals("CC")) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Menu.startMenu(pathDic, pathEnglish, pathAnother);
                } else {

                    System.out.println(" ");
                    System.out.println("Write Another world: ");
                    System.out.println(" ");

                    BufferedReader bfAnother = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
                    String anotherWord = bfAnother.readLine();

                    if (anotherWord.equals("CC")) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Menu.startMenu(pathDic, pathEnglish, pathAnother);
                    } else {

                        writeEglish.write(englishWord + System.getProperty("line.separator"));

                        writeEglish.flush();

                        writeEglish.close();
                        writeAnother.write(anotherWord + System.getProperty("line.separator"));
                        // writeAnother.println(anotherWord);

                        writeAnother.flush();

                        writeAnother.close();

                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Words " + englishWord + " and " + anotherWord + " has been written");
                        System.out.println(" ");

                    }

                }

            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } else {

            Setting.createDicFile(pathDic, pathEnglish, pathAnother);

            WriteNewWord.startWrite(pathDic, pathEnglish, pathAnother);

        }

    }
}
