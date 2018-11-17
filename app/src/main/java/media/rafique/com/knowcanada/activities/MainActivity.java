package media.rafique.com.knowcanada.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import media.rafique.com.knowcanada.R;
import media.rafique.com.knowcanada.base.BaseActivity;
import media.rafique.com.knowcanada.fragments.HomeFragment;
import media.rafique.com.knowcanada.listenres.OnFragmentInteractionListener;

public class MainActivity extends BaseActivity implements OnFragmentInteractionListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initToolBar();
    loadFragments();
  }

  private void loadFragments() {
    HomeFragment fragment = HomeFragment.newInstance(null);
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
        .commit();
  }

  private void initToolBar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setToolbar(toolbar);
    setScreenTitle(getString(R.string.activity_title));
  }

  @Override
  public void setToolbarTitle(String title) {
    setScreenTitle(title);
  }
}
