package media.rafique.com.knowcanada.view.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import media.rafique.com.knowcanada.R;
import media.rafique.com.knowcanada.view.base.BaseActivity;
import media.rafique.com.knowcanada.view.fragments.HomeFragment;
import media.rafique.com.knowcanada.view.listenres.OnFragmentInteractionListener;

/*
 * @author Rafique Mujawar
 * Date 19-11-2018
 * Main activity of Application
 *
 * */
public class MainActivity extends BaseActivity implements OnFragmentInteractionListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initToolBar();
    loadFragments();
  }

  /**
   * Method to load fragment of the activity
   */
  private void loadFragments() {
    HomeFragment fragment = HomeFragment.newInstance(null);
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
        .commit();
  }

  /**
   * Method to initialise the toolbar and set the default title
   */
  private void initToolBar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setToolbar(toolbar);
    setScreenTitle(getString(R.string.activity_title));
  }

  /**
   * Method to set Activity title from Fragment
   *
   * @param title Title of the screen
   */
  @Override
  public void setToolbarTitle(String title) {
    setScreenTitle(title);
  }
}
