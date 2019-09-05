package AbstractFCompuertas;

public abstract class FactoryCompuertas {
        
        abstract ConcreteOR getOR(String tipoOR);
        abstract ConcreteNOT getNOT();
        abstract ConcreteAND getAND(String tipoAND);
}