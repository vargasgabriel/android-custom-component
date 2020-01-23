package br.com.vargas.customcomponents.components;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import br.com.vargas.customcomponents.R;

public class TextAndSubtextTextView extends LinearLayout {

    private String text;
    private int textColor;

    private String subtext;
    private int subtextColor;

    private TextView subtitleTextView;
    private TextView titleTextView;

    public TextAndSubtextTextView(Context context) {
        super(context);
    }

    public TextAndSubtextTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TextAndSubtextTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        int defaultColor = context.getResources().getColor(android.R.color.darker_gray);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextAndSubtextTextView, 0, 0);

        text = a.getString(R.styleable.TextAndSubtextTextView_text);
        textColor = a.getColor(R.styleable.TextAndSubtextTextView_textColor, defaultColor);

        subtext = a.getString(R.styleable.TextAndSubtextTextView_subtext);
        subtextColor = a.getColor(R.styleable.TextAndSubtextTextView_subtextColor, defaultColor);

        a.recycle();

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.text_and_subtext_component, this, true);

        titleTextView = (TextView) getChildAt(0);
        titleTextView.setText(text);
        titleTextView.setTextColor(textColor);

        subtitleTextView = (TextView) getChildAt(1);
        subtitleTextView.setText(subtext);
        subtitleTextView.setTextColor(subtextColor);
    }

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
        titleTextView.setText(newText);
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int newColor) {
        this.textColor = newColor;
        titleTextView.setTextColor(newColor);
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String newSubtext) {
        this.subtext = newSubtext;
        subtitleTextView.setText(newSubtext);
    }

    public int getSubtextColor() {
        return subtextColor;
    }

    public void setSubtextColor(int newColor) {
        this.subtextColor = newColor;
        subtitleTextView.setTextColor(newColor);
    }
}
