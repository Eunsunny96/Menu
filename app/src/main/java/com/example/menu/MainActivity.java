package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(this,
                        OptionMenuActivity.class);
                break;
            case R.id.button2:
                intent = new Intent(this,
                        OptionXmlActivity.class);
                break;
            case R.id.button3:
                intent = new Intent(this,
                        MenuCheckActivity.class);
                break;
            case R.id.button4:
                intent = new Intent(this,
                        ContextMenuActivity.class);
                break;
        }
        startActivity(intent);
    }
}