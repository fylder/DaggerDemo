package fylder.retrofit.demo.dagger;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import fylder.retrofit.demo.http.RetrofitClient;

/**
 * Created by 剑指锁妖塔 on 2016/4/7.
 */
@Module
public class AppModule {

    Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    public Application providesApp() {
        return app;
    }

    /**
     * 创建一个Retrofit Service
     */
    @Provides
    public RetrofitClient provideService() {
        return new RetrofitClient();
    }


}
