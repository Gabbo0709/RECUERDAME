package com.example.recuerdame.ui.rutina;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recuerdame.databinding.FragmentRutinaBinding;

public class RutinaFragment extends Fragment {

    private FragmentRutinaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RutinaViewModel RutinaViewModel =
                new ViewModelProvider(this).get(RutinaViewModel.class);

        binding = FragmentRutinaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRutina;
        com.example.recuerdame.ui.rutina.RutinaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
