public class ClothingNode {
    private Clothing data;
    private ClothingNode link;

    public ClothingNode(Clothing i, ClothingNode n){
        this.data = i;
        this.link = n;
    }
    public static ClothingNode listPosition(ClothingNode head, int position)
    {
        ClothingNode cursor;
        int i;
        if (position <= 0)
            throw new IllegalArgumentException("position is not positive");
        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.link;
        return cursor;
    }
    public Clothing getData() {
        return data;
    }

    public void setData(Clothing data) {
        this.data = data;
    }

    public ClothingNode getLink() {
        return link;
    }

    public void setLink(ClothingNode link) {
        this.link = link;
    }
}