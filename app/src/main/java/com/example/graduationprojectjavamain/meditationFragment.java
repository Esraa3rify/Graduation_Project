package com.example.graduationprojectjavamain;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class meditationFragment extends Fragment {

    private Button courses;
    private Button articles;
    private Button notes;
    public meditationFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }





    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        Fragment fragment;
        view = inflater.inflate(R.layout.fragment_meditation, container, false);
       courses=view.findViewById(R.id.btn_courses);
       articles=view.findViewById(R.id.btn_try_again);
       notes=view.findViewById(R.id.btn_notes);
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                CoursesFragment CF = new CoursesFragment();
                ft.replace(R.id.frameLayout, CF);
                ft.commit();
            }
        });

        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ArticlesFragment CF = new ArticlesFragment();
                ft.replace(R.id.frameLayout, CF);
                ft.commit();
            }
        });

       notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                JournalsFragment CF = new JournalsFragment();
                ft.replace(R.id.frameLayout, CF);
                ft.commit();
            }
        });

        return view;
    }



}