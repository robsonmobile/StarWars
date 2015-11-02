package net.paulacr.starwars.network;

import net.paulacr.starwars.models.POJO.people.People;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Paula on 24/10/2015.
 */
public interface StarWarsApi {

    @GET("/people") void performPeopleRequest(Callback<People> callback);
}
