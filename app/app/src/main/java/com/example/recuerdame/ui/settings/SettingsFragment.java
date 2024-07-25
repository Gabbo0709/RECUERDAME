package com.example.recuerdame.ui.settings;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.recuerdame.R;

public class SettingsFragment extends Fragment {

    private Switch switchDarkMode;
    private Switch switchContrastMode;
    private Button buttonAdjustFontSize;
    private EditText edittextChangeName;
    private EditText edittextChangeDate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        // Inicializar los elementos de la vista
        switchDarkMode = root.findViewById(R.id.switchDarkMode);
        switchContrastMode = root.findViewById(R.id.switchContrastMode);
        buttonAdjustFontSize = root.findViewById(R.id.buttonAdjustFontSize);
        edittextChangeName = root.findViewById(R.id.edittextChangeName);
        edittextChangeDate = root.findViewById(R.id.edittextChangeDate);

        // Asignar listeners a los elementos
        switchDarkMode.setOnClickListener(v ->
                Toast.makeText(getContext(), "Modo oscuro activado/desactivado", Toast.LENGTH_SHORT).show()
        );

        switchContrastMode.setOnClickListener(v ->
                Toast.makeText(getContext(), "Modo alto contraste activado/desactivado", Toast.LENGTH_SHORT).show()
        );

        buttonAdjustFontSize.setOnClickListener(v ->
                Toast.makeText(getContext(), "Ajustar tamaño de letra", Toast.LENGTH_SHORT).show()
        );

        edittextChangeName.setOnClickListener(v ->
                Toast.makeText(getContext(), "Cambiar Nombre de Usuario", Toast.LENGTH_SHORT).show()
        );

        edittextChangeDate.setOnClickListener(v ->
                Toast.makeText(getContext(), "Cambiar Fecha de Nacimiento", Toast.LENGTH_SHORT).show()
        );

        return root;
    }
}
