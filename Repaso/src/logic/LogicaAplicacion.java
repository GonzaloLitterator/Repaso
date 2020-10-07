package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import beans.Partido;

public class LogicaAplicacion implements Serializable{
	private final String NOMBRE_FICHERO="fichero.dat";
	private FileOutputStream fileO;
	private ObjectOutputStream output;
	private FileInputStream fileI;
	private ObjectInputStream input;
	private LinkedList<Partido> partidos = new LinkedList<Partido>(); 
	
	public LogicaAplicacion() {	
	}
	
	public boolean altaNuevoPartido(Partido p) {
		return partidos.add(p);
	}
	
	public Partido borradoPartido(int Index) {
		Partido Borrado=null;
		System.out.println(Index<partidos.size());
		if (Index>0 && Index<partidos.size()) {
			Index--;
			Borrado=partidos.get(Index);
			partidos.remove(Index);
		}
		return Borrado;
	}
	
	public LinkedList<Partido> listaPartidosOrdenados(String metodo){
		LinkedList<Partido> copia= new LinkedList<>(partidos);
		if (metodo.equalsIgnoreCase("Ascendente"))
			Collections.sort(copia);
		else {
			Collections.sort(copia, new Comparator<Partido>(){
				@Override
				public int compare(Partido o1, Partido o2) {
					return o2.getFecha().compareTo(o1.getFecha());
				}
			});
		}
			
		return copia;
	}
	
	public LinkedList<Partido> listaPartidosDivision(Partido.Divisiones d){
		return partidos;
	}
	
	public void cargarFichero()  throws IOException, ClassNotFoundException{
		//Abro el fichero
		fileI=new FileInputStream(NOMBRE_FICHERO);
		input = new ObjectInputStream(fileI);
		if(input!=null)
			partidos= (LinkedList<Partido>) input.readObject();
		//Cierro fichero
		if(input!=null)
			input.close();
	}

	public void guardarEnFichero() throws IOException{
		//Abro el fichero
		fileO=new FileOutputStream(NOMBRE_FICHERO,false);
		output = new ObjectOutputStream(fileO);
		if(output!=null)
			output.writeObject(partidos);
		//Cierro fichero
		if(output!=null)
			output.close();
	}
	
	public LinkedList<Partido> getPartidos(){
		return partidos;
	}
	
}
