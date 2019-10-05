package com.example.myapplication.String;

public class StringCheck implements String_method{
    public  boolean string_check(String e2,String e3)

    {
        boolean a=false;
        if(e2.equals(e3)){
            a=true;
        }
        return a;
    }

    @Override
    public boolean is_empty(String s1 ,String s2) {
        if(s1.isEmpty() && s2.isEmpty())
        {
            return false;
        }
        else {
            return  true;
        }
    }

    @Override
    public boolean length_of_string(String s1) {
        if(s1.length()<6)
        {
        return false;
    }else {
            return  true;
        }
    }

}
