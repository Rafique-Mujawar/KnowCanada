package media.rafique.com.model.callback;

import media.rafique.com.model.base.BaseAPIErrorCallback;
import media.rafique.com.model.response.GetHomeResponse;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public interface GetHomeListCallback extends BaseAPIErrorCallback {
  void onGetHomeListSuccess(GetHomeResponse response);
}