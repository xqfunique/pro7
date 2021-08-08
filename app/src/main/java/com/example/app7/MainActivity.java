package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textToSpeech = new TextToSpeech(this, status -> {
            try {
                textToSpeech.setLanguage(Locale.UK);
                button.setOnClickListener(v -> {
                    String extractedValue = editText.getText().toString().trim();
                    textToSpeech.speak(extractedValue, TextToSpeech.QUEUE_FLUSH, null);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}