package main;

class Movement {
    private int step = 1;
    private int disk = 1;
    private char origin = 'A';
    private char destination = 'A';

    // constructor
    Movement(int step, int diskIndex, char origin, char destination) {
//    Movement(int step, Disk disk, Rod origin, Rod destination) {
        this.step = step;
        this.disk = diskIndex;
        this.origin = (Character) origin;
        this.destination = (char) destination;
    }

    public int step() {
        return this.step;
    }

    public int disk() {
        return this.disk;
    }

    public char origin() {
        return this.origin;
    }

    public char destination() {
        return this.destination;
    }
}
