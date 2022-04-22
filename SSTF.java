import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



public class SSTF extends DiskScheduler{

    ArrayList<Integer> initialSequenceTemp = new ArrayList<Integer>();
    SSTF(ArrayList<Integer> initialSequence, int initialHeadStart) {
        super(initialSequence, initialHeadStart);

        initialSequenceTemp.addAll(initialSequence);
    }

    @Override
    public void run() {
        int current = initialHeadStart;
        initialSequenceTemp.add(initialHeadStart);
        sequence.add(initialHeadStart);
        Collections.sort(initialSequenceTemp);
        while(!initialSequenceTemp.isEmpty()) {
            for (int i = 0; i < initialSequenceTemp.size(); i++) {
                if(i == initialSequenceTemp.size() - 1){
                    for(int j = i; j > 0; j--){

                        current = initialSequenceTemp.get(j - 1);
                        sequence.add(current);
                        totalHeadMovements += Math.abs(current - initialSequenceTemp.get(j));
                        initialSequenceTemp.remove(j);
                    }
                    initialSequenceTemp.remove(0);
                    break;
                }
                if(initialSequenceTemp.get(i).equals(current)){

                    if(i != 0 && Math.abs(initialSequenceTemp.get(i - 1) - current) < Math.abs(initialSequenceTemp.get(i + 1) - current)){
                        current = initialSequenceTemp.get(i - 1);
                    }
                    else {
                        current = initialSequenceTemp.get(i + 1);
                    }
                    sequence.add(current);
                    totalHeadMovements += Math.abs(current - initialSequenceTemp.get(i));
                    initialSequenceTemp.remove(i);
                    i = -1;
                }
            }
        }

        printResults("SSTF", totalHeadMovements, sequence);
    }


}
