package ir.coursio.daggertutorial.modules;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import ir.coursio.daggertutorial.scopes.DaggerTutorialApplicationScope;
import okhttp3.OkHttpClient;

/**
 * Created by Taher on 21/04/2017.
 * Project: DaggerTutorial
 */

@Module(includes = {ContextModule.class, NetworkModule.class})
public class PicassoModule {

    @Provides
    @DaggerTutorialApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader downloader) {
        return new Picasso.Builder(context)
                .downloader(downloader)
                .build();
    }

    @Provides
    @DaggerTutorialApplicationScope
    public OkHttp3Downloader downloader(OkHttpClient client) {
        return new OkHttp3Downloader(client);
    }

}
