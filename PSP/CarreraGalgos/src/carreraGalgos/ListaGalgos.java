package carreraGalgos;

import java.util.ArrayList;

public class ListaGalgos {
	
	public void listaGalgos1(ArrayList<GalgoH>lista1) {		
	GalgoH max = new GalgoH("Max");
	GalgoH atlas = new GalgoH("Atlas");
	GalgoH rocky = new GalgoH("Rocky");
	GalgoH thor = new GalgoH("Thor");
	GalgoH milo = new GalgoH("Milo");
	GalgoH rufus = new GalgoH("Rufus");
	lista1.add(max);
	lista1.add(atlas);
	lista1.add(rocky);
	lista1.add(thor);
	lista1.add(milo);
	lista1.add(rufus);
	}		
	
	public void listaGalgos2(ArrayList<GalgoI>lista2) {		
	GalgoI sasha = new GalgoI("Sasha");
	GalgoI daisy= new GalgoI("Daisy");
	GalgoI luna = new GalgoI("Luna");
	GalgoI chloe = new GalgoI("Cloe");
	GalgoI penny = new GalgoI("Penny");
	GalgoI nala = new GalgoI("Nala");
	lista2.add(sasha);
	lista2.add(daisy);
	lista2.add(luna);
	lista2.add(chloe);
	lista2.add(penny);
	lista2.add(nala);
	}		
}
