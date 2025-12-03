import java.text.DecimalFormat;

public class MenuItem implements Comparable<MenuItem> {
    private String name;
    private double price;
    private int quantity;
    DecimalFormat df = new DecimalFormat("0.00");

    public MenuItem(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        double total = price * quantity;
        return name + "\t$" + df.format(price) + "\t" + quantity + "\t$" + df.format(total);
    }

    public boolean equals(MenuItem o){
        if(o == null){ return false;}
        return this.name.equalsIgnoreCase(o.name) && this.price == o.price;
    }


    @Override
    public int compareTo(MenuItem o) {
        if (this.name.compareToIgnoreCase(o.name) != 0) {
            return this.name.compareToIgnoreCase(o.name);
        }
        return Double.compare(this.price, o.price);
    }
}
