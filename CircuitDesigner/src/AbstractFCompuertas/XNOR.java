package AbstractFCompuertas;


public class XNOR implements ConcreteOR{

    @Override
    public int operacion(int input1, int input2) {
        int sumaXOR;
        sumaXOR = input1 + input2;
        if (sumaXOR == 0){
            return 1;
            
        }else if (sumaXOR == 1){
            return 0;
            
        }else {
            return 1;
        }

    }
    
}