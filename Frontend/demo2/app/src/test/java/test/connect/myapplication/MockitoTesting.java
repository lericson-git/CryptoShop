package test.connect.myapplication;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import test.connect.myapplication.model.Post;


public class MockitoTesting {
    @Test
    // Shouldn't be listed before post is created
    public void test_bothListedBefore() {
        activity_sell spySell = spy(activity_sell.class);
        assertEquals(spySell.getListed(), Boolean.FALSE);
    }
    @Test
    // Should be listed after post is created
    public void test_bothListedAfter() {
        activity_sell spySell = spy(activity_sell.class);
        Post ex = new Post("Novel", 20, "Shakespear Drama");

        spySell.setPost(ex);
        verify(spySell).setPost(ex);
        assertEquals(spySell.getListed(), Boolean.TRUE);
    }
    @Test

    public void test_samePost() {
        activity_sell spySell = spy(activity_sell.class);
        Post ex = new Post("Drama", 20, "Wizard and Oz");

        spySell.setPost(ex);
        verify(spySell).setPost(ex);
        assertEquals(spySell.getPost(), ex);
    }
    @Test

    public void test_notsamePost() {
        activity_sell spySell = spy(activity_sell.class);
        Post ex = new Post("Book", 50, "Huck Finn: Adventure");

        spySell.setPost(ex);
        verify(spySell).setPost(ex);
        assertEquals(spySell.getPost(), ex);
    }
    @Test
    // Shouldn't be listed before post is created
    public void test_bothListedBeforetheClass() {
        activity_sell spySell = spy(activity_sell.class);
        assertEquals(spySell.getListed(), Boolean.FALSE);
    }





}



