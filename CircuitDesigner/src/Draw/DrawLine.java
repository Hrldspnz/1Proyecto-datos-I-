
package Draw;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que contiene las lineas de conexion y las dibuja
 * @author Harold Espinoza M.
 * @version 1.2
 */
public class DrawLine {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public Color color;
    
    /**
     * Contructor de la clase de lineas de conexion
     * @param x1 Entero con la poscicion en el eje x del primer punto de la linea
     * @param y1 Entero con la poscicion en el eje y del primer punto de la linea
     * @param x2 Entero con la poscicion en el eje x del segundo punto de la linea
     * @param y2 Entero con la poscicion en el eje y del segundo punto de la linea
     * @param color Color de la linea 
     * @author Harold Espinoza M.
     */
    public DrawLine(int x1, int y1, int x2, int y2, Color color){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }
    
    /**
     * Metodo que dibuja la linea con su respectivo color 
     * @author Harold Espinoza M.
     * @param g recibe una instancia de la clase graphics
     */
    public void Draw(Graphics g){
        g.setColor(this.getColor());
        g.drawLine(x1,y1,x2,y2);
    }
    
    public void setX1(int x1){
        this.x1 = x1;
    }
   
    public void setY1(int y1){
        this.y1 = y1;
    }
   
    public void setX2(int x2){
        this.x2 = x2;
    }
   
    public void setY2(int y2){
        this.y2 = y2;
    }
   
    public int getX1(){
        return this.x1;
    }
   
   public int getY1(){
       return this.y1;
   }
   
   public int getX2(){
       return this.x2;
   }
   
   public int getY2(){
       return this.y2;
   }
   
   public Color getColor(){
       return this.color;
   }
}