package AbstractFCompuertas;

/**
 * Esta clase implementa el metodo de ConcreteOR para adaptarlo a la compuerta OR
 * @author Harold Espinoza M.
 * @version 1.0
 */
public class OR implements ConcreteOR {
    /**
    * Se Sobreescribe el metodo de la operacion para la compuerta OR
    * @param input1 primera entrada de la compuerta OR
    * @param input2 segunda entrada de la compuerta OR
    * @return Retorna un entero con el resultado de la operacion de la compuerta OR
    * @author Harold Espinoza M.
    **/
    @Override
    public int operacion(int input1, int input2) {
        if (input1 + input2 == 2){
            return 1;
        
        } else {
            return input1 + input2;
                    
        }
    }
}    
