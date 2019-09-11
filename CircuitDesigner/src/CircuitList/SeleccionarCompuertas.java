package CircuitList;
import AbstractFCompuertas.ConcreteAND;
import AbstractFCompuertas.ConcreteNOT;
import AbstractFCompuertas.ConcreteOR;
import AbstractFCompuertas.ProducerCompuertas;
import AbstractFCompuertas.FactoryCompuertas;


public class SeleccionarCompuertas {
	   public static void main(String[] args) {
	      FactoryCompuertas ORFactory = ProducerCompuertas.getFactory("OR");

	      ConcreteOR OR1 = ORFactory.getOR("OR");
	      System.out.println("Compuerta OR:" + OR1.operacion(1, 1));

	      ConcreteOR OR2 = ORFactory.getOR("NOR");
	      System.out.println("Compuerta NOR:" + OR2.operacion(1, 1));
	      
	      ConcreteOR OR3 = ORFactory.getOR("XOR");
	      System.out.println("Compuerta XOR:" + OR3.operacion(1, 1));
              
              ConcreteOR OR4 = ORFactory.getOR("XNOR");
	      System.out.println("Compuerta XNOR:" + OR4.operacion(1, 1));
              
	      FactoryCompuertas NOTFactory = ProducerCompuertas.getFactory("NOT");

	      ConcreteNOT NOT1 = NOTFactory.getNOT();
	      System.out.println("Compuerta NOT:" + NOT1.Invertir(1));

              FactoryCompuertas ANDFactory = ProducerCompuertas.getFactory("AND");

	      ConcreteAND AND1 = ANDFactory.getAND("AND");
	      System.out.println("Compuerta AND:" + AND1.operacion(1, 1));
              
	      ConcreteAND AND2 = ANDFactory.getAND("NAND");
	      System.out.println("Compuerta NAND:" + AND2.operacion(1, 1));              
              
	   }
}
