package TracksRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TrackAPI {

    @GET("tracks")
    Call<List<Track>> loadTracks();

    @GET("tracks/{id}")
    Call<Track> getTrack(@Path("id") String id);
}
