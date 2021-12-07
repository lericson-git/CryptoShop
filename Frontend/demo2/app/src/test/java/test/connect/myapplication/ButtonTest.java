package test.connect.myapplication;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import test.connect.myapplication.model.Post;

public class ButtonTest {
    private static final String CHINA_SYMBOL = "table tennis";
    private Instrumentation mInstrumentation;
    private Activity mActivity;
    private EditText mEditText;
    private Button mButtonOk;
    private ImageButton mButtonCancel;
    private TextView mSymbolTextView;
    private TextView mWarningTextView;
    @Before
    public void setup() {

        mEditText = (EditText) mActivity.findViewById(R.id.etnidk);
        mButtonOk = (Button) mActivity.findViewById(R.id.btnclickmepls);
        mButtonCancel = (ImageButton) mActivity.findViewById(R.id.btnnike);
    }
    @Test
            public void firstTest() {

        mButtonOk.setClickable(true);
        assertTrue(mButtonOk.isClickable());
//        View.OnClickListener okButtonListener = spy(new MockOnClickOkListener());
//        mButtonOk.setOnClickListener(okButtonListener);
//        mButtonOk.performClick();
//        verify(okButtonListener, times(1)).onClick(mButtonOk);
//        mButtonCancel.setClickable(false);
//        assertFalse(mButtonCancel.isClickable());
//        View.OnClickListener cancelButtonListener = mock(View.OnClickListener.class);
//        doAnswer((InvocationOnMock invocation) -> {
//            mEditText.setText(null);
//            return null;
//        }).when(cancelButtonListener).onClick(any(View.class));
//        mButtonCancel.setOnClickListener(cancelButtonListener);
//        assertTrue(mButtonCancel.isClickable());
//        mButtonCancel.performClick();
//        verify(cancelButtonListener, times(1)).onClick(mButtonCancel);
    }



}
