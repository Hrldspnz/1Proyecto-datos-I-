package CircuitList;

import AbstractFCompuertas.ConcreteAND;
import AbstractFCompuertas.ConcreteNOT;
import AbstractFCompuertas.ConcreteOR;
import AbstractFCompuertas.FactoryCompuertas;
import AbstractFCompuertas.ProducerCompuertas;

public class CompList {
   
    private Node head;
    private int size;
    private int ContANDS  = 0;
    private int ContNANDS  = 0;
    private int ContORS  = 0;
    private int ContNORS  = 0;
    private int ContXORS  = 0;
    private int ContXNORS  = 0;
    private int ContNOTS  = 0;
    
    
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
            this.head.setData(0);
            switch(tipoComp){
                case "NOT": this.head.setName(tipoComp + ContNOTS); break;
                case "OR": this.head.setName(tipoComp + ContORS); break;
                case "NOR": this.head.setName(tipoComp + ContNORS); break;
                case "XOR": this.head.setName(tipoComp + ContXORS); break;
                case "XNOR": this.head.setName(tipoComp + ContXNORS); break;
                case "AND": this.head.setName(tipoComp + ContANDS); break;
                case "NAND": this.head.setName(tipoComp + ContNANDS); break;
                default: this.head.setName(null); break;
            }

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
                act.setName(tipoComp + " " + ContNOTS);
            
            }else{

                int input1;
                int input2;
                
                
                Node act = this.head;
                
                while (act.getNext() != null) {
                    act = act.getNext();
                }
                
                act.setNext(Comp);
                act = act.getNext();
                act.setprev1(this.head); //Cambiar por funcion
                act.setprev2(this.head.next); //cambiar x2 
                
                input1 = (int) act.prev1.getData();
                input2 = (int) act.prev2.getData();
                
                act.setData(this.Calculo(Compuerta, tipoComp, input1, input2));
                switch(tipoComp){
                    case "NOT": act.setName(tipoComp + ContNOTS); break;
                    case "OR": act.setName(tipoComp + ContORS); break;
                    case "NOR": act.setName(tipoComp + ContNORS); break;
                    case "XOR": act.setName(tipoComp + ContXORS); break;
                    case "XNOR": act.setName(tipoComp + ContXNORS); break;
                    case "AND": act.setName(tipoComp + ContANDS); break;
                    case "NAND": act.setName(tipoComp + ContNANDS); break;
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
            this.head.setName(name);
            
        }else{
            Node act = this.head;
            while (act.getNext() != null) {
                act = act.getNext();
            }
            
            act.setNext(Comp);
            act = act.getNext();
            act.setData(signal);
            act.setName(name);
        }
        this.size++;
    } 
    
    public void displayList() {
        Node current = this.head;
        while (current != null) {
            System.out.println("El dato de la compuerta "+ current.getName()+ " es: "+ current.getData());
            current = current.getNext();
        }
    }
        
}