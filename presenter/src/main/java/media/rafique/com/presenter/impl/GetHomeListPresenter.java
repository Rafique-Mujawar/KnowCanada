package media.rafique.com.presenter.impl;

import media.rafique.com.model.base.ExecuteInterface;
import media.rafique.com.model.callback.GetHomeListCallback;
import media.rafique.com.model.requests.NoBodyRequest;
import media.rafique.com.model.response.GetHomeResponse;
import media.rafique.com.presenter.contractors.GetHomeListContractor.GetHomeListActionListener;
import media.rafique.com.presenter.contractors.GetHomeListContractor.GetHomeListView;
import media.rafique.com.utilitymodule.error.KCError;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public class GetHomeListPresenter implements GetHomeListActionListener,
    GetHomeListCallback {
  private GetHomeListView mView;
  private ExecuteInterface<NoBodyRequest> mService;

  public GetHomeListPresenter(GetHomeListView mView, ExecuteInterface<NoBodyRequest> mService) {
    this.mView = mView;
    this.mService = mService;
  }

  @Override
  public void getHomeList() {
    mService.executeService(new NoBodyRequest());
  }

  @Override
  public void onGetHomeListSuccess(GetHomeResponse response) {
    mView.onGetHomeListSuccess(response.getTitle(), response.getRows());
  }

  @Override
  public void onError(KCError error) {
    mView.onGetHomeListError(error);
  }

  @Override
  public void onKCFail(KCError error) {
    mView.onGetHomeListError(error);
  }
}