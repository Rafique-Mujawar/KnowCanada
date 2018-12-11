package media.rafique.com.knowcanada.model.api;

import media.rafique.com.knowcanada.model.constants.APIConstants;
import media.rafique.com.knowcanada.model.response.GetHomeResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * API interace for GET home list
 */
public interface GetHomeListAPI {
  @GET(APIConstants.URL_GET_HOME_LIST)
  Call<GetHomeResponse> getHomeList();
}
