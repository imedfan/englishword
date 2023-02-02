package com.englishlearn.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.englishlearn.demo.model.entity.Word;
import com.englishlearn.demo.service.WordService;
import com.englishlearn.demo.service.impl.WordServiceImpl;

public class WriteNewWord {

    Word word = new Word();
    @Autowired
    WordService wordServiceImpl;

    // @Autowired
    // WordServiceImpl wordServiceImpl = new WordServiceImpl();


    public void startWrite()
            throws IOException, IllegalAccessException {

        // File fileEnglish = new File(pathEnglish);
        // File fileAnother = new File(pathAnother);
        // Word word = new Word();
        // WordServiceImpl wordService = new WordServiceImpl();

        // if (fileEnglish.exists() == true || fileAnother.exists() == true) {

        try {

            // FileOutputStream fileOutputStreamEnglish = new FileOutputStream(fileEnglish,
            // true);
            // false -> true, если надо продолжать писать в файл при его наличии, с false
            // файл будет очищен
            // Writer writeEglish = new OutputStreamWriter(fileOutputStreamEnglish,
            // StandardCharsets.UTF_8);

            // FileOutputStream fileOutputStreamAnother = new FileOutputStream(fileAnother,
            // true);
            // false -> true, если надо продолжать писать в файл при его наличии, с false
            // файл будет очищен
            // Writer writeAnother = new OutputStreamWriter(fileOutputStreamAnother);

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
                Menu.startMenu();
            } else {

                System.out.println(" ");
                System.out.println("Write Another world: ");
                System.out.println(" ");

                BufferedReader bfAnother = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
                String anotherWord = bfAnother.readLine();

                if (anotherWord.equals("CC")) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    Menu.startMenu();
                } else {

                    try {
                        word.setEnglishWord(englishWord);
                        word.setTranslatedWord(anotherWord);
                        wordServiceImpl.addWord(word);
                    } catch (NullPointerException e) {
                        System.out.println("pizda" + e.getMessage());
                    }

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Words " + englishWord + " and " + anotherWord + " has been written");
                    System.out.println(" ");

                }

            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
}
