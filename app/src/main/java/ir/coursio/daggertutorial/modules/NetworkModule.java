package ir.coursio.daggertutorial.modules;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import ir.coursio.daggertutorial.scopes.DaggerTutorialApplicationScope;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Taher on 21/04/2017.
 * Project: DaggerTutorial
 */

@Module(includes = ContextModule.class)
public class NetworkModule {
    @Provides
    @DaggerTutorialApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @DaggerTutorialApplicationScope
    public HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
    }

    @Provides
    @DaggerTutorialApplicationScope
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 5 * 1000 * 1000); //5MB cache;
    }

    @Provides
    @DaggerTutorialApplicationScope
    public File file(Context context) {
        File cacheFile = new File(context.getCacheDir(), "okhttp_cache");
        cacheFile.mkdirs();
        return cacheFile;
    }

}
