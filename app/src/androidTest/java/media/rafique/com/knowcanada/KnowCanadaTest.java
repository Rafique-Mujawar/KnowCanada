package media.rafique.com.knowcanada;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import media.rafique.com.knowcanada.view.activities.MainActivity;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * @author Rafique Mujawar
 * Date 19-11-2018
 */
@RunWith(JUnit4.class)
public class KnowCanadaTest {

  private MainActivity mMainActivity;
  @Rule
  public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity
      .class);

  /**
   * Method to setting up variables to used while running test cases
   */
  @Before
  public void setUp() {
    mMainActivity = activityTestRule.getActivity();
    assertNotNull("Activity exist", mMainActivity);
  }

  /**
   * Test case for when data is network is available and data is loaded
   */
  @Test
  public void testAdapterAvailability() {
    RecyclerView recyclerView = mMainActivity.findViewById(R.id.rv_home_list);
    assertNotNull(recyclerView);
    ViewMatchers.assertThat(recyclerView.getAdapter(), CoreMatchers.instanceOf(RecyclerView
        .Adapter.class));
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ViewMatchers.assertThat(recyclerView.getAdapter().getItemCount(), Matchers.greaterThan(0));
  }

  /**
   * Test case for when data is network is available and data is loaded
   */
  @Test
  public void testEmptyMessageVisibility() {
    TextView textView = mMainActivity.findViewById(R.id.tv_empty_list);
    assertNotNull(textView);
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ViewMatchers.assertThat(textView.getVisibility(), Matchers.equalTo(View.GONE));
  }

  /**
   * Test case for when data is network is available and data is loaded
   */
  @Test
  public void testTitleText() {
    ActionBar actionBar = mMainActivity.getSupportActionBar();
    assertNotNull(actionBar);
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertNotNull(actionBar.getTitle());
    assertTrue(!actionBar.getTitle().toString().isEmpty());
  }

  @After
  public void tearDown() {
    mMainActivity = null;
  }
}
