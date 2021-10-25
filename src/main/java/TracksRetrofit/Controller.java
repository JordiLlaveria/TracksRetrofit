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

public class Controller implements Callback<List<Track>> {

    static final String BASE_URL = "http://localhost:8080/dsaAPP/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TrackAPI trackAPI = retrofit.create(TrackAPI.class);

        //Get All Tracks
        Call<List<Track>> call = trackAPI.loadTracks();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
        if(response.isSuccessful()) {
            List<Track> trackList = response.body();
            for (Track track: trackList) {
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
}