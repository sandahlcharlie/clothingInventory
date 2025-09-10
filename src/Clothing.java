public class Clothing{
    private String garment; //This will be the item of clothing
    private int stock; //This is the amount of items of clothing in stock

    public Clothing(String garment, int cost){
        this.garment = garment;
        this.stock = cost;
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
        return "This garment is " + garment + " and it has been worn " + stock + "times";
    }

    @Override
    public boolean equals(int ){

    }
}