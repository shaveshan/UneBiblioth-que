package com.shaveshan.fontawsomeaddtomyapp;
        import android.annotation.SuppressLint;
        import androidx.annotation.Nullable;
        import android.content.Context;
        import android.graphics.Typeface;
        import android.util.AttributeSet;
        import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class MyTextViewFontAwesome extends TextView {

    public MyTextViewFontAwesome(Context c) {
        super(c);
        init();
    }

    public MyTextViewFontAwesome(Context c , @Nullable AttributeSet attrs) {
        super(c , attrs);
        init();
    }

    public MyTextViewFontAwesome(Context c, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(c, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setTypeface(
                Typeface.createFromAsset(
                        getContext().getAssets(),
                        "fonts/solid.ttf"
                )
        );

    }
}