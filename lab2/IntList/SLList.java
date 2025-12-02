package IntList;

public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i ;
            next = n;
        }
    }

    private IntNode first;
    private int size;
    /**Create a empty SSList*/
    public void SSList(){
        first = null;
        size = 0;
    }

    public SLList(int x){
        first = new IntNode(x,null);
        size = 1;
    }

    /** Get the size of the SLList */
    public int size(){
       return size;
    }
    /** Add value x to the front of the SLList*/
    public void addFirst(int x){
        first  = new IntNode(x,first);
        size+=1;
    }
    /** Add value x to the end of the SLList*/
    public void addLast(int x){
        if (first==null){
            first = new IntNode(x,null);
            size+=1;
            return;
        }
        IntNode temp = first;
        while (temp.next != null){
            temp=temp.next;
        }
        temp.next  = new IntNode(x,null);
        size+=1;
    }
    /** Get the first value of the SLList*/
    public  int getFirst(){
        return first.item;
    }
    /** Get the last value of the SLList*/
    public int getLast(){
        IntNode temp = first;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp.item;
    }


    public static void main(String[] args) {
        SLList L = new SLList(5);
        System.out.println("The length of L which should be 1:"+L.size());
        System.out.println("The first value of L which should be 5: "+L.getFirst());
        L.addFirst(20);
        System.out.println("The first value of L which should be 20: "+L.getFirst());
        L.addLast(15);
        System.out.println("The last value of L which should be 15: "+L.getLast());
        System.out.println("The length of L which should be 3:"+L.size());
    }
}
