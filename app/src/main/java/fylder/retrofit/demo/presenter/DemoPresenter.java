package fylder.retrofit.demo.presenter;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import fylder.retrofit.demo.http.RetrofitClient;
import fylder.retrofit.demo.http.server.Api;
import fylder.retrofit.demo.presenter.impl.DemoViewImpl;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * demo的业务逻辑
 * Created by 剑指锁妖塔 on 2016/6/20.
 */
public class DemoPresenter implements ViewPresenter<DemoViewImpl> {

    DemoViewImpl viewImpl;

    RetrofitClient client;

    @Inject
    DemoPresenter(RetrofitClient client) {
        this.client = client;
    }

    @Override
    public void setViewImpl(DemoViewImpl view) {
        this.viewImpl = view;
    }

    public void test() {

        client.getInstance(Api.class).getInfo()
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Logger.w(s);
                }, r -> Logger.e(r.getMessage()));

    }

}
