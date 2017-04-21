package ir.coursio.daggertutorial.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Taher on 21/04/2017.
 * Project: DaggerTutorial
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface DaggerTutorialApplicationScope {
}
