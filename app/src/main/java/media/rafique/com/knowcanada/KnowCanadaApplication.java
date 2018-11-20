package media.rafique.com.knowcanada;

import android.app.Application;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public class KnowCanadaApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    /*START:Enable Picasso image catching and indicator */
    Picasso.Builder builder = new Picasso.Builder(this);
    builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
    Picasso built = builder.build();
    built.setIndicatorsEnabled(true);
    Picasso.setSingletonInstance(built);
    /*END: Enable Picasso image catching and indicator */
  }
}
