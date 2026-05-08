package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {

    public static Fragment2Binding fragment2Binding;
    private OnFragment2DataListener listener;

    // واجهة للتواصل مع الـ Host Activity
    public interface OnFragment2DataListener {
        void onDataReceived(String name, String email, String gender);
    }

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2DataListener) {
            listener = (OnFragment2DataListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragment2DataListener");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment2Binding = Fragment2Binding.inflate(inflater, container, false);

        // زر Continue الوحيد في أسفل الشاشة
        fragment2Binding.buttonContinue.setOnClickListener(v -> {
            String name = fragment2Binding.editTextName.getText().toString();
            String email = fragment2Binding.editTextEmail.getText().toString();
            String gender = fragment2Binding.editTextGender.getText().toString();

            // إرسال البيانات إلى الـ MainActivity
            listener.onDataReceived(name, email, gender);
        });

        return fragment2Binding.getRoot();
    }
}
