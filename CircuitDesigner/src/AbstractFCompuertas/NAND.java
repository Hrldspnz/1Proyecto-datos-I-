package AbstractFCompuertas;


public class NAND implements ConcreteAND{

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
