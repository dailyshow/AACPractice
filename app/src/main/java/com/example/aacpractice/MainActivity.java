package com.example.aacpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aacpractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    public void moveActivity(View view) {
        Intent intent = new Intent(this, ViewModelActivity.class);
        startActivity(intent);
    }

    public void moveFragment(View view) {
        Intent intent = new Intent(this, VmShareActivity.class);
        startActivity(intent);
    }
}
