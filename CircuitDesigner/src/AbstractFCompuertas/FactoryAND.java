package AbstractFCompuertas;

/**
 * Clase de la Fabrica de compuertas AND que hereda de la clase abstracta FactoryCompuertas
 * @author Harold Espinoza Matarrita 
 * @version 1.0
 */
public class FactoryAND extends FactoryCompuertas {
    /**
     * Sobreescribe el metodo getAND para acceder a la Compuerta requerida por el usuario
     * @param tipoAND Recibe un String con el tipo de compuerta que desea el usuario
     * @return El metodo retorna una nueva compuerta AND del tipo que el usuario necesita (AND, NAND)
     */
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
