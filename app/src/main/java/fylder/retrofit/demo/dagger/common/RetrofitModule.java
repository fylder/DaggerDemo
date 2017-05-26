package fylder.retrofit.demo.dagger.common;

import dagger.Module;
import dagger.Provides;
import fylder.retrofit.demo.http.RetrofitClient;

/**
 * Retrofit模块
 * Created by 剑指锁妖塔 on 2017/5/26.
 */
@Module
public class RetrofitModule {

    @Provides
    RetrofitClient providesClient() {
        return new RetrofitClient();
    }
}
