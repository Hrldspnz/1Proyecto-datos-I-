package AbstractFCompuertas;
/**
 * Clase abstracta que permite acceder a las disteintas fabricas de Compuertas
 * @author Harold Espinoza M.
 * @version 1.0
 */
public abstract class FactoryCompuertas {
        
        abstract public ConcreteOR getOR(String tipoOR);
        abstract public ConcreteNOT getNOT();
        abstract public ConcreteAND getAND(String tipoAND);
}