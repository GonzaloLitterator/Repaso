package beans;

import java.io.Serializable;
import java.util.Date;

public class Partido implements Serializable, Comparable<Partido>{

	public enum Divisiones {PRIMERA, SEGUNDA, TERCERA}
	
	private String eqLocal, eqVisitante, resultado;
	private Divisiones division;
	private Date fecha;
	
	public Partido(String eqLocal,String eqVisitante, 
			String resultado, Divisiones division,Date fecha) {	
	}
	public Partido() {	
	}

	public String getEqLocal() {
		return eqLocal;
	}

	public void setEqLocal(String eqLocal) {
		this.eqLocal = eqLocal;
	}

	public String getEqVisitante() {
		return eqVisitante;
	}

	public void setEqVisitante(String eqVisitante) {
		this.eqVisitante = eqVisitante;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Divisiones getDivision() {
		return division;
	}

	public void setDivision(Divisiones division) {
		this.division = division;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	};
	
	@Override
	public String toString() {
		String rslt;
		rslt=eqLocal+" "+resultado+" "+eqVisitante+
				"/ DIVISION: "+division+"/ "+fecha;
		return rslt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

	@Override
	public int compareTo(Partido p) {
		return this.fecha.compareTo(p.fecha);
	}

}
