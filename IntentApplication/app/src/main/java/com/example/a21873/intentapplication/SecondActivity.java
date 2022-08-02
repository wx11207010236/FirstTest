package com.example.a21873.intentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    private TextView tvInfo;
    private Button btnOnlick;

    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvInfo = findViewById(R.id.tv_info);
        btnOnlick = findViewById(R.id.btn_onlick);
        name = Utils.name;


        //接收数据
        final Intent intent = getIntent();

        final String info = intent.getStringExtra("info");
        boolean islogon = intent.getBooleanExtra("islogin", false);
        int age = intent.getIntExtra("age", 0);

        User user = (User) intent.getSerializableExtra("user");

        ArrayList<User> list = (ArrayList<User>) intent.getSerializableExtra("list");

        Person person=intent.getParcelableExtra("person");
        ArrayList<Person> personArrayList=intent.getParcelableArrayListExtra("plist");


        final Bundle bundle = intent.getExtras();

        String name = bundle.getString("name", "王五");
        int id = bundle.getInt("id", 0);

        User user1 = (User) bundle.getSerializable("user1");

        ArrayList<User> list1 = (ArrayList<User>) bundle.getSerializable("list");
        Person person1=bundle.getParcelable("person");
        ArrayList<Person> personArrayList1=bundle.getParcelableArrayList("plist");

        //  tvInfo.setText(info+","+islogon+","+age+","+name+","+id);

        tvInfo.setText(personArrayList1.toString());


        btnOnlick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent1=new Intent(SecondActivity.this,MainActivity.class);



//                Intent intent1=getIntent();

                Bundle bundle1=new Bundle();

                bundle1.putString("info","第二个界面信心");
                intent1.putExtras(bundle1);


                setResult(2,intent1);
                finish();


            }
        });


    }


}
