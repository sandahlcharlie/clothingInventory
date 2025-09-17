import java.util.ArrayList;

public class ClothingArrayDriver {
    public static int overallAvg(Clothing[] a){
        int sum = 0;
        int count = 0;
        for(Clothing item: a) {
            sum += (item).getStock();
            count++;
        }
        return sum/count;
    }

    public static int count(Clothing[] a, Clothing o){
        int count = 0;
        for(Clothing item: a){
            if(item.equals(o)){
                count++;
            }
        }
        return count;
    }

    public int groupAvg(Clothing[] a, String s){
       int sum = 0;
       int count = 0;
       for(Clothing item: a){
           if(item.getGarment().equals(s)) {
                sum += (item).getStock();
                count++;
           }
       }
        return sum/count;
    }

    public Clothing[] lessThan(Clothing[] a, Integer i){
        ArrayList<Clothing> less = new ArrayList<>();
        for(Clothing item: a){
            if(item.getStock() < i){
                less.add(item);
            }
        }
        return less.toArray(new Clothing[0]);
    }

    public void groupEdit(Clothing[] a, String s, Integer n){
        for(Clothing item: a){
            if(item.getGarment().equals(s)) {
                item.setStock(item.getStock()+n);
            }
        }
    }
}
