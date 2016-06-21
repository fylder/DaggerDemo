package fylder.retrofit.demo.dagger.module;

import dagger.Module;
import dagger.Provides;
import fylder.retrofit.demo.http.RetrofitClient;
import fylder.retrofit.demo.presenter.DemoPresenter;

/**
 * Created by 剑指锁妖塔 on 2016/4/7.
 */
@Module
public class DemoModule {

    public DemoModule() {

    }

    @Provides
    DemoPresenter providesPresenter(RetrofitClient client) {
        return new DemoPresenter(client);
    }

}
