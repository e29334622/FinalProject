package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class chinese extends AppCompatActivity {
    //客製化類別Data,包含一張圖片與文字
    class Data{
        int photo;
        String name;
    }
    //繼承BaseAdapter
    public class MyAdapter extends BaseAdapter {
        //保存在MyAdapter之中的資料來源
        private chinese.Data[] data;
        //保存在MyAdapter之中的畫面
        private int view;
        //透過建構子儲存資料來源與畫面
        public MyAdapter (chinese.Data[] data, int view) {
            this.data = data;
            this.view = view;
        }
        //回傳資料來源筆數
        @Override
        public int getCount() {
            return data.length;
        }
        //回傳某筆項目
        @Override
        public Object getItem(int position) {
            return data[position];
        }
        //回傳某筆項目id
        @Override
        public long getItemId(int position) {
            return 0;
        }
        //取得畫面元件
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //取得xml畫面
            convertView = getLayoutInflater().inflate(view,parent,false);
            //連接TextView元件
            TextView name = convertView.findViewById(R.id.name);
            //根據position把字串顯示到TextView
            name.setText(data[position].name);
            //連接ImageView 元件
            ImageView imageView = convertView.findViewById(R.id.imageView);
            //根據position把圖片顯示到ImageView
            imageView.setImageResource(data[position].photo);
            return convertView;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);


        //連接button元件
        Button btn_backtomain = findViewById(R.id.btn_backtomain);
        //對btn_backtomain設置監聽
        btn_backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(chinese.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //建立資料來源,用陣列方式宣告自行設計的類別,並為陣列的每個內容填入藥顯示的資料
        String[] MealNameArray = new String[]{"大麥克", "雙層牛肉吉事堡", "嫩煎雞腿堡", "麥香雞", "麥克雞塊(6塊)", "麥克雞塊(10塊)", "勁辣雞腿堡", "麥脆雞翅",
                "麥脆雞腿", "黃金起司豬排堡", "麥香魚", "煙燻雞肉長堡", "醬燒豬肉長寶堡", "蕈菇安格斯黑牛堡", "BLT安格斯黑牛堡", "BLT辣脆雞腿堡", "BLT嫩煎雞腿堡", "凱撒辣脆雞沙拉", "義式烤雞沙拉"};
        int[] MealPhotoArray = new int[]{R.drawable.a_01_big_bac, R.drawable.a_02_cheeseburger, R.drawable.a_03_gbc, R.drawable.a_04_mcchicken, R.drawable.a_05_ngt6, R.drawable.a_06_ngt10,
                R.drawable.a_07_scf, R.drawable.a_08_mfc, R.drawable.a_09_mfc, R.drawable.a_10_pork_burger, R.drawable.a_11_fof, R.drawable.a_12_smoked_chicken, R.drawable.a_13_ginger_pork,
                R.drawable.a_14_mushroom, R.drawable.a_15_beef, R.drawable.a_16_fried_chicken, R.drawable.a_17_grilled_chicken, R.drawable.a_18_spicy_fried_chicken, R.drawable.a_19_grilled_chicken};
        Data[] mealData = new Data[MealNameArray.length];
        for(int i=0 ; i<mealData.length ; i++){
            mealData[i] = new Data();
            mealData[i].name = MealNameArray[i];
            mealData[i].photo = MealPhotoArray[i];
        }
        //建立MyAdapter物件,並放入mealData與custom
        MyAdapter mealAdapter = new MyAdapter(mealData,R.layout.custom);
        //連接Spinner元件,並連結MyAdapter
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(mealAdapter);
        //建立資料來源(字串)


        String[] SetOrSingleArray = new String[]{"套餐", "單點"};
        //建立Adapter物件,並放入字串與simple_spinner_item
        ArrayAdapter<String> SetOrSingleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SetOrSingleArray);
        //連接spinner元件,並連結MyAdapter
        Spinner spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(SetOrSingleAdapter);



        TextView textView2 = findViewById(R.id.textView2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    String[] set01 = getResources().getStringArray(R.array.Price);
                    textView2.setText("hello");
                }
                else if(position == 1) {
                    textView2.setText("hello22");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}