package fylder.retrofit.demo.http.progress.impl;

/**
 * 上传监听
 * Created by 剑指锁妖塔 on 2016/4/4.
 */
public interface UploadListener {

    /**
     * @param bytesWritten  上传的字节
     * @param contentLength 总字节
     */
    void onRequestProgress(long bytesWritten, long contentLength);

}
