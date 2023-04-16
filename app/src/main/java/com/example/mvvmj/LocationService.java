package com.example.mvvmj;


import android.location.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 定位功能 (location service)
public class LocationService {
    //create list for storing the data of point.
    ArrayList<HashMap<String,Double>> pointList = new ArrayList<HashMap<String,Double>>();
    // inital the the data of points
    public void LocationService(ArrayList<HashMap<String,Double>> pointList){
        this.pointList = pointList;
    }
    public void LocationService(){

    }

    public HashMap<String,Double> getLocationFromAddress(String address){
        return null;
    }
    public String getAddressFromLocation(int index){
        return null;
    }

    public String getAddressFromLocation(HashMap<String,Double> point){
        return null;
    }

    public HashMap<String,Double> AddressToLocation(){
        return null;
    }
    public String LocationToAddress(){
        return null;
    }

    public Double getDistanceBetweenTwoPoints(ArrayList<HashMap<String,Double>> twoPointList){
        return null;
    }


}
