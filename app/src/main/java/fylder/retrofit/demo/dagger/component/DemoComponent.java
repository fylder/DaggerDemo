package fylder.retrofit.demo.dagger.component;

import dagger.Component;
import fylder.retrofit.demo.dagger.ActivityScope;
import fylder.retrofit.demo.DemoActivity;
import fylder.retrofit.demo.dagger.AppComponent;
import fylder.retrofit.demo.dagger.common.RetrofitModule;
import fylder.retrofit.demo.dagger.module.DemoModule;

/**
 * Created by 剑指锁妖塔 on 2016/4/7.
 */
@ActivityScope
@Component(modules = {DemoModule.class, RetrofitModule.class}, dependencies = AppComponent.class)
public interface DemoComponent {

    DemoActivity inject(DemoActivity activity);

}
