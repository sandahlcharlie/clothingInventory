import java.text.DecimalFormat;
/**
 * Represents a menu item with a name, price, and quantity
 * Implements Comparable to allow comparing by name (case-insensitive) and then by price
 * @author Charles Sandahl
 * @version 0.1
 */
public class MenuItem implements Comparable<MenuItem> {
    private String name;
    private double price;
    private int quantity;
    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Constructs a MenuItem
     * @param name the name of the menu item
     * @param price the price of the menu item
     * @param quantity the quantity ordered
     */
    public MenuItem(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the name of the menu item
     * @return the item name
     */
    public String getName() {return name;}
    /**
     * Sets the name of the menu item
     * @param name the item name
     */
    public void setName(String name) {this.name = name;}
    /**
     * Gets the price of the menu item
     * @return the item price
     */
    public double getPrice() {return price;}
    /**
     * Sets the price of the menu item
     * @param price the item name
     */
    public void setPrice(double price) {this.price = price;}
    /**
     * Gets the quantity of the menu item
     * @return the quantity
     */
    public int getQuantity() {return quantity;}
    /**
     * Sets the quantity of the menu item
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {this.quantity = quantity;}

    /**
     * Returns a formatted string representation of the menu item
     * Fits in the receipt columns well
     * Calculates total and changes price and total to a string using DecimalFormat
     * Format for string:
     *      20 spaces for name
     *      9 spaces for price
     *      10 spaces for quantity
     *      total
     * @return formatted string showing MenuItem and total
     */
    @Override
    public String toString(){
        double total = price * quantity;
        String priceString = df.format(price);
        String totalString = df.format(total);
        return String.format("%-20s $%-9s %-10d $%s", name, price, quantity, total);    }

    /**
     * Checks if this MenuItem is equal to another MenuItem
     * Two items are equal if they have the same name (case-insensitive) and price
     * @param o the MenuItem to compare with
     * @return true if items are equal, false otherwise
     */
    public boolean equals(MenuItem o){
        if(o == null){ return false;}
        return this.name.equalsIgnoreCase(o.name) && this.price == o.price;
    }

    /**
     * Compares this MenuItem to another for ordering
     * Items are compared first by name (case-insensitive), then by price
     * @param o the MenuItem to compare to
     * @return negative if this item comes before o, positive if after, 0 if equal
     */
    @Override
    public int compareTo(MenuItem o) {
        if (this.name.compareToIgnoreCase(o.name) != 0) {
            return this.name.compareToIgnoreCase(o.name);
        }
        return Double.compare(this.price, o.price);
    }
}
