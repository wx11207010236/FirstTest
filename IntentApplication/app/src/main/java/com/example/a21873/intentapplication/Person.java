package com.example.a21873.intentapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by 21873 on 2020/4/10.
 */

public class Person implements Parcelable {

    private String name;
    private  int id;
    private String pwd;
    private  int age;

    public Person(String name, int id, String pwd, int age) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.age = age;
    }

    public Person() {
    }

    protected Person(Parcel in) {
        name = in.readString();
        id = in.readInt();
        pwd = in.readString();
        age = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeString(pwd);
        dest.writeInt(age);
    }
}
