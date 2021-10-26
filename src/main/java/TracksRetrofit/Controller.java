package TracksRetrofit;

import java.awt.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class Controller {

    static final String BASE_URL = "http://localhost:8080/dsaApp/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TrackAPI trackAPI = retrofit.create(TrackAPI.class);

        //Get All Tracks (Returns 201)
        //2soT1G093
        /*Call<List<Track>> call = trackAPI.loadTracks();
        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                if (response.isSuccessful()) {
                    List<Track> trackList = response.body();
                    for (Track track : trackList) {
                        System.out.println(track.getId());
                        System.out.println(track.getTitle());
                        System.out.println(track.getSinger());
                    }
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        */
        Call<Track> call2 = trackAPI.getTrack("2soT1G093");
        call2.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if (response.isSuccessful()) {
                    Track track = response.body();
                    System.out.println(track.getId());
                    System.out.println(track.getTitle());
                    System.out.println(track.getSinger());
                }
                else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}