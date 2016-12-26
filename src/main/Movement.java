package main;

class Movement {
    private int step = 1;
    private Disk disk;
//    private Rod origin;
//    private Rod destination;
    private char origin;
    private char destination;

    // constructor
//    Movement(int step, Disk disk, Rod origin, Rod destination) {
    Movement(int step, Disk disk, char origin, char destination) {
        this.step = step;
        this.disk = disk;
        this.origin = origin;
        this.destination = destination;
    }

    public int step() {
        return step;
    }

      public Disk disk() {
        return disk;
    }

    public char origin() {
        return origin;
//        return origin.label();
    }

    public char destination() {
        return destination;
//        return destination.label();
    }
}
