package TracksRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface TrackAPI {

    @GET("tracks")
    Call<List<Track>> loadTracks();

    //@PUT("/")
}
