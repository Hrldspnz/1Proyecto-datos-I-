package AbstractFCompuertas;

/**
 * Clase de la Fabrica de compuerta NOT que hereda de la clase abstracta FactoryCompuertas
 * @author Harold Espinoza Matarrita 
 * @version 1.0
 */
public class FactoryNOT extends FactoryCompuertas {

    @Override
    public ConcreteOR getOR(String tipoOR) {
        return null;
    }
    /**
     * Sobreescribe el metodo getNOT para acceder a la Compuerta requerida por el usuario
     * @return El metodo retorna una nueva compuerta NOT
     */
    @Override
    public ConcreteNOT getNOT() {
        return new NOT();
        
    }
    

    @Override
    public ConcreteAND getAND(String tipoAND) {
        return null;
    }
    
}
