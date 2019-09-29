package Draw;

import CircuitList.Node;
import java.awt.Graphics;


/**
 * Clase que contiene las compuertas dibujadas y sus datos asosiados
 * @author Harold Espinoza M.
 * @version 1.2
 * 
 */
public class DrawComp {
    private int x, y;
    private String Name = null;
    public Node asNode;
    public static final int ancho = 51;
    public static final int largo = 26;
    
    /**
     * Constructor de la clase para el dibujado de las compuertas
     * @param x Entero con la poscicion en el eje x de la compuerta
     * @param y Entero con la poscicion en el eje y de la compuerta
     * @param AsNode Nodo asosiado de la lista dobleenlazada de compuertas
     * @param name Nombre de la compuerta
     * @author Harold Espinoza M.
     */
    public DrawComp(int x, int y, Node AsNode, String name){
        this.x = x;
        this.y = y;
        this.Name = name;
        this.asNode = AsNode;
    }
    
    /**
     * Metodo que dibuja la compuerta junto con su nombre
     * @author Harold Espinoza M.
     * @param g recibe una instancia de la clase graphics
     */
    public void Draw(Graphics g){
        g.drawRect(this.x - ancho/2, this.y - largo/2, ancho, largo);
        g.drawString(Name, x-10, y);
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
