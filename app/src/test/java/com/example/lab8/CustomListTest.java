package com.example.lab8;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void setUp(){
        // Initialize your CustomList with an empty list before each test
        list = new CustomList(null, new ArrayList<>());
    }

    @Test
    public void hasCity_WhenCityExists_ShouldReturnTrue() {
        City city = new City("Regina", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void hasCity_WhenCityDoesNotExist_ShouldReturnFalse() {
        City city = new City("Saskatoon", "SK");
        assertFalse(list.hasCity(city));
    }

    @Test
    public void deleteCity_WhenCityExists_ShouldRemoveCity() {
        City city = new City("Moose Jaw", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));

        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    public void countCities_ShouldReturnCorrectCount() {
        assertEquals(0, list.countCities());

        list.addCity(new City("Prince Albert", "SK"));
        assertEquals(1, list.countCities());

        list.addCity(new City("Swift Current", "SK"));
        assertEquals(2, list.countCities());

        list.deleteCity(new City("Prince Albert", "SK"));
        assertEquals(1, list.countCities());
    }

}
