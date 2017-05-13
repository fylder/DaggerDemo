package fylder.retrofit.demo.http.server;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Streaming;

/**
 * Created by 剑指锁妖塔 on 2016/3/31.
 */
public interface Api {

    /**
     * beware with large files
     */
    @Streaming
    @GET("")
    Observable<ResponseBody> download();

    @Multipart
    @POST("")
    Observable<String> upload(@PartMap Map<String, RequestBody> params);

    @GET("retrofitTest/querycollect")
    Observable<String> getInfo();

}
