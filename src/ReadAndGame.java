
import java.io.*;

public class ReadAndGame {

    //TODO autoexit game if file ends

    // Remember mode: y/n else you remember word
    public static void startRemember(String path) throws IllegalAccessException{ 
        String s = new String();
        try {
            File file = new File(path);
    
            var fr = new FileReader(file);
    
            BufferedReader reader = new BufferedReader(fr);
    
            LineIterator lineIterator = new LineIterator(reader);

            int niceCount = 0;
            int shitCount = 0;
    
            while (lineIterator.hasNext()) {

                s = lineIterator.nextLine();
                System.out.println(s);
                System.out.println(" ");
                System.out.println("Do you know this word?");
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
                }
            }
    
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void startTranslate(){
        System.out.println("Soon");
    }
    

    
}
