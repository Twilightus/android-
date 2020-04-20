package com.example.androidcourse1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private List<Content> contentList = new ArrayList<>();
    private Context context;
    private CardOnClick cardOnClick;
    public ContentAdapter(Context context){
        this.context = context;
    }

    public void setData(List<Content> data) {
        contentList.clear();
        contentList.addAll(data);
        notifyDataSetChanged();
    }

    public void setCardOnClick(CardOnClick cardOnClick) {
        this.cardOnClick = cardOnClick;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_content,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        holder.bind(contentList.get(position),position);
    }


    @Override
    public int getItemCount() {
        return contentList.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        CardView cardView;


        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_content_item);
            textView = itemView.findViewById(R.id.text_content_item);
            cardView = itemView.findViewById(R.id.card_main);
        }
        void bind(Content content, final int position){
            imageView.setImageResource(content.getId());
            textView.setText(content.getTitle());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(null != cardOnClick){
                        cardOnClick.onClick(position);
                    }
                }
            });
        }

    }

    interface CardOnClick{
        void onClick(int position);
    }

}
