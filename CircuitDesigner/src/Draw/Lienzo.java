package Draw;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JPanel;
import CircuitList.CompList;
import CircuitList.Node;
import static Draw.Paleta.Setnombre;
import static Draw.Paleta.pointin;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Harold
 */
public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {
    private Vector<DrawComp> vectorNodos;
    private Vector<DrawLine> vectorLineas;
    public CompList CList = new CompList();
    public int index = 0;
    public DrawComp MovComp;
    public int indMovComp;
    public Point punto1, punto2;
    private Node tempAs;
         
    
    public Lienzo(){
        this.vectorNodos = new Vector<>();
        this.vectorLineas = new Vector<>();
        this.addMouseListener(this);   
        this.addMouseMotionListener(this);
    }
    
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
          
            if (pointin == 1){
                
                if (Setnombre.equalsIgnoreCase("Signal")){
                    CList.insertarSignal(Setnombre, 0);
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode,Setnombre));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("OR")){
                    CList.insertarComp("OR", "OR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, "OR"));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("NOR")){
                    CList.insertarComp("OR", "NOR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, "NOR"));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("XOR")){
                    CList.insertarComp("OR", "XOR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, "XOR"));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("XNOR")){
                    CList.insertarComp("OR", "XNOR");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, "XNOR"));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("AND")){
                    CList.insertarComp("AND", "AND");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, "AND"));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else if(Setnombre.equalsIgnoreCase("NAND")){
                    CList.insertarComp("AND", "NAND");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, "NAND"));
                    index++;
                    repaint();
                    
                    pointin=0;
                }else{
                    CList.insertarComp("NOT", "NOT");
                    Node AsNode = new Node();
                    AsNode = CList.Search(index);
                    this.vectorNodos.add(new DrawComp(e.getX(), e.getY(), AsNode, "NOT"));
                    index++;
                    repaint();
                   
                    pointin=0;
                }
            
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
                            this.vectorLineas.add(new DrawLine(punto1.x,punto1.y,punto2.x,punto2.y));
                        }else if (Comp.asNode.prev2 == null && Comp.asNode.getSubType() != "Signal" && Comp.asNode.getSubType() != "NOT" ){
                            Comp.asNode.setprev2(tempAs);
                            punto2 = new Point(Comp.getX()-51/2,Comp.getY());
                            this.vectorLineas.add(new DrawLine(punto1.x,punto1.y,punto2.x,punto2.y));
                        }
                        
                        repaint();
                        punto1 = null;
                        punto2 = null;
                        if(Comp.asNode.prev2==null){
                            System.out.println("El previo de "+ Comp.asNode.getName() +" son: "+Comp.asNode.prev1.getSubType());
                        }else{
                            System.out.println("Los previos de "+ Comp.asNode.getName() +" son: "+Comp.asNode.prev1.getSubType() +" "+ Comp.asNode.prev2.getSubType());
                        }
                    }
                }
            }
        }
    }

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

    @Override
    public void mouseDragged(MouseEvent e) {
        if(MovComp != null){
            this.vectorNodos.set(indMovComp, new DrawComp(e.getX(),e.getY(),MovComp.getAsNode(),MovComp.getName()));
            int indLine = 0;
            for (DrawLine line: vectorLineas){
                if(new Rectangle(line.getX1() - DrawComp.ancho,line.getY1() - DrawComp.largo/2, DrawComp.ancho+15, DrawComp.largo+15).contains(e.getPoint())){
                    this.vectorLineas.set(indLine, new DrawLine(e.getX()+51/2,e.getY(),line.getX2(),line.getY2()));
                }else if(new Rectangle(line.getX2() - DrawComp.ancho/4,line.getY2() - DrawComp.largo/2, DrawComp.ancho+15, DrawComp.largo+15).contains(e.getPoint())){
                    this.vectorLineas.set(indLine, new DrawLine(line.getX1(),line.getY1(),e.getX()-51/2,e.getY()));
                }indLine++;
            }
                
        }repaint();
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
