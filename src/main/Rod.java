package main;

import java.util.List;

public class Rod {
    private char label;
    private List<Disk> disks;

    Rod(char label) {
        this.label  = label;
    }
    
    public char label () {
        return label;
    }
}
