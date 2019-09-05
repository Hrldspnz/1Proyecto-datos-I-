package AbstractFCompuertas;


public class ProducerCompuertas {
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

