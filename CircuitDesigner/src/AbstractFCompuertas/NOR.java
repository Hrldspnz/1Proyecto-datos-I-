package AbstractFCompuertas;


public class NOR implements ConcreteOR{

    @Override
    public int operacion(int input1, int input2) {
        int sumaNOR;
        sumaNOR = input1 + input2;
        if (sumaNOR == 0){
            return 1;
            
        }else{
            return 0;
            
        }

    }
    
}
