import java.util.Scanner;

public class Input {
    public String keyboard(String label) {
        System.out.print(label);
        Scanner input = new Scanner(System.in);

        return input.next();
    }
}
