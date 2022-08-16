package com.example.application0806.VO;

// alt + insert 키
//  생성자, getter&setter 등 자동 완성

import android.os.Parcel;
import android.os.Parcelable;

// 직렬화가 되어질 수 있도록 Parcelable 인터페이스를 구현
public class User implements Parcelable {
    private String email;
    private String password;
    private String name;
    private String profileMessage;

    public User() { }
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public User(String email, String password, String name, String profileMessage) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.profileMessage = profileMessage;
    }

    protected User(Parcel in) {
        email = in.readString();
        password = in.readString();
        name = in.readString();
        profileMessage = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileMessage() {
        return profileMessage;
    }

    public void setProfileMessage(String profileMessage) {
        this.profileMessage = profileMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(name);
        parcel.writeString(profileMessage);
    }
}
