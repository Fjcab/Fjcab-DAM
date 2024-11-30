package ejemplosArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class bucleNormal {

	public static void main(String[] args) {
		ArrayList <String> nombres = new ArrayList <String> ();
		nombres.add("Javier");
		nombres.add("Leire");
		nombres.add("Izan");
		nombres.add("Ainhoa");
		nombres.add("Maria");
		
		System.out.println("Tamaño del arrayList: "+nombres.size());
		System.out.println();
		
		//bucle for normal
		/*for(int i=0;i<nombres.size();i++) {
			System.out.println("Contenido de la posición numero "+i+": "+nombres.get(i));
		}*/
		
		//bucle con iterador
	    /*Iterator<String> it= nombres.iterator();
	    while(it.hasNext()) {
	    	System.out.println("Contenido de la posición: "+it.next());
	    }*/
	    
	    //bucle for each
	    for (String cadena: nombres) {
	        if(cadena.equals("Izan")) {
	        	System.out.print("Izan ha sido encontrado");
	        	break;
	        }
	    }
	    
	    
	    ArrayList<alumno>alumnosClase=new ArrayList<alumno>();
	    alumno a1=new alumno("123","David");
	    alumno a2=new alumno("456","Jaime");
	    alumno a3=new alumno("789","Alicia");
	    alumnosClase.add(a1);
	    alumnosClase.add(a2);
	    alumnosClase.add(a3);
	    for (alumno a: alumnosClase) {
	        if(a.getDni().equals("951")) {
	        	System.out.print(a.getNombre());
	        	break;
	        }
	    }
	    
	    for (alumno a: alumnosClase) {
	        //alumnosClase.remove(a.getDni().equals("456"));
	    	if(a.getDni().equals("456")) {
		      alumnosClase.remove(a);
		      break;
		    }
	    }
	    
	}

}
