package media.rafique.com.model.manager;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public class SessionManager {
  private static final int REQUEST_TIMEOUT = 75;
  private volatile static SessionManager sessionManager = null;
  private static String baseUrl = "https://dl.dropboxusercontent.com/";
  private Retrofit restAdapter;

  private static void createRestAdapter() {
    sessionManager.restAdapter = new Retrofit.Builder().baseUrl(baseUrl).client(getLoggerClient())
        .addConverterFactory(GsonConverterFactory.create()).build();
  }

  /**
   * Method to get instance of session manager
   *
   * @return - instance of sxm session manager
   * @throws IOException - throws IOException if base url is not provided
   */
  public static SessionManager getSessionManager() throws IOException {
    if (sessionManager == null) {
      synchronized (SessionManager.class) {
        if (sessionManager == null) {
          sessionManager = new SessionManager();
          if (TextUtils.isEmpty(baseUrl)) {
            Log.e("IOException",
                "BaseUrl not provided : " + "url not defined");
            throw new IOException("Un defined url");
          }
          createRestAdapter();
        }
      }
    }
    return sessionManager;
  }

  /**
   * Implementation of Https to the framework
   *
   * @return OkHttpClient Returns OkHttpClient object with ssl support.
   */
  private static OkHttpClient getLoggerClient() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.addInterceptor(loggingInterceptor);
    return builder.build();
  }

  public Retrofit getRestAdapter() {
    return restAdapter;
  }
}
