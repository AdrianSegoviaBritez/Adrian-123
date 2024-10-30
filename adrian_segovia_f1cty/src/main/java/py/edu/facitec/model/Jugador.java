package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Jugador extends Persona{
  private String nombre;
  private Integer numero;
  
  @JsonBackReference(value = "relacion1")
  @ManyToOne
	private Club club;

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public Club getClub() {
	return club;
}

public void setClub(Club club) {
	this.club = club;
}

@Override
public String toString() {
	return "Jugador [nombre=" + nombre + ", numero=" + numero + ", club=" + club + "]";
}
  
  
  
}
