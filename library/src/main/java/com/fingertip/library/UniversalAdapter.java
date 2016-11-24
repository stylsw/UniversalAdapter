package com.fingertip.library;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by sweet on 2016/11/20.
 */

public abstract class UniversalAdapter<T> extends BaseAdapter {

    private Context mContext;
    private int mItemLayoutId;
    private List<T> mData;
    private SparseArray<Class> mItemTypeArray;
    public UniversalAdapter(Context mContext,List<T> mData,int mItemLayoutId) {
        this.mContext = mContext;
        this.mItemLayoutId = mItemLayoutId;
        this.mData = mData;
    }

    public UniversalAdapter(Context mContext,List<T> mData,ItemType... mItemTypes) {
        this.mContext = mContext;
        this.mData = mData;
        mItemTypeArray = new SparseArray<Class>();
        for(ItemType tempItemType : mItemTypes)
        {
            mItemTypeArray.put(tempItemType.getItemLayoutId(),tempItemType.getDataClass());
        }
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if(null == mItemTypeArray)
            return super.getItemViewType(position);

        return mItemTypeArray.keyAt(mItemTypeArray.indexOfValue(mData.get(position).getClass()));
    }

    @Override
    public int getViewTypeCount() {
        return null == mItemTypeArray ? super.getViewTypeCount() : mItemTypeArray.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        int mItemLayoutId = null == mItemTypeArray ? this.mItemLayoutId : getItemViewType(position);
        ViewHolder viewHolder = ViewHolder.get(mContext,view,viewGroup, mItemLayoutId,position);
        bindItemView(viewHolder,mData.get(position),mItemLayoutId,position);
        return viewHolder.getConvertView();
    }

    public abstract void bindItemView(ViewHolder viewHolder,T data,int itemLayoutId,int position);

}
