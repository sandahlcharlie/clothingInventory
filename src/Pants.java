public class Pants extends Clothing{
    private int length;

    public Pants(String garment, int stock, int length) {
        super(garment, stock);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
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