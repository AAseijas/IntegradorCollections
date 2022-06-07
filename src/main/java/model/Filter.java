package model;

public class Filter {
    private OperationTypeEnum operationTypeEnum;
    private RealestateTypeEnum realestateTypeEnum;
    private StatusEnum statusEnum;

    public Filter(OperationTypeEnum operationTypeEnum, RealestateTypeEnum realestateTypeEnum, StatusEnum statusEnum) {
        this.operationTypeEnum = operationTypeEnum;
        this.realestateTypeEnum = realestateTypeEnum;
        this.statusEnum = statusEnum;
    }

    public OperationTypeEnum getOperationTypeEnum() {
        return operationTypeEnum;
    }

    public RealestateTypeEnum getRealestateTypeEnum() {
        return realestateTypeEnum;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }
}
