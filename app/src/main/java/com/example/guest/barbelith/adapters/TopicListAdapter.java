package com.example.guest.barbelith.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Topic;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/5/16.
 */
public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.TopicViewHolder> {
    private ArrayList<Topic> mTopics = new ArrayList<>();
    private Context mContext;
    private int mFlipper = 0;
    private int alphaColor;
    private int betaColor;

    public TopicListAdapter(Context context, ArrayList<Topic> topics, int _alphaColor, int _betaColor) {
        mContext = context;
        mTopics = topics;
        alphaColor = _alphaColor;
        betaColor = _betaColor;
    }

    @Override
    public TopicListAdapter.TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_list_item, parent, false);
        TopicViewHolder viewHolder = new TopicViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopicListAdapter.TopicViewHolder holder, int position) {
        holder.bindTopic(mTopics.get(position));
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.textView_Title) TextView mTextView_Title;

        private Context mContext;

        public TopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindTopic(Topic topic) {
            mFlipper++;
            mTextView_Title.setText(topic.getTitle());
            if(mFlipper % 2 == 0){
                mTextView_Title.setBackgroundColor(alphaColor);
            }else{
                mTextView_Title.setBackgroundColor(betaColor);
            }
        }
    }

}
