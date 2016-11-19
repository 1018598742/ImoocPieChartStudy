package com.example.administrator.imoocpiechartstudy;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/18 0018.
 */
public class MonthBean implements Parcelable{
    public String date;
    public ArrayList<PieBean> obj;

    protected MonthBean(Parcel in) {
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MonthBean> CREATOR = new Creator<MonthBean>() {
        @Override
        public MonthBean createFromParcel(Parcel in) {
            return new MonthBean(in);
        }

        @Override
        public MonthBean[] newArray(int size) {
            return new MonthBean[size];
        }
    };

    @Override
    public String toString() {
        return "MonthBean{" +
                "date='" + date + '\'' +
                ", obj=" + obj +
                '}';
    }

    class PieBean{
        public String title;
        public int value;

        @Override
        public String toString() {
            return "PieBean{" +
                    "title='" + title + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
