package AbstractFCompuertas;
/**
 * Esta clase implementa el metodo de concretNOT sobreecribiendolo para el NOT
 * @author Harold Espinoza M.
 * @version 1.0
 */

public class NOT implements ConcreteNOT{
    /**
     * Sobreescribe el metodo del NOT y lo adapta para invertar la salida 
     * @param input Entrada de la copuerta NOT
     * @return Retorna un entero que es lo contrario a la señal (para 0 retorna 1 y para 1 retorna 0)
     * @author Harold Espinoza M.
     */
    @Override
    public int Invertir(int input) {
        if (input == 0){
            return 1;
        }else{
            return 0;
        }
    }
    
}
