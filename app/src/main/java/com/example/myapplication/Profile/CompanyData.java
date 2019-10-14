package com.example.myapplication.Profile;

import java.util.ArrayList;

public class CompanyData {
    String name;
    String add;

    public CompanyData(String name, String add, String contactno, String criteria, float ctc) {
        this.name = name;
        this.add = add;
        this.contactno = contactno;
        this.criteria = criteria;
        this.ctc = ctc;
    }

    public CompanyData() {
    }

    String contactno;
    String criteria;
    float ctc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public float getCtc() {
        return ctc;
    }

    public void setCtc(float ctc) {
        this.ctc = ctc;
    }
}