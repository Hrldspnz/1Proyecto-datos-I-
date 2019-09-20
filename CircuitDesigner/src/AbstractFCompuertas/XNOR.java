package AbstractFCompuertas;


public class XNOR implements ConcreteOR{

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