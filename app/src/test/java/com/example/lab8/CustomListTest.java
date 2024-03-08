package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private static City mockCity() {
        return new City("Edmonton","Alberta");
    }

    public static CustomList mockCityList() {
        City mockCity = mockCity();
        ArrayList<City> cityListArray = new ArrayList<>();
        cityListArray.add(mockCity);
        CustomList cityList = new CustomList(null, cityListArray);
        return cityList;
    }

    @Test
    void testHasCity() {
        CustomList cityList = mockCityList();
        City city = mockCity();
        cityList.add(city);
        assertTrue(cityList.hasCity(city), "City should be in the list.");
        City newCity = new City("Richmond", "BC");
        assertFalse(cityList.hasCity(newCity), "City should not be in the list.");
    }

    @Test
    void testDelete() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Vancouver", "BC");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testDeleteCityException() {
        CustomList cityList = mockCityList();
        City newCity = new City("Calgary", "AB");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(newCity));
    }

    @Test
    void testCountCities() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Calgary", "AB"));
        assertEquals(2, cityList.countCities());
    }

}
