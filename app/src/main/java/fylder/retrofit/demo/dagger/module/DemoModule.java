package fylder.retrofit.demo.dagger.module;

import dagger.Module;
import dagger.Provides;
import fylder.retrofit.demo.model.DemoModel;
import fylder.retrofit.demo.model.impl.DemoImpl;

/**
 * Created by 剑指锁妖塔 on 2016/4/7.
 */
@Module
public class DemoModule {

    DemoImpl i;

    public DemoModule(DemoImpl i) {
        this.i = i;
    }


    @Provides
    DemoModel providesModel() {
        return new DemoModel(i);
    }

}
