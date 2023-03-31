package 装饰者模式;

public abstract class Drink {
    private String description;
    private Double price = 0.0;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public abstract double cost();
}
