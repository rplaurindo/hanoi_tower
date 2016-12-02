class Movement {
    private Integer step = 1;
    private Integer disk = 1;
    private Character origin = 'A';
    private Character destination = 'A';

    // constructor
    Movement(int step, int diskIndex, Character origin, Character destination) {
        this.step = step;
        this.disk = diskIndex;
        this.origin = origin;
        this.destination = destination;
    }

    public int step() {
        return this.step;
    }

    public Integer disk() {
        return this.disk;
    }

    public Character origin() {
        return this.origin;
    }

    public Character destination() {
        return this.destination;
    }
}
