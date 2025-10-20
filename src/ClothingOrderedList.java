public class ClothingOrderedList {
    private ClothingNode head;
    private ClothingNode tail;
    private int manyNodes;

    public ClothingOrderedList() {
        this.head = null;
        this.tail = null;
        manyNodes = 0;
    }

    public void add(Clothing item) {
        head = new ClothingNode(item, head);
        manyNodes++;
    }

    public int size() {
        return manyNodes;
    }

    public void display() {
        ClothingNode cursor = head;
        while (cursor != null) {
            System.out.print(cursor.getData() + "\t");
            cursor = cursor.getLink();

        }
    }

    public Boolean add(int index, Clothing element) {
        ClothingNode cursor = head;
        ClothingNode previousNode = head;
        ClothingNode newNode = null;
        int i = indexOf(element);


        while (cursor != null) {
            if (i == index) {
                newNode.setLink(cursor);
                previousNode.setLink(newNode);
                break;
            }
            previousNode = cursor;
            cursor = cursor.getLink();
        }
    }

    public int indexOf(Clothing item){
        ClothingNode cursor = head;
        int index = 1;
        while (cursor != null && !cursor.getData().equals(item)){
            index++;
            cursor = cursor.getLink();
        }

        if(cursor == null){return -1;}
        return index;
    }
}