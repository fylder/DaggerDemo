package fylder.retrofit.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fylder.retrofit.demo.app.App;
import fylder.retrofit.demo.dagger.component.DaggerDemoComponent;
import fylder.retrofit.demo.dagger.module.DemoModule;
import fylder.retrofit.demo.model.DemoModel;
import fylder.retrofit.demo.model.RetrofitModel;
import fylder.retrofit.demo.model.impl.DemoImpl;

public class DemoActivity extends AppCompatActivity implements DemoImpl {

    @Bind(R.id.demo_id)
    TextView pT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);

        DaggerDemoComponent.builder().appComponent(App.getAppComponent()).demoModule(new DemoModule(this)).build().inject(this);
    }

    @Inject
    RetrofitModel r;
    @Inject
    DemoModel demoModel;

    /**
     * retrofitTest
     */
    @OnClick(R.id.demo_btn)
    void test() {
        demoModel.retrofitTest(r);
    }


    @Override
    public void showText(String str) {
        pT.setText(str);
    }
}
