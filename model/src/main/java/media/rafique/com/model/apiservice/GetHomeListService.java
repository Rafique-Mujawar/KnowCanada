package media.rafique.com.model.apiservice;


import java.io.IOException;

import media.rafique.com.model.api.GetHomeListAPI;
import media.rafique.com.model.base.BaseService;
import media.rafique.com.model.callback.GetHomeListCallback;
import media.rafique.com.model.manager.SessionManager;
import media.rafique.com.model.requests.NoBodyRequest;
import media.rafique.com.model.response.GetHomeResponse;
import media.rafique.com.utilitymodule.error.KCError;
import retrofit2.Call;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * Service class for Get home list API
 */
public class GetHomeListService extends BaseService<GetHomeResponse, NoBodyRequest> {
  private GetHomeListCallback mCallback;

  public GetHomeListService(GetHomeListCallback mCallback) {
    this.mCallback = mCallback;
  }

  /**
   * method for valid server response for Get home list API
   *
   * @param echoMeData expected format of data
   */
  @Override
  public void onKCResponse(GetHomeResponse echoMeData) {
    mCallback.onGetHomeListSuccess(echoMeData);
  }

  /**
   * Method for any error occurred
   *
   * @param error {@link KCError}
   */
  @Override
  public void onKCError(KCError error) {
    mCallback.onError(error);
  }

  /**
   * Common method to be called by All presenters.
   *
   * @param noBody Generic request
   */
  @Override
  public void executeService(NoBodyRequest noBody) {
    Call<GetHomeResponse> call = null;
    try {
      call = SessionManager.getSessionManager().getRestAdapter().create(GetHomeListAPI.class)
          .getHomeList();
    } catch (IOException e) {
      e.printStackTrace();
    }
    filterCall(call);
  }
}
