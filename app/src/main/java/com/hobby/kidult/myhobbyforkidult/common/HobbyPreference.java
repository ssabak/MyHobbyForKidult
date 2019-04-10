package com.hobby.kidult.myhobbyforkidult.common;

import android.app.Application;
import android.app.Service;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HobbyPreference extends Application {

    //	Preferences
    protected SharedPreferences mPref;

    // 취미 종류 저장
    public void setHobbyList(int nType)
    {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt("CarType", nType);
        editor.commit();
    }

    public int getHobbyList()
    {
        mPref = getSharedPreferences("Info_pref", Service.MODE_PRIVATE);
        int nType = mPref.getInt("CarType", 0);
        return nType;
    }

    public ArrayList<String> setHobbyList(String key)
    {
        mPref = getSharedPreferences("Info_pref", Service.MODE_PRIVATE);

        // 추후 DEFVALUE 값 변경
        Set<String> defValues = new HashSet<String>();
        defValues.add("danger_poison");
        defValues.add("danger_flammable");
        defValues.add("danger_explosive");
        defValues.add("danger_oxidizing");

        defValues.add("hyd_overground");
        defValues.add("hyd_underground");
        defValues.add("hyd_watertower");

        Set<String> set = mPref.getStringSet(key, defValues);
        return new ArrayList<String>(set);
    }

    public void getHobbyList(ArrayList<String> data)
    {
        SharedPreferences.Editor editor = mPref.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(data);
        editor.putStringSet("FireType", set);
        editor.commit();
    }
}
