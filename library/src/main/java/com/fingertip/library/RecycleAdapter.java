package com.fingertip.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by sweet on 2016/11/25.
 */

public abstract class RecycleAdapter<T> extends RecyclerView.Adapter<RecycleViewHolder> {
    protected Context mContext;
    protected List<T> mDatas;
    protected int mItemLayoutId;
    private SparseArray<Class> mItemTypeArray;

    public RecycleAdapter(Context mContext, List<T> mDatas, int mItemLayoutId) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.mItemLayoutId = mItemLayoutId;
    }
    public RecycleAdapter(Context mContext, List<T> mDatas, ItemType... mItemTypes) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mItemTypeArray = new SparseArray<Class>();
        for(ItemType tempItemType : mItemTypes)
        {
            mItemTypeArray.put(tempItemType.getItemLayoutId(),tempItemType.getDataClass());
        }
    }
    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int itemLayoutId = null == mItemTypeArray ? mItemLayoutId : viewType;
        return RecycleViewHolder.createViewHolder(mContext,parent,itemLayoutId);
    }

    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        onBindItemView(holder,mDatas.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void onBindItemView(RecycleViewHolder recycleViewHolder,T data,int position);


    @Override
    public int getItemViewType(int position) {
        if(null == mItemTypeArray)
            return super.getItemViewType(position);

        return mItemTypeArray.keyAt(mItemTypeArray.indexOfValue(mDatas.get(position).getClass()));
    }
}
