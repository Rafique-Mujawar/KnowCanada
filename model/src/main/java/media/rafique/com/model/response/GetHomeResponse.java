package media.rafique.com.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import media.rafique.com.utilitymodule.data.HomeResponseItem;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public class GetHomeResponse implements Parcelable {
  private String title;
  private ArrayList<HomeResponseItem> rows;

  protected GetHomeResponse(Parcel in) {
    title = in.readString();
    rows = in.createTypedArrayList(HomeResponseItem.CREATOR);
  }

  public GetHomeResponse() {
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeTypedList(rows);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<GetHomeResponse> CREATOR = new Creator<GetHomeResponse>() {
    @Override
    public GetHomeResponse createFromParcel(Parcel in) {
      return new GetHomeResponse(in);
    }

    @Override
    public GetHomeResponse[] newArray(int size) {
      return new GetHomeResponse[size];
    }
  };

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ArrayList<HomeResponseItem> getRows() {
    return rows;
  }

  public void setRows(ArrayList<HomeResponseItem> rows) {
    this.rows = rows;
  }
}
