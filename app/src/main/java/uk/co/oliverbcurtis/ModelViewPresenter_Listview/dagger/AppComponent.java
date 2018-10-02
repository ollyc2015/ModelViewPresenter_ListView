package uk.co.oliverbcurtis.ModelViewPresenter_Listview.dagger;

/*
Below is where we specify our app modules, so that Dagger knows where to look for the @Provides annotation

We also need to specify our activities here so Dagger knows where to inject
(if you open BaseActivity, you will see the keyword @Inject at the top. This is where you'll have your objects that
you don't need to initialise.
 */

import javax.inject.Singleton;

import dagger.Component;
import uk.co.oliverbcurtis.ModelViewPresenter_Listview.ui.BaseActivity;

//Component binds our dependancies
@Singleton
@Component(modules = {AppModule.class})

public interface AppComponent{

    void inject(DaggerApplication application);

    void inject(BaseActivity baseActivity);
}