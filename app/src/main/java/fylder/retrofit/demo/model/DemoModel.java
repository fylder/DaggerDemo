package fylder.retrofit.demo.model;

import com.orhanobut.logger.Logger;

import fylder.retrofit.demo.http.server.Api;
import fylder.retrofit.demo.model.impl.DemoImpl;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 剑指锁妖塔 on 2016/4/7.
 */
public class DemoModel {

    DemoImpl viewImpl;

    Subscription subscription;

    public DemoModel(DemoImpl i) {
        this.viewImpl = i;
    }

    public void retrofitTest(RetrofitModel r) {
        r.getInstance(Api.class).getInfo()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        s -> {
                            Logger.i(s);
                            viewImpl.showText(s);
                        },
                        e -> {
                            Logger.e(e.getMessage());
                            viewImpl.showText(e.getMessage());
                        }
                );
    }
}
