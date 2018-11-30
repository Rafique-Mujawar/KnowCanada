package media.rafique.com.model.service;

import media.rafique.com.model.callback.GetHomeListCallback;

/**
 * @author Rafique Mujawar
 * Date 30-11-2018
 */
public interface GetHomeListService {
  /**
   * Service Method to be called by presenter.
   *
   * @param callback callback interface
   */
  void fetchHomeList(GetHomeListCallback callback);
}
