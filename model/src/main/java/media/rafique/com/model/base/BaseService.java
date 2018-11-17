package media.rafique.com.model.base;

import android.support.annotation.NonNull;

import com.google.gson.JsonSyntaxException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import media.rafique.com.utilitymodule.constants.KnowCanadaConstants;
import media.rafique.com.utilitymodule.error.KCError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * Base Service to filter the response and error code and provide appropriate
 */
public abstract class BaseService<RESPONSE, REQUEST> implements ExecuteInterface<REQUEST> {
  public final String TAG = this.getClass().getSimpleName();

  protected void filterCall(Call<RESPONSE> call) {
    call.enqueue(new Callback<RESPONSE>() {
      @Override
      public void onResponse(@NonNull Call<RESPONSE> call,
                             @NonNull Response<RESPONSE> response) {
        onKCResponse(response.body());
      }

      @Override
      public void onFailure(@NonNull Call<RESPONSE> call, @NonNull Throwable t) {
        if (t instanceof SocketTimeoutException) {
          onKCError(new KCError(KnowCanadaConstants.ERROR_TIME_OUT, t.getMessage()));
        } else if (t instanceof UnknownHostException) {
          onKCError(new KCError(KnowCanadaConstants.ERROR_NETWORK, t.getMessage()));
        } else if (t instanceof JsonSyntaxException) {
          onKCError(new KCError(KnowCanadaConstants.ERROR_JSON_SYNTAX, t.getMessage()));
        } else {
          onKCError(new KCError(KnowCanadaConstants.ERROR_OTHER, t.getMessage()));
        }
      }
    });
  }

  public abstract void onKCResponse(RESPONSE echoMeData);

  public abstract void onKCError(KCError error);
}