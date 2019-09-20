package CircuitList;

public class Node {
    private Object data;
    private Object name;
    public Node next;
    public Node prev1;
    public Node prev2;

    public Node() {
        this.next = null;
        this.data = null;
        this.name = null;
        this.prev1 = null;
        this.prev2 = null;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public void setName(Object name) {
        this.name = name;
    }
            
    public Object getName() {
        return this.name;
    }
    
    public Node getNext() {
        return this.next;
    }

    public void setNext(Node BNode) {
        this.next = BNode;
    }
    
    public void setprev1(Node BNode) {
        this.prev1 = BNode;
    }
    
    public void setprev2(Node BNode) {
        this.prev2 = BNode;
    }
    
    public Node getprev1() {
        return this.prev1;
    }
    
    public Node getprev2() {    
        return this.prev2;
    }
    
}