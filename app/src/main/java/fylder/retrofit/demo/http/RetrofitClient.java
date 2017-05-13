package fylder.retrofit.demo.http;

import fylder.retrofit.demo.http.converter.StringConverterFactory;
import fylder.retrofit.demo.http.progress.DownloadInterceptor;
import fylder.retrofit.demo.http.progress.UploadInterceptor;
import fylder.retrofit.demo.http.progress.impl.DownloadListener;
import fylder.retrofit.demo.http.progress.impl.UploadListener;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by 剑指锁妖塔 on 2016/3/31.
 */
public class RetrofitClient {

    private static final String baseUrl = "http://www.fylder.me:8080/photo/";

    /**
     * 获取一个Api Service
     */
    public <T> T getInstance(final Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())   //RxJava回调
                .addConverterFactory(new StringConverterFactory())          //解析String 而且必须放在json解析之上
                .addConverterFactory(JacksonConverterFactory.create())      //Jackson 解析json
                .build();

        return retrofit.create(service);
    }

    /**
     * download
     *
     * @param service
     * @param listener okhttp拦截器
     * @return service
     */
    public <T> T getInstanceDown(final Class<T> service, DownloadListener listener) {

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new DownloadInterceptor(listener))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())   //RxJava回调
                .addConverterFactory(new StringConverterFactory())          //解析String 而且必须放在json解析之上
                .addConverterFactory(JacksonConverterFactory.create())      //Jackson 解析json
                .client(okHttpClient)
                .build();

        return retrofit.create(service);
    }

    /**
     * upload
     *
     * @param service
     * @param listener okhttp拦截器
     * @return service
     */
    public <T> T getInstanceUpload(final Class<T> service, UploadListener listener) {

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new UploadInterceptor(listener))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())   //RxJava回调
                .addConverterFactory(new StringConverterFactory())          //解析String 而且必须放在json解析之上
                .addConverterFactory(JacksonConverterFactory.create())      //Jackson 解析json
                .client(okHttpClient)
                .build();

        return retrofit.create(service);
    }

}
