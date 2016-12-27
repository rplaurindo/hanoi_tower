package main;

import java.util.ArrayList;

public class HanoiTower {
    
    HanoiTower(int disksCount) {
        this.disksCount = disksCount;
        
        prepare();
    }
    
    private int disksCount = 0;
    private int movimentsCount = 0;
    private ArrayList<Disk> startRod = new ArrayList<Disk>();
    private ArrayList<Disk> auxRod = new ArrayList<Disk>();
    private ArrayList<Disk> targetRod = new ArrayList<Disk>();
    private ArrayList<Disk> currentRod = startRod;
    private ArrayList<Movement> movementsList = new ArrayList<Movement>();

    private void prepare() {
        for (int i = 0; i < disksCount; i++) {
            startRod.add(new Disk(i + 1));
        }
    }

    private void move(int step, Disk disk, char origin, char destination) {
        ArrayList<Disk> destinationRod = new ArrayList<Disk>();
        ArrayList<Disk> originRod = new ArrayList<Disk>();

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

        // FIFO - first-in, first-out
        // não está corretamente abstraído, porque uma torre é uma LIFO (pilha), onde o último a entrar, é o primeiro a sair
//        System.out.println(destinationRod.get(0));
        destinationRod.add(0, originRod.get(0));
        currentRod = destinationRod;

        originRod.remove(originRod.get(0));

        Movement movement = new Movement(step, disk, origin, destination);
        movementsList.add(movement);
    }

    private Disk resolveSmallerDisk(Disk disk1, Disk disk2) {
        if (disk1.index() < disk2.index()) {
          return disk1;
      } else {
          return disk2;
      }
    }

    private Disk resolveDisk (ArrayList<Disk> currentRod) {
        
        if (currentRod == startRod) {
            if (auxRod.size() == 0 && targetRod.size() == 0) {
                return startRod.get(0);
            } else if (auxRod.size() == 0) {
                return targetRod.get(0);
            } else if (targetRod.size() == 0) {
                return auxRod.get(0);
            } else {
                return resolveSmallerDisk(auxRod.get(0),
                                               targetRod.get(0));
            }
        } else if (currentRod == auxRod) {
            if (startRod.size() == 0) {
                return targetRod.get(0);
            } else if (targetRod.size() == 0) {
                return startRod.get(0);
            } else {
                return resolveSmallerDisk(startRod.get(0),
                                               targetRod.get(0));
            }
        } else {
            if (startRod.size() == 0) {
                return auxRod.get(0);
            } else if (auxRod.size() == 0) {
                return startRod.get(0);
            } else {
                return resolveSmallerDisk(startRod.get(0),
                                               auxRod.get(0));
            }
        }

    }

    public ArrayList<Movement> movements() {
        return movementsList;
    }

    public void run() {
        char oddRods[] = {'A', 'B', 'C'};
        char pairRods[] = {'A', 'C', 'B'};
        char rod[] = new char[3];
        
        Disk disk = startRod.get(0);
        int originIndex = 0;
        int destinationIndex = 0;
        char origin[] = new char[3];
        char destination[] = new char[3];

        if (disksCount % 2 != 0) {
            rod = oddRods;
        } else {
            rod = pairRods;
        }
        
        origin = rod;
        destination = rod;
        movimentsCount = (int) Math.pow(2, disksCount) - 1;

        for (int step = 1; step <= movimentsCount; step++) {
            
            disk = resolveDisk(currentRod);
            
            if (disk.index() % 2 != 0) {
                originIndex = (step - 1)%3;
                destinationIndex = (step + 1)%3;
            } else {
                originIndex = (step + 1)%3;
                destinationIndex = (step - 1)%3;
            }

//            System.out.println("Step: " + step);
//            System.out.println("Origin Rod: " + origin[originIndex]);
//            System.out.println("Destination Rod: " + destination[destinationIndex]);
            
            move(step, disk, origin[originIndex],
                 destination[destinationIndex]);
        }

    }

}

class Main {
    
    public static void main(String... args) throws Exception {
        Input input = new Input();
        int disksCount = input.catchInteger();
        HanoiTower h = new HanoiTower(disksCount);
        h.run();
        
        System.out.print("\n");
        for (Movement movement : h.movements()) {
            System.out.println("Movimento " + movement.step() + ": " +
                               "mova o disco " + movement.disk().index() +
                               " da haste " + movement.origin() +
                               " para a haste " + movement.destination()
                              );
        }
    }
    
}