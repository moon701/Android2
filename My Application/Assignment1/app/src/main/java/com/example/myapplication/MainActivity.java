package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragment2DataListener {

    private ActivityMainBinding binding;
    private int currentFragment = 1;
    private String name, email, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // بدء التطبيق بـ Fragment1
        Fragment1 fragment1 = Fragment1.newInstance(null, null);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment1)
                .commit();

        // لم يعد هناك زر في الـ Activity، التنقل يتم من داخل الـ Fragments
    }

    // استقبال البيانات من Fragment2 عبر الواجهة
    @Override
    public void onDataReceived(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;

        if (!TextUtils.isEmpty(name)) {
            // إنشاء Fragment3 وتمرير الاسم
            Fragment3 fragment3 = new Fragment3();
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            fragment3.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment3)
                    .addToBackStack(null)
                    .commit();

            currentFragment = 3;
        } else {
            Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
        }
    }
}
