package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.BoxAdapterClass> {
    List<Integer> list;
    Context context;
    int lastSelectedPosition = -1; // Track the last selected box position
    //    boolean isLastSelectedGreen = false;
    private boolean isSelected = false;
    private ArrayList<Integer> selectedPositions = new ArrayList<>();
    int iii;
    int i;


    public BoxAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BoxAdapterClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new BoxAdapterClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoxAdapterClass holder, @SuppressLint("RecyclerView") int position) {
//        holder.isSelected = (position == lastSelectedPosition);
//        holder.itemView.setSelected(holder.isSelected);
//
//        // Update the background color based on selection state
//        int backgroundColor = holder.isSelected ?
//                holder.itemView.getContext().getResources().getColor(R.color.red) :
//                holder.itemView.getContext().getResources().getColor(R.color.black);
//
//        holder.itemView.setBackgroundColor(backgroundColor);

        // Set the click listener for the item
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Toggle the selection state when the item is clicked
////                if (position != lastSelectedPosition) {
////                    // Deselect the previous item
////                    int previousSelectedPosition = lastSelectedPosition;
////                    lastSelectedPosition = position;
////                    notifyItemChanged(previousSelectedPosition);
////                }
////
////                // Select the current item
////                holder.isSelected = !holder.isSelected;
////                holder.itemView.setSelected(holder.isSelected);
////                notifyItemChanged(position);
//                isSelected = !isSelected;
//                holder.itemView.setSelected(isSelected);
//
//
//                int backgroundColor = isSelected ?
//                        holder.imageview.getContext().getResources().getColor(R.color.red) :
//                        holder.imageview.getContext().getResources().getColor(R.color.black);
//
//                holder.imageview.setBackgroundColor(backgroundColor);
//
//                Log.e("isselcted", "onClick: "+isSelected);
//
//                // You can also perform other actions based on item selection here
//            }
//        });

//        holder.itemView.setSelected(holder.isSelected);

        holder.itemView.setSelected(selectedPositions.contains(position));

        int lastItemPosition = getItemCount() - 1;

         holder.itemView.setOnClickListener(v -> {
            if (selectedPositions.contains(position)) {
                selectedPositions.remove(Integer.valueOf(position));
                Log.e("isselcted", "remove: " + selectedPositions);
                holder.imageview.setImageResource(R.color.black);
            } else {
                selectedPositions.add(position);
                Log.e("isselcted", "add: " + selectedPositions);
                if (position == lastItemPosition){
                    holder.imageview.setImageResource(R.color.red);
                    iii = 1;
                }else {
//                    if (iii == 1){
//                        holder.imageview.setImageResource(R.color.green);
//                    }else {
                        holder.imageview.setImageResource(R.color.blue);
//                    }
                }
            }
//            notifyItemChanged(position);
            Log.e("isselcted", "onClick: " + selectedPositions);

        });
        if (iii == 1){
            holder.imageview.setImageResource(R.color.green);
        }else {
            holder.imageview.setImageResource(R.color.blue);
        }

    }

    public void setSelected(int position) {
        if (position >= 0 && position < list.size()) {
            lastSelectedPosition = position;
            notifyDataSetChanged(); // Refresh the RecyclerView to update colors
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BoxAdapterClass extends RecyclerView.ViewHolder {

        public boolean isSelected = false;
        ImageView imageview;

        public BoxAdapterClass(@NonNull View itemView) {
            super(itemView);

            imageview = itemView.findViewById(R.id.imageview);
        }
    }
}
