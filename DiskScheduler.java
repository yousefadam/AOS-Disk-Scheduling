import java.util.ArrayList;

public abstract class DiskScheduler {
    int totalHeadMovements;
    int initialHeadStart;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    ArrayList<Integer> initialSequence = new ArrayList<Integer>();

    DiskScheduler(ArrayList<Integer> initialSequence, int initialHeadStart){
        totalHeadMovements = 0;
        this.initialSequence = initialSequence;
        this.initialHeadStart = initialHeadStart;
    }

    public abstract void run();
    public abstract void printResults();
}
