package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OptionXmlActivity extends AppCompatActivity {
    TextView selection;
    String[] items={"lorem","ipsum","dolor","sit","amet"};
    RecyclerView rv;
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        selection=findViewById(R.id.selection);
        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));
        myAdapter=new MyAdapter();
        rv.setAdapter(myAdapter);
    }
    //메뉴를 생성하는 함수
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi=getMenuInflater(); //메뉴 생성기
        mi.inflate(R.menu.menu, menu); // menu.xml 을 읽어서 메뉴 생성
        return true; //메뉴 표시
    }
    //메뉴의 아이템을 선택할 때 호출되는 함수
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                //디바이스에 상대적인 픽셀
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 55);
                break;
            case R.id.menu2:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 65);
                break;
            case R.id.menu3:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 75);
                break;
            case R.id.menu4:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 85);
                break;
            case R.id.menu5:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 95);
                break;
            case R.id.menu6:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 105);
                break;
            default:
                return false;
        }
        return true;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        @NonNull
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rowItem= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row, parent, false);
            return new MyAdapter.ViewHolder(rowItem);
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.textView.setText(items[position]);
        }

        @Override
        public int getItemCount() {
            return items.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;
            public ViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                this.textView= itemView.findViewById(R.id.text1);
            }

            @Override
            public void onClick(View v) {
                selection.setText(items[getLayoutPosition()]);
            }
        }
    }
}