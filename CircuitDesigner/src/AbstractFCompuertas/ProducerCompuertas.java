package AbstractFCompuertas;
/**
 * Clase encargada de selecionar la fabrica de compuertas necesitada
 * @author Harold Espinoza M.
 */

public class ProducerCompuertas {
    /**
     * Metodo que selecciona la fabrica dependiendo de la necesidad del usuario
     * @param choice String con la fabrica solicitada
     * @return Retorna una fabrica 
     * @author Harold Espinoza M.
     */
            
    public static FactoryCompuertas getFactory(String choice){
        if(choice.equalsIgnoreCase("OR")){
            return new FactoryOR();
	         
        }else if(choice.equalsIgnoreCase("NOT")){
            return new FactoryNOT();
                 
        }else if(choice.equalsIgnoreCase("AND")){
            return new FactoryAND();
        }
	      
            return null;
        }
}

