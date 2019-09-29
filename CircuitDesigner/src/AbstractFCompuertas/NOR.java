package AbstractFCompuertas;

/**
 * Esta clase implementa el metodo de ConcreteOR y lo sobreescribe para definir la operacion del NOR
 * @author Harold Espinoza M.
 * @version 1.0
 */

public class NOR implements ConcreteOR{
    /**
     * Se sobreescribe el metodo de operacion para la compuerta NOR
     * @param input1 Primera entrada de la compuerta NOR
     * @param input2 Segunda entrada de la compuerta NOR
     * @return El metodo retorna un entero con el resultado de la operacion de la compuerta NOR
     * @author Harold Espinoza M.
     **/
    
    @Override
    public int operacion(int input1, int input2) {
        int sumaNOR;
        sumaNOR = input1 + input2;
        if (sumaNOR == 0){
            return 1;
            
        }else{
            return 0;
            
        }

    }
    
}
