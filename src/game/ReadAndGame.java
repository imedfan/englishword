package game;

import java.io.*;

import service.LineIterator;

public class ReadAndGame {

    public static void startRemember(String pathDic, String pathEnglish, String pathAnother)
            throws IllegalAccessException {
        String s = new String();
        try {
            File file = new File(pathEnglish);

            var fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            LineIterator lineIterator = new LineIterator(reader);

            int niceCount = 0;
            int shitCount = 0;

            while (lineIterator.hasNext() == true) {

                s = lineIterator.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(" ");
                System.out.println("Do you know this word?");
                System.out.println(" ");
                System.out.println(s);
                System.out.println(" ");

                BufferedReader bfanswer = new BufferedReader(new InputStreamReader(System.in));
                String answer = bfanswer.readLine();

                switch (answer) {

                    case "y":
                        niceCount++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Nice! Next ->");
                        System.out.println(" ");
                        continue;

                    case "n":
                        shitCount++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Shit! Next ->");
                        System.out.println(" ");
                        continue;

                    case "e":
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("You NiceCount: " + niceCount + ". " + "You ShitCount: " + shitCount + ". ");
                        System.out.println(" ");
                        System.exit(0);

                    default:
                        System.out.println("You need press Y or N");

                    case "CC":
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Menu.startMenu(pathDic, pathEnglish, pathAnother);

                }
            }

            while (lineIterator.hasNext() == false) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Words run out");
                System.out.println("You NiceCount: " + niceCount + ". " + "You ShitCount: " + shitCount + ". ");
                System.out.println(" ");
                Menu.startMenu(pathDic, pathEnglish, pathAnother);
            }

        } catch (FileNotFoundException e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("You need to create a dictonary and add new words for learn");
            System.out.println(" ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void startTranslate(String pathEnglish, String pathAnother)
            throws IllegalAccessException, IOException {

        try {
            File fileEnglish = new File(pathEnglish);
            var frEnglish = new FileReader(fileEnglish);
            BufferedReader readerEnglish = new BufferedReader(frEnglish);
            LineIterator lineIteratorEnglish = new LineIterator(readerEnglish);

            File fileAnother = new File(pathAnother);
            var frAnother = new FileReader(fileAnother);
            BufferedReader readerAnother = new BufferedReader(frAnother);
            LineIterator lineIteratorAnother = new LineIterator(readerAnother);

            int niceCount = 0;
            int shitCount = 0;

            start: while (lineIteratorEnglish.hasNext() == true) {

                String wordEnglish = lineIteratorEnglish.nextLine();

                while (lineIteratorAnother.hasNext()) {
                    String wordAnother = lineIteratorAnother.nextLine();

                    System.out.println(wordEnglish);
                    System.out.println(" ");
                    System.out.println("Do you know translate this word?");
                    System.out.println(" ");

                    BufferedReader bfTranslateAnswer = new BufferedReader(new InputStreamReader(System.in));
                    String answer = bfTranslateAnswer.readLine();

                    if (answer.equals(wordAnother)) {
                        niceCount++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Yes! Next ->");
                        System.out.println(" ");
                        continue start;
                    } else if (answer.equals("e")) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("You NiceCount: " + niceCount + ". " + "You ShitCount: " + shitCount + ". ");
                        System.out.println(" ");
                        System.exit(0);
                    } else if (answer.equals("CC")) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Menu.startMenu(answer, pathEnglish, pathAnother);
                    } else {
                        shitCount++;
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Shit! Next ->");
                        System.out.println(" ");
                        continue start;
                    }
                }

            }

            while (lineIteratorEnglish.hasNext() == false) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Words run out");
                System.out.println("You NiceCount: " + niceCount + ". " + "You ShitCount: " + shitCount + ". ");
                System.out.println(" ");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("You need to create a dictonary and add new words for learn");
            System.out.println(" ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
