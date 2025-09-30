public class Pants extends Clothing{
    private int length;

    public Pants(String garment, int stock, int length) {
        super(garment, stock);
        this.length = length;
    }

    public int getIsLongSleeve() {
        return length;
    }

    public void setIsLongSleeve(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + length;
    }

    public boolean equals(Pants o) {
        if (o == null) return false;
        if (!super.equals(o)) return false;
        return this.length == o.length;
    }
}