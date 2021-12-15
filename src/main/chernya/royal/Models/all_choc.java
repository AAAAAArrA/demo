package royal.Models;

public class all_choc {
    private int id;
    private String choc_name;
    private int price;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoc_name() {
        return choc_name;
    }

    public all_choc(){

    }
    public all_choc(int id, String choc_name, int price, int quantity) {
        this.id = id;
        this.choc_name = choc_name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setChoc_name(String choc_name) {
        this.choc_name = choc_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
