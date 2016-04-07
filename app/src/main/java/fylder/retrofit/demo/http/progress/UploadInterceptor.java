package fylder.retrofit.demo.http.progress;


import java.io.IOException;

import fylder.retrofit.demo.http.progress.impl.UploadListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 上传拦截器
 * Created by 剑指锁妖塔 on 2016/4/4.
 */
public class UploadInterceptor implements Interceptor {

    private UploadListener progressListener;

    public UploadInterceptor(UploadListener progressListener) {
        this.progressListener = progressListener;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();

        if (originalRequest.body() == null) {
            return chain.proceed(originalRequest);
        }

        Request progressRequest = originalRequest.newBuilder()
                .method(originalRequest.method(), new UploadRequestBody(originalRequest.body(), progressListener))
                .build();

        return chain.proceed(progressRequest);
    }
}