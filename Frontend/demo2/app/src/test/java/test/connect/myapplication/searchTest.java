package test.connect.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import static org.mockito.Mockito.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class searchTest {
    @Test
    public void test_ListViewAdapter() {
        activity_search mockSearch = mock(activity_search.class);
        activity_search search = new activity_search();

        LayoutInflater inflater = mock(LayoutInflater.class);
        ViewGroup container = mock(ViewGroup.class);
        Bundle savedInstanceState = mock(Bundle.class);
        View view = mockSearch.onCreateView(inflater, container, savedInstanceState);

        

        ListViewAdapter adapter = spy(ListViewAdapter.class);

    }
}