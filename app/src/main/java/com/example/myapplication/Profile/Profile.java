package com.example.myapplication.Profile;

public class Profile {
    String name;
    String hsc;

    public Profile(String name, String ssc, String hsc, String aggregate, String phoneno) {
        this.name = name;
        this.hsc = hsc;
        this.ssc = ssc;
        this.aggregate = aggregate;
        this.phoneno = phoneno;
    }

    String ssc;
    String aggregate;

    public Profile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHsc() {
        return hsc;
    }

    public void setHsc(String hsc) {
        this.hsc = hsc;
    }

    public String getSsc() {
        return ssc;
    }

    public void setSsc(String ssc) {
        this.ssc = ssc;
    }

    public String getAggregate() {
        return aggregate;
    }

    public void setAggregate(String aggregate) {
        this.aggregate = aggregate;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    String phoneno;
}
