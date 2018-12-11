package media.rafique.com.knowcanada.presenter.base;

import android.content.Context;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public interface BaseView {

  /**
   * Returns Context
   *
   * @return context
   */
  Context getViewContext();

  /**
   * Method to display error when network is not available
   */
  void showNetworkError();

  /**
   * Method to check if connected is available
   *
   * @return - true if network is available else false
   */
  boolean isNetworkAvailable();
}
