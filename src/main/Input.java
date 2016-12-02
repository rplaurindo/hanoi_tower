// for don’t need call the as fully named class for the class "Scanner"
import java.util.Scanner;

class Input {
    public String keyboard(String label, boolean breakLine) {
        String text = "";
        
        if (breakLine) {
            System.out.println(label);
        } else {
            System.out.print(label);
        }
        
        try (Scanner input = new Scanner(System.in);) {
            text = input.next();
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        
        return text;
        
    }

}
