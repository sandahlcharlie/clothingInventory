public class Clothing implements Comparable<Clothing>{
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
        return  garment + "\t" + stock;
    }

    public boolean equals(Clothing o){
        if(o == null){ return false;}
        return this.garment.equalsIgnoreCase(o.garment) && this.stock == o.stock;
   }

    @Override
    public int compareTo(Clothing o) {
        if (this.garment.compareToIgnoreCase(o.garment) != 0) {
            return this.garment.compareToIgnoreCase(o.garment);
        }
        return Integer.compare(this.stock, o.stock);
    }
}