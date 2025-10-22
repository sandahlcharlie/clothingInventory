public class ClothingTypesLists {
    private ClothingOrderedList PantsList;
    private ClothingOrderedList ShirtList;
    
    public ClothingTypesLists(){
        this.PantsList = new ClothingOrderedList();
        this.ShirtList = new ClothingOrderedList();
    }
    
    public void add(Clothing element) throws ClassNotFoundException{
        if (element instanceof Pants) {
            PantsList.add(element);
        } else if (element instanceof Shirt) {
            ShirtList.add(element);
        } else {
            throw new ClassNotFoundException("Element not instance of either subclass");
        }
    }

    public int sizeOf(ClothingOrderedList iol){
        return iol.size();
    }

    public void display(ClothingOrderedList iol){
        iol.display();
    }

    public boolean add(int index, Clothing element){
        if(element instanceof Pants){
            return PantsList.add(index, element);
        } else if (element instanceof Shirt) {
            return ShirtList.add(index, element);
        } else {
            return false;
        }
    }

    public boolean remove(Clothing target){
        if(target instanceof Pants){
            return PantsList.remove(target);
        } else if (target instanceof Shirt) {
            return ShirtList.remove(target);
        } else {
            return false;
        }
    }

    public boolean remove(ClothingOrderedList iol, int index){
        if(iol.get(index) instanceof Pants){
            return PantsList.remove(index);
        } else if (iol.get(index) instanceof Shirt) {
            return ShirtList.remove(index);
        } else {
            return false;
        }
    }

    public int indexOf(Clothing target){
        if(target instanceof Pants){
            return PantsList.indexOf(target);
        } else if (target instanceof Shirt) {
            return ShirtList.indexOf(target);
        } else {
            return -1;
        }
    }

    public ClothingOrderedList getList(char type){
       if (Character.toLowerCase(type) == 'p'){
           return PantsList;
       } else if (Character.toLowerCase(type) == 's') {
           return ShirtList;
       }else{
           return null;
       }
    }

    public Clothing get(ClothingOrderedList iol, int index){
        if(iol.get(index) instanceof Pants){
            return PantsList.get(index);
        } else if (iol.get(index) instanceof Shirt) {
            return ShirtList.get(index);
        } else {
            return null;
        }
    }
}
