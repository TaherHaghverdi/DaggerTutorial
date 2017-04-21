package ir.coursio.daggertutorial;

import com.squareup.picasso.Picasso;

import dagger.Component;
import ir.coursio.daggertutorial.api.ApiService;
import ir.coursio.daggertutorial.modules.ApiServiceModule;
import ir.coursio.daggertutorial.modules.PicassoModule;
import ir.coursio.daggertutorial.qualifier.ApiServiceQualifier;
import ir.coursio.daggertutorial.scopes.DaggerTutorialApplicationScope;

/**
 * Created by Taher on 21/04/2017.
 * Project: DaggerTutorial
 */

@DaggerTutorialApplicationScope
@Component(modules = {ApiServiceModule.class, PicassoModule.class})
public interface DaggerTutorialApplicationComponent {

    Picasso getPicasso();

    @ApiServiceQualifier
    ApiService getApiService();
}
