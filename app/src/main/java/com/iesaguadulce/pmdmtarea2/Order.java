package com.iesaguadulce.pmdmtarea2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Order implements Parcelable {

    private String name;
    private String phone;
    private String address;
    private String collection;

    public Order(String name, String phone, String address, String collection) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.collection = collection;
    }

    protected Order(Parcel in) {
        name = in.readString();
        phone = in.readString();
        address = in.readString();
        collection = in.readString();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() { return address; }

    public String getCollection() {
        return collection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeString(collection);
    }
}
