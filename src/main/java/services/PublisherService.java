package services;

import model.Posting;
import model.Publisher;
import model.RealestateTypeEnum;
import model.StatusEnum;
import utils.PostingUtils;

import java.util.*;

public class PublisherService {


    /////////////EJ.2
    public List<Posting> getPostingsByPublisher(Publisher publisher) {
        List<Posting> filteredPosting = new ArrayList<>(); //--> Lista PostFiltradas
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings()); //-->Lista Postings
        Iterator<Posting> it = postingList.iterator();

        while (it.hasNext()) {
            Posting post = it.next();
            if (publisher.getPublisherId().equals(post.getPublisher().getPublisherId())) {
                filteredPosting.add(post);
            }
        }
        for(Posting posting : filteredPosting){
            System.out.println(posting);
        }
        return filteredPosting;
    }

    private List<Posting> getListPostingByStatusEnum(List<Posting> postingList, StatusEnum statusEnum) {
        List<Posting> fileteredPosting = new ArrayList<>();
        for (Posting post : postingList) {
            if (statusEnum.equals(post.getStatus())) {
                fileteredPosting.add(post);
            }
        }
        return fileteredPosting;
    }

    public Map<String, Integer> getStatusEnumMap(Publisher publisher) {
        List<Posting> postingList = new ArrayList<>(this.getPostingsByPublisher(publisher));
        HashMap<String, Integer> mapaReturn = new HashMap<>();
        Integer contadorDraft = this.getListPostingByStatusEnum(postingList, StatusEnum.DRAFT).size();
        Integer contadorOnline = this.getListPostingByStatusEnum(postingList, StatusEnum.ONLINE).size();
        Integer contadorOffline = this.getListPostingByStatusEnum(postingList, StatusEnum.OFFLINE).size();

        mapaReturn.put(StatusEnum.DRAFT.name(), contadorDraft);
        mapaReturn.put(StatusEnum.ONLINE.name(), contadorOnline);
        mapaReturn.put(StatusEnum.OFFLINE.name(), contadorOffline);

        System.out.println(mapaReturn);

        return mapaReturn;
    }
    /////////////////EJ. PLUS
    public void editTitleOfPostingByIdPublisher (Publisher publisher) {
        List<Posting> postingList = new ArrayList<>(PostingUtils.getListPostings());
        PostingService ps = new PostingService();
        for(Posting posting : postingList){
            if( posting.getPublisher().getPublisherId().equals(publisher.getPublisherId())){
                ps.editPosting(posting.getPostingId());
            }
        }
        this.getPostingsByPublisher(publisher);
    }
}

