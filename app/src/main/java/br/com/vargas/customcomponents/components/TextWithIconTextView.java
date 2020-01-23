package br.com.vargas.customcomponents.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.vargas.customcomponents.R;

public class TextWithIconTextView extends LinearLayout  {

    private ImageView icon;
    private Drawable iconError;
    private Drawable iconRunning;
    private Drawable iconSuccess;
    private Drawable iconWaiting;

    private int status;
    public static final int WAITING = 0;
    public static final int RUNNING = 1;
    public static final int SUCCESS = 2;
    public static final int ERROR = 3;
    private String text;
    private TextView titleTextView;

    public TextWithIconTextView(Context context) {
        super(context);
    }

    public TextWithIconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TextWithIconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextWithIconTextView, 0, 0);
        text = a.getString(R.styleable.TextWithIconTextView_text);
        iconError = a.getDrawable(R.styleable.TextWithIconTextView_iconError);
        iconRunning = a.getDrawable(R.styleable.TextWithIconTextView_iconRunning);
        iconSuccess = a.getDrawable(R.styleable.TextWithIconTextView_iconSuccess);
        iconWaiting = a.getDrawable(R.styleable.TextWithIconTextView_iconWaiting);

        status = a.getInt(R.styleable.TextWithIconTextView_status, 0);

        a.recycle();


        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.text_with_icon_component, this, true);

        titleTextView = (TextView) getChildAt(0);
        titleTextView.setText(text);

        icon = (ImageView) getChildAt(1);
        setIconStatus();

    }

    private void setIconStatus() {
        switch (status) {
            case SUCCESS:
                icon.setImageDrawable(iconSuccess);
                break;

            case ERROR:
                icon.setImageDrawable(iconError);
                break;

            case RUNNING:
                icon.setImageDrawable(iconRunning);
                break;

            default:
                icon.setImageDrawable(iconWaiting);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        this.text = newText;
        titleTextView.setText(newText);
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int newStatus) {
        this.status = newStatus;
        setIconStatus();
    }


}
