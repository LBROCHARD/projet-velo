package com.formation.velo.service.impl;

import com.formation.velo.api.compost.OpenDataCompostNantes;
import com.formation.velo.api.compost.OpenDataNantesClientCompost;
import com.formation.velo.model.Compost;
import com.formation.velo.repository.CompostRepository;
import com.formation.velo.service.CompostService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class CompostServiceImpl implements CompostService {
    
    private final CompostRepository compostRepository;

    public CompostServiceImpl(CompostRepository repository) {
        this.compostRepository = repository;
    }

    @Override
    public List<Compost> findAll() {
        return compostRepository.findAll();
    }

    @Override
    public Optional<Compost> findById(Integer id) {
        return compostRepository.findById(id);
    }

    @Override
    public Compost save(Compost station) {
        return compostRepository.save(station);
    }

    @Override
    public void deleteById(Integer id) {
        compostRepository.deleteById(id);
    }

    @Override
    public void delete(Compost station) {
        compostRepository.delete(station);
    }

    @Override
    public void getRecord() {
        String urlBase = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(urlBase).addConverterFactory(GsonConverterFactory.create()).build();

        OpenDataNantesClientCompost client = retrofit.create(OpenDataNantesClientCompost.class);
        Call<OpenDataCompostNantes> openDataCompostNantesCall = client.getRecords();

        try {
            OpenDataCompostNantes openDataCompostNantes = openDataCompostNantesCall.execute().body();

            Arrays.stream(openDataCompostNantes.getRecords()).forEach(record -> {
                Optional<Compost> compost = findByRecordId(record.getRecordId());
                if(compost.isPresent()) {
                    compost.get().setLongitude(record.getField().getLocation()[1]);
                    compost.get().setLattitude(record.getField().getLocation()[0]);

                    save(compost.get());
                } else {
                    Compost newCompost = Compost.builder()
                            .recordId(record.getRecordId())
                            .nom(record.getField().getNom())
                            .lieu(record.getField().getLieu())
                            .categorie(record.getField().getCategorie())
                            .adresse(record.getField().getAdresse())
                            .lien(record.getField().getLien())
                            .longitude(record.getField().getLocation()[0])
                            .lattitude(record.getField().getLocation()[1])
                            .build();

                    save(newCompost);
                }
            });
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Compost> findByRecordId(String recordId) {
        return compostRepository.findByRecordId(recordId);
    }
}
