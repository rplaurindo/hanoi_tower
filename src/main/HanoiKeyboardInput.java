package main;

import br.com.home_labs.io.console.Input;

public class HanoiKeyboardInput {
    public int catchInteger() {
        Input input = new Input();
        String stringIn = input.keyboard("Digite a quantidade de  discos: ", false);
        int intInput = 0;

        try {
            intInput = Integer.parseInt(stringIn);
        } catch(NumberFormatException e) {
            System.out.println("Entrada inválida!");
            catchInteger();
        }

        return intInput;
    }
}
