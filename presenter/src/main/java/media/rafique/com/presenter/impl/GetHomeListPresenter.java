package media.rafique.com.presenter.impl;

import android.text.TextUtils;

import java.util.Iterator;

import media.rafique.com.model.callback.GetHomeListCallback;
import media.rafique.com.model.response.GetHomeResponse;
import media.rafique.com.model.service.GetHomeListService;
import media.rafique.com.model.serviceImpl.GetHomeListServiceImpl;
import media.rafique.com.presenter.contractors.GetHomeListContractor.GetHomeListActionListener;
import media.rafique.com.presenter.contractors.GetHomeListContractor.GetHomeListView;
import media.rafique.com.utilitymodule.data.HomeResponseItem;
import media.rafique.com.utilitymodule.error.KCError;
import media.rafique.com.utilitymodule.utils.KCUtils;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * <p>
 * Presente class for Get Home List API.
 */
public class GetHomeListPresenter implements GetHomeListActionListener,
    GetHomeListCallback {
  /**
   * instance of Presenter view for Get Home List API
   */
  private GetHomeListView mView;

  /**
   * Instance of Service for Get Home List API
   */
  private GetHomeListService mService;


  public GetHomeListPresenter(GetHomeListView mView) {
    this.mView = mView;
    this.mService = new GetHomeListServiceImpl();
  }


  /**
   * Use this constructor Only for UNIT TESTING
   *
   * @param mView   Mocked instance of GetHomeListView from Test class
   * @param service Mocked instance of GetHomeListService from Test class
   */
  public GetHomeListPresenter(GetHomeListView mView, GetHomeListService service) {
    this.mView = mView;
    this.mService = service;
  }

  /**
   * entry method to fetch home list data
   */
  @Override
  public void getHomeList() {
    mService.fetchHomeList(this);
  }

  /**
   * Callback method for home list success
   *
   * @param response {@link GetHomeResponse}
   */
  @Override
  public void onGetHomeListSuccess(GetHomeResponse response) {
    //If response is empty
    if (null == response.getRows() || response.getRows().isEmpty()) {
      mView.onEmptyHomeList();
    } else {
      Iterator<HomeResponseItem> iterator = response.getRows().iterator();
      while (iterator.hasNext()) {
        HomeResponseItem item = iterator.next();
        //Check for invalid entry and remove it from list
        if (!KCUtils.isValidFactItem(item)) {
          iterator.remove();
        }
      }
      mView.onGetHomeListSuccess(response.getRows());
    }
    //Check if title is non empty and set accordingly
    if (!TextUtils.isEmpty(response.getTitle())) {
      mView.onHomeGetListTitle(response.getTitle());
    }
  }

  /**
   * Callback method for Error
   *
   * @param error {@link KCError}
   */
  @Override
  public void onError(KCError error) {
    mView.onGetHomeListError(error);
  }
}
