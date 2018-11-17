package media.rafique.com.presenter.contractors;

import java.util.ArrayList;

import media.rafique.com.presenter.base.BaseView;
import media.rafique.com.utilitymodule.data.HomeResponseItem;
import media.rafique.com.utilitymodule.error.KCError;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public interface GetHomeListContractor {

  interface GetHomeListView extends BaseView {
    void onGetHomeListSuccess(String title, ArrayList<HomeResponseItem> list);

    void onGetHomeListError(KCError error);
  }

  interface GetHomeListActionListener {
    void getHomeList();
  }
}
