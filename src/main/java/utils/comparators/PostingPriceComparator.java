package utils.comparators;

import model.Posting;

import java.util.Comparator;

public class PostingPriceComparator implements Comparator<Posting> {

    @Override
    public int compare(Posting o1, Posting o2) {

        return Long.compare(o1.getPrice().getAmount(),o2.getPrice().getAmount());
    }
}
