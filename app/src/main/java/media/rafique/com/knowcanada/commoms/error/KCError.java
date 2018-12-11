package media.rafique.com.knowcanada.commoms.error;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * <p>
 * This class provides the code and details of the error or failure occured during the call
 */
public class KCError implements Parcelable {
  /**
   * Error Message
   */
  private String message;

  /**
   * Error code
   */
  private String code;

  public KCError(String message, String code) {
    this.message = message;
    this.code = code;
  }

  protected KCError(Parcel in) {
    message = in.readString();
    code = in.readString();
  }

  public static final Creator<KCError> CREATOR = new Creator<KCError>() {
    @Override
    public KCError createFromParcel(Parcel in) {
      return new KCError(in);
    }

    @Override
    public KCError[] newArray(int size) {
      return new KCError[size];
    }
  };

  public KCError() {
  }

  /**
   * Describe the kinds of special objects contained in this Parcelable
   * instance's marshaled representation. For example, if the object will
   * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
   * the return value of this method must include the
   * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
   *
   * @return a bitmask indicating the set of special object types marshaled
   * by this Parcelable object instance.
   */
  @Override
  public int describeContents() {
    return 0;
  }

  /**
   * Flatten this object in to a Parcel.
   *
   * @param dest  The Parcel in which the object should be written.
   * @param flags Additional flags about how the object should be written.
   *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
   */
  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(message);
    dest.writeString(code);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
