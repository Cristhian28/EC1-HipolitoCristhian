package com.hipolito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hipolito.app.model.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Long>{

}
