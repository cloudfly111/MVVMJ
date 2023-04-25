package com.example.mvvmj;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 定位功能 (location service)
// 經緯度地址互相轉換
// 兩點直線距離
public class LocationService {
    //create list for storing the data of point.
    ArrayList<HashMap<String,Double>> pointList = new ArrayList<HashMap<String,Double>>();
    //coder for geographic data processing
    private Geocoder geoCoder;
    // limit number of coder result
    public int maxResultNum = 5;

    // inital the the data of points and coder
    public void LocationService(ArrayList<HashMap<String,Double>> pointList, Context context){
        this.pointList = pointList;
        geoCoder = getGeoCoder(context);
    }
    //inital coder
    public void LocationService(Context context){
        geoCoder = getGeoCoder(context);
    }
    //create coder for geographic data processing
    private Geocoder getGeoCoder(Context context){
        Geocoder geoCoder = new Geocoder(context);
        return geoCoder;
    }

    //get location infor from address
    public Address getLocationFromAddress(String address) {
        return AddressToLocation(address).get(0);
    }
    //get address from location list
    public String getAddressFromLocation(int index){
        return LocationToAddress(pointList.get(index)).get(0).getAddressLine(0);
    }
    //get address from the input of location data
    public String getAddressFromLocation(HashMap<String,Double> point){
        return LocationToAddress(point).get(0).getAddressLine(0);
    }
    // transfer address to location
    public List<Address> AddressToLocation(String address){
        try {
            List<Address> locationList = geoCoder.getFromLocationName(address, maxResultNum);
            return locationList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // transfer location to address
    public List<Address> LocationToAddress(HashMap<String,Double> point){
        try {
            List<Address> locationList =geoCoder.getFromLocation(point.get("latitude"),point.get("longitude"),maxResultNum);
            return locationList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // get the distance from list containing two point data
    public Double getDistanceBetweenTwoPoints(ArrayList<HashMap<String,Double>> twoPointList){
        float[] distanceResults = new float[3];
        Location.distanceBetween(twoPointList.get(0).get("latitude"),twoPointList.get(0).get("longitude")
                ,twoPointList.get(1).get("latitude"),twoPointList.get(1).get("longitude"),distanceResults);
        return Double.valueOf(distanceResults[0]);
    }


}
