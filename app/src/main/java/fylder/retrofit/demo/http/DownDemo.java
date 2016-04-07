package fylder.retrofit.demo.http;

import android.os.Environment;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fylder.retrofit.demo.http.progress.impl.DownloadListener;
import fylder.retrofit.demo.http.server.Api;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 剑指锁妖塔 on 2016/3/31.
 */
public class DownDemo {

    public static Observable<Boolean> downloadFile(final String path, DownloadListener listener) {

        return RetrofitClient.getInstanceDown(Api.class, listener).download()
                .map(r -> writeResponseBodyToDisk(r, path))
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * IO写入sdcard
     */
    private static boolean writeResponseBodyToDisk(ResponseBody response, String path) {
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "retrofitTest.apk");

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = response.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = response.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    Logger.t("writeResponseBodyToDisk").d("file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();
                return true;
            } catch (IOException e) {
                Logger.t("IOException").d("file download: " + e.getMessage());
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
}

