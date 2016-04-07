package fylder.retrofit.demo.http.progress.impl;

/**
 * 下载监听
 * Created by 剑指锁妖塔 on 2016/4/4.
 */
public interface DownloadListener {

    /**
     * @param bytesRead     已下载
     * @param contentLength 总大小
     * @param done          下载是否完成
     */
    void update(long bytesRead, long contentLength, boolean done);

}
