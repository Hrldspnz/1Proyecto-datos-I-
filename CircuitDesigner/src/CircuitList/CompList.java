package CircuitList;

import AbstractFCompuertas.ConcreteAND;
import AbstractFCompuertas.ConcreteNOT;
import AbstractFCompuertas.ConcreteOR;
import AbstractFCompuertas.FactoryCompuertas;
import AbstractFCompuertas.ProducerCompuertas;
import static CircuitList.Node.ContANDS;
import static CircuitList.Node.ContNANDS;
import static CircuitList.Node.ContNORS;
import static CircuitList.Node.ContNOTS;
import static CircuitList.Node.ContORS;
import static CircuitList.Node.ContXNORS;
import static CircuitList.Node.ContXORS;

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
    
    public static int Calculo(String Compuerta, String TypeComp, int in1,int in2) {
        int num;
        num = 0;
        if(Compuerta.equalsIgnoreCase("OR")){
            FactoryCompuertas ORFactory = ProducerCompuertas.getFactory("OR");
            if(TypeComp.equalsIgnoreCase("OR")){
                  ConcreteOR OR = ORFactory.getOR("OR");
                  num = OR.operacion(in1, in2);
                  ContORS++;
            
            }else if(TypeComp.equalsIgnoreCase("NOR")){
                  ConcreteOR NOR = ORFactory.getOR("NOR");
                  num =  NOR.operacion(in1, in2);
                  ContNORS++;
                  
            }else if(TypeComp.equalsIgnoreCase("XOR")){
                  ConcreteOR XOR = ORFactory.getOR("XOR");
                  num =  XOR.operacion(in1, in2);
                  ContXORS++;
            
            }else if(TypeComp.equalsIgnoreCase("XNOR")){
                  ConcreteOR XNOR = ORFactory.getOR("XNOR");
                  num =  XNOR.operacion(in1, in2);
                  ContXNORS++;
            }
        }else if(Compuerta.equalsIgnoreCase("AND")){
            FactoryCompuertas ANDFactory = ProducerCompuertas.getFactory("AND");
            if(TypeComp.equalsIgnoreCase("AND")){
                  ConcreteAND AND = ANDFactory.getAND("AND");
                  num =  AND.operacion(in1, in2);
                  ContANDS++;
                  
            }else if(TypeComp.equalsIgnoreCase("NAND")){
                  ConcreteAND NAND = ANDFactory.getAND("NAND");
                  num =  NAND.operacion(in1, in2);
                  ContNANDS++;
            }      
            
        }else{
            FactoryCompuertas NOTFactory = ProducerCompuertas.getFactory("NOT");
            
              ConcreteNOT NOT = NOTFactory.getNOT();
              num =  NOT.Invertir(in1);
              ContNOTS++;
        }
        
        return num;
         
    } 
    
    public Node Search(int ind){
        int SIndex = 0;
        Node currNode = this.head;
        while(SIndex < ind){
            currNode = currNode.getNext();
            SIndex++;
        
        }
        return currNode;
    
    }

    public void insertarComp(String Compuerta,String tipoComp){
        
        Node Comp = new Node();
        
        if (this.isEmpty()){
            this.head = Comp;
            switch(tipoComp){
                case "NOT": this.head.setName(tipoComp + ContNOTS);
                            this.head.setTypes(Compuerta, tipoComp); break;
                case "OR":  this.head.setName(tipoComp + ContORS); 
                            this.head.setTypes(Compuerta, tipoComp); break;
                case "NOR": this.head.setName(tipoComp + ContNORS); 
                            this.head.setTypes(Compuerta, tipoComp); break;
                case "XOR": this.head.setName(tipoComp + ContXORS); 
                            this.head.setTypes(Compuerta, tipoComp); break;
                case "XNOR": this.head.setName(tipoComp + ContXNORS); 
                            this.head.setTypes(Compuerta, tipoComp); break;
                case "AND": this.head.setName(tipoComp + ContANDS); 
                            this.head.setTypes(Compuerta, tipoComp); break;
                case "NAND": this.head.setName(tipoComp + ContNANDS); 
                            this.head.setTypes(Compuerta, tipoComp); break;
                default: this.head.setName(null); break;
            }

        }else{
            if(Compuerta.equalsIgnoreCase("NOT")){

                

                Node act = this.head;
                while (act.getNext() != null) {
                    act = act.getNext();
                }

                act.setNext(Comp);
                act = act.getNext();
                
                act.setName(tipoComp + " " + ContNOTS);
                act.setTypes(Compuerta, tipoComp);
            
            }else{

                
                
                
                Node act = this.head;
                
                while (act.getNext() != null) {
                    act = act.getNext();
                }
                
                act.setNext(Comp);
                act = act.getNext();
                
                switch(tipoComp){
                    case "NOT": act.setName(tipoComp + ContNOTS); 
                                act.setTypes(Compuerta, tipoComp); break;
                    case "OR": act.setName(tipoComp + ContORS); 
                               act.setTypes(Compuerta, tipoComp); break;
                    case "NOR": act.setName(tipoComp + ContNORS);
                                act.setTypes(Compuerta, tipoComp); break;
                    case "XOR": act.setName(tipoComp + ContXORS); 
                                act.setTypes(Compuerta, tipoComp); break;
                    case "XNOR": act.setName(tipoComp + ContXNORS);
                                act.setTypes(Compuerta, tipoComp); break;
                    case "AND": act.setName(tipoComp + ContANDS); 
                                act.setTypes(Compuerta, tipoComp); break;
                    case "NAND": act.setName(tipoComp + ContNANDS); 
                                act.setTypes(Compuerta, tipoComp); break;
                    default: act.setName(null); break;
                
                }          
            }
        }
        this.size++;
        
        
    }
    
    public void insertarSignal(String name, int signal){
        
        Node Comp = new Node();
        if (this.isEmpty()){
            this.head = Comp;
            this.head.setData(signal);
            this.head.setprev1(this.head);
            this.head.setName(name);
            this.head.setTypes("Signal", "Signal");
            
        }else{
            Node act = this.head;
            while (act.getNext() != null) {
                act = act.getNext();
            }
            
            act.setNext(Comp);
            act = act.getNext();
            act.setData(signal);
            act.setName(name);
            act.setprev1(act);
            act.setTypes("Signal", "Signal");
        }
        this.size++;
    } 
    
    public void displayList() {
        Node current = this.head;
        while (current != null) {
            
            if(current.getType().equals("Signal")){
                
                System.out.println("El dato de la compuerta "+ current.getName()+ " es: "+ current.getData());
            }else{
                current.setprev1(this.head);
                current.setprev2(this.head.next);
                current.setData(Calculo((String)current.getType(),(String)current.getSubType(),(int) current.prev1.getData(),(int) current.prev2.getData()));
                System.out.println("El dato de la compuerta "+ current.getName()+ " es: "+ current.getData());
            }
            current = current.getNext();
        }
    }
        
}