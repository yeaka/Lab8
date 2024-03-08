package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List getCities() {
        List list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Counts the number of cities in the list
     * @return The number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
    /**
     * Removes a city from the list
     * @param city to be removed
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City isn't in the list");
        }
        cities.remove(city);
    }

    /**
     * Checks if the city is in the list
     * @param city to check for presence in the list
     * @return true if the list is in the city
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }




}
