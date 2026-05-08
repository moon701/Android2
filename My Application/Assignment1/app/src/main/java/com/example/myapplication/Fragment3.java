package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.Fragment3Binding;

public class Fragment3 extends Fragment {

    private Fragment3Binding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = Fragment3Binding.inflate(inflater, container, false);

        // استرجاع الاسم من الـ Bundle
        if (getArguments() != null) {
            String name = getArguments().getString("name");
            binding.textViewName.setText("Welcome, " + name);
        }

        // الزر يبدأ معطل
        binding.buttonFinish.setEnabled(false);

        // تفاعل الـ CheckBox
        binding.checkBoxConfirm.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.buttonFinish.setEnabled(true);
                binding.buttonFinish.setText("Finish");
            } else {
                binding.buttonFinish.setEnabled(false);
                binding.buttonFinish.setText("Continue");
            }
        });

        // عند الضغط على زر Finish
        binding.buttonFinish.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Registration Completed!", Toast.LENGTH_SHORT).show();
            // إذا أردت إنهاء التطبيق بدل الرسالة:
            // getActivity().finish();
        });

        return binding.getRoot();
    }
}
