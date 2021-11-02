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

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class sellTest {

    @Test
    //Spy posting should be same as regular posting
    public void test_samePost() {
        activity_sell spySell = spy(activity_sell.class);
        Post ex = new Post("Book", 20, "Harry Potter: Goblet of Fire");

        spySell.setPost(ex);
        verify(spySell).setPost(ex);
        assertEquals(spySell.getPost(), ex);
    }

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
        Post ex = new Post("Book", 20, "Harry Potter: Goblet of Fire");

        spySell.setPost(ex);
        verify(spySell).setPost(ex);
        assertEquals(spySell.getListed(), Boolean.TRUE);
    }
}