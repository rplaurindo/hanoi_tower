// for don’t need call the complete naming of the class "Scanner"
import java.util.Scanner;

class Input {
    public String keyboard(String label, boolean breakLine) {
        if (breakLine) {
            System.out.println(label);
        } else {
            System.out.print(label);
        }

        Scanner input = new Scanner(System.in);

        return input.next();
    }
}
