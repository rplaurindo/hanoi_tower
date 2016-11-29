public class Movement {
    private Integer step = 1;
    private Integer disc = 1;
    private Character origin = 'A';
    private Character destination = 'A';

    // constructor
    Movement(int step, int discIndex, Character origin, Character destination) {
        this.step = step;
        this.disc = discIndex;
        this.origin = origin;
        this.destination = destination;
    }

    public int step() {
        return this.step;
    }

    public Integer disc() {
        return this.disc;
    }

    public Character origin() {
        return this.origin;
    }

    public Character destination() {
        return this.destination;
    }
}
