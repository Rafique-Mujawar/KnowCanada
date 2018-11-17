package media.rafique.com.model.base;

import media.rafique.com.utilitymodule.error.KCError;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public interface BaseAPIErrorCallback {
  void onError(KCError error);
}
