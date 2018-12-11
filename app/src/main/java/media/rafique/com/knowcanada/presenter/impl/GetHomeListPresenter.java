package media.rafique.com.knowcanada.presenter.impl;

import android.text.TextUtils;

import java.util.Iterator;

import media.rafique.com.knowcanada.commoms.data.HomeResponseItem;
import media.rafique.com.knowcanada.commoms.error.KCError;
import media.rafique.com.knowcanada.commoms.utils.KCUtils;
import media.rafique.com.knowcanada.model.callback.GetHomeListCallback;
import media.rafique.com.knowcanada.model.response.GetHomeResponse;
import media.rafique.com.knowcanada.model.service.GetHomeListService;
import media.rafique.com.knowcanada.model.serviceImpl.GetHomeListServiceImpl;
import media.rafique.com.knowcanada.presenter.contractors.GetHomeListContractor;


/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * <p>
 * Presente class for Get Home List API.
 */
public class GetHomeListPresenter implements GetHomeListContractor.GetHomeListActionListener,
    GetHomeListCallback {
  /**
   * instance of Presenter view for Get Home List API
   */
  private GetHomeListContractor.GetHomeListView mView;

  /**
   * Instance of Service for Get Home List API
   */
  private GetHomeListService mService;


  public GetHomeListPresenter(GetHomeListContractor.GetHomeListView mView) {
    this.mView = mView;
    this.mService = new GetHomeListServiceImpl();
  }


  /**
   * Use this constructor Only for UNIT TESTING
   *
   * @param mView   Mocked instance of GetHomeListView from Test class
   * @param service Mocked instance of GetHomeListService from Test class
   */
  public GetHomeListPresenter(GetHomeListContractor.GetHomeListView mView,
                              GetHomeListService service) {
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
