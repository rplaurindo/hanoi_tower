import java.util.ArrayList;
import java.util.Scanner;

class Movement {
    // private Integer index;
    private Integer step;
    private Integer from;
    private Integer to;

    // constructor
    Movement(int step, int disc, char from, char to) {
        this.step = step;
        this.step = disc;
        this.from = from;
        this.to = to;
    }

    public int step() {
        return this.step;
    }

    public String from() {
        return this.from;
    }

    public String to() {
        return this.to;
    }

    public String disc() {
        return this.disc;
    }
}


class HanoiKeyboardInput {
    public int catchInteger() {
        Input input = new Input();
        String stringIn = input.keyboard("Digite a quantidade de  discos: ");
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

class HanoiTower {
    private Integer discsCount = 0;

    HanoiTower(Integer discsCount) {
        this.discsCount = discsCount;
    }

    private Integer movimentsCount = (int) Math.pow(2, discsCount) - 1;

    private char oddRods[] = {"A", "B", "C"};
    private char pairRods[] = {"A", "C", "B"};

    private ArrayList<Integer> startRod = new ArrayList<Integer>();
    private ArrayList<Integer> auxRod = new ArrayList<Integer>();
    private ArrayList<Integer> targetRod = new ArrayList<Integer>();
    private ArrayList<Integer> currentRod = new ArrayList<Integer>();

    private ArrayList<Movement> movementsList = new ArrayList<Movement>();

    private void prepare() {
        for (int i = 0; i < discsCount; i++) {
            startRod.add(i + 1);
        }
    }

    // private void move(int step, int disc, ArrayList<Integer> from,
    //                   ArrayList<Integer> to) {

    private void move(int step, char from, char to) {
        ArrayList<Integer> toRod = new ArrayList<Integer>();
        ArrayList<Integer> fromRod = new ArrayList<Integer>();

        switch (to) {
            case "A": toRod = startRod;
                break;
            case "B": toRod = auxRod;
                break;
            default: toRod = targetRod;
        }

        switch (from) {
            case "A": fromRod = startRod;
                break;
            case "B": fromRod = auxRod;
                break;
            default: fromRod = targetRod;
        }

        toRod.add(fromRod.get(0));
        fromRod.remove(fromRod.get(0));
        Movement movement = new Movement(step, toRod.get(0), from, to);
        movementsList.add(movement);
    }

    public ArrayList<Movement> movements() {
        return movementsList;
    }

    private int resolveSmallerDiscIndex (int discIndex1, int discIndex2) {
        if (discIndex1 < discIndex2) {
            return discIndex1;
        } else {
            return discIndex2;
        }
    }

    private int resolveDiskIndex (ArrayList<Integer> currentRod) {
        int discIndex1  = 0;
        int discIndex2  = 0;

        switch (currentRod) {
            case startRod: {
                try {
                    discIndex1 = auxRod.get(0);
                } catch (NullPointerException e) {
                    return targetRod.get(0);
                }

                try {
                    discIndex2 = targetRod.get(0);
                } catch (NullPointerException e) {
                    return auxRod.get(0);
                }

                return resolveSmallerDiscIndex(auxRod.get(0), targetRod.get(0));
            }
            case auxRod: {
                try {
                    discIndex1 = startRod.get(0);
                } catch (NullPointerException e) {
                    return targetRod.get(0);
                }

                try {
                    discIndex2 = targetRod.get(0);
                } catch (NullPointerException e) {
                    return startRod.get(0);
                }

                return resolveSmallerDiscIndex(startRod.get(0),
                                               targetRod.get(0));
            }
            default: {
                try {
                    discIndex1 = startRod.get(0);
                } catch (NullPointerException e) {
                    return auxRod.get(0);
                }

                try {
                    discIndex2 = auxRod.get(0);
                } catch (NullPointerException e) {
                    return startRod.get(0);
                }

                return resolveSmallerDiscIndex(startRod.get(0), auxRod.get(0));
            }
        }


    }

    public void run() {
        prepare();

        currentRod = startRod;
        // first movement
        // if discsCount is odd
        if (discsCount % 2 != 0) {
            move(1, 1, oddRods[0], oddRods[2]);
        } else {
            move(1, 1, pairRods[0], pairRods[2]);
        }

        for (int step = 2; i <= movimentsCount; i++) {
            switch (currentRod) {
                // case startRod: ...;
                //     break;
                // case auxRod: ...;
                //     break;
                // default: ...;
            }
        }

    }

}


class Main {
    public static void main(String[] args) {
        HanoiKeyboardInput input = new HanoiKeyboardInput();
        int discsCount = input.catchInteger();
        HanoiTower h = new HanoiTower(discsCount);
        h.run();

        for (Movement movement : h.movements()) {
            System.out.println("Movimento " + movement.step() + ": " +
                               "mova o disco " + movement.disc() +
                               " da haste " + movement.from() +
                               " para a haste " + movement.to();
        }
    }
}
