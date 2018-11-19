package media.rafique.com.model.callback;

import media.rafique.com.model.base.BaseAPIErrorCallback;
import media.rafique.com.model.response.GetHomeResponse;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * callback class for Home list success
 */
public interface GetHomeListCallback extends BaseAPIErrorCallback {
  /**
   * Callback method for home list success
   *
   * @param response {@link GetHomeResponse}
   */
  void onGetHomeListSuccess(GetHomeResponse response);
}
