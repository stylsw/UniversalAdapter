package com.fingertip.library;

/**
 * Created by sweet on 2016/11/24.
 */

public class ItemType {
    private int mItemLayoutId;
    private Class mDataClass;

    public ItemType(int mItemLayoutId, Class mDataClass) {
        this.mItemLayoutId = mItemLayoutId;
        this.mDataClass = mDataClass;
    }

    public int getItemLayoutId() {
        return mItemLayoutId;
    }

    public void setItemLayoutId(int mItemLayoutId) {
        this.mItemLayoutId = mItemLayoutId;
    }

    public Class getDataClass() {
        return mDataClass;
    }

    public void setDataClass(Class mDataClass) {
        this.mDataClass = mDataClass;
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "mItemLayoutId=" + mItemLayoutId +
                ", mDataClass=" + mDataClass +
                '}';
    }
}
