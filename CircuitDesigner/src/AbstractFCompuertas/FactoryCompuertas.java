package AbstractFCompuertas;

public abstract class FactoryCompuertas {
        
        abstract public ConcreteOR getOR(String tipoOR);
        abstract public ConcreteNOT getNOT();
        abstract public ConcreteAND getAND(String tipoAND);
}