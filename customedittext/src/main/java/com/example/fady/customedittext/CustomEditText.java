package com.example.fady.customedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class CustomEditText extends LinearLayout {
    EditText etRowText;
    TextView tvRowHint;
    ImageView imgRowIcon;
    Button btnHit;


    public CustomEditText(Context context) {
        super(context);
        initView(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        attrebutes(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        attrebutes(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
        attrebutes(context, attrs);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_edittext_view, this);
        tvRowHint = findViewById(R.id.tvRowHint);
        etRowText = findViewById(R.id.etRowText);
        imgRowIcon = findViewById(R.id.imgRowIcon);
        btnHit = findViewById(R.id.btnHit);
    }

    private void attrebutes(Context context, AttributeSet attributeSet) {
//        TypedArray styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.UserProfileCustomRowView);

        TypedArray styleAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.custom_style);
        if (styleAttributes.hasValue(R.styleable.custom_style_rowHint)) {
            tvRowHint = findViewById(R.id.tvRowHint);
            tvRowHint.setText(styleAttributes.getString(R.styleable.custom_style_rowHint));
        }
        if (styleAttributes.hasValue(R.styleable.custom_style_rowIcon)) {
            imgRowIcon = findViewById(R.id.imgRowIcon);
            setImageIcon(styleAttributes.getResourceId(R.styleable.custom_style_rowIcon, -1));
        }

    }

    private void setImageIcon(int img) {
        imgRowIcon.setImageResource(img);
    }
}

