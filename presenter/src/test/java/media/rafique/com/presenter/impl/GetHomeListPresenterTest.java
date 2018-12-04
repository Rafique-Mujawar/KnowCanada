package media.rafique.com.presenter.impl;

import android.text.TextUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import media.rafique.com.model.callback.GetHomeListCallback;
import media.rafique.com.model.response.GetHomeResponse;
import media.rafique.com.model.service.GetHomeListService;
import media.rafique.com.presenter.contractors.GetHomeListContractor;
import media.rafique.com.utilitymodule.data.HomeResponseItem;
import media.rafique.com.utilitymodule.error.KCError;

import static org.mockito.Matchers.any;

/**
 * @author Rafique Mujawar
 * Test class for GetHomeListPresenter
 * Date 29-11-2018
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(TextUtils.class)
public class GetHomeListPresenterTest {

  @Mock
  private GetHomeListService mService;

  @Mock
  private GetHomeListContractor.GetHomeListView mView;

  /**
   * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
   * perform further actions or assertions on them.
   */
  @Captor
  private ArgumentCaptor<GetHomeListCallback> mCallback;

  private GetHomeListPresenter mPresenter;

  @Before
  public void setup() {
    /*
     * We need to mock TextUtil.java as TextUtils is not part of java but Android
     */
    PowerMockito.mockStatic(TextUtils.class);
    PowerMockito.when(TextUtils.isEmpty(any(CharSequence.class))).thenAnswer(new Answer<Boolean>() {
      @Override
      public Boolean answer(InvocationOnMock invocation) {
        CharSequence a = (CharSequence) invocation.getArguments()[0];
        return !(a != null && a.length() > 0);
      }
    });

    MockitoAnnotations.initMocks(this);

    // Create Presenter Instance
    mPresenter = new GetHomeListPresenter(mView, mService);
  }

  /**
   * Test case to handle on success with empty data
   */
  @Test
  public void testGetHomeListSuccessWithEmptyRows() {
    GetHomeResponse response = new GetHomeResponse();
    response.setRows(new ArrayList<HomeResponseItem>());
    mPresenter.getHomeList();
    Mockito.verify(mService).fetchHomeList(mCallback.capture());
    mCallback.getValue().onGetHomeListSuccess(response);
    Mockito.verify(mView).onEmptyHomeList();
  }

  /**
   * Test case to handle on success with null data
   */
  @Test
  public void testGetHomeListSuccessWithNoRows() {
    GetHomeResponse response = new GetHomeResponse();
    mPresenter.getHomeList();
    Mockito.verify(mService).fetchHomeList(mCallback.capture());
    mCallback.getValue().onGetHomeListSuccess(response);
    Mockito.verify(mView).onEmptyHomeList();
  }

  /**
   * Test case to handle on success with valid title
   */
  @Test
  public void testGetHomeListSuccessWithValidTitle() {
    GetHomeResponse response = new GetHomeResponse();
    String title = "Test Title";
    response.setTitle(title);
    mPresenter.getHomeList();
    Mockito.verify(mService).fetchHomeList(mCallback.capture());
    mCallback.getValue().onGetHomeListSuccess(response);
    Mockito.verify(mView).onHomeGetListTitle(title);
  }

  /**
   * Test case to handle on success with empty data but valid title
   */
  @Test
  public void testGetHomeListSuccessWithEmptyDataAndValidTitle() {
    GetHomeResponse response = new GetHomeResponse();
    String title = "Test Title";
    response.setTitle(title);
    mPresenter.getHomeList();
    Mockito.verify(mService).fetchHomeList(mCallback.capture());
    mCallback.getValue().onGetHomeListSuccess(response);
    Mockito.verify(mView).onEmptyHomeList();
    Mockito.verify(mView).onHomeGetListTitle(title);
  }

  /**
   * Test case to handle on success with valid rows and valid title
   */
  @Test
  public void testGetHomeListSuccessWithDataAndTitle() {
    GetHomeResponse response = new GetHomeResponse();
    ArrayList<HomeResponseItem> rows = new ArrayList<>();
    rows.add(new HomeResponseItem("t1", "desc1", "href"));
    rows.add(new HomeResponseItem("t2", null, "href2"));
    rows.add(new HomeResponseItem(null, "desc3", "href3"));
    rows.add(new HomeResponseItem("t4", "desc4", null));
    String title = "Title";
    response.setTitle(title);
    response.setRows(rows);
    mPresenter.getHomeList();
    Mockito.verify(mService).fetchHomeList(mCallback.capture());
    mCallback.getValue().onGetHomeListSuccess(response);
    Mockito.verify(mView).onGetHomeListSuccess(response.getRows());
    Mockito.verify(mView).onHomeGetListTitle(title);
  }

  /**
   * Test case to handle on failure
   */
  @Test
  public void testGetHomeListError() {
    mPresenter.getHomeList();
    KCError error = new KCError();
    Mockito.verify(mService).fetchHomeList(mCallback.capture());
    mCallback.getValue().onError(error);
    Mockito.verify(mView).onGetHomeListError(error);
  }


  @After
  public void tearDown() {
    mPresenter = null;
  }
}
