package com.example.cowinslot.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cowinslot.Adapter.SlotAdapter;
import com.example.cowinslot.Network.MyBase;
import com.example.cowinslot.Network.MyCalls;
import com.example.cowinslot.Network.ServerResponse.SlotResponse;
import com.example.cowinslot.R;
import com.example.cowinslot.databinding.ActivityMainBinding;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private SlotAdapter adapter;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        intilization();
        setup();
        onClickListner();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id == android.R.id.home){
            alertMethod();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        alertMethod();
    }

    private void alertMethod() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit Alert!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Are you sure want to exit");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            finishAffinity();
        });

        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.setCancelable(false);
        builder.show();
    }

    private void intilization() {

        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK,1);
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = dateFormat.format(calendar.getTime());

        Log.d("Date", "intilization: " + date);


    }

    private void setup() {

        retrofitLoginCall();
//        setrcv();
    }

    private void retrofitLoginCall() {

        activityMainBinding.llProgressBar.setVisibility(View.VISIBLE);
        MyCalls myCalls = MyBase.getMyBase().create(MyCalls.class);
        Call<SlotResponse> call =myCalls.slotcall("770",date);

        call.enqueue(new Callback<SlotResponse>() {
            @Override
            public void onResponse(Call<SlotResponse> call, Response<SlotResponse> response) {

                activityMainBinding.llProgressBar.setVisibility(View.GONE);
                Log.d("Response", "onResponse: "  + response);
                if(response.isSuccessful()){
//                    if(response.body().getStatus().equals("200")){
//                        Toast.makeText(MainActivity.this, "Successfully Called", Toast.LENGTH_SHORT).show();

                        setData(response.body().getServerResponse());
//                    }else if(response.body().getStatus().equals("200")){
//                        Toast.makeText(MainActivity.this, "User not found", Toast.LENGTH_SHORT).show();
//                    }
                }else{
                    Toast.makeText(MainActivity.this, "Something went wrong, please try again later", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SlotResponse> call, Throwable t) {
                activityMainBinding.llProgressBar.setVisibility(View.GONE);
                if (t instanceof IOException) {
                    Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setData(List<SlotResponse.Sessions> serverResponse) {

        activityMainBinding.rcvDisplay.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        activityMainBinding.rcvDisplay.setAdapter(new SlotAdapter(serverResponse,MainActivity.this));

    }

    private void setrcv() {

//        activityMainBinding.rcvDisplay.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
//        adapter = new SlotAdapter();
//        activityMainBinding.rcvDisplay.setAdapter(adapter);
    }

    private void onClickListner() {

        activityMainBinding.btnRefresh.setOnClickListener(v -> {
            retrofitLoginCall();
        });
    }
}