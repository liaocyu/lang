package 职责链模式;

public class PurchaseRequest {
    private Integer type;
    private Float price;
    private Integer id;

    public PurchaseRequest(Integer type, Float price, Integer id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }
}
