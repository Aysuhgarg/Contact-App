package com.example.fragmentwithrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    TextView tvName,tvTel;
    EditText etName,etTel;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;
    public static ArrayList<Person> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName=findViewById(R.id.tvName);
        tvTel=findViewById(R.id.tvTel);
        etName=findViewById(R.id.etName);
        etTel=findViewById(R.id.etTel);
        btnAdd=findViewById(R.id.btnAdd);
        fragmentManager=this.getSupportFragmentManager();
        listFrag=(ListFrag)fragmentManager.findFragmentById(R.id.listFrag);

        people=new ArrayList<Person>();
        people.add(new Person("Ayush","657437577"));
        people.add(new Person("Ayush","456577479876"));
        people.add(new Person("Chuck","098765343"));
        people.add(new Person("Tom","98765438"));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etName.getText().toString().isEmpty()||etTel.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter your Name and phone number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    people.add(new Person(etName.getText().toString().trim(),etTel.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Contact is Successfully Added", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etTel.setText(null);
                    listFrag.notifyDataChange();
                }

            }
        });

        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {

        tvName.setText(people.get(index).getName());
        tvTel.setText(people.get(index).getTelnr());
    }
}
