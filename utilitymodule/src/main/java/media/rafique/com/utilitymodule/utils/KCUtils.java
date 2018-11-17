package media.rafique.com.utilitymodule.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import media.rafique.com.utilitymodule.R;
import media.rafique.com.utilitymodule.constants.KnowCanadaConstants;

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
  public static int getNetworkStatus(Context context) {
    if (context != null) {
      ConnectivityManager cm =
          (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
      if (cm != null) {
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
          if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
            return ConnectivityManager.TYPE_WIFI;
          }

          if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
            return ConnectivityManager.TYPE_MOBILE;
          }
        }
      }
    }
    return KnowCanadaConstants.NOT_CONNECTION_STATUS;
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

}
