package com.formation.velo.repository;

import com.formation.velo.model.Compost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompostRepository extends JpaRepository<Compost, Integer> {
    Optional<Compost> findByRecordId(String recordId);
}
