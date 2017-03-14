package com.sunofbeaches.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.sunofbeaches.recyclerviewdemo.adapters.GridAdapter;
import com.sunofbeaches.recyclerviewdemo.adapters.ListAdapter;
import com.sunofbeaches.recyclerviewdemo.adapters.StaggerAdapter;
import com.sunofbeaches.recyclerviewdemo.beans.ItemBean;
import com.sunofbeaches.recyclerviewdemo.utils.Datas;

import java.util.ArrayList;
import java.util.List;

/**
 * create by TrillGates 2017/3/11
 * God bless my code!
 * For more : http://bbs.sunofbeaches.com
 */

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private List<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) this.findViewById(R.id.recycler_view);
        //模拟一下数据
        initData();
        //第一次加载数据的话,直接加载第一个List的类型嘛
        showList(true, false);
    }

    /**
     * 这里的话模拟一下数据哇
     */
    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < Datas.icons.length; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.title = "图片 - " + i;
            itemBean.icon = Datas.icons[i];
            mData.add(itemBean);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单选项
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //处理菜单选项
        int itemId = item.getItemId();
        switch (itemId) {
            //list部分
            case R.id.list_horizontal_reverse:
                showList(false, true);
                break;
            case R.id.list_horizontal_stander:
                showList(false, false);
                break;
            case R.id.list_vertical_reverse:
                showList(true, true);
                break;
            case R.id.list_vertical_stander:
                showList(true, false);
                break;
            //这是实现GridView部分的代码
            case R.id.grid_horizontal_reverse:
                showGrid(false, true);
                break;
            case R.id.grid_horizontal_stander:
                showGrid(false, false);
                break;
            case R.id.grid_vertical_reverse:
                showGrid(true, true);
                break;
            case R.id.grid_vertical_stander:
                showGrid(true, false);
                break;
            //瀑布流部分
            case R.id.stagger_horizontal_reverse:
                showStagger(false, true);
                break;
            case R.id.stagger_horizontal_stander:
                showStagger(false, false);
                break;
            case R.id.stagger_vertical_reverse:
                showStagger(true, true);
                break;
            case R.id.stagger_vertical_stander:
                showStagger(true, false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showList(boolean isVertical, boolean isReverse) {
        //创建适配器
        ListAdapter listAdapter = new ListAdapter(mData, this);
        //根据条件创建布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器的属性
        layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(isReverse);
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //设置适配器
        mRecyclerView.setAdapter(listAdapter);
    }

    private void showGrid(boolean isVertical, boolean isReverse) {
        GridAdapter gridAdapter = new GridAdapter(mData, this);
        //创建布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(isVertical ? GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);
        gridLayoutManager.setReverseLayout(isReverse);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(gridAdapter);
    }

    private void showStagger(boolean isVertical, boolean isReverse) {
        //创建布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, isVertical ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);
        //创建适配器
        StaggerAdapter adapter = new StaggerAdapter(mData, this);
        //设置布局管理器的属性
        layoutManager.setReverseLayout(isReverse);
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //设置适配器
        mRecyclerView.setAdapter(adapter);
    }

}
