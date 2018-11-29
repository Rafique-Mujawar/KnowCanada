package media.rafique.com.knowcanada.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import media.rafique.com.knowcanada.R;
import media.rafique.com.presenter.base.BaseView;
import media.rafique.com.utilitymodule.utils.KCUtils;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public abstract class BaseFragment extends Fragment implements BaseView {
  /**
   * Returns Context
   *
   * @return context
   */
  @Override
  public Context getViewContext() {
    if (!isAdded()) {
      return null;
    }
    return getContext();
  }

  /**
   * Method to display error when network is not available
   */
  @Override
  public void showNetworkError() {
    if (!isAdded()) {
      return;
    }
    String title = getString(R.string.no_network_title);
    String msg = getString(R.string.no_network_msg);
    KCUtils.showAlertDialog(getViewContext(), title, msg);
  }

  /**
   * Method to check if connected is available
   *
   * @return - true if network is available else false
   */
  @Override
  public boolean isNetworkAvailable() {
    return null != getViewContext() && isAdded() && KCUtils.isConnectedToNetwork(getViewContext());
  }
}
