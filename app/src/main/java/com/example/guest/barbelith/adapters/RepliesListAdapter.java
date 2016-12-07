package com.example.guest.barbelith.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Post;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/6/16.
 */
public class RepliesListAdapter extends RecyclerView.Adapter<RepliesListAdapter.RepliesViewHolder>{
    private ArrayList<Post> mReplies = new ArrayList<>();
    private Context mContext;
    private int mFlipper = 0;
    private int alphaColor;
    private int betaColor;
    private int mainColor;

    public RepliesListAdapter(Context context, ArrayList<Post> replies, int _alphaColor, int _betaColor, int _mainColor) {
        mContext = context;
        mReplies = replies;
        alphaColor = _alphaColor;
        betaColor = _betaColor;
        mainColor = _mainColor;
    }

    @Override
    public RepliesListAdapter.RepliesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reply_list_item, parent, false);
        RepliesViewHolder viewHolder = new RepliesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepliesListAdapter.RepliesViewHolder holder, int position) {
        holder.bindReplies(mReplies.get(position));
    }

    @Override
    public int getItemCount() {
        return mReplies.size();
    }

    public class RepliesViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.textView_Content) TextView mTextView_Content;

        private Context mContext;

        public RepliesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

//        @Override
//        public void onClick(View v) {
//            int itemPosition = getLayoutPosition();
//            Intent intent = new Intent(mContext, PDetailActivity.class);
//            intent.putExtra("topic", Parcels.wrap(mRepliess.get(itemPosition)));
//            intent.putExtra("mainColor", mainColor);
//            intent.putExtra("alphaColor", alphaColor);
//            intent.putExtra("betaColor", betaColor);
//            mContext.startActivity(intent);
//        }

        public void bindReplies(Post post) {
            mFlipper++;
            mTextView_Content.setText(post.getContent());
            if(mFlipper % 2 == 0){
                mTextView_Content.setBackgroundColor(alphaColor);
            }else{
                mTextView_Content.setBackgroundColor(betaColor);
            }
        }
    }

}
