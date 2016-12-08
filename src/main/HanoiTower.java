package main;

import java.util.ArrayList;

public class HanoiTower {
    private int disksCount = 0;

    private char oddRods[] = {'A', 'B', 'C'};
    private char pairRods[] = {'A', 'C', 'B'};

    private ArrayList<Integer> startRod = new ArrayList<Integer>();
    private ArrayList<Integer> auxRod = new ArrayList<Integer>();
    private ArrayList<Integer> targetRod = new ArrayList<Integer>();
    private ArrayList<Integer> currentRod = startRod;

    private ArrayList<Movement> movementsList = new ArrayList<Movement>();

    HanoiTower(int disksCount) {
        this.disksCount = disksCount;
    }

    private Integer movimentsCount = 0;

    private void prepare() {
        for (int i = 0; i < disksCount; i++) {
            startRod.add(i + 1);
        }
    }

    private void move(int step, int diskIndex, char origin, char destination) {
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

        Movement movement = new Movement(step, diskIndex, origin, destination);
        movementsList.add(movement);
    }

    private int resolveSmallerDiskIndex (int diskIndex1, int diskIndex2) {
        if (diskIndex1 < diskIndex2) {
            return diskIndex1;
        } else {
            return diskIndex2;
        }
    }

    private int resolveDiskIndex (ArrayList<Integer> currentRod) {
        if (currentRod == startRod) {
            if (auxRod.size() == 0) {
                return targetRod.get(0);
            } else if (targetRod.size() == 0) {
                return auxRod.get(0);
            } else {
                return resolveSmallerDiskIndex(auxRod.get(0),
                                               targetRod.get(0));
            }
        } else if (currentRod == auxRod) {
            if (startRod.size() == 0) {
                return targetRod.get(0);
            } else if (targetRod.size() == 0) {
                return startRod.get(0);
            } else {
                return resolveSmallerDiskIndex(startRod.get(0),
                                               targetRod.get(0));
            }
        } else {
            if (startRod.size() == 0) {
                return auxRod.get(0);
            } else if (auxRod.size() == 0) {
                return startRod.get(0);
            } else {
                return resolveSmallerDiskIndex(startRod.get(0),
                                               auxRod.get(0));
            }
        }

    }

    public ArrayList<Movement> movements() {
        return movementsList;
    }

    public void run() {
        int diskIndex = 1;
        int originIndex = 0;
        int destinationIndex = 0;
        char origin[] = new char[3];
        char destination[] = new char[3];

        prepare();

        // System.out.println("Start rod: " + startRod);
        // System.out.println("Auxiliary rod: " + auxRod);
        // System.out.println("Target rod: " + targetRod);
        // System.out.println("Step 1");

        // first movement
        // if disksCount is odd
        if (disksCount % 2 != 0) {
            origin = oddRods;
            destination = oddRods;
            move(1, diskIndex, oddRods[0], oddRods[2]);
        // if disksCount is pair
        } else {
            origin = pairRods;
            destination = pairRods;
            move(1, diskIndex, pairRods[0], pairRods[2]);
        }

        movimentsCount = (int) Math.pow(2, disksCount) - 1;

        for (int step = 2; step <= movimentsCount; step++) {
            diskIndex = resolveDiskIndex(currentRod);

            if (diskIndex % 2 != 0) {
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

            move(step, diskIndex, origin[originIndex],
                 destination[destinationIndex]);
        }

        // System.out.println("Start rod: " + startRod);
        // System.out.println("Auxiliary rod: " + auxRod);
        // System.out.println("Target rod: " + targetRod);
    }

}
