package ir.coursio.daggertutorial.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ir.coursio.daggertutorial.scopes.DaggerTutorialApplicationScope;

/**
 * Created by Taher on 21/04/2017.
 * Project: DaggerTutorial
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @DaggerTutorialApplicationScope
    public Context context() {
        return context;
    }
}
