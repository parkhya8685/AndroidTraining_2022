package com.ps.intent;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ps.intent.adapter.EmployeeAdapter;
import com.ps.intent.model.EmployeeDTO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
    private RecyclerView employeeRV;
    private EditText nameET,emailET,mobileET;
    private Button addNameBT;
    private ArrayList<EmployeeDTO> listItem;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        initializeViews();
    }

    private void initializeViews() {
        employeeRV = findViewById(R.id.employeeRV);
        nameET = findViewById(R.id.nameET);
        mobileET = findViewById(R.id.mobileET);
        emailET = findViewById(R.id.emailET);
        addNameBT = findViewById(R.id.addNameBT);
        setEmployeeAdapter();
        addNameBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameET.getText().toString().trim().length() == 0) {
                    Toast.makeText(FirstActivity.this, "Enter Name.", Toast.LENGTH_SHORT).show();
                } else {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setName(nameET.getText().toString().trim());
                    employeeDTO.setEmail(emailET.getText().toString().trim());
                    employeeDTO.setMobile(mobileET.getText().toString().trim());

                    listItem.add(employeeDTO);
                    nameET.setText("");
                    employeeAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void setEmployeeAdapter() {
        listItem = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(listItem, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        employeeRV.setLayoutManager(mLayoutManager);
        employeeRV.setItemAnimator(new DefaultItemAnimator());
        employeeRV.setAdapter(employeeAdapter);
    }
}