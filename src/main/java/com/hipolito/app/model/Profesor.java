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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProfesor;
	@Column
	private String profesor;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="profesor_curso",
			joinColumns = @JoinColumn(
					name="id_profesor", 
					nullable=false, unique=true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_profesor) references profesor(id_profesor)")
					),
			inverseJoinColumns =  @JoinColumn(
					name="id_curso", 
					nullable=false, unique=true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_curso) references curso(id_curso)")
					)
			)
	private List<Curso> curso=new ArrayList<>();
	
	public long getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(long idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	
	
}
