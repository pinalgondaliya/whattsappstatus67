package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo.LanguageModel;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    private LanguageActivity context;
    private String selectedLanguageCode;
    private ArrayList<LanguageModel> languageList;
    private ItemClickListener itemClickListener;

    public LanguageAdapter(LanguageActivity context, String selectedLanguageCode, ArrayList<LanguageModel> languageList, ItemClickListener itemClickListener) {
        this.context = context;
        this.selectedLanguageCode = selectedLanguageCode;
        this.languageList = languageList;
        this.itemClickListener = itemClickListener;
    }



    @Override
    public int getItemCount() {
        return languageList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint({"RecyclerView"}) int position) {
        LanguageModel languageModel = languageList.get(position);

        holder.languageNameTextView.setText(languageModel.getLanguage_name());
        holder.translateNameTextView.setText(languageModel.getTranslate_name());

        if (selectedLanguageCode.equalsIgnoreCase(languageModel.getLanguage_code())) {
            // Selected language
            holder.mainRelativeLayout.setBackground(context.getResources().getDrawable(R.drawable.lan_bg_selected));
            holder.languageNameTextView.setTextColor(context.getResources().getColor(R.color.black));
            holder.translateNameTextView.setTextColor(context.getResources().getColor(R.color.black));
//            holder.checkSelectedImageView.setImageResource(R.drawable.check_language_selected);
        } else {
            // Unselected language
//            holder.mainRelativeLayout.setBackground(context.getResources().getDrawable(R.drawable.lan_bg_unselected));
            holder.languageNameTextView.setTextColor(context.getResources().getColor(R.color.black));
            holder.translateNameTextView.setTextColor(context.getResources().getColor(R.color.black));
            holder.checkSelectedImageView.setImageResource(0);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(languageModel);
                }
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_language, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView languageNameTextView;
        public TextView translateNameTextView;
        public RelativeLayout mainRelativeLayout;
        public ImageView checkSelectedImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            languageNameTextView = itemView.findViewById(R.id.txt_language);
            translateNameTextView = itemView.findViewById(R.id.translate_language);
            mainRelativeLayout = itemView.findViewById(R.id.main_rl);
            checkSelectedImageView = itemView.findViewById(R.id.check_selected);
        }
    }

    public interface ItemClickListener {
        void onItemClick(LanguageModel selectedLanguage);
    }
}
