package com.dx.bilibili.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import butterknife.Unbinder;

/**
 * Created by jiayiyang on 17/5/8.
 */

public class MvpActivityBean implements Parcelable{

    private Unbinder unbinder;

    public void setUnbinder(Unbinder unbinder){
        this.unbinder = unbinder;
    }

    public Unbinder getUnbinder(){
        return unbinder;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable((Serializable) unbinder);
    }

    public static final Parcelable.Creator<MvpActivityBean> CREATOR = new Parcelable.Creator<MvpActivityBean>() {
        @Override
        public MvpActivityBean createFromParcel(Parcel source) {
            MvpActivityBean mvpActivityBean = new MvpActivityBean();
            mvpActivityBean.setUnbinder((Unbinder)source.readSerializable());
            return mvpActivityBean;
        }

        @Override
        public MvpActivityBean[] newArray(int size) {
            return new MvpActivityBean[size];
        }
    };

}
