package com.example.a21873.intentapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TextView tvInfo;
    private Button btnOnlick,btnOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tv_info);
        btnOnlick = findViewById(R.id.btn_onlick);
        btnOpen=findViewById(R.id.btn_onOpen);

        btnOnlick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Activity 的跳转

                //显示启动

                //1
//                Intent intent=new Intent();
//
//                intent.setClass(MainActivity.this,SecondActivity.class);
//
//                startActivity(intent);


                //2

                // Utils.name="张三";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);


                //存入数据到intent

                //1 ,将intent作为存储的载体

                //传递对象与对象集合

                User user = new User("张三", 1, "123456", 26);
                User user2 = new User("李四", 2, "123456", 18);
                User user3 = new User("王五", 3, "123456", 19);

                ArrayList<User> list = new ArrayList<>();
                list.add(user);
                list.add(user2);
                list.add(user3);


                Person person = new Person("张三1", 1, "123456", 26);
                Person person1 = new Person("李四2", 2, "123456", 18);
                Person person2 = new Person("王五3", 3, "123456", 19);

                ArrayList<Person> personList = new ArrayList<>();
                personList.add(person);
                personList.add(person1);
                personList.add(person2);

                intent.putExtra("info", "张三");
                intent.putExtra("islogin", true);
                intent.putExtra("age", 20);
                intent.putExtra("user", user);
                intent.putExtra("list", list);

                intent.putExtra("person", person);
                intent.putExtra("plist", personList);


                //2  bundle

                Bundle bundle = new Bundle();

                bundle.putString("name", "李四");
                bundle.putInt("id", 23);

                bundle.putSerializable("user1", user);
                bundle.putSerializable("list", list);

                bundle.putParcelable("person", person1);
                bundle.putParcelableArrayList("plist", personList);


                intent.putExtras(bundle);


                startActivityForResult(intent,1);


                //3


//                ComponentName componentName=new ComponentName(MainActivity.this, SecondActivity.class);
//
//                Intent intent = new Intent();
//
//              intent.setComponent(componentName);
//
//                startActivity(intent);


                //隐式启动


//                Intent intent=new Intent();
//
//                intent.setAction("com.cn.wx.myactivity1");
//                startActivity(intent);


            }
        });



        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //打开拨号
//                Uri uri=Uri.parse("tel:15077914531");
//                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
//                startActivity(intent);

                //打开浏览器  默认和指定
//                Uri uri=Uri.parse("http://www.baidu.com");
//                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent);



                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                File file = new File("/mnt/sdcard/qq.apk");

                intent.setDataAndType(Uri.fromFile(file),
                        "application/vnd.android.package-archive");

                startActivity(intent);



            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        Log.e("------", "onActivityResult: "+requestCode+","+resultCode);



        Bundle bundle=data.getExtras();
        String info =bundle.getString("info");
        tvInfo.setText(data.getStringExtra("info"));





    }
}
