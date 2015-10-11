package es.shyri.materialtoolbar.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.shyri.materialtoolbar.sample.R;
import es.shyri.materialtoolbar.sample.model.CelestialBody;

/**
 * Created by Shyri on 28/09/2015.
 */
public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.ViewHolder> {
    private ArrayList<CelestialBody> mDataset;
    OnCityClickListener onCityClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView icon;
        public View rowRoot;
        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            icon = (ImageView) v.findViewById(R.id.icon);
            rowRoot = v.findViewById(R.id.rowRoot);
        }
    }

    public void add(int position, CelestialBody item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(CelestialBody item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PlanetsAdapter(ArrayList<CelestialBody> myDataset, OnCityClickListener onCityClickListener) {
        mDataset = myDataset;
        this.onCityClickListener = onCityClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlanetsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final CelestialBody celestialBody = mDataset.get(position);
        holder.txtHeader.setText(celestialBody.getName());
        holder.txtFooter.setText(celestialBody.getDescription());
        holder.icon.setImageResource(celestialBody.getImageResourceId());
        holder.rowRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCityClickListener.onClick(v, position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnCityClickListener{
        public void onClick(View v, int position);
    }


    public CelestialBody getItem(int position) {
        return mDataset.get(position);
    }
}
