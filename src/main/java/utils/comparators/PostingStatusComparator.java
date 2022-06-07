package utils.comparators;

import model.Posting;

import java.util.Comparator;

public class PostingStatusComparator implements Comparator<Posting> {
    @Override
    public int compare(Posting o1, Posting o2) {
        return o1.getStatus().name().compareTo(o2.getStatus().name());
    }
}
