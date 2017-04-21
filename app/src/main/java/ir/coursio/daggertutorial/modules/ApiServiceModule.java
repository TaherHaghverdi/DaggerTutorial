package ir.coursio.daggertutorial.modules;

import dagger.Module;
import dagger.Provides;
import ir.coursio.daggertutorial.api.ApiService;
import ir.coursio.daggertutorial.qualifier.ApiServiceQualifier;
import ir.coursio.daggertutorial.qualifier.RetrofitQualifier;
import ir.coursio.daggertutorial.scopes.DaggerTutorialApplicationScope;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Taher on 21/04/2017.
 * Project: DaggerTutorial
 */

@Module(includes = NetworkModule.class)
public class ApiServiceModule {
    private static final String BASE_URL = "http://api.icndb.com/";

    @Provides
    @ApiServiceQualifier
    @DaggerTutorialApplicationScope
    public ApiService apiService(@RetrofitQualifier Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @RetrofitQualifier
    @DaggerTutorialApplicationScope
    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    @Provides
    @DaggerTutorialApplicationScope
    public ApiService anotherApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @DaggerTutorialApplicationScope
    public Retrofit anotherRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}
