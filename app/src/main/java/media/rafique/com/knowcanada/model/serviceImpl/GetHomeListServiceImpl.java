package media.rafique.com.knowcanada.model.serviceImpl;


import java.io.IOException;

import media.rafique.com.knowcanada.commoms.error.KCError;
import media.rafique.com.knowcanada.model.api.GetHomeListAPI;
import media.rafique.com.knowcanada.model.base.BaseService;
import media.rafique.com.knowcanada.model.callback.GetHomeListCallback;
import media.rafique.com.knowcanada.model.manager.SessionManager;
import media.rafique.com.knowcanada.model.response.GetHomeResponse;
import media.rafique.com.knowcanada.model.service.GetHomeListService;
import retrofit2.Call;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * Service class for Get home list API
 */
public class GetHomeListServiceImpl extends BaseService<GetHomeResponse>
    implements GetHomeListService {
  private GetHomeListCallback mCallback;

  public GetHomeListServiceImpl() {
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
   */
  @Override
  public void executeService() {
    Call<GetHomeResponse> call = null;
    try {
      call = SessionManager.getSessionManager().getRestAdapter().create(GetHomeListAPI.class)
          .getHomeList();
    } catch (IOException e) {
      e.printStackTrace();
    }
    filterCall(call);
  }

  /**
   * Service Method to be called by presenters.
   *
   * @param callback callback interface
   */
  @Override
  public void fetchHomeList(GetHomeListCallback callback) {
    this.mCallback = callback;
    executeService();
  }
}
