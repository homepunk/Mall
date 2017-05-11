package homepunk.work.mall.presentation;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by Homepunk on 24.04.2017.
 **/

public class MallApplication extends Application {
    public static MallApplication instance;

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        Timber.plant(new Timber.DebugTree());

        Stetho.initializeWithDefaults(this);
    }
}
