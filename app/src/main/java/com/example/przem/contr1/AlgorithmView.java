package com.example.przem.contr1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Konrad on 13.11.2016.
 */

public class AlgorithmView extends View {

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public AlgorithmView(Context context, AttributeSet attrs, int index) {
        super(context, attrs);
        this.index = index;
    }
}
