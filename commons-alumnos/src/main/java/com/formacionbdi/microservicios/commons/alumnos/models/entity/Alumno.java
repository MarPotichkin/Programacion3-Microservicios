package com.formacionbdi.microservicios.commons.alumnos.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@Lob
	@JsonIgnore
	private byte [] foto;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	public Integer getFotoHashCode() {
		return (this.foto!=null) ? this.foto.hashCode() : null;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public boolean equals(Object obj) {
		
		//esta instancia es == a object
		if(this == obj) {
			return true;
		}
		
		//evalua si el objeto es del mismo tipo, es decir Alumno
		if(!(obj instanceof Alumno)) {
			return false;
		}
		
		//Casteo del tipo object a Alumno 
		Alumno a = (Alumno) obj;
		
		//evaluo primero que el ID sea distinto a nulo, y lo comparamos con el ID de "a"
		//si todo esto se cumple devuelve True, el mismo obj con el mismo ID
		//pero si alguna de las dos condiciones falla va a seguir buscando en la lista de los ID para ver que coincida y encontrarlo
		return this.id != null && this.id.equals(a.getId());
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	
}