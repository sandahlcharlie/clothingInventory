public class ClothingSortedArraySet {
    private Clothing[] ClothingAry;
    private Integer max;

    public ClothingSortedArraySet(Integer max){
        this.max = max;
        this.ClothingAry = new Clothing[max];
    }

    public void insert(Clothing c) {
        for (int k = 0; k < size(); k++) {
            Clothing existing = ClothingAry[k];
            boolean isDuplicate = false;

            if (existing.getClass().equals(c.getClass())) {
                if (existing instanceof Pants && c instanceof Pants) {
                    isDuplicate = ((Pants)existing).equals((Pants)c);
                } else if (existing instanceof Shirt && c instanceof Shirt) {
                    isDuplicate = ((Shirt)existing).equals((Shirt)c);
                } else if (!(existing instanceof Pants) && !(existing instanceof Shirt)) {
                    isDuplicate = existing.equals(c);
                }
            }

            if (isDuplicate) {
                return; // Don't insert duplicates
            }
        }
        int i = size() - 1;
        while (i >= 0) {
            Clothing clothes = ClothingAry[i];
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
            if(clothes == null){break;}
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
            i--;
        }
        return -1;
    }

    public boolean remove(Clothing c){
        int i = indexOf(c);
        if(i == -1){return false;}

        for(int j = i; j < size()-1; j++){
            ClothingAry[j] = ClothingAry[j+1];
        }
        ClothingAry[size()-1] = null;
        return true;
    }

    public Clothing grab(int index){
        return ClothingAry[index];
    }

    public ClothingSortedArraySet categorySet(int type){
        ClothingSortedArraySet subset = new ClothingSortedArraySet(max);

        for (int i = 0; i < size(); i++) {
            Clothing c = ClothingAry[i];

            if (type == 1 && c instanceof Pants) {
                subset.insert(c);
            } else if (type == 2 && c instanceof Shirt) {
                subset.insert(c);
            } else if (type == 3 && !(c instanceof Shirt) && !(c instanceof Pants)) {
                subset.insert(c);
            }
        }
        return subset;
    }
}
