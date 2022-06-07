package services;

import model.Posting;
import utils.PostingUtils;

import java.util.*;

public class PostingServiceV2 {

    public List<Posting> getPostingsByFilter(HashMap<String, String> filter) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());

        for (Map.Entry<String, String> entry : filter.entrySet()) {
            postingList.removeIf(posting -> !posting.toString().contains(entry.getValue()));
        }

        for (Posting posting : postingList) {
            System.out.println(posting);
        }
        return postingList;

    }
}
