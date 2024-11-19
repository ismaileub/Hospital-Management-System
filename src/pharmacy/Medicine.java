package pharmacy;

public class Medicine {
    private String name;
    private double price;
    private int stock;

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public String getFullInfo() {
        return "Name: "+name + ", Price: " + price + ", Stock: " + stock;
    }
}
