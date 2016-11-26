import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.InputMismatchException;

// class Movement implements Comparable<Movement> {
class Movement {
    // private Integer index;
    private Integer step;
    private String direction;

    // constructor
    // Movement(int index, String direction) {
    Movement(int step, String direction) {
        // setIndex(index);
        setStep(step);
        setMovement(direction);
    }

    // private void setIndex (int number) {
    //     this.index = number;
    // }

    private void setStep (int number) {
        this.step = number;
    }

    private void setMovement (String direction) {
        this.direction = direction;
    }

    // public int index() {
    //     return this.index;
    // }

    public int step() {
        return this.step;
    }

    public String direction() {
        return this.direction;
    }

    // public int compareTo(Movement disc) {
    //     return this.index.compareTo(disc.index);
    // }
}

class Input {
    public static int catchInteger() {
        System.out.print("Digite a quantidade de  discos: ");
        Scanner input = new Scanner(System.in);
        int intInput = 0;

        try {
            intInput = input.nextInt();
        } catch(InputMismatchException e) {
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

    // private String possibleMovements[] = {
    //     "A-->B",
    //     "A-->C",
    //     "B-->A",
    //     "B-->C",
    //     "C-->B",
    //     "C-->A"
    // };

    private Integer movimentsCount = (int) Math.pow(2, discsCount) - 1;
    private ArrayList<Integer> startRod = new ArrayList<Integer>();
    private ArrayList<Integer> auxRod = new ArrayList<Integer>();
    private ArrayList<Integer> targetRod = new ArrayList<Integer>();
    private ArrayList<Integer> currentRod = new ArrayList<Integer>();
    private ArrayList<Movement> movementsList = new ArrayList<Movement>();
    private int disc = 1;

    private void prepare() {
        for (int i = 0; i < discsCount; i++) {
            startRod.add(i + 1);
        }
    }

    // private String sequenciaImpares[] = {"A-->C", "C-->B", "B-->A"};
    // private String sequenciaPares[] = {"A-->B", "B-->C", "C-->A"};

    // private void move(int pos, int intervalos, int maxP, int y) {
    // private void move(int pos, int intervalos, int maxP, int y) {
    // private void movePair(int movimentsCount) {
    // private void moveWhenPair(int step, String direction, ArrayList<Integer> fromRod,
    private void move(int step, String direction, ArrayList<Integer> fromRod,
                          ArrayList<Integer> toRod) {
        // int index = 0;

        // for (int i = pos; i <= maxP; i += intervalos) {
        // move from A to B

        Movement movement = new Movement(step, direction);
        movementsList.add(movement);

        toRod.add(fromRod.get(0));
        fromRod.remove(fromRod.get(0));



       // } else {
       //      for (int i = pos; i <= maxP; i += intervalos) {
       //          Movement movement = new Movement(i, sequenciaPares[index]);
       //          movementsList.add(movement);
       //          index++;

       //          if(index > 2){
       //              index = 0;
       //          }
       //      }
       // }
    }

    public ArrayList<Movement> movements() {
        return movementsList;
    }

    public void run() {
        prepare();
        int step = 1;

        // if discsCount is pair
        if (discsCount % 2 == 0) {
            // while(step < movimentsCount) {
                if (startRod.size() == discsCount) {
                    // qualquer coisa fazer um método para eleger para onde vai
                    currentRod = auxRod;
                    move(step, "A-->B", startRod, auxRod);
                } else () {
                    currentRod = targetRod;
                    move(step, "A-->C", startRod, targetRod);
                } else () {
                    currentRod = targetRod;
                    move(step, "B-->C", auxRod, targetRod);
                } else () {
                    currentRod = startRod;
                    move(step, "B-->A", auxRod, startRod);
                } else () {
                    currentRod = auxRod;
                    move(step, "C-->B", targetRod, auxRod);
                } else () {
                    currentRod = startRod;
                    move(step, "C-->A", targetRod, startRod);
                }

                step += 1;
            // }

        // if discsCount is odd
        } else {
            // while(targetRod.size() < discsCount) {
                if (startRod.size() == discsCount) {
                    currentRod = auxRod;
                    move(step, "A-->C", startRod, targetRod);
                } else () {
                    currentRod = targetRod;
                    move(step, "A-->B", startRod, auxRod);
                } else () {
                    currentRod = targetRod;
                    move(step, "B-->C", auxRod, targetRod);
                } else () {
                    currentRod = startRod;
                    move(step, "B-->A", auxRod, startRod);
                } else () {
                    currentRod = auxRod;
                    move(step, "C-->B", targetRod, auxRod);
                } else () {
                    currentRod = startRod;
                    move(step, "C-->A", targetRod, startRod);
                }
                step += 1;
            // }
        }

    }

}


class Main {
    public static void main(String[] args) {
        int discsCount = Input.catchInteger();
        HanoiTower h = new HanoiTower(discsCount);
        h.run();

        // ArrayList<Movement> movementCollection = new ArrayList<Movement>();
        // movementCollection = h.movements();

        // // Collections.sort(movementCollection);

        // // for (Movement movement : movementCollection) {
        for (Movement movement : h.movements()) {
            System.out.println("Movimento " + movement
                               .step() + ": " + movement.direction());
        }
    }
}
