package fylder.retrofit.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fylder.retrofit.demo.app.App;
import fylder.retrofit.demo.dagger.component.DaggerDemoComponent;
import fylder.retrofit.demo.dagger.module.DemoModule;
import fylder.retrofit.demo.presenter.DemoPresenter;
import fylder.retrofit.demo.presenter.impl.DemoViewImpl;

public class DemoActivity extends AppCompatActivity implements DemoViewImpl {

    @BindView(R.id.demo_id)
    protected TextView pT;

    @Inject
    DemoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);

        DaggerDemoComponent.builder()
                .appComponent(App.getAppComponent())
                .demoModule(new DemoModule()).build().inject(this);
        presenter.setViewImpl(this);
    }

    /**
     * retrofitTest
     */
    @OnClick(R.id.demo_btn)
    void test() {
        presenter.test();
    }


}
