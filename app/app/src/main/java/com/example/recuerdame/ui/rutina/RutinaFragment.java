package com.example.recuerdame.ui.rutina;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recuerdame.R;
import com.example.recuerdame.databinding.FragmentRutinaBinding;

public class RutinaFragment extends Fragment {

    private FragmentRutinaBinding binding;
    private Button toggleButton;
    private LinearLayout buttonContainer;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RutinaViewModel rutinaViewModel =
                new ViewModelProvider(this).get(RutinaViewModel.class);

        binding = FragmentRutinaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRutina;
        RutinaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        toggleButton = root.findViewById(R.id.toggleButton);
        buttonContainer = root.findViewById(R.id.buttonContainer);

        // Configurar el click listener para toggleButton
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonContainer.getVisibility() == View.VISIBLE) {
                    buttonContainer.setVisibility(View.GONE);
                } else {
                    buttonContainer.setVisibility(View.VISIBLE);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


