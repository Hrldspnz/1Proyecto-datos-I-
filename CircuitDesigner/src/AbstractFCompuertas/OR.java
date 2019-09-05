package AbstractFCompuertas;

public class OR implements ConcreteOR {

    @Override
    public int operacion(int input1, int input2) {
        if (input1 + input2 == 2){
            return 1;
        
        } else {
            return input1 + input2;
                    
        }
    }
}    
