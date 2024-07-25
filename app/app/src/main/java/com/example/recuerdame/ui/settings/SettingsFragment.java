package com.example.recuerdame.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recuerdame.databinding.FragmentSettingsBinding;
import com.example.recuerdame.ui.settings.SettingsViewModel;

public class SettingsFragment extends Fragment {
    private SettingsViewModel settingsViewModel;
    private FragmentSettingsBinding binding;

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        final TextView textView = binding.textConfinguracion;

        // Corrección aquí
        settingsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}
