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
import android.widget.ImageView;


public class CoursesFragment extends Fragment {


private ImageView stresscourse;


    public CoursesFragment() {
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
        view = inflater.inflate(R.layout.fragment_courses, container, false);
        stresscourse = view.findViewById(R.id.imageView13);

        stresscourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
               CourseDetailsFragment CF = new  CourseDetailsFragment();
                ft.replace(R.id.frameLayout, CF);
                ft.commit();
            }
        });

        return view;
    }
}