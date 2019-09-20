package Draw;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JPanel;
import java.awt.Rectangle;

/**
 *
 * @author Harold
 */
public class Paleta extends JPanel implements MouseListener {
    private Vector<DrawComp> vectorPaleta;
    public static String Setnombre = null;
    public static int pointin = 0;
    
    
    public Paleta(){
        this.vectorPaleta = new Vector<>();
        this.addMouseListener(this);
        this.vectorPaleta.add(new DrawComp(40, 30, null, "Signal"));
        this.vectorPaleta.add(new DrawComp(40, 80, null, "AND"));
        this.vectorPaleta.add(new DrawComp(40, 130, null, "NAND"));
        this.vectorPaleta.add(new DrawComp(40, 180, null, "NOT"));
        this.vectorPaleta.add(new DrawComp(40, 230, null, "OR"));
        this.vectorPaleta.add(new DrawComp(40, 280, null, "NOR"));
        this.vectorPaleta.add(new DrawComp(40, 330, null, "XOR"));
        this.vectorPaleta.add(new DrawComp(40, 380, null, "XNOR"));
    }
    
    public void paint(Graphics g){
        for (DrawComp nodos: vectorPaleta){
            nodos.Draw(g);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
            for (DrawComp Comp: vectorPaleta)
            if(new Rectangle(Comp.getX() - DrawComp.ancho/2,Comp.getY() - DrawComp.largo/2, Comp.ancho, Comp.largo).contains(e.getPoint())){
                Setnombre = Comp.getName();
                pointin = 1;
                
               
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}

