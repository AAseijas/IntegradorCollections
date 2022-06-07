package services;

import model.Filter;
import model.Posting;
import utils.comparators.*;
import utils.PostingUtils;

import java.util.*;

public class PostingService {

    public List<Posting> getPostingByDate() {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());
        Collections.sort(postingList, new PostingDateComparator());
        for (Posting post : postingList) {
            System.out.println(post.getCreationDate());
        }
        return postingList;
    }

    public List<Posting> getPostingByStatusEnum(boolean ascendent) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());

        if (ascendent) {
            Collections.sort(postingList, new PostingStatusComparator());
        } else {
            Collections.sort(postingList, new PostingStatusComparator().reversed());
        }

        for (Posting post : postingList) {
            System.out.println(post.getStatus());
        }
        return postingList;
    }

    public List<Posting> getPostingByOperationType(boolean ascendent) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());

        if (ascendent) {

            Collections.sort(postingList, new PostingOperationComparator());
        } else {
            Collections.sort(postingList, new PostingOperationComparator().reversed());
        }

        for (Posting post : postingList) {
            System.out.println(post.getOperationType());
        }
        return postingList;
    }

    public List<Posting> getPostingByRealState(boolean ascendent) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());

        if (ascendent) {

            Collections.sort(postingList, new PostingRealStateComparator());
        } else {
            Collections.sort(postingList, new PostingRealStateComparator().reversed());
        }

        for (Posting post : postingList) {
            System.out.println(post.getRealestateType());
        }
        return postingList;
    }

    public List<Posting> getPostingByPrice(boolean ascendent) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());

        if (ascendent) {

            Collections.sort(postingList, new PostingPriceComparator());
        } else {
            Collections.sort(postingList, new PostingPriceComparator().reversed());
        }

        for (Posting post : postingList) {
            System.out.println(post.getPrice());
        }
        return postingList;
    }

    public List<Posting> getPostingListByFilter(List<Posting> postingList, Filter filter) {
        List<Posting> filteredPostings = new ArrayList<>();

        for (Posting post : postingList) {
            if (filter.getOperationTypeEnum() != null && filter.getStatusEnum() == null) {
                if (filter.getRealestateTypeEnum() == null && filter.getOperationTypeEnum().equals(post.getOperationType())) {
                    postingList.add(post);
                } else if (filter.getRealestateTypeEnum().equals(post.getRealestateType())) {
                    postingList.add(post);
                }
            } else if (filter.getRealestateTypeEnum() == null && filter.getStatusEnum().equals(post.getStatus())) {
                postingList.add(post);
            }
            if (filter.getOperationTypeEnum() != null && filter.getStatusEnum() != null) {
                if (filter.getRealestateTypeEnum() == null && filter.getOperationTypeEnum().equals(post.getOperationType()) && filter.getStatusEnum().equals(post.getStatus())) {
                    filteredPostings.add(post);
                } else if (filter.getRealestateTypeEnum().equals(post.getRealestateType()) && filter.getOperationTypeEnum().equals(post.getOperationType()) && filter.getStatusEnum().equals(post.getStatus())) {
                    filteredPostings.add(post);
                }
            }
            if (filter.getOperationTypeEnum() == null && filter.getRealestateTypeEnum() != null) {
                if (filter.getStatusEnum() == null && filter.getRealestateTypeEnum().equals(post.getRealestateType())) {
                    filteredPostings.add(post);
                } else if (filter.getStatusEnum() != null && filter.getRealestateTypeEnum().equals(post.getRealestateType()) && filter.getStatusEnum().equals(post.getStatus())) {
                    filteredPostings.add(post);
                }
            }
        }

        for (Posting posti : filteredPostings) {
            System.out.println(posti);
        }

        return filteredPostings;
    }
////////////EJ. 5
    public Posting getPostingById(Integer id) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());
        Iterator<Posting> it = postingList.iterator();
        Posting postFiltered = new Posting();
        while (it.hasNext()) {
            Posting post = it.next();
            if (id.equals(post.getPostingId())) {
                postFiltered = post;
            }
        }
        System.out.println(postFiltered);
        return postFiltered;
    }

    public void addNewPosting(Posting posting) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());
        postingList.add(posting);
    }
    public void editPosting (Integer idPost){
        Posting post = this.getPostingById(idPost);
        StringBuilder str = new StringBuilder(post.getTitle());
        str.append(" por ");
        str.append(post.getPrice().getAmount());
        str.append(" ");
        str.append(post.getPrice().getCurrency());

        post.setTitle(str.toString());
        System.out.println(post);
    }
}
