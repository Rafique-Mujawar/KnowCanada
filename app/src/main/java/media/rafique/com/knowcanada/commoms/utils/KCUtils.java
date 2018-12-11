package media.rafique.com.knowcanada.commoms.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import media.rafique.com.knowcanada.R;
import media.rafique.com.knowcanada.commoms.data.HomeResponseItem;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 */
public class KCUtils {

  /**
   * Retrieving network connectivity status.
   *
   * @param context Context.
   * @return status of network connection.
   */
  public static boolean isConnectedToNetwork(Context context) {
    if (context != null) {
      ConnectivityManager cm =
          (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
      if (cm != null) {
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return null != activeNetwork && activeNetwork.isConnected();
      }
    }
    return false;
  }

  /**
   * Method to display alert dialog
   *
   * @param context -  context
   * @param title   - title of dialog
   * @param msg     - message of dialog
   */
  public static void showAlertDialog(Context context, String title, String msg) {
    final AlertDialog.Builder builder;
    builder = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog);
    builder.setTitle(title)
        .setMessage(msg)
        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        })
        .setCancelable(true)
        .show();
  }

  /**
   * Method to check if Home Response item is valid or not.if one of parameter is having non
   * empty value then item is considered as valid else invalid
   *
   * @param item {@link HomeResponseItem}
   * @return true if one of parameter is having non
   * empty value else false
   */
  public static boolean isValidFactItem(HomeResponseItem item) {
    return null != item && (!TextUtils.isEmpty(item.getTitle()) || !TextUtils.isEmpty(item
        .getDescription()) || !TextUtils.isEmpty(item.getImageHref()));
  }
}
