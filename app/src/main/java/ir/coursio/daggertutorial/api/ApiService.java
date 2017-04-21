package ir.coursio.daggertutorial.api;

import ir.coursio.daggertutorial.model.Responses.JokeListResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Taher on 2/5/2017.
 * Project: MyApplication
 */


public interface ApiService {

    @GET("jokes")
    Call<JokeListResponse> getJokes();
}