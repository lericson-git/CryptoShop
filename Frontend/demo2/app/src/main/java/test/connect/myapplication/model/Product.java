package test.connect.myapplication.model;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class Product implements Parcelable {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String p_condition; //maybe this crashes MySQL since condition it's a reserved word.
    private String mainTag;
    private String subTag;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private Integer sellerId;
    private Integer buyerId;
    private boolean hasBeenBought;

    public Product() {
        name = "Default Product";
        p_condition = "Good Condition";
        description = "This is a test product to make sure things are working properly.";
        hasBeenBought = false;
        id = 100;
        price = 100.00;
    }

    protected Product(Parcel in) {
        name = in.readString();
        p_condition = in.readString();
        description = in.readString();
        hasBeenBought = in.readBoolean();
        id = in.readInt();
        price = in.readDouble();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public boolean hasBeenBought() {
        return hasBeenBought;
    }

    public void setHasBeenBought(boolean hasBeenBought) {
        this.hasBeenBought = hasBeenBought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCondition() {
        return p_condition;
    }

    public void setCondition(String condition) {
        this.p_condition = condition;
    }

    public String getMainTag() {
        return mainTag;
    }

    public void setMainTag(String main_tag) {
        this.mainTag = main_tag;
    }

    public String getSubTag() {
        return subTag;
    }

    public void setSubTag(String sub_tag) {
        this.subTag = sub_tag;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer seller_id) {
        this.sellerId = seller_id;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyer_id) {
        this.buyerId = buyer_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(name);
        out.writeString(p_condition);
        out.writeString(description);
        out.writeBoolean(hasBeenBought);
        out.writeInt(id);
        out.writeDouble(price);
    }
}
