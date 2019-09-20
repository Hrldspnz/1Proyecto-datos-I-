package AbstractFCompuertas;


public class FactoryAND extends FactoryCompuertas {

    @Override
    public ConcreteAND getAND(String tipoAND) {
        if(tipoAND == null){
            return null;
        }
        if(tipoAND.equalsIgnoreCase("AND")){
            return new AND();
        }else if (tipoAND.equalsIgnoreCase("NAND")){
            return new NAND();
        }
        return null;
    }
    
    @Override
    public ConcreteOR getOR(String tipoOR) {
        return null;
    }    
    
    @Override
    public ConcreteNOT getNOT() {
        return null;
    }
}
