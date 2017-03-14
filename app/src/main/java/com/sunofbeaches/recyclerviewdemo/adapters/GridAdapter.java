package com.sunofbeaches.recyclerviewdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.sunofbeaches.recyclerviewdemo.R;
import com.sunofbeaches.recyclerviewdemo.beans.ItemBean;

import java.util.List;

/**
 * Created by TrillGates on 17/3/11.
 * God bless my code!
 * For more : http://bbs.sunofbeaches.com
 */
public class GridAdapter extends RecyclerViewBaseAdapter {

    public GridAdapter(List<ItemBean> data, Context context) {
        super(data, context);
    }

    @Override
    protected InnerHolder getInnerHolder(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid_view, null);
        return new InnerHolder(view);
    }
}
