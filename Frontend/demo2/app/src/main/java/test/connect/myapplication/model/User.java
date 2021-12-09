package test.connect.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private Integer id;
    private String name;
    private String email;
    private String username;
    private String hashed_pass;
    private int bought_p;
    private int sold_p;
    private double btc_balance;

    public User() {
        //Default user params for testing
        id = 1;
        name = "John Doe";
        email = "johndoe@gmail.com";
        username = "jdoe13";
        btc_balance = 500;
    }

    public User(String user) {
        username = user;
    }

    private User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        username = in.readString();
        btc_balance = in.readDouble();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashed_pass() {
        return hashed_pass;
    }

    public void setHashed_pass(String hashed_pass) {
        this.hashed_pass = hashed_pass;
    }

    public int getBought_p() {
        return bought_p;
    }

    public void setBought_p(int bought_p) {
        this.bought_p = bought_p;
    }

    public int getSold_p() {
        return sold_p;
    }

    public void setSold_p(int sold_p) {
        this.sold_p = sold_p;
    }

    public double getBtc_balance() {
        return btc_balance;
    }

    public void setBtc_balance(double btc_balance) {
        this.btc_balance = btc_balance;
    }

    public String printable(){
        return "\nID: " + getId()
                +"\nNAME:  "+ getName()
                +"\nEMAIL:  "+getEmail()+"\n";
    }

    /* everything below here is for implementing Parcelable */
    // 99.9% of the time you can just ignore this
    @Override
    public int describeContents() {
        return 0;
    }

    // Write object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeString(name);
        out.writeString(email);
        out.writeString(username);
        out.writeDouble(btc_balance);
    }

    // This is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };


}
