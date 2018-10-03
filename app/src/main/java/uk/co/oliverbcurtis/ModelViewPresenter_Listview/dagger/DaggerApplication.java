package uk.co.oliverbcurtis.ModelViewPresenter_Listview.dagger;

import android.app.Application;

//An application class is the entry point for the app (from a cold start), this is referenced in the Android Manifest
public class DaggerApplication extends Application {

    //Here is where the AppComponent is handled from the AppComponent interface class
    AppComponent appComponent;

    @Override
    public void onCreate(){

        super.onCreate();
    /*
    Here we feed the dagger builder the reference point to what it should be instantiating or provided,
    which is found in the AppModule Class.

    'this' is being passed to the constructor found in AppModule Class, so reference can be passed
     */
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        //This is passed as we are injecting into 'this' activity
        appComponent.inject(this);
    }

    /*
Below is a helper method;
We are returning the app component here so that the base activity can get references to the AppComponent
this will allow us to inject anywhere
 */
    public AppComponent getAppComponent(){
        return  appComponent;
    }
}

