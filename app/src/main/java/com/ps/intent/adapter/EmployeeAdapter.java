package com.ps.intent.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ps.intent.R;
import com.ps.intent.SecondActivity;
import com.ps.intent.model.EmployeeDTO;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    private List<EmployeeDTO> employeeDTOs;
    private Context context;

    public EmployeeAdapter(List<EmployeeDTO> employeeDTOs, Context context) {
        this.employeeDTOs = employeeDTOs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final EmployeeDTO employeeDTO = employeeDTOs.get(position);
        holder.nameTV.setText(employeeDTO.getName());
        holder.mobileTV.setText(employeeDTO.getMobile());
        holder.emailTV.setText(employeeDTO.getEmail());
        holder.itemLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vEmployeeName=employeeDTOs.get(position).getName();
                Toast.makeText(context, vEmployeeName, Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, SecondActivity.class).putExtra("CITY_NAME",vEmployeeName));
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeDTOs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTV, emailTV, mobileTV;
        private LinearLayout itemLL;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            emailTV = itemView.findViewById(R.id.emailTV);
            mobileTV = itemView.findViewById(R.id.mobileTV);
            itemLL = itemView.findViewById(R.id.itemLL);
        }
    }
}
