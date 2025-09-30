public class Shirt extends Clothing {
    private boolean isLongSleeve;

    public Shirt(String garment, int stock, boolean isLongSleeve) {
        super(garment, stock);
        this.isLongSleeve = isLongSleeve;
    }

    public boolean getIsLongSleeve() {
        return isLongSleeve;
    }

    public void setIsLongSleeve(boolean isLongSleeve) {
        this.isLongSleeve = isLongSleeve;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + isLongSleeve;
    }

    public boolean equals(Shirt o) {
        if (o == null) return false;
        if (!super.equals(o)) return false;
        return this.isLongSleeve == o.isLongSleeve;
    }
}