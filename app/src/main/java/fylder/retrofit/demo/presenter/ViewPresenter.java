package fylder.retrofit.demo.presenter;

/**
 * Presenter的接口传入
 * Created by 剑指锁妖塔 on 2016/6/20.
 */
public interface ViewPresenter<T> {

    void setViewImpl(T view);

}
