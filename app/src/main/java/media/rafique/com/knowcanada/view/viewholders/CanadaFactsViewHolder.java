package media.rafique.com.knowcanada.view.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import media.rafique.com.knowcanada.R;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * view holder for facts entry
 */
public class CanadaFactsViewHolder extends RecyclerView.ViewHolder {
  private TextView tvTitle;
  private TextView tvDescription;
  private ImageView ivFact;

  public CanadaFactsViewHolder(View view) {
    super(view);
    this.tvTitle = view.findViewById(R.id.tv_title);
    this.tvDescription = view.findViewById(R.id.tv_description);
    this.ivFact = view.findViewById(R.id.iv_event_photo);

  }

  public TextView getTvTitle() {
    return tvTitle;
  }

  public void setTvTitle(TextView tvTitle) {
    this.tvTitle = tvTitle;
  }

  public TextView getTvDescription() {
    return tvDescription;
  }

  public void setTvDescription(TextView tvDescription) {
    this.tvDescription = tvDescription;
  }

  public ImageView getIvFact() {
    return ivFact;
  }

  public void setIvFact(ImageView ivFact) {
    this.ivFact = ivFact;
  }
}
