package AbstractFCompuertas;

/**
 * Clase de la Fabrica de compuerta OR que hereda de la clase abstracta FactoryCompuertas
 * @author Harold Espinoza Matarrita 
 * @version 1.0
 */

public class FactoryOR extends FactoryCompuertas{
    /**
     * Sesobreecribe el metodo getOR para crear la compuerta requerida por el usuario
     * @param tipoOR Recibe un String con el tipo de OR que el usuario necesita
     * @return El metodo retorna una nueva compuerta OR del tipo que solicito el usuario (OR, NOR, XOR, XNOR)
     */
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
