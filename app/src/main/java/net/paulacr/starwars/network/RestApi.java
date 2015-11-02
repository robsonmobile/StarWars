package net.paulacr.starwars.network;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.paulacr.starwars.models.POJO.people.People;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Paula on 24/10/2015.
 */
public class RestApi {

    private RestAdapter restAdapter;
    private StarWarsApi api;
    private static final String ENDPOINT = "http://swapi.co/api/";

    Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new ItemTypeAdapterFactory()) // This is the important line ;)
            .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
            .create();

    public RestApi() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();
    }

    private void createApi() {
        api = restAdapter.create(StarWarsApi.class);
    }

    public void requestForPeople(Callback callback) {
        createApi();
        api.performPeopleRequest(callback);
    }


}
