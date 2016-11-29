// for don’t need call the complete naming of the class "Scanner"
import java.util.Scanner;

class Input {
    public String keyboard(String label) {
        System.out.print(label);
        Scanner input = new Scanner(System.in);
        // java.util.Scanner input = new java.util.Scanner(System.in);

        return input.next();
    }
}
