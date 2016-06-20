package fylder.retrofit.demo.app;

import android.app.Application;

import com.orhanobut.logger.Logger;

import fylder.retrofit.demo.dagger.AppComponent;
import fylder.retrofit.demo.dagger.AppModule;
import fylder.retrofit.demo.dagger.DaggerAppComponent;

/**
 * Created by 剑指锁妖塔 on 2016/3/31.
 */
public class App extends Application {

    static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("log_show");

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
