package AbstractFCompuertas;


public class FactoryNOT extends FactoryCompuertas {

    @Override
    public ConcreteOR getOR(String tipoOR) {
        return null;
    }

    @Override
    public ConcreteNOT getNOT() {
        return new NOT();
        
    }
    

    @Override
    public ConcreteAND getAND(String tipoAND) {
        return null;
    }
    
}
