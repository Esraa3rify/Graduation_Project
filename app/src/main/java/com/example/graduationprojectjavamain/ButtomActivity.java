package com.example.graduationprojectjavamain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ButtomActivity extends AppCompatActivity {

    final Fragment firstFragment = new ActivtyFragment();
    final Fragment secondFragment = new meditationFragment();
    final Fragment thirdFragment = new CommunityFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = firstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom);

        bottomNavigation();

    }


    @SuppressLint("NonConstantResourceId")
    private void bottomNavigation(){
        BottomNavigationView navigation = findViewById(R.id.navigationView);
        fm.beginTransaction().add(R.id.frameLayout, thirdFragment, "3").hide(thirdFragment).commit();
        fm.beginTransaction().add(R.id.frameLayout, secondFragment, "2").hide(secondFragment).commit();
        fm.beginTransaction().add(R.id.frameLayout, firstFragment, "1").commit();

        navigation.setSelectedItemId(R.id.home);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    fm.beginTransaction().hide(active).show(secondFragment).commit();
                    active = secondFragment;

                    return true;

                case R.id.activity:
                    fm.beginTransaction().hide(active).show(firstFragment).commit();
                    active = firstFragment;
                    return true;

                case R.id.community:
                    fm.beginTransaction().hide(active).show(thirdFragment).commit();
                    active = thirdFragment;
                    return true;
            }
            return false;
        });
    }
}