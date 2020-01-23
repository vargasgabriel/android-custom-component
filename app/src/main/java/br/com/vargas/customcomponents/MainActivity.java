package br.com.vargas.customcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import br.com.vargas.customcomponents.components.TextWithIconTextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextWithIconTextView text1 = findViewById(R.id.text_1);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "click text1");
                changeStatus(text1);
            }
        });

        final TextWithIconTextView text2 = findViewById(R.id.text_2);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "click text1");
                changeStatus(text2);
            }
        });
    }

    private void changeStatus(TextWithIconTextView text) {
        int atualStatus = text.getStatus();

        switch (atualStatus) {
            case TextWithIconTextView.SUCCESS:
                text.setStatus(TextWithIconTextView.ERROR);
                break;

            case TextWithIconTextView.ERROR:
                text.setStatus(TextWithIconTextView.RUNNING);
                break;

            case TextWithIconTextView.RUNNING:
                text.setStatus(TextWithIconTextView.WAITING);
                break;

            default:
                text.setStatus(TextWithIconTextView.SUCCESS);
        }
    }
}
