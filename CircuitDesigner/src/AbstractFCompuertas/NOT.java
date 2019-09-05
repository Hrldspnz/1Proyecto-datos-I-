package AbstractFCompuertas;


public class NOT implements ConcreteNOT{

    @Override
    public int Invertir(int input) {
        if (input == 0){
            return 1;
        }else{
            return 0;
        }
    }
    
}
