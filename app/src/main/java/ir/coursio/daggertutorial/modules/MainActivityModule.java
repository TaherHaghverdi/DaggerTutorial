package ir.coursio.daggertutorial.modules;


import dagger.Module;
import dagger.Provides;
import ir.coursio.daggertutorial.MainActivity;
import ir.coursio.daggertutorial.scopes.MainActivityScope;

/**
 * Created by Taher on 22/04/2017.
 * Project: DaggerTutorial
 */

@Module
public class MainActivityModule {
    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public MainActivity mainActivity(){
        return mainActivity;
    }

}
