package utils.comparators;

import model.Posting;

import java.util.Comparator;

public class PostingDateComparator implements Comparator<Posting> {

    @Override
    public int compare(Posting o1, Posting o2) {
        return o1.getCreationDate().compareTo(o2.getCreationDate());
    }
}
