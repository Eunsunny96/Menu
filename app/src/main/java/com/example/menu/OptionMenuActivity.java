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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OptionMenuActivity extends AppCompatActivity {
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
        menu.add(0,1,0,"55sp");
        menu.add(0,2,0,"65sp");
        menu.add(0,3,0,"75sp");
        menu.add(0,4,0,"85sp");
        menu.add(0,5,0,"95sp");
        menu.add(0,6,0,"105sp");
        menu.add(0,7,0,"115sp");
        menu.add(0,8,0,"125sp");
        return true; //메뉴 표시
    }
    //메뉴의 아이템을 선택할 때 호출되는 함수
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                //디바이스에 상대적인 픽셀
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 55);
                break;
            case 2:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 65);
                break;
            case 3:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 75);
                break;
            case 4:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 85);
                break;
            case 5:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 95);
                break;
            case 6:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 105);
                break;
            case 7:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 115);
                break;
            case 8:
                selection.setTextSize(TypedValue.COMPLEX_UNIT_SP, 125);
                break;
            default:
                return false;
        }
        return true;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rowItem= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row, parent, false);
            return new MyAdapter.ViewHolder(rowItem);
        }

        @Override
        public void onBindViewHolder(OptionMenuActivity.MyAdapter.ViewHolder holder, int position) {
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