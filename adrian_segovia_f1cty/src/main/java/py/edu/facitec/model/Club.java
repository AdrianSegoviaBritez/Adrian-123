package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer clave;
   private String nombre;
   
  //Cuando la lista es mas importante visualizar
   @JsonManagedReference(value = "relacion1")
@OneToMany(mappedBy = "club")
private List<Jugador> jugador;

public Integer getClave() {
	return clave;
}

public void setClave(Integer clave) {
	this.clave = clave;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public List<Jugador> getJugador() {
	return jugador;
}

public void setJugador(List<Jugador> jugador) {
	this.jugador = jugador;
}

@Override
public String toString() {
	return "Club [clave=" + clave + ", nombre=" + nombre + ", jugador=" + jugador + "]";
}
   
   
   
}
