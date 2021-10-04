package test.connect.myapplication.model;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String username;
    private String hashed_pass;
    private int bought_p;
    private int sold_p;
    private double btc_balance;

    public User() {
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
        return "\nID:  " + getId()
                +"\nNAME:  "+ getName()
                +"\nEMAIL:  "+getEmail()+"\n";
    }
}
