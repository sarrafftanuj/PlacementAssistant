package com.example.myapplication.Profile;

public class Profile {
    String name;
    Float hsc;

    public Profile(String name, Float ssc, Float hsc, Float aggregate, String phoneno) {
        this.name = name;
        this.hsc = hsc;
        this.ssc = ssc;
        this.aggregate = aggregate;
        this.phoneno = phoneno;
    }

    Float ssc;
    Float aggregate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHsc() {
        return hsc;
    }

    public void setHsc(Float hsc) {
        this.hsc = hsc;
    }

    public Float getSsc() {
        return ssc;
    }

    public void setSsc(Float ssc) {
        this.ssc = ssc;
    }

    public Float getAggregate() {
        return aggregate;
    }

    public void setAggregate(Float aggregate) {
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
