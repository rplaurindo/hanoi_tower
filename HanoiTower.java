import java.util.ArrayList;

public class HanoiTower {
    private Integer discsCount = 0;

    private Character oddRods[] = {'A', 'B', 'C'};
    private Character pairRods[] = {'A', 'C', 'B'};

    private ArrayList<Integer> startRod = new ArrayList<Integer>();
    private ArrayList<Integer> auxRod = new ArrayList<Integer>();
    private ArrayList<Integer> targetRod = new ArrayList<Integer>();
    private ArrayList<Integer> currentRod = startRod;

    private ArrayList<Movement> movementsList = new ArrayList<Movement>();

    HanoiTower(Integer discsCount) {
        this.discsCount = discsCount;
    }

    private Integer movimentsCount = 0;

    private void prepare() {
        for (int i = 0; i < discsCount; i++) {
            startRod.add(i + 1);
        }
    }

    private void move(int step, int discIndex, char origin, char destination) {
        ArrayList<Integer> destinationRod = new ArrayList<Integer>();
        ArrayList<Integer> originRod = new ArrayList<Integer>();

        switch (origin) {
            case 'A': originRod = startRod;
                break;
            case 'B': originRod = auxRod;
                break;
            default: originRod = targetRod;
        }

        switch (destination) {
            case 'A': destinationRod = startRod;
                break;
            case 'B': destinationRod = auxRod;
                break;
            default: destinationRod = targetRod;
        }

        destinationRod.add(0, originRod.get(0));
        currentRod = destinationRod;

        originRod.remove(originRod.get(0));

        Movement movement = new Movement(step, discIndex, origin, destination);
        movementsList.add(movement);
    }

    private int resolveSmallerDiscIndex (int discIndex1, int discIndex2) {
        if (discIndex1 < discIndex2) {
            return discIndex1;
        } else {
            return discIndex2;
        }
    }

    private int resolveDiscIndex (ArrayList<Integer> currentRod) {
        if (currentRod == startRod) {
            if (auxRod.size() == 0) {
                return targetRod.get(0);
            } else if (targetRod.size() == 0) {
                return auxRod.get(0);
            } else {
                return resolveSmallerDiscIndex(auxRod.get(0),
                                               targetRod.get(0));
            }
        } else if (currentRod == auxRod) {
            if (startRod.size() == 0) {
                return targetRod.get(0);
            } else if (targetRod.size() == 0) {
                return startRod.get(0);
            } else {
                return resolveSmallerDiscIndex(startRod.get(0),
                                               targetRod.get(0));
            }
        } else {
            if (startRod.size() == 0) {
                return auxRod.get(0);
            } else if (auxRod.size() == 0) {
                return startRod.get(0);
            } else {
                return resolveSmallerDiscIndex(startRod.get(0),
                                               auxRod.get(0));
            }
        }

    }

    public ArrayList<Movement> movements() {
        return movementsList;
    }

    public void run() {
        int discIndex = 1;
        int originIndex = 0;
        int destinationIndex = 0;
        Character origin[] = new Character[3];
        Character destination[] = new Character[3];

        prepare();

        // System.out.println("Start rod: " + startRod);
        // System.out.println("Auxiliary rod: " + auxRod);
        // System.out.println("Target rod: " + targetRod);
        // System.out.println("Step 1");

        // first movement
        // if discsCount is odd
        if (discsCount % 2 != 0) {
            origin = oddRods;
            destination = oddRods;
            move(1, discIndex, oddRods[0], oddRods[2]);
        // if discsCount is pair
        } else {
            origin = pairRods;
            destination = pairRods;
            move(1, discIndex, pairRods[0], pairRods[2]);
        }

        movimentsCount = (int) Math.pow(2, discsCount) - 1;

        for (int step = 2; step <= movimentsCount; step++) {
            discIndex = resolveDiscIndex(currentRod);

            if (discIndex % 2 != 0) {
                originIndex = (step - 1)%3;
                destinationIndex = (step + 1)%3;
            } else {
                originIndex = (step + 1)%3;
                destinationIndex = (step - 1)%3;
            }

            // System.out.println("Start rod: " + startRod);
            // System.out.println("Auxiliary rod: " + auxRod);
            // System.out.println("Target rod: " + targetRod);
            // System.out.println("Step: " + step);

            move(step, discIndex, origin[originIndex],
                 destination[destinationIndex]);
        }

        // System.out.println("Start rod: " + startRod);
        // System.out.println("Auxiliary rod: " + auxRod);
        // System.out.println("Target rod: " + targetRod);
    }

}
