package com.formation.velo.api.compost;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenDataNantesClientCompost {

    @GET("/api/records/1.0/search/?dataset=512042839_composteurs-quartier-nantes-metropole&q=&rows=327&facet=categorie&facet=annee&facet=lieu")
    Call<OpenDataCompostNantes> getRecords();
}