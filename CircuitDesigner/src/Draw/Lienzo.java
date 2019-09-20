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
import java.awt.Rectangle;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Harold
 */
public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {
    private Vector<DrawComp> vectorNodos;
    public CompList CList = new CompList();
    public int index = 0;
    public DrawComp MovComp;
    public int indMovComp;
    
    
    public Lienzo(){
        this.vectorNodos = new Vector<>();
        this.addMouseListener(this);   
        this.addMouseMotionListener(this);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        for (DrawComp nodos: vectorNodos){
            nodos.Draw(g);
            
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
          
            if (pointin == 1){
                
                if (Setnombre.equalsIgnoreCase("Signal")){
                    CList.insertarSignal(Setnombre, 1);
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
       int iComp = 0;
       for (DrawComp Comp: vectorNodos){
            if(new Rectangle(Comp.getX() - DrawComp.ancho/2,Comp.getY() - DrawComp.largo/2, Comp.ancho, Comp.largo).contains(e.getPoint())){
                MovComp = Comp;
                indMovComp = iComp;
                break;
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
        }repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
