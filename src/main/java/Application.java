////// 1. Dado un Publisher, obtener todos los avisos que ha creado.
//     2. Dado un Publisher, agrupar los avisos de acuerdo a su estado de publicación (status). Esto para poder mostrarle un resumen de la cantidad de avisos que tiene.
//        Ejemplo:
//        DRAFT - 5
//        ONLINE - 20
//        OFFLINE - 8
//     3. Teniendo la lista de avisos, se desea tener una función que nos permita ordenar los avisos de acuerdo a :
//        Los más recientes. Tener en cuenta la fecha de creación.
//        Estado de publicación - Ascendente y descendente(StatusEnum)
//        Tipo de operación - Ascendente y descendente (OperationTypeEnum)
//        Tipo de inmueble - Ascendente y descendente (RealestateTypeEnum)
//        Precio - Ascendente y descendente
//     4. Sobre la lista de avisos, también necesitamos filtrar los avisos de acuerdo a (Tener en cuenta que puede aplicar uno o más filtros):
//        Tipo de operación (OperationTypeEnum)
//        Tipo de inmueble (RealestateTypeEnum)
//        Estado de publicación (StatusEnum)
//     5. Adicionalmente, el usuario tiene la necesidad de hacer operaciones para un aviso en particular, las funciones son :
//        Dado un id de aviso, consultar la información de este.
//        Adicionar un nuevo aviso
//        Dado un id de aviso, actualizar la información de este.
//

import model.*;
import services.PostingService;
import services.PostingServiceV2;
import services.PublisherService;
import utils.PostingUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;


public class Application {
    public static void main(String[] args) {
        PublisherService publisherService = new PublisherService();
        PostingService postingService = new PostingService();

//        publisherService.getStatusEnumMap(new Publisher(10000, "BERE", "BERE@mail.com", CountryEnum.AR));
//        System.out.println("-----------------------------------------");
//        postingService.getPostingByDate();
//        System.out.println("-----------------------------------------");
//        postingService.getPostingByStatusEnum(true);
//        System.out.println("-----------------------------------------");
//        postingService.getPostingByOperationType(true);
//        System.out.println("-----------------------------------------");
//        postingService.getPostingByRealState(true);
//        System.out.println("-----------------------------------------");
//        postingService.getPostingByPrice(true);
//        postingService.getPostingListByFilter((List<Posting>) PostingUtils.getListPostings(), new Filter(null, RealestateTypeEnum.APARTMENT, StatusEnum.DRAFT));
//        postingService.editPosting(10410005);
//        postingService.getPostingById(10410005);
        //  publisherService.editTitleOfPostingByIdPublisher(new Publisher(10013, "JOSAFAT GERARDO", "JOSAFAT-GERARDO@mail.com", CountryEnum.BR));
        PostingServiceV2 ps2 = new PostingServiceV2();

        HashMap<String, String> filter = new HashMap<>();
        filter.put("realestateType", RealestateTypeEnum.APARTMENT.name());
        filter.put("status",StatusEnum.DRAFT.name());
        filter.put("operationType",OperationTypeEnum.RENT.name());

        HashMap<String, String> filter2 = new HashMap<>();
        filter2.put("realestateType", RealestateTypeEnum.GARAGE.name());
        filter2.put("status",StatusEnum.OFFLINE.name());
        filter2.put("operationType",OperationTypeEnum.SELL.name());


        ps2.getPostingsByFilter(filter);
        System.out.println("--------------");
        ps2.getPostingsByFilter(filter2);
    }

}
