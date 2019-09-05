package AbstractFCompuertas;


public class XOR implements ConcreteOR{

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