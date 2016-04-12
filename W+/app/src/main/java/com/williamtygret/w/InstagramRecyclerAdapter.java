package com.williamtygret.w;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by williamtygret on 3/29/16.
 */
public class InstagramRecyclerAdapter extends RecyclerView.Adapter<InstagramRecyclerAdapter.ViewHolder> {

    private ArrayList<InstagramData.InstagramItemData> mData;

    public InstagramRecyclerAdapter(ArrayList<InstagramData.InstagramItemData> data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.instagram_item, parent, false);
        return new ViewHolder(parent.getContext(), v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final InstagramData.InstagramItemData item = mData.get(position);

        String sourceString = "<b>" +"freshprincewilliam: "+ "</b> " + item.getHeadline();


        holder.mHeadline.setText(Html.fromHtml(sourceString));
        holder.mHeadline.setText("freshprincewilliam: "+item.getHeadline());

        String thumbnailUrlString = item.getThumbnailUrl();
        if (thumbnailUrlString != null && !thumbnailUrlString.isEmpty()) {
            Picasso.with(holder.mContext).load(item.getThumbnailUrl()).into(holder.mThumbnail);
        } else {
            holder.mThumbnail.setImageResource(R.drawable.willhead);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Context mContext;
        RelativeLayout mContainer;
        ImageView mThumbnail;
        TextView mHeadline;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            mContext = context;
            mContainer = (RelativeLayout) itemView.findViewById(R.id.instaLayout);
            mThumbnail = (ImageView) itemView.findViewById(R.id.instagramImageView);
            mHeadline = (TextView) itemView.findViewById(R.id.instagramTextView);
        }
    }


}
