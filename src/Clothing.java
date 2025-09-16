public class Clothing{
    private String garment; //This will be the item of clothing
    private int stock; //This is the amount of items of clothing in stock

    public Clothing(String garment, int stock){
        this.garment = garment;
        this.stock = stock;
    }

    public String getGarment() {
        return garment;
    }

    public void setGarment(String garment) {
        this.garment = garment;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "This garment is " + garment + " and we have " + stock + " in stock";
    }

    public boolean equals(Clothing o){
        if(o == null){ return false;}
        return this.garment.equalsIgnoreCase(o.garment) && this.stock == o.stock;
   }
}