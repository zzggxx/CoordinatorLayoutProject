package com.example.splash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Integer> mArrayList;
    private final LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, ArrayList<Integer> arrayList) {
        mContext = context;
        mArrayList = arrayList;

        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer integer = mArrayList.get(position);

        holder.mItem.setText(String.valueOf(integer));
    }

    @Override
    public int getItemCount() {
        return mArrayList == null ? 0 : mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mItem;

        public ViewHolder(View itemView) {
            super(itemView);

            mItem = (TextView) itemView.findViewById(R.id.item);
        }
    }
}
