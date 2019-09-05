package AbstractFCompuertas;


public class FactoryOR extends FactoryCompuertas{

    @Override
    public ConcreteOR getOR(String tipoOR) {
        if(tipoOR == null){
            return null;
        }
        if(tipoOR.equalsIgnoreCase("OR")){
            return new OR();
        }else if (tipoOR.equalsIgnoreCase("NOR")){
            return new NOR();
        }else if (tipoOR.equalsIgnoreCase("XOR")){
            return new XOR();
        }else if (tipoOR.equalsIgnoreCase("XNOR")){
            return new XNOR();
        }
        
        return null;
        
    }

    @Override
    public ConcreteNOT getNOT() {
        return null;
    }

    @Override
    public ConcreteAND getAND(String tipoAND) {
        return null;
    }
    
    
    
}
