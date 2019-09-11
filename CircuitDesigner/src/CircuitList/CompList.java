package CircuitList;

import AbstractFCompuertas.ConcreteAND;
import AbstractFCompuertas.ConcreteNOT;
import AbstractFCompuertas.ConcreteOR;
import AbstractFCompuertas.FactoryCompuertas;
import AbstractFCompuertas.ProducerCompuertas;

public class CompList {
   
    private Node head;
    private int size;
    public CompList() {
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null;
    }
    public int size() {
        return this.size;
    }
    
    public int Calculo(String Compuerta, String TypeComp, int in1,int in2) {
        int num;
        num = 0;
        if(Compuerta.equalsIgnoreCase("OR")){
            FactoryCompuertas ORFactory = ProducerCompuertas.getFactory("OR");
            if(TypeComp.equalsIgnoreCase("OR")){
                  ConcreteOR OR = ORFactory.getOR("OR");
                  num = OR.operacion(in1, in2);
            
            }else if(TypeComp.equalsIgnoreCase("NOR")){
                  ConcreteOR NOR = ORFactory.getOR("NOR");
                  num =  NOR.operacion(in1, in2);
                  
            }else if(TypeComp.equalsIgnoreCase("XOR")){
                  ConcreteOR XOR = ORFactory.getOR("XOR");
                  num =  XOR.operacion(in1, in2);
            
            }else if(TypeComp.equalsIgnoreCase("XNOR")){
                  ConcreteOR XNOR = ORFactory.getOR("XNOR");
                  num =  XNOR.operacion(in1, in2);
            }
        }else if(Compuerta.equalsIgnoreCase("AND")){
            FactoryCompuertas ANDFactory = ProducerCompuertas.getFactory("AND");
            if(TypeComp.equalsIgnoreCase("AND")){
                  ConcreteAND AND = ANDFactory.getAND("AND");
                  num =  AND.operacion(in1, in2);
                  
            }else if(TypeComp.equalsIgnoreCase("NAND")){
                  ConcreteAND NAND = ANDFactory.getAND("NAND");
                  num =  NAND.operacion(in1, in2);
            }      
            
        }else{
            FactoryCompuertas NOTFactory = ProducerCompuertas.getFactory("NOT");
            
              ConcreteNOT NOT = NOTFactory.getNOT();
              num =  NOT.Invertir(in1);   
        }
        return num;
         
    }

    public void insertarComp(String Compuerta,String tipoComp){
        
        Node Comp = new Node();
        if (this.isEmpty()){
            this.head = Comp;
            this.head.setData(0);

        }else{
            if(Compuerta.equalsIgnoreCase("NOT")){

                int input1;

                Node act = this.head;
                while (act.getNext() != null) {
                    act = act.getNext();
                }

                act.setNext(Comp);
                act = act.getNext();
                act.setprev1(this.head); //Cambiar por funcion  
                input1 = (int) act.prev1.getData();
                act.setData(this.Calculo(Compuerta, tipoComp, input1, 0));               
                System.out.println("OMGLUL "+act.getData());
                
            }else{

                int input1;
                int input2;
                
                
                Node act = this.head;
                
                while (act.getNext() != null) {
                    act = act.getNext();
                }
                System.out.println("SKEREE ");
                
                act.setNext(Comp);
                act = act.getNext();
                act.setprev1(this.head); //Cambiar por funcion
                act.setprev2(this.head.next); //cambiar x2 
                
                input1 = (int) act.prev1.getData();
                input2 = (int) act.prev2.getData();
                
                act.setData(this.Calculo(Compuerta, tipoComp, input1, input2));
                System.out.println("POG ");

            }
        }
        this.size++;
    }
    
    public void insertarSignal(String name, int signal){
        
        Node Comp = new Node();
        if (this.isEmpty()){
            this.head = Comp;
            this.head.setData(signal);
            System.out.println("c mamo " + this.head.getData());
            
        }else{
            Node act = this.head;
            while (act.getNext() != null) {
                act = act.getNext();
            }
            
            act.setNext(Comp);
            act = act.getNext();
            act.setData(signal);
            System.out.println("Fierro "+act.getData());
        }
        this.size++;
    }
    
    
    public Node iterar() {
        Node act = this.head;
        while (act.getNext() != null) {
            
            act = act.getNext();
        }
        return act;
    }
    
    public Node deleteFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.next;
            this.size--;
            return temp;
        } else {
            return null;
        }
    }
    
    public void displayList() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    
    public Node find(String searchValue) {
        Node current = this.head;
        while (current != null) {
            if (current.getData().equals(searchValue)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }
    
    public Node delete(String searchValue) {
        Node current = this.head;
        Node previous = this.head;

        while (current != null) {
            if (current.getData().equals(searchValue)) {
                if (current == this.head) {
                    this.head = this.head.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return current;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return null;
    }

    public static void main(String[] args){
        CompList lList = new CompList();
        lList.insertarSignal("a",1);
        lList.insertarSignal("b", 1);
        lList.insertarComp("OR","OR");
        lList.insertarComp("AND","AND");
        lList.displayList();
        System.out.println();

    }
}