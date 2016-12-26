package main;

//public class Disk implements Comparable<Disk> {
public class Disk {

    // this isn't necessary, because that is used for sort
//    @Override
//    public int compareTo(Disk disk) {
//        if (index() < disk.index()) {
//            return index();
//        } else {
//            return disk.index();
//        }
//    }
    
    private int index;
    // this isn't necessary, because a disk belongs to a rod, not it has one rod
//    private Rod rod;
    
    Disk(int index) {
        this.index = index;
    }
    
    public int index() {
        return index;
    }

}
