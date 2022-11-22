package com.formation.velo.service;

import com.formation.velo.model.Compost;
import java.util.List;
import java.util.Optional;

public interface CompostService {
    
    List<Compost> findAll();
    Optional<Compost> findById(Integer id);
    Compost save(Compost compost);

    void deleteById(Integer id);

    void delete(Compost compost);

    void getRecord();

    Optional<Compost> findByRecordId(String recordId);
}
