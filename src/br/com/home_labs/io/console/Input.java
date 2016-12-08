package br.com.home_labs.io.console;

// for don’t need call the as fully named class for the class "BufferedReader"
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Input {
    
    public String keyboard(String label, boolean breakLine) {
        String text = "";
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        if (breakLine) {
            System.out.println(label);
        } else {
            System.out.print(label);
        }
        
        try {
            text = buffer.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }

        return text;
    }

}
