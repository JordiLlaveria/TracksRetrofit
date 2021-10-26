package TracksRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

public interface TrackAPI {

    @GET("tracks")
    Call<List<Track>> loadTracks();

    @GET("tracks/{id}")
    Call<Track> getTrack(@Path("id") String id);

    //DELETE esborra un element del servidor
    @DELETE("tracks/{id}")
    Call<Track> deleteTrack(@Path("id") String id);

    //POST permet afegir un element nou al servidor
    @POST("tracks")
    Call<Track> postTrack(@Body Track track);

    //PUT permet editar un element ja existent al servidor
    @PUT("tracks")
    Call<Track> updateTrack(@Body Track track);
}
