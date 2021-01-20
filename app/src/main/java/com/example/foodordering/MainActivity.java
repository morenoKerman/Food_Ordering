package com.example.foodordering;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<String> spAdapter;
    ArrayList<String> spinner_item;
    ListView list;
    ArrayList<String> fastFood, chineseFood, steakRibs, warung;
    ArrayAdapter<String> listAdapter;
    GifImageView gif;
    Button shareBtn;
    ListView shareList;
    ArrayList<String> share = new ArrayList<>();
    ArrayAdapter<String> shareAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        list = findViewById(R.id.list);
        gif = findViewById(R.id.gif);
        shareBtn = findViewById(R.id.shareBtn);
        shareList = findViewById(R.id.shareList);

        shareBtn.setVisibility(View.INVISIBLE);

        spinner_item = new ArrayList<>();
        spinner_item.add("No choice made");
        spinner_item.add("Fast Food");
        spinner_item.add("Chinese Restaurants");
        spinner_item.add("steak & Ribs");
        spinner_item.add("Warung");

        fastFood = new ArrayList<>();
        fastFood.add("KFC");
        fastFood.add("Mc Donald");
        fastFood.add("Popeye");
        fastFood.add("Burger king");

        chineseFood = new ArrayList<>();
        chineseFood.add("Chi-min");
        chineseFood.add("Steak house");
        chineseFood.add("Bamboo Green Garden");
        chineseFood.add("Casa nena");

        steakRibs = new ArrayList<>();
        steakRibs.add("The Garden");
        steakRibs.add("Mighty Rackes");
        steakRibs.add("JiJi's");
        steakRibs.add("Coffee Box");

        warung = new ArrayList<>();
        warung.add("Warung Suzie");
        warung.add("Warung Redjo");
        warung.add("Warung Aliesje");
        warung.add("Warung Alensis");


        spAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, spinner_item);
        spinner.setAdapter(spAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 1){
                    listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, fastFood);
                    gif.setVisibility(View.INVISIBLE);
                }
                if (i == 2){
                    listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, chineseFood);
                    gif.setVisibility(View.INVISIBLE);
                }
                if (i == 3){
                    listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, steakRibs);
                    gif.setVisibility(View.INVISIBLE);
                }
                if (i == 4){
                    listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, warung);
                    gif.setVisibility(View.INVISIBLE);
                }
                list.setAdapter(listAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i <= 5) {
                    String item = list.getSelectedItem().toString();
                    share.add(item);
                    shareAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, share);
                    shareList.setAdapter(shareAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });








    }
}