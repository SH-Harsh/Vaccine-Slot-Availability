package com.example.cowinslot.Network;


import com.example.cowinslot.Network.ServerResponse.SlotResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyCalls {

    @GET("findByDistrict")
    Call<SlotResponse> slotcall(
            @Query("district_id") String district_id,
            @Query("date") String date
    );

}

//district_id={district_id}&date={date}
