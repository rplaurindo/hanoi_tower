class Main {
    public static void main(String[] args) {
        HanoiKeyboardInput input = new HanoiKeyboardInput();
        int discsCount = input.catchInteger();
        HanoiTower h = new HanoiTower(discsCount);
        h.run();

        for (Movement movement : h.movements()) {
            System.out.println("Movimento " + movement.step() + ": " +
                               "mova o disco " + movement.disc() +
                               " da haste " + movement.origin() +
                               " para a haste " + movement.destination()
                               );
        }
    }
}
