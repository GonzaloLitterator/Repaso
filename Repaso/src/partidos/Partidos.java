package partidos;

import beans.Partido;
import logic.LogicaAplicacion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Partidos {
	String format = "MM/dd/yyyy";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner imp = new Scanner(System.in);
		SimpleDateFormat fecha= new SimpleDateFormat("dd/MM/yyyy");
		LogicaAplicacion logica= new LogicaAplicacion();
		Partido p=new Partido();
		
		try {
			logica.cargarFichero();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int opc=0;
		do {
			menu();
			opc=Integer.parseInt(imp.nextLine());
			
			switch(opc) {
				case 1:
					p=new Partido();
					System.out.println("Escribe el nombre del equipo Local:");
					p.setEqLocal(imp.nextLine());
					System.out.println("Escribe el nombre del equipo Visitante:");
					p.setEqVisitante(imp.nextLine());
					System.out.println("Escribe el resultado:");
					p.setResultado(imp.nextLine());
					System.out.println("Escribe el numero de la division (1-PRIMERA, 2-SEGUNDA, 3-TERCERA):");
					int div=Integer.parseInt(imp.nextLine());
					if(div==1){
					p.setDivision(Partido.Divisiones.PRIMERA);
					}
					else if (div==2){
						p.setDivision(Partido.Divisiones.SEGUNDA);
					}
					else if (div==3) {
						p.setDivision(Partido.Divisiones.TERCERA);
					}
					System.out.println("Escribe la fecha en formato (dd/mm/yyyy)");
					try {
						//parseo la linea que me pasa imp y la meto en la funcion set
						p.setFecha(fecha.parse(imp.nextLine()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(logica.altaNuevoPartido(p)) {
						System.out.println("Introducido correctamente");
					}
					else
						System.out.println("Error con los datos");
					break;
				case 2:
					mostrarListaPartidos(logica.getPartidos());
					break;
				case 3:
					System.out.println("Introduce el indice de la lista del partido a borrar");
					p=logica.borradoPartido(Integer.parseInt(imp.nextLine()));
					System.out.println();
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
				try {
					logica.guardarEnFichero();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					System.out.println("Adeuu");
					break;
			}
			
		}while(opc!=6);
		imp.close();
	}
	
	public static void menu() {
		System.out.println("------------ MENU ---------------"
				+ "\n 1- Dar de alta un nuevo partido."
				+ "\n 2- Mostar listado."
				+ "\n 3- Borrado de un partido."
				+ "\n 4- Mostrar los partidos ordenados."
				+ "\n 5- Mostrar partidos de una división."
				+ "\n 6- Salir y guardar.");
	}
	
	public static void mostrarListaPartidos(List <Partido> lista) {
		int tam=lista.size();
		Partido p;
		for(int i=0;i<tam;i++){
			p=lista.get(i);
			System.out.println("L: "+p.getEqLocal()+" V: "
			+p.getEqVisitante()+" R: "+p.getResultado()+" D:"
			+p.getDivision()+" F: "+p.getFecha()+"\n");
		}
	}

}
	
