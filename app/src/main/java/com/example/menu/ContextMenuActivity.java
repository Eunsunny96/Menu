package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContextMenuActivity extends AppCompatActivity {
    EditText editName;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        editName=findViewById(R.id.editName);
        btnOk=findViewById(R.id.btnOk);
        //컨텍스트 메뉴 등록
        registerForContextMenu(editName);
        registerForContextMenu(btnOk);
    }
//컨텍스트 메뉴 생성 - 길게 누를 때 호출
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==editName){
            menu.setHeaderTitle("입력메뉴");
            menu.add(0,1,0,"번역");
            menu.add(0,2,0,"필기인식");
        }else if(v==btnOk){
            menu.add(0,3,0,"지우기");
        }
    }
//컨텍스트 메뉴의 아이템 선택
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "번역하기",
                        Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "필기인식",
                        Toast.LENGTH_SHORT).show();
                break;
            case 3:
                editName.setText("");
                break;
        }
        return true;
    }
}




