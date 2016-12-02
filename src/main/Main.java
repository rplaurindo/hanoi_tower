package main;

class Main {
    
    public static void main(String[] args) {
        Input input = new Input();
        int disksCount = input.catchInteger();
        HanoiTower h = new HanoiTower(disksCount);
        h.run();

        for (Movement movement : h.movements()) {
            System.out.println("Movimento " + movement.step() + ": " +
                               "mova o disko " + movement.disk() +
                               " da haste " + movement.origin() +
                               " para a haste " + movement.destination()
                               );
        }
    }
    
}
