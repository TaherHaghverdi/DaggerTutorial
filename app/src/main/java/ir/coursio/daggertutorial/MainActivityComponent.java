package ir.coursio.daggertutorial;


import dagger.Component;
import ir.coursio.daggertutorial.modules.MainActivityModule;
import ir.coursio.daggertutorial.scopes.MainActivityScope;

/**
 * Created by Taher on 22/04/2017.
 * Project: DaggerTutorial
 */

@Component(modules = MainActivityModule.class, dependencies = DaggerTutorialApplicationComponent.class)
@MainActivityScope
public interface MainActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}
