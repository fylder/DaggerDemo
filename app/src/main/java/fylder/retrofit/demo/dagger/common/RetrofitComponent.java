package fylder.retrofit.demo.dagger.common;

import dagger.Component;
import fylder.retrofit.demo.dagger.ActivityScope;
import fylder.retrofit.demo.dagger.AppComponent;

/**
 * Retrofit Service
 * Created by 剑指锁妖塔 on 2017/5/26.
 */
@ActivityScope
@Component(modules = RetrofitModule.class, dependencies = AppComponent.class)
public interface RetrofitComponent {

}
