package AbstractFCompuertas;
/**
 * Clase que implementa el metodo de concrete OR para la compuerta XNOR
 * @author Harold Espinoza M.
 * @version 1.0
 */

public class XNOR implements ConcreteOR{
    /**
     * El metodo de operacion es sobreescrito para la compuerta XNOR
     * @param input1 primera entrada de la compuerta XNOR
     * @param input2 segunda entrada de la compuerta XNOR
     * @return Se retorna un entero con el resultado de la operacion de la compuerta XNOR
     * @author Harold Espinoza M.
     **/
    @Override
    public int operacion(int input1, int input2) {
        int sumaXNOR;
        sumaXNOR = input1 + input2;
        if (sumaXNOR == 0){
            return 1;
            
        }else if (sumaXNOR == 1){
            return 0;
            
        }else {
            return 1;
        }

    }
    
}