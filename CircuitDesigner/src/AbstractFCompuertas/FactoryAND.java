package AbstractFCompuertas;


public class FactoryAND extends FactoryCompuertas {

    @Override
    ConcreteOR getOR(String tipoOR) {
        return null;
    }

    @Override
    ConcreteNOT getNOT() {
        return null;
    }

    @Override
    ConcreteAND getAND(String tipoAND) {
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
    
}
