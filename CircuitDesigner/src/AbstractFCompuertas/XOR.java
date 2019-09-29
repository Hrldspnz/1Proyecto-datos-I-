package AbstractFCompuertas;

/**
 * Esta clase implementa de ConcreteOR el metodo de la operacion para la XOR
 * @author Harold Espinoza M.
 * @version 1.0
 */

public class XOR implements ConcreteOR{
    /**
     * Se sobreescribe el metodo con la operacion de la compuerta XOR
     * @param input1 primera entrada de la compuerta XOR
     * @param input2 segunda entrada de la compuerta XOR
     * @return Retorna un entero con el resultado de la operacion de la compuerta XOR
     */
    @Override
    public int operacion(int input1, int input2) {
        int sumaXOR;
        sumaXOR = input1 + input2;
        if (sumaXOR == 0){
            return 0;
            
        }else if (sumaXOR == 1){
            return 1;
            
        }else {
            return 0;
        }

    }
    
}