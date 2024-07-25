package com.example.recuerdame.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.example.recuerdame.R;
import com.example.recuerdame.dao.DatosUsuario;
import com.example.recuerdame.modelos.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kotlinx.coroutines.scheduling.Task;

public class SettingsFragment extends Fragment {

    private Switch switchDarkMode;
    private Switch switchContrastMode;
    private Button buttonAdjustFontSize;
    private EditText edittextChangeName;
    private EditText edittextChangeDate;
    private Button buttonSavedChanges;

    private DatosUsuario datosUsuario;
    private Usuario usuario;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);


        // Inicializar los elementos de la vista
        switchDarkMode = root.findViewById(R.id.switchDarkMode);
        switchContrastMode = root.findViewById(R.id.switchContrastMode);
        buttonAdjustFontSize = root.findViewById(R.id.buttonAdjustFontSize);
        edittextChangeName = root.findViewById(R.id.edittextChangeName);
        edittextChangeDate = root.findViewById(R.id.edittextChangeDate);
        buttonSavedChanges = root.findViewById(R.id.buttonSavedChanges);

        datosUsuario = new DatosUsuario(getContext());
        usuario = datosUsuario.leerUsuario();

        cargarConfiguracion();
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) ->{
            Toast.makeText(getContext(), "Modo oscuro en proximas versiones", Toast.LENGTH_SHORT).show();
          /*
            if(isChecked){
              AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
          }else{
              AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
          }*/
        });
        switchContrastMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(getContext(), "Modo alto contraste en proximas versiones", Toast.LENGTH_SHORT).show();
        });

        buttonAdjustFontSize.setOnClickListener(v ->
                Toast.makeText(getContext(), "Ajustar tamaño de letra en proximas versiones", Toast.LENGTH_SHORT).show()
        );

        buttonSavedChanges.setOnClickListener(v -> guardarCambios());

        return root;
    }

    private void cargarConfiguracion() {
        switchDarkMode.setChecked(datosUsuario.obtenerModoOscuro());
        switchContrastMode.setChecked(datosUsuario.obtenerAltoContraste());
        edittextChangeName.setText(usuario.getNombre());
        edittextChangeDate.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(usuario.getFechaNacimiento()));
    }

    private void guardarCambios() {
        String nuevoNombre = edittextChangeName.getText().toString();
        String nuevaFechaStr = edittextChangeDate.getText().toString();

        usuario.setNombre(nuevoNombre);
        Toast.makeText(getContext(), "Cambios guardados"+usuario.getNombre(), Toast.LENGTH_SHORT).show();

        try {
            Date nuevaFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(nuevaFechaStr);
            if (nuevaFecha != null) {
                usuario.setFechaNacimiento(nuevaFecha);
                datosUsuario.guardarUsuario(usuario);
                Toast.makeText(getContext(), "Cambios guardados"+usuario.getFechaNacimiento(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Fecha de nacimiento no válida", Toast.LENGTH_SHORT).show();
            }
        } catch (ParseException e) {
            Toast.makeText(getContext(), "Formato de fecha no válido. Use dd/MM/yyyy", Toast.LENGTH_SHORT).show();
        }
    }
}
