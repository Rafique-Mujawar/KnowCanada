package media.rafique.com.knowcanada.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import media.rafique.com.knowcanada.R;
import media.rafique.com.knowcanada.viewholders.CanadaFactsViewHolder;
import media.rafique.com.utilitymodule.data.HomeResponseItem;

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
    holder.getTvDescription().setText(item.getDescription());
    holder.getTvTitle().setText(item.getTitle());
    Picasso.get().load(item.getImageHref()).placeholder(R.drawable.ic_launcher_background)
        .into(holder.getIvFact());
  }

  @Override
  public int getItemCount() {
    return null != items ? items.size() : 0;
  }
}
