package AbstractFCompuertas;

/**
 * Esta clase implementa el metodo de ConcreteAND y lo sobreescribe para definir la operacion del AND
 * @author Harold Espinoza M.
 * @version 1.0
 */
public class AND implements ConcreteAND{
    
    /**
     * Metodo de concreteAND se sobreescribe para la operacion de multiplicacion para adaptarla a la compuerta AND
     * @param input1 Primera entrada de la compuerta AND
     * @param input2 Segunda entrada de la compuerta AND
     * @return El metodo retorna un entero con el resultado de la operacion de la compuerta AND
     * @author Harold Espinoza M.
     **/
    
    @Override
    public int operacion(int input1, int input2) {
        
        int multAND;
        multAND = input1 * input2;
        
        return multAND;
    }
    
}
