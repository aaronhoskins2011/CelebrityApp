package com.example.aaron.celebrityapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CelebrityNameFragment.OnFragmentInteractionListener {
    private static final String NAME_FRAGMENT = "nameFragment";
    private static final String INFO_FRAGMENT = "infoFragment";
    FrameLayout fmCelbertyName;
    FrameLayout fmCelbertyInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fmCelbertyName = (FrameLayout)findViewById(R.id.flCelebrityName);
        fmCelbertyInfo = (FrameLayout)findViewById(R.id.flCelebrityInfo);
        CelebrityNameFragment cbNameFrag = CelebrityNameFragment.newInstance("","Name");
        getSupportFragmentManager().beginTransaction().replace(R.id.flCelebrityName,cbNameFrag ,NAME_FRAGMENT).commit();
    }


    @Override
    public void onFragmentInteraction(String string) {
        System.out.println("Main = " + string);
        CelebrityInfoFragment cbInfoFrag = CelebrityInfoFragment.newInstance(string,"Info for " + string);
        getSupportFragmentManager().beginTransaction().replace(R.id.flCelebrityInfo,cbInfoFrag ,INFO_FRAGMENT).commit();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
