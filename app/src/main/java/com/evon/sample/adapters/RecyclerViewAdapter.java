package com.evon.sample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evon.sample.R;
import com.evon.sample.room_database.entity.Model;

import java.util.List;

/**
 * The type Recycler view adapter.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Model> modelList;

    /**
     * Instantiates a new Recycler view adapter.
     *
     * @param modelList the model list
     */
    public RecyclerViewAdapter(List<Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        Model model = modelList.get(position);
        holder.itemTextView.setText(model.getItemName());
        holder.nameTextView.setText(model.getPersonName());
        holder.itemView.setTag(model);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    /**
     * Add items.
     *
     * @param modelList the model list
     */
    public void addItems(List<Model> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    /**
     * The type Recycler view holder.
     */
    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
        private TextView nameTextView;

        /**
         * Instantiates a new Recycler view holder.
         *
         * @param view the view
         */
        RecyclerViewHolder(View view) {
            super(view);
            itemTextView = view.findViewById(R.id.itemTextView);
            nameTextView = view.findViewById(R.id.nameTextView);
        }
    }
}