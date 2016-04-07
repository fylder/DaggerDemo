package fylder.retrofit.demo.dagger;

import javax.inject.Singleton;

import dagger.Component;
import fylder.retrofit.demo.model.RetrofitModel;

/**
 * Created by 剑指锁妖塔 on 2016/4/7.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    RetrofitModel getRetrofitModel();
}
