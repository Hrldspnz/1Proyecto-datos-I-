package Draw;

import CircuitList.Node;
import java.awt.Graphics;


/**
 *
 * @author Harold
 */
public class DrawComp {
    private int x, y;
    private String Name = null;
    public Node asNode;
    public static final int ancho = 51;
    public static final int largo = 26;
    
    public DrawComp(int x, int y, Node AsNode, String name){
        this.x = x;
        this.y = y;
        this.Name = name;
        this.asNode = AsNode;
    }
    public void Draw(Graphics g){
        g.drawRect(this.x - ancho/2, this.y - largo/2, ancho, largo);
        g.drawString(Name, x, y);
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name){
        this.Name = name;
    }
    
    public Node getAsNode(){
        return asNode;
    }    
    
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
