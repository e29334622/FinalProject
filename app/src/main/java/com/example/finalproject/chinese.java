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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class chinese extends AppCompatActivity {

    class Data{
        int photo;
        String name;
    }

    public class MyAdapter extends BaseAdapter {
        private chinese.Data[] data;
        private int view;

        public MyAdapter (chinese.Data[] data, int view) {
            this.data = data;
            this.view = view;
        }
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(view,parent,false);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(data[position].name);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            imageView.setImageResource(data[position].photo);
            return convertView;
        }
    }

    private Button btn_backtomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);

        btn_backtomain = findViewById(R.id.btn_backtomain);
        btn_backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(chinese.this, MainActivity.class);
                startActivity(intent);
            }
        });

        String[] mealNameArray = new String[]{"大麥克", "雙層牛肉吉事堡", "嫩煎雞腿堡", "麥香雞", "麥克雞塊(6塊)", "麥克雞塊(10塊)", "勁辣雞腿堡", "麥脆雞翅",
                "麥脆雞腿", "黃金起司豬排堡", "麥香魚", "煙燻雞肉長堡", "醬燒豬肉長寶堡", "蕈菇安格斯黑牛堡", "BLT安格斯黑牛堡", "BLT辣脆雞腿堡", "BLT嫩煎雞腿堡", "凱撒辣脆雞沙拉", "義式烤雞沙拉"};
        int[] mealPhotoArray = new int[]{R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1,
                R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1, R.drawable.meal1};

        Data[] mealData = new Data[mealNameArray.length];
        for(int i=0 ; i<mealData.length ; i++){
            mealData[i] = new Data();
            mealData[i].name = mealNameArray[i];
            mealData[i].photo = mealPhotoArray[i];
        }

        MyAdapter mealAdapter = new MyAdapter(mealData,R.layout.meal);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(mealAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(chinese.this, meal.class);
                intent.putExtra("mealName", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
}