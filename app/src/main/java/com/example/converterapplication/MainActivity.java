package com.example.converterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView autoCompleteTextView1;
    AutoCompleteTextView autoCompleteTextView2;
    TextInputLayout textInputLayout1;
    TextInputLayout textInputLayout2;
    ArrayAdapter<String> itemAdapter1;
    ArrayAdapter<String> itemAdapter2;
    ArrayAdapter<String> itemAdapter3;
    ArrayAdapter<String> itemAdapter4;
    ArrayAdapter<String> itemAdapter5;
    ArrayAdapter<String> itemAdapter6;
    ArrayAdapter<String> itemAdapter7;
    ArrayAdapter<String> itemAdapter8;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String [] items1 = {"km", "m" , "cm", "mm" , "kg", "g", "mg"};
        String [] convert_unit1 = {"m","cm","mm"};
        String [] convert_unit2 = {"g","mg"};
        String [] convert_unit3 = {"km", "cm" , "mm"};
        String [] convert_unit4 = {"km", "m" , "mm"};
        String [] convert_unit5 = {"km", "m" , "cm"};
        String [] convert_unit6 = {"kg","mg"};
        String [] convert_unit7 = {"kg","g"};

        textInputLayout1 = findViewById(R.id.textInputLayout1);
        textInputLayout2 = findViewById(R.id.textInputLayout2);
        autoCompleteTextView1 = findViewById(R.id.drop_items);
        autoCompleteTextView2 = findViewById(R.id.drop_items2);
        itemAdapter1 = new ArrayAdapter<String>(this, R.layout.items_list, items1);
        autoCompleteTextView1.setAdapter(itemAdapter1);
        itemAdapter2 = new ArrayAdapter<String>(this, R.layout.items_list, convert_unit1);
        itemAdapter3 = new ArrayAdapter<String>(this, R.layout.items_list, convert_unit2);
        itemAdapter4 = new ArrayAdapter<String>(this, R.layout.items_list, convert_unit3);
        itemAdapter5 = new ArrayAdapter<String>(this, R.layout.items_list, convert_unit4);
        itemAdapter6 = new ArrayAdapter<String>(this, R.layout.items_list, convert_unit5);
        itemAdapter7 = new ArrayAdapter<String>(this, R.layout.items_list, convert_unit6);
        itemAdapter8 = new ArrayAdapter<String>(this, R.layout.items_list, convert_unit7);
        button = findViewById(R.id.convertBtn);

        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                autoCompleteTextView2.getText().clear();
                if(item == "km"){
                    autoCompleteTextView2.setAdapter(itemAdapter2);
                }
                else if(item == "m"){
                    autoCompleteTextView2.setAdapter(itemAdapter4);
                }
                else if(item == "cm"){
                    autoCompleteTextView2.setAdapter(itemAdapter5);
                }
                else if(item == "mm"){
                    autoCompleteTextView2.setAdapter(itemAdapter6);
                }
                else if(item == "kg"){
                    autoCompleteTextView2.setAdapter(itemAdapter3);
                }
                else if(item == "g"){
                    autoCompleteTextView2.setAdapter(itemAdapter7);
                }
                else if(item == "mg"){
                    autoCompleteTextView2.setAdapter(itemAdapter8);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Select any unit" ,Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = textInputLayout1.getEditText().getText().toString();
                String to = autoCompleteTextView1.getText().toString();
                String from = autoCompleteTextView2.getText().toString();
                Double val = Double.parseDouble(value);
                if(to.equals("km")){
                            if(from.equals("m")){
                        Double ans = val * 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("cm")){
                        Double ans = val * 100000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("mm")){
                        Double ans = val * 1000000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                }
                else if(to.equals("m")){
                    if(from.equals("km")){
                        Double ans = val / 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("cm")){
                        Double ans = val * 100;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("mm")){
                        Double ans = val * 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                }
                else if(to.equals("cm")){
                    if(from.equals("km")){
                        Double ans = val / 100000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("m")){
                        Double ans = val / 100;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("mm")){
                        Double ans = val * 10;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                }
                else if(to.equals("mm")){
                    if(from.equals("km")){
                        Double ans = val / 1000000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("cm")){
                        Double ans = val / 10;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("m")){
                        Double ans = val / 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                }
                else if(to.equals("kg")){
                    if(from.equals("g")){
                        Double ans = val * 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("mg")){
                        Double ans = val * 1000000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                }
                else if(to.equals("g")){
                    if(from.equals("kg")){
                        Double ans = val / 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("mg")){
                        Double ans = val * 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                }
                else if(to.equals("mg")){
                    if(from.equals("kg")){
                        Double ans = val / 1000000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                    else if(from.equals("g")){
                        Double ans = val / 1000;
                        textInputLayout2.getEditText().setText(String.valueOf(ans));
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter valid choice" ,Toast.LENGTH_SHORT).show();
                }

//                Toast.makeText(getApplicationContext(), "Unit : "+to ,Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), "Unit : "+from ,Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), "Value : "+value ,Toast.LENGTH_SHORT).show();
            }
        });

    }
}