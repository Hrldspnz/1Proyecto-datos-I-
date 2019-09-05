package AbstractFCompuertas;


public class AND implements ConcreteAND{

    @Override
    public int operacion(int input1, int input2) {
        
        int multAND;
        multAND = input1 * input2;
        
        return multAND;
    }
    
}
