package com.br.lima.atividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.lima.atividade.model.entity.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
    
}
