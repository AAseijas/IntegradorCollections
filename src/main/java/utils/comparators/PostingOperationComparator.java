package utils.comparators;

import model.Posting;

import java.util.Comparator;

public class PostingOperationComparator implements Comparator<Posting> {
    @Override
    public int compare(Posting o1, Posting o2) {
        return o1.getOperationType().name().compareTo(o2.getOperationType().name());
    }
}
