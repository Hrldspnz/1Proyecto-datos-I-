package Draw;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JPanel;
import CircuitList.CompList;
import CircuitList.Node;
import static CircuitList.CompList.Calculo;
import static Draw.Paleta.Setnombre;
import static Draw.Paleta.pointin;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Clase del panel para el dibujado y manipulacion de las compuertas que implemeta MouseListener, MouseMotionListener para la deteccion de lo que hace el mouse
 * @author Harold
 * @version 1.2
 */
public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {
    public static Vector<DrawComp> vectorNodos;
    private Vector<DrawLine> vectorLineas;
    public CompList CList = new CompList();
    public int index = 0;
    public DrawComp MovComp;
    public int indMovComp;
    public Point punto1, punto2;
    private Node tempAs;
    public static int Ndata = 0;
         
    /**
     * Constructor de la clase que inicia los parametros necesarios
     * @author Harold Espinoza M.
     */
    public Lienzo(){
        vectorNodos = new Vector<>();
        this.vectorLineas = new Vector<>();
        this.addMouseListener(this);   
        this.addMouseMotionListener(this);
        
    }

    /**
     * Metodo que se encarga de pintar todas las compuertas y las lineas de conexion
     * utiliza el metodo padre de la clase graphics 
     * @author Harold Espinoza M.
     */
    public void paint(Graphics g){
        super.paint(g);
        for (DrawComp nodos: vectorNodos){
            nodos.Draw(g);
            
        }
        for (DrawLine lineas: vectorLineas){
            lineas.Draw(g);
            
        }      
        repaint();
    }
    
    /**
     * Metodo de recurcion que realiza el el calculo de la compuerta solicitada
     * Para ello calcula el dato de las compuertas conectdas a ella y luego calcula su dato
     * @param comp Nodo con la compuerta que se desea calcular el resultado
     * @return Devuelve un entero con el dato final de la compuerta
     */
    public static int CalcData(Node comp){
        if(comp.prev1.getType() != "Signal"){
            comp.prev1.setData(CalcData(comp.prev1));
            
        }if(comp.prev2 != null && comp.prev2.getType() != "Signal"){
            comp.prev2.setData(CalcData(comp.prev2));
            
        }if(comp.getType().equals("NOT")){
            Ndata = Calculo((String)comp.getType(), (String)comp.getSubType(), (int)comp.prev1.getData(), 0);
               
        }else if (comp.getType()!= "Signal"){          
            Ndata = Calculo((String)comp.getType(), (String)comp.getSubType(), (int)comp.prev1.getData(), (int)comp.prev2.getData());
        }                 
        
        return Ndata;
    }
    
    /**
     * Se sobreescribe el metod de mouseClicked para realizar diferentes acciones deendiendo del click en el mouse
     * Con el Click derecho si se tiene una compuerta seleccionada de la paaleta puede colocar una compuerta, en caso de no tener una compuerta si se da click sobre una señal permite cambiar el nombre o su señal
     * Con el Click izquierdo sobre una compuerta o señal se permite crear lineas de conccion para ello se da click izquierdo primero sobre la salida de la compuerta que se desea conectar a la entrada de otra luego sobre la segunda compuerta
     * @param e Recibe como parametro los eventos del mouse
     * @author Harold Espinoza M.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
          
            if (pointin == 1){
                
                if (Setnombre.equalsIgnoreCase("Signal")){
                    CList.insertarSignal("none", 0);
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode,Setnombre));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("OR")){
                    CList.insertarComp("OR", "OR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, (String) AsNode.getName()));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("NOR")){
                    CList.insertarComp("OR", "NOR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, (String) AsNode.getName()));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("XOR")){
                    CList.insertarComp("OR", "XOR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, (String) AsNode.getName()));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("XNOR")){
                    CList.insertarComp("OR", "XNOR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, (String) AsNode.getName()));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("AND")){
                    CList.insertarComp("AND", "AND");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, (String) AsNode.getName()));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("NAND")){
                    CList.insertarComp("AND", "NAND");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, (String) AsNode.getName()));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else{
                    CList.insertarComp("NOT", "NOT");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, (String) AsNode.getName()));
                    index++;
                    repaint();
                   
                    pointin=0;
                }
            
            }else for (DrawComp Comp: vectorNodos){ 
                if(new Rectangle(Comp.getX() - DrawComp.ancho/2,Comp.getY() - DrawComp.largo/2, Comp.ancho, Comp.largo).contains(e.getPoint())){
                    if(Comp.getAsNode().getType() == "Signal"){
                        if(Comp.getAsNode().getName() == "none"){
                            String NewName = JOptionPane.showInputDialog("Ingrese el nombre de la señal");
                            Comp.setName(NewName);
                            Comp.asNode.setName(NewName);
                        } else {
                            String signal = JOptionPane.showInputDialog("Ingrese el dato la señal");
                            System.out.println(signal);
                            if(signal.equalsIgnoreCase("True") || signal.equalsIgnoreCase("TRUE") || signal.equalsIgnoreCase("1") || signal.equalsIgnoreCase("true") ){
                                Comp.asNode.setData(1);
                                System.out.println("Se cambio la señal a 1 : "+Comp.asNode.getData() );
                            }else{
                                Comp.asNode.setData(0);
                                System.out.println("Se cambio la señal a 0 : "+Comp.asNode.getData() );
                            }
                        }
                        
                    }
                }repaint();
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1){
            for (DrawComp Comp: vectorNodos){
                if(new Rectangle(Comp.getX() - DrawComp.ancho/2,Comp.getY() - DrawComp.largo/2, Comp.ancho, Comp.largo).contains(e.getPoint())){
                    if(punto1 == null){
                        tempAs = Comp.asNode;
                        punto1 = new Point(Comp.getX()+51/2,Comp.getY());              
                    }else{
                        
                        if(Comp.asNode.prev1 == null && Comp.asNode.getSubType() != "Signal"){
                            Comp.asNode.setprev1(tempAs);
                            punto2 = new Point(Comp.getX()-51/2,Comp.getY());
                            Random num = new Random();                      
                            Color random = new Color(num.nextInt(255),num.nextInt(255),num.nextInt(255));
                            this.vectorLineas.add(new DrawLine(punto1.x,punto1.y,punto2.x,punto2.y, random));
                        }else if (Comp.asNode.prev2 == null && Comp.asNode.getSubType() != "Signal" && Comp.asNode.getSubType() != "NOT" ){
                            Comp.asNode.setprev2(tempAs);
                            punto2 = new Point(Comp.getX()-51/2,Comp.getY());
                            Random num = new Random();
                            Color random = new Color(num.nextInt(255),num.nextInt(255),num.nextInt(255));
                            this.vectorLineas.add(new DrawLine(punto1.x,punto1.y,punto2.x,punto2.y, random));
                        }
                        
                        repaint();
                        punto1 = null;
                        punto2 = null;
                        
                    }
                }
            }
        }
    }

    /**
     * Metodo sobreescrito para definir que sucede en caso de presionar un boton del mouse
     * En este caso se utiliza para mover una compuerta, si el mouse esta encima de una compuerta guarda esta en una variable 
     * @author Harold Espinoza M.
     */
    @Override
    public void mousePressed(MouseEvent e) {
       
       int iComp = 0;
     
       for (DrawComp Comp: vectorNodos){
            if(new Rectangle(Comp.getX() - DrawComp.ancho/2,Comp.getY() - DrawComp.largo/2, Comp.ancho, Comp.largo).contains(e.getPoint())){
                MovComp = Comp;
                indMovComp = iComp;
                
            }
            
            iComp++;
       }
    }

    /**
     * Metodo sobreescrito para definir las acciones cunado se suelta un boton del mouse
     * En este caso se reinician las variables usadas para mover la compuerta
     * @author Harold Espinoza M.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        MovComp = null;
        indMovComp = -1;
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    /**
     * Se sobreescribe el metodo para cuando se arrastra el mouse
     * Si las variables contienen una compuerta la mueven a la posicion en la que mouse se encuentre es decir la arrastra con el
     * Si la compuerta contiene una linea entonces la mueve tambien
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if(MovComp != null){
            vectorNodos.set(indMovComp, new DrawComp(e.getX(),e.getY(),MovComp.getAsNode(),MovComp.getName()));
            int indLine = 0;
            for (DrawLine line: vectorLineas){
                if(new Rectangle(line.getX1() - DrawComp.ancho,line.getY1() - DrawComp.largo/2, DrawComp.ancho+15, DrawComp.largo+15).contains(e.getPoint())){
                    this.vectorLineas.set(indLine, new DrawLine(e.getX()+51/2,e.getY(),line.getX2(),line.getY2(),line.getColor()));
                }else if(new Rectangle(line.getX2() - DrawComp.ancho/4,line.getY2() - DrawComp.largo/2, DrawComp.ancho+15, DrawComp.largo+15).contains(e.getPoint())){
                    this.vectorLineas.set(indLine, new DrawLine(line.getX1(),line.getY1(),e.getX()-51/2,e.getY(),line.getColor()));
                }indLine++;
            }
                
        }repaint();
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
