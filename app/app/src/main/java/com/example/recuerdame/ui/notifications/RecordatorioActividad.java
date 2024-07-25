package com.example.recuerdame.ui.notifications;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recuerdame.R;

// Para crear una recordatorio
public class RecordatorioActividad extends AppCompatActivity {

    private ViewGroup container; // Define container aquí
    private int subformCount = 0; // Define subformCount aquí

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordatorio_actividad);  // Cargar el layout de la nueva actividad

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

        // Configurar el botón de retroceso
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar la actividad actual y regresar
                finish();
            }
        });

        // Inicializar el contenedor
        container = findViewById(R.id.container);

        // Configurar el botón para añadir subformularios
        Button btnAddSubform = findViewById(R.id.btn_add_subform);
        btnAddSubform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubform();
            }
        });
    }

    private void addSubform() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View subform = inflater.inflate(R.layout.sub_formularios, container, false);

        // Asignar IDs únicos a los EditTexts si es necesario
        EditText etField1 = subform.findViewById(R.id.et_field1);
        EditText etField2 = subform.findViewById(R.id.et_field2);
        etField1.setId(View.generateViewId());
        etField2.setId(View.generateViewId());

        // Añadir listener de cambio de enfoque para minimizar otros subformularios
        View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    minimizeOtherSubforms(subform);
                }
            }
        };
        etField1.setOnFocusChangeListener(focusChangeListener);
        etField2.setOnFocusChangeListener(focusChangeListener);

        container.addView(subform);
        subformCount++;
    }

    private void minimizeOtherSubforms(View focusedSubform) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View subform = container.getChildAt(i);
            if (subform != focusedSubform) {
                subform.setVisibility(View.GONE);
            } else {
                subform.setVisibility(View.VISIBLE);
            }
        }
    }
}
