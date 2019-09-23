// Junyong Lee
// 800623507     // 1.5

public class IntNode {
    // 1.1
    private int data;
    private IntNode link;

    // 1.2
    public IntNode() {
        data = 0;
        link = null;
    }

    // 1.3
    public IntNode(int _data, IntNode _node) {
        data = _data;
        link = _node;
    }

    // 1.4 Get & Set
    public int getData() {
        return data;
    }

    public void setData(int d) {
        data = d;
    }

    public IntNode getLink() {
        return link;
    }

    public void setLink(IntNode l) {
        link = l;
    }

    // 1.5
    public String toString() {
        String result = "";
        IntNode cursor = null;
        // Activated by head

        result += Integer.toString(this.getData());
        // When activated by head
        for (cursor = link; cursor != null; cursor = cursor.link) {

            result += "->";
            result += Integer.toString(cursor.getData());

        }

        return result;
    }

    // 1.6
    public void addNodeAfterThis(int newdata) {
        link = new IntNode(newdata, link);
    }

    // 1.7
    public void removeNodeAfterThis() {
        link = link.link;
    }

    // 1.8
    public static int listLength(IntNode head) {

        int answer;

        answer = 0;
        for (IntNode cursor = head; cursor != null; cursor = cursor.link) {
            answer++;
        }

        return answer;
    }

    // 1.9
    public static boolean search(IntNode head, int data) {

        if(head == null){
            throw new IllegalArgumentException("head must not be null");
        }
        IntNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link) {
            if (data == cursor.data) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {

        IntNode head = new IntNode(42, null); // head -> (42,null)
       
        //IntNode nulltest = null;
        //System.out.println(search(nulltest, 25));
        
        System.out.println(head.getData()); // 42

        System.out.println(head.getLink()); // null

        head.addNodeAfterThis(75); // head -> (42) -> (75, null)
        head.addNodeAfterThis(83); // head -> (42) -> (83) -> (75,null)
        System.out.println(head.link.getData());
        System.out.println(head.toString());
        System.out.println(head.link.toString());
        System.out.println(head.link.link.toString());

        System.out.println(search(head, 83));
        System.out.println(search(head, 24));

        System.out.println(listLength(head)); // 3

        head.removeNodeAfterThis(); // remove (83)
        System.out.println(head.toString()); // head -> (42) -> (75)

        System.out.println(listLength(head)); // 2

    }

}