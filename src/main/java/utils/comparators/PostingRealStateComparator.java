package utils.comparators;

import model.Posting;

import java.util.Comparator;

public class PostingRealStateComparator implements Comparator<Posting> {

    @Override
    public int compare(Posting o1, Posting o2) {
        return o1.getRealestateType().name().compareTo(o2.getRealestateType().name());
    }
}
