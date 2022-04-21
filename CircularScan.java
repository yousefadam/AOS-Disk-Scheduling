import java.util.ArrayList;

public class CircularScan extends DiskScheduler{
    int diskSize;
    CircularScan(ArrayList<Integer> initialSequence, int initialHeadStart, int diskSize) {
        super(initialSequence, initialHeadStart);
        this.diskSize = diskSize;
    }

    @Override
    public void run() {

    }

    @Override
    public void printResults() {

    }
}
