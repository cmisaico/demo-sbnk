package com.demo.repository;

import com.demo.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoH2Repository extends JpaRepository<Alumno, Long> {
}
