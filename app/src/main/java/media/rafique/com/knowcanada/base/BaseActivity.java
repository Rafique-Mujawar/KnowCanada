package media.rafique.com.knowcanada.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import media.rafique.com.knowcanada.R;
import media.rafique.com.presenter.base.BaseView;
import media.rafique.com.utilitymodule.utils.KCUtils;

/**
 * Base Activity for the Application
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

  protected Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  /**
   * Returns Context
   *
   * @return context
   */
  @Override
  public Context getViewContext() {
    return this;
  }

  public void setScreenTitle(String title) {
    if (null == toolbar) {
      return;
    }
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (null == actionBar) {
      return;
    }
    actionBar.setTitle(TextUtils.isEmpty(title) ? getString(R.string.activity_title) : title);
  }

  public void setToolbar(Toolbar toolbar) {
    this.toolbar = toolbar;
  }

  /**
   * Method to display error when network is not available
   */
  @Override
  public void showNetworkError() {
    if (isFinishing() || isDestroyed()) {
      return;
    }
    String title = getString(R.string.no_network_title);
    String msg = getString(R.string.no_network_msg);
    KCUtils.showAlertDialog(this, title, msg);
  }

  /**
   * Method to check if connected is available
   *
   * @return - true if network is available else false
   */
  @Override
  public boolean isNetworkAvailable() {
    return !isFinishing() && !isDestroyed() && KCUtils.isConnectedToNetwork(this);
  }
}
