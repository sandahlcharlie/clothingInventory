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

        if (index < 1){return false;}
        if (index == 1) {
            head = new ClothingNode(element, head);
        } else if (index == size() + 1) {
            while (cursor.getLink() != null) {
                cursor = cursor.getLink();
            }
            cursor.setLink(new ClothingNode(element, null));
        } else {
            for (int i = 0; i < index - 2; i++) {
                cursor = cursor.getLink();
            }
            cursor.setLink(new ClothingNode(element, cursor.getLink()));
        }
        manyNodes++;
        return true;
    }



    public boolean remove(Clothing item) {
        ClothingNode cursor = head;
        ClothingNode previousNode = null;
        if (head == null) {return false;}

        if (head.getData().equals(item)) {
            head = head.getLink();
            manyNodes--;
            return true;
        }

        while (cursor != null) {
            if (cursor.getData().equals(item)) {
                if (previousNode == null) {
                    head = cursor.getLink();
                } else {
                    previousNode.setLink(cursor.getLink());
                }
                manyNodes--;
                return true;
            }
            previousNode = cursor;
            cursor = cursor.getLink();
        }

        return false;
    }

    public boolean remove(int index) {
        ClothingNode cursor = head;
        ClothingNode previousNode = null;

        if (index < 1) {return false;}
        if (index > size()) {
            head = head.getLink();
            manyNodes--;
            return true;
        }
        if (index == 1) {
            head = head.getLink();
            manyNodes--;
            return true;
        }

        for (int i = 1; i < index; i++) {
            previousNode = cursor;
            cursor = cursor.getLink();
        }

        if (previousNode == null) {
            head = cursor.getLink();
        } else {
            previousNode.setLink(cursor.getLink());
        }

        manyNodes--;
        return true;
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