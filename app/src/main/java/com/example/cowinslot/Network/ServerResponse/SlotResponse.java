package com.example.cowinslot.Network.ServerResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SlotResponse {

    @SerializedName("sessions")
    @Expose
    private List<Sessions> serverResponse = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<Sessions> getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(List<Sessions> serverResponse) {
        this.serverResponse = serverResponse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Sessions {

        @Expose
        private int center_id;
        @Expose
        private String name;
        @Expose
        private String address;
        @Expose
        private String state_name;
        @Expose
        private String district_name;
        @Expose
        private String block_name;
        @Expose
        private int pincode;
        @Expose
        private String from;
        @Expose
        private String to;
        @Expose
        private int lat;

        @SerializedName("long")
        @Expose
        private int lon;
        @Expose
        private String fee_type;
        @Expose
        private String session_id;
        @Expose
        private String date;
        @Expose
        private int available_capacity_dose1;
        @Expose
        private int available_capacity_dose2;
        @Expose
        private int available_capacity;
        @Expose
        private String fee;
        @Expose
        private int min_age_limit;
        @Expose
        private String vaccine;
        @Expose
        private String[] slots;

        public int getCenter_id() {
            return center_id;
        }

        public void setCenter_id(int center_id) {
            this.center_id = center_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getState_name() {
            return state_name;
        }

        public void setState_name(String state_name) {
            this.state_name = state_name;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public String getBlock_name() {
            return block_name;
        }

        public void setBlock_name(String block_name) {
            this.block_name = block_name;
        }

        public int getPincode() {
            return pincode;
        }

        public void setPincode(int pincode) {
            this.pincode = pincode;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public int getLat() {
            return lat;
        }

        public void setLat(int lat) {
            this.lat = lat;
        }

        public int getLon() {
            return lon;
        }

        public void setLon(int lon) {
            this.lon = lon;
        }

        public String getFee_type() {
            return fee_type;
        }

        public void setFee_type(String fee_type) {
            this.fee_type = fee_type;
        }

        public String getSession_id() {
            return session_id;
        }

        public void setSession_id(String session_id) {
            this.session_id = session_id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getAvailable_capacity_dose1() {
            return available_capacity_dose1;
        }

        public void setAvailable_capacity_dose1(int available_capacity_dose1) {
            this.available_capacity_dose1 = available_capacity_dose1;
        }

        public int getAvailable_capacity_dose2() {
            return available_capacity_dose2;
        }

        public void setAvailable_capacity_dose2(int available_capacity_dose2) {
            this.available_capacity_dose2 = available_capacity_dose2;
        }

        public int getAvailable_capacity() {
            return available_capacity;
        }

        public void setAvailable_capacity(int available_capacity) {
            this.available_capacity = available_capacity;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public int getMin_age_limit() {
            return min_age_limit;
        }

        public void setMin_age_limit(int min_age_limit) {
            this.min_age_limit = min_age_limit;
        }

        public String getVaccine() {
            return vaccine;
        }

        public void setVaccine(String vaccine) {
            this.vaccine = vaccine;
        }

        public String[] getSlots() {
            return slots;
        }

        public void setSlots(String[] slots) {
            this.slots = slots;
        }
    }
}
