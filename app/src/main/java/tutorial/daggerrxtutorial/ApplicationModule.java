package tutorial.daggerrxtutorial;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tutorial.daggerrxtutorial.utilities.AnalyticsManager;
import tutorial.daggerrxtutorial.utilities.Validator;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class ApplicationModule {

    private Application application;
    private Context mContext;

    public ApplicationModule(Application application, Context context) {
        this.application = application;
        this.mContext = context;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    AnalyticsManager provideAnalyticsManager() {
        return new AnalyticsManager(application);
    }

    @Provides
    @Singleton
    Validator provideValidator() {
        return new Validator();
    }

    @Provides
    @Singleton
    HeavyExternalLibrary provideHeavyExternalLibrary() {
        HeavyExternalLibrary heavyExternalLibrary = new HeavyExternalLibrary();
        heavyExternalLibrary.init();
        return heavyExternalLibrary;
    }

    @Provides
    @Singleton
    HeavyLibraryWrapper provideLibraryWrapper() {
        return new HeavyLibraryWrapper();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

}
