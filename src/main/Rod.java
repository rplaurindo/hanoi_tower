package main;

import java.util.List;

public class Rod {
    private char label;
    private List<Disk> disks;

    Rod(char label, Disk... disks) {
        this.label  = label;
//        List<Disk> initDiskList = new ArrayList<Disk>(disks);
//        this.disks = (ArrayList<Disk>) disks;
    }
    
    public char label() {
        return label;
    }
    
    public void addDisk(Disk disk) {
        disks.add(disk);
    }
    
    public void moveDisk(Disk disk, Rod rod) {
        disks.remove(disk);
        rod.addDisk(disk);
    }
}
