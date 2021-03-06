package media.rafique.com.knowcanada.commoms.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * holder class for Single item of Canada facts fetched from server
 *
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public class HomeResponseItem implements Parcelable {
  /**
   * title of he fact
   */
  private String title;

  /**
   * Description of the fact
   */
  private String description;

  /**
   * supporting Image url for the facts
   */
  private String imageHref;

  protected HomeResponseItem(Parcel in) {
    title = in.readString();
    description = in.readString();
    imageHref = in.readString();
  }

  public HomeResponseItem() {
  }

  public HomeResponseItem(String title, String description, String imageHref) {
    this.title = title;
    this.description = description;
    this.imageHref = imageHref;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeString(description);
    dest.writeString(imageHref);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<HomeResponseItem> CREATOR = new Creator<HomeResponseItem>() {
    @Override
    public HomeResponseItem createFromParcel(Parcel in) {
      return new HomeResponseItem(in);
    }

    @Override
    public HomeResponseItem[] newArray(int size) {
      return new HomeResponseItem[size];
    }
  };

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageHref() {
    return imageHref;
  }

  public void setImageHref(String imageHref) {
    this.imageHref = imageHref;
  }
}
