package media.rafique.com.knowcanada.model.base;

import media.rafique.com.knowcanada.commoms.error.KCError;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * Base Error Callback class
 */
public interface BaseAPIErrorCallback {
  /**
   * Callback method for Error
   *
   * @param error {@link KCError}
   */
  void onError(KCError error);
}
