package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {

    private Fragment1Binding binding;

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);

        // زر Continue ينقل المستخدم إلى Fragment2
        binding.buttonContinue.setOnClickListener(v -> {
            Fragment2 fragment2 = Fragment2.newInstance(null, null);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .addToBackStack(null)
                    .commit();
        });

        return binding.getRoot();
    }
}
