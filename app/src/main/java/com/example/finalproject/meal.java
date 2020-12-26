package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class meal extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        textView = findViewById(R.id.textView);
        String[] mealNameArray = new String[]{"大麥克", "雙層牛肉吉事堡", "嫩煎雞腿堡", "麥香雞", "麥克雞塊(6塊)", "麥克雞塊(10塊)", "勁辣雞腿堡", "麥脆雞翅",
                "麥脆雞腿", "黃金起司豬排堡", "麥香魚", "煙燻雞肉長堡", "醬燒豬肉長寶堡", "蕈菇安格斯黑牛堡", "BLT安格斯黑牛堡", "BLT辣脆雞腿堡", "BLT嫩煎雞腿堡", "凱撒辣脆雞沙拉", "義式烤雞沙拉"};
        //textView.setText();
    }
}