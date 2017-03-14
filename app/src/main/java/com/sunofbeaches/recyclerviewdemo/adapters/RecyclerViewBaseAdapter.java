package com.sunofbeaches.recyclerviewdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunofbeaches.recyclerviewdemo.R;
import com.sunofbeaches.recyclerviewdemo.beans.ItemBean;

import java.util.List;

/**
 * Created by TrillGates on 17/3/11.
 * God bless my code!
 * For more : http://bbs.sunofbeaches.com
 */
public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.InnerHolder> {


    private final List<ItemBean> mData;
    private final Context mContext;

    public RecyclerViewBaseAdapter(List<ItemBean> data, Context context) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getInnerHolder(mContext);
    }


    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (null != mData) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mTitle;

        public InnerHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.pic);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }

        public void setData(ItemBean itemBean) {
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }

    protected abstract InnerHolder getInnerHolder(Context context);
}
