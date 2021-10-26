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
    TrackAPI trackAPI;
    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        trackAPI = retrofit.create(TrackAPI.class);
    }
    public void getAllTracks() {
        //Get All Tracks (Returns 201)
        //2soT1G093
        Call<List<Track>> callgetalltracks = trackAPI.loadTracks();
        callgetalltracks.enqueue(new Callback<List<Track>>() {
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
    }
    public void getSingleTrack(String id){
        //Get a single track
        Call<Track> callsingletrack = trackAPI.getTrack(id);
        callsingletrack.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if (response.isSuccessful()) {
                    Track track = response.body();
                    System.out.println(track.getId());
                    System.out.println(track.getTitle());
                    System.out.println(track.getSinger());
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    //DELETE esborra un element del servidor
    public void deleteTrack(String id){
        //Delete a single track
        Call<Track> calldelete = trackAPI.deleteTrack(id);
        calldelete.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if (response.isSuccessful()) {
                    Track track = response.body();
                    System.out.println(track.getId());
                    System.out.println(track.getTitle());
                    System.out.println(track.getSinger());
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    //POST permet afegir un element nou al servidor
    public void postNewTrack(String id, String singer, String title){
        Track trackpost = new Track();
        trackpost.setId(id);
        trackpost.setSinger(singer);
        trackpost.setTitle(title);
        Call<Track> callpost = trackAPI.postTrack(trackpost);
        callpost.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if (response.isSuccessful()) {
                    Track track = response.body();
                    System.out.println(track.getId());
                    System.out.println(track.getTitle());
                    System.out.println(track.getSinger());
                } else {
                    System.out.println(response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<Track> call, Throwable t) {
            }
        });
    }
    //PUT permet editar un element ja existent al servidor
    public void putNewTrack(String id, String singer, String title) {
        Track trackput = new Track();
        trackput.setId(id);
        trackput.setSinger(singer);
        trackput.setTitle(title);
        Call<Track> callput = trackAPI.updateTrack(trackput);
        callput.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if (response.isSuccessful()) {
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {

            }
        });
    }
}