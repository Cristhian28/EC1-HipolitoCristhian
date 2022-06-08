package com.hipolito.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="curso")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long idCurso;
	@Column
	private String curso;
	@Column
	private String descrripcion;
	
	@ManyToOne
	@JoinColumn(name="id_malla", nullable=false, unique=true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references mallaCurricular(id_malla)"))
	private MallaCurricular mallaCurricular;
	
	@ManyToMany(mappedBy = "profesor", cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Profesor> profesor=new ArrayList<>();
	
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescrripcion() {
		return descrripcion;
	}
	public void setDescrripcion(String descrripcion) {
		this.descrripcion = descrripcion;
	}
	
	
	
	

}
