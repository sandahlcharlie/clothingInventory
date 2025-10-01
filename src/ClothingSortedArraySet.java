public class ClothingSortedArraySet {
    private Clothing[] ClothingAry;
    private Integer max;

    public ClothingSortedArraySet(Integer max){
        this.max = max;
        this.ClothingAry = new Clothing[max];
    }

    public void insert(Clothing c) {
        int i = size() - 1;
        while (i >= 0) {
            Clothing clothes = ClothingAry[i];
            if (clothes.equals(c)) {
                return;
            }
            if (clothes.compareTo(c) > 0) {
                ClothingAry[i + 1] = clothes;
                i--;
            } else {
                break;
            }
        }
        ClothingAry[i + 1] = c;
    }

    public int size(){
        int count = 0;
        for (Clothing clothing : ClothingAry) {
            if (clothing != null) count++;
            else break;
        }
        return count;
    }

    @Override
    public String toString(){
        String clothing = "";
        for(Clothing clothes:ClothingAry){
            clothing += clothes.toString() +"\n";
        }
        return clothing;
    }

    public int indexOf(Clothing c){
        int i = size() - 1;
        while (i >= 0) {
            Clothing clothes = ClothingAry[i];
            if (clothes.equals(c)){
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Clothing c){
        int i = indexOf(c);
        if(i == -1){return false;}

        for(int j = i; j < size()-1; j++){
            ClothingAry[i] = ClothingAry[i+1];
        }
        return true;
    }

    public Clothing grab(int index){
        return ClothingAry[index];
    }

    public ClothingSortedArraySet categorySet(int type){
        ClothingSortedArraySet subset = new ClothingSortedArraySet(max);

        for (int i = 0; i < size(); i++) {
            Clothing c = ClothingAry[i];

            if (type == 1 && c instanceof Shirt) {
                subset.insert(c);
            } else if (type == 2 && c instanceof Pants) {
                subset.insert(c);
            } else if (type == 3 && !(c instanceof Shirt) && !(c instanceof Pants)) {
                subset.insert(c);
            }
        }
        return subset;
    }
}
