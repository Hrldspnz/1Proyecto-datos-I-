package CircuitList;

/*import AbstractFCompuertas.ConcreteAND;
import AbstractFCompuertas.ConcreteNOT;
import AbstractFCompuertas.ConcreteOR;
import AbstractFCompuertas.FactoryCompuertas;
import AbstractFCompuertas.ProducerCompuertas;*/

public class Node {
    private Object data;
    private Object name;
    private Object Type;
    private Object subType;
    public Node next;
    public Node prev1;
    public Node prev2;
    public static int ContANDS = 0;
    public static int ContNANDS  = 0;
    public static int ContORS  = 0;
    public static int ContNORS  = 0;
    public static int ContXORS  = 0;
    public static int ContXNORS  = 0;
    public static int ContNOTS  = 0;

    public Node() {
        this.next = null;
        this.data = null;
        this.name = null;
        this.Type = null;
        this.subType = null;
        this.prev1 = null;
        this.prev2 = null;
    }

    public Object getData() {
        
        return this.data;
        
    }
    

    public void setData(Object data) {
        this.data = data;
    }
    
    public void setTypes(Object type, Object subType) {
        this.Type = type;
        this.subType = subType;
    }
    
    public Object getType() {
        return this.Type;
    }
    
    public Object getSubType() {
        return this.subType;
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