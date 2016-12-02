package br.com.home_labs.io.console;

// for don’t need call the as fully named class for the class "Scanner"
import java.util.Scanner;

public class Input {
    
    public String keyboard(String label, boolean breakLine) {
        String text = "";

        if (breakLine) {
            System.out.println(label);
        } else {
            System.out.print(label);
        }

        try (Scanner scanner = new Scanner(System.in);) {
            text = scanner.next();
        }
        catch(Exception e) {
          e.printStackTrace();
        }

        return text;

    }

}
