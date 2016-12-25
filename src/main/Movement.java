package main;

class Movement {
    private int step = 1;
//    private int disk = 1;
    private Disk disk;
//    private Rod origin;
//    private Rod destination;
    private char origin;
    private char destination;

    // constructor
//    Movement(int step, int diskIndex, char origin, char destination) {
    Movement(int step, Disk disk, char origin, char destination) {
        this.step = step;
//        disk = diskIndex;
        this.disk = disk;
        this.origin = origin;
        this.destination = destination;
    }

    public int step() {
        return step;
    }

//    public int disk() {
      public Disk disk() {
        return disk;
//        return this.disk.index();
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
