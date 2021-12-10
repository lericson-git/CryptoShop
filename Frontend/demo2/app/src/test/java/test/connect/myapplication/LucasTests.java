package test.connect.myapplication;

import static org.mockito.Mockito.spy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import org.junit.Test;
import static org.junit.Assert.*;

import test.connect.myapplication.model.Product;
import test.connect.myapplication.model.User;

public class LucasTests {
    @Test
    public void testUserParcel() {
        //Creating spy users
        User spyUser = spy(new User());
        spyUser.setName("John Doe");

        //Testing Parcelable Implementation
        Parcelable parcelUser = (Parcelable) spyUser;
        assertEquals((User) parcelUser, spyUser);
    }

    @Test
    public void testProductParcel() {
        //Creating spy products
        Product spyProd = spy(new Product());
        spyProd.setName("Corvette C14");

        //Testing Parcelable Implementation
        Parcelable parcelProd = (Parcelable) spyProd;
        assertEquals((Product) parcelProd, spyProd);
    }

    @Test
    public void testSearch() {
        //Create spy search_activity
        activity_search spySearch = spy(activity_search.class);

        //Test static method
        activity_search.addProduct(new Product());
        assertNotNull(spySearch.productList.get(0));
    }
}
