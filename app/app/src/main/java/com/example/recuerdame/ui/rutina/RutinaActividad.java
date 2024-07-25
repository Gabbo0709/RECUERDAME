package com.example.recuerdame.ui.rutina;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recuerdame.R;

// Para crear una rutina
public class RutinaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_activity);  // Cargar el layout de la nueva actividad

        // Vincular el EditText del layout
        EditText editTextNumeric = findViewById(R.id.editText2);

        InputFilter rangeFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                try {
                    int input = Integer.parseInt(dest.toString() + source.toString());
                    if (isInRange(1, 99, input)) {
                        return null;
                    }
                } catch (NumberFormatException ignored) {
                }
                return "";
            }

            private boolean isInRange(int min, int max, int input) {
                return input >= min && input <= max;
            }
        };

        editTextNumeric.setFilters(new InputFilter[]{rangeFilter});


    }
}


