package com.hipolito.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mallaCurricular")
public class MallaCurricular implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMalla;
	@Column
	private long anio;
	
	@OneToMany(mappedBy = "mallaCurricular")
	private List<Curso> curso =new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="id_universidad",nullable=false, unique =true,
	foreignKey=@ForeignKey(foreignKeyDefinition = "foreign Key(id_universidad) references universidad(id_universidad)"))
	private Universidad universidad;
	
	public long getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(long idMalla) {
		this.idMalla = idMalla;
	}
	public long getAnio() {
		return anio;
	}
	public void setAnio(long anio) {
		this.anio = anio;
	}


	
}
