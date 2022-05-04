package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.entities.PadreFamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadreFamiliaRepository extends JpaRepository<PadreFamilia, Integer> {
}
