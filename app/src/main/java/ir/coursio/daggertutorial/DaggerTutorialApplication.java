package ir.coursio.daggertutorial;

import android.app.Activity;
import android.app.Application;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;


import java.io.File;

import ir.coursio.daggertutorial.api.ApiService;
import ir.coursio.daggertutorial.modules.ApiServiceModule;
import ir.coursio.daggertutorial.modules.ContextModule;
import ir.coursio.daggertutorial.modules.NetworkModule;
import ir.coursio.daggertutorial.modules.PicassoModule;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Taher on 21/04/2017.
 * Project: DaggerTutorial
 */

public class DaggerTutorialApplication extends Application {
    DaggerTutorialApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        component = DaggerDaggerTutorialApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();


    }

    public DaggerTutorialApplicationComponent component() {
        return component;
    }

    public static DaggerTutorialApplication get(Activity activity) {
        return (DaggerTutorialApplication) activity.getApplication();
    }
}
