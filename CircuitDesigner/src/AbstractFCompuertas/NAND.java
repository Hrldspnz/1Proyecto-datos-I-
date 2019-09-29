package AbstractFCompuertas;

/**
 * Esta clase implementa el metodo de ConcreteAND y lo sobreescribe para definir la operacion del NAND
 * @author Harold Espinoza M.
 * @version 1.0
 */

public class NAND implements ConcreteAND{
    /**
     * Metodo de concreteAND se sobreescribe para la operacion de multiplicacion y se adapta a la compuerta NAND
     * @param input1 Primera entrada de la compuerta NAND
     * @param input2 Segunda entrada de la compuerta NAND
     * @return El metodo retorna un entero con el resultado de la operacion de la compuerta NAND
     * @author Harold Espinoza M.
     **/
    @Override
    public int operacion(int input1, int input2) {
        
        int multAND;
        multAND = input1 * input2;
        
        if(multAND == 0){
            return 1;
        }else{
            return 0;
        }
    }
    
}
