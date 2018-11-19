package media.rafique.com.presenter.contractors;

import java.util.ArrayList;

import media.rafique.com.presenter.base.BaseView;
import media.rafique.com.utilitymodule.data.HomeResponseItem;
import media.rafique.com.utilitymodule.error.KCError;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * Contrcot for get Home List API
 */
public interface GetHomeListContractor {

  /**
   * Presenter View for get Home List API
   */
  interface GetHomeListView extends BaseView {
    /**
     * Callback method for Successfully fetching home list data
     *
     * @param list list of canadian facts
     */
    void onGetHomeListSuccess(ArrayList<HomeResponseItem> list);

    /**
     * Callback method for Successfully fetching home list title
     *
     * @param title title of the data
     */

    void onHomeGetListTitle(String title);

    /**
     * Callback method for empty list
     */
    void onEmptyHomeList();

    /**
     * Callback method for error occurred while fetching home data
     *
     * @param error {@link KCError}
     */
    void onGetHomeListError(KCError error);
  }

  /**
   * Action Listener interface for home list data
   */
  interface GetHomeListActionListener {
    /**
     * entry method to fetch home list data
     */
    void getHomeList();
  }
}
