package media.rafique.com.knowcanada.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import media.rafique.com.knowcanada.R;
import media.rafique.com.knowcanada.commoms.data.HomeResponseItem;
import media.rafique.com.knowcanada.view.viewholders.CanadaFactsViewHolder;

/**
 * @author Rafique Mujawar
 * Date 17-11-2018
 * Adapter class for Home list data
 */
public class HomeListAdapter extends RecyclerView.Adapter<CanadaFactsViewHolder> {
  private ArrayList<HomeResponseItem> items = null;

  /**
   * Method to set new set of data and update the adapter
   *
   * @param items list of new set of items
   */
  public void setItems(ArrayList<HomeResponseItem> items) {
    this.items = items;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public CanadaFactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view =
        LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_canada_facts, viewGroup, false);
    return new CanadaFactsViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CanadaFactsViewHolder holder, int position) {
    HomeResponseItem item = items.get(position);
    if (!TextUtils.isEmpty(item.getDescription())) {
      holder.getTvDescription().setText(item.getDescription());
    } else {
      holder.getTvDescription().setText(R.string.error_title_info_available);
    }
    if (!TextUtils.isEmpty(item.getTitle())) {
      holder.getTvTitle().setText(item.getTitle());
    } else {
      holder.getTvTitle().setText(R.string.error_title_not_available);
    }
    if (!TextUtils.isEmpty(item.getImageHref())) {
      Picasso.get().load(item.getImageHref()).placeholder(R.drawable.ic_launcher_background)
          .into(holder.getIvFact());
    } else {
      holder.getIvFact().setImageResource(R.drawable.ic_launcher_background);
    }
  }

  @Override
  public int getItemCount() {
    return null != items ? items.size() : 0;
  }
}
