package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuCheckActivity extends AppCompatActivity {
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_check);
        txtResult=findViewById(R.id.txtResult);
    }
//메뉴가 생성될 때
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_check, menu);
        return true;
    }
//메뉴 아이템을 선택할 때
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bigfont:
                if(item.isChecked()){ //체크상태
                    txtResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                }else{
                    txtResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                }
                break;
            case R.id.red:
                txtResult.setTextColor(Color.RED);
                break;
            case R.id.green:
                txtResult.setTextColor(Color.GREEN);
                break;
            case R.id.blue:
                txtResult.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }
//메뉴 출력 전
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        float px = txtResult.getTextSize(); //고정값
        float sp = px / getResources().getDisplayMetrics().scaledDensity;
        Log.i("test",px+"px");
        Log.i("test",sp+"sp");
        if(sp==40){
            menu.findItem(R.id.bigfont).setChecked(true);
        }else{
            menu.findItem(R.id.bigfont).setChecked(false);
        }
        int color=txtResult.getTextColors().getDefaultColor();
        if(color==Color.RED){
            menu.findItem(R.id.red).setChecked(true);
        }else if(color==Color.GREEN){
            menu.findItem(R.id.green).setChecked(true);
        }else if(color==Color.BLUE){
            menu.findItem(R.id.blue).setChecked(true);
        }
        return true;
    }
}