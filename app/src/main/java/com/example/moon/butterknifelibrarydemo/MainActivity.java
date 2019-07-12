package com.example.moon.butterknifelibrarydemo;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)                 //View Binding
    TextView tv_1;

    @BindView(R.id.textView2)
    TextView tv_2;

    @BindView(R.id.button)
    Button btn_1;

    @BindView(R.id.button2)
    Button btn_2;

    @BindView(R.id.main_layout)
    ConstraintLayout constraintLayout;

    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;

    @BindString(R.string.MyName)      // Resource Binding
    String myName;

    @BindDrawable(R.drawable.ic_launcher_background)    //Drawable Binding
    Drawable graphics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);         // Step One
        tv_1.setText(myName);
       // constraintLayout.setBackground(graphics);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Mustofa");
        arrayList.add("Mahmud");
        arrayList.add("Moon");
        Custom_Adapter custom_adapter = new Custom_Adapter(arrayList,getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(custom_adapter);
    }

    @OnClick(R.id.button)                      //Listener Binding
    public void btn_1_click(){
        Toast.makeText(getApplicationContext(),"Button One CLicked",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button2)
    public void btn_2_click(){
        Toast.makeText(getApplicationContext(),"Button Two Clicked",Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.button)
    public boolean btn_1_long_click(){
        Toast.makeText(getApplicationContext(),"Long Clicked",Toast.LENGTH_SHORT).show();
        return true;
    }

}
