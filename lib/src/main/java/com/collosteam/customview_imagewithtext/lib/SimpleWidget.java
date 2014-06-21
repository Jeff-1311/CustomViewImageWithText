package com.collosteam.customview_imagewithtext.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * On this we write all logic and data for work with our custom view
 */
public class SimpleWidget extends LinearLayout {

    private static final String TAG = "{SimpleWidget}" ;
    ImageView imageView;
    TextView textView;

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
        if (imageView != null) {
            imageView.setImageResource(imageResource);
            invalidate();
        }

    }

    public void setColorBackgraund(int colorBackgraund) {
        this.colorBackgraund = colorBackgraund;
        if (imageView != null) {
            imageView.setBackgroundResource(colorBackgraund);
            invalidate();
        }
    }

    public void setText(CharSequence text) {
        this.text = text;
        if (textView != null) {
            textView.setText(text);
            invalidate();
        }
    }

    int imageResource = R.drawable.ic_launcher;
    int colorBackgraund = R.color.yellow;
    CharSequence text;


    public SimpleWidget(Context context) {
        super(context);
        init(null);
    }

    public SimpleWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public SimpleWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    View v;
    public void init(AttributeSet attributeSet) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.layout_view, this);

        imageView = (ImageView) v.findViewById(R.id.imageView);
        textView = (TextView) v.findViewById(R.id.textView);

        if (attributeSet != null) {
            TypedArray a = getContext().obtainStyledAttributes(attributeSet, R.styleable.SimpleWidget);

            this.imageResource = a.getInt(R.styleable.SimpleWidget_simpleImage, R.drawable.ic_launcher);
            if (imageResource > 0) {
                setImageResource(imageResource);
            }


            this.colorBackgraund = a.getInt(R.styleable.SimpleWidget_simpleBack, R.color.yellow);
            if (colorBackgraund > 0) {
                setColorBackgraund(colorBackgraund);
            }

            this.text = a.getString(R.styleable.SimpleWidget_simpleString);
            textView.setText(text);

            invalidate();
        }


    }
}
