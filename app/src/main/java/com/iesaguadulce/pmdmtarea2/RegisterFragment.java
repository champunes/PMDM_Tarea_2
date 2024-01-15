package com.iesaguadulce.pmdmtarea2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.iesaguadulce.pmdmtarea2.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRegisterBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tfAddress.setVisibility(View.INVISIBLE);
        ((MaterialAutoCompleteTextView) binding.tfCollection.getEditText()).setOnItemClickListener((parent, v, position, id) -> {
            switch (position) {
                case 0:
                    binding.tfAddress.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    binding.tfAddress.setVisibility(View.INVISIBLE);
                    break;
            }
        });

        binding.btnRegisterClear.setOnClickListener(v -> {
            binding.tfName.getEditText().setText("");
            binding.tfTlf.getEditText().setText("");
            binding.tfAddress.getEditText().setText("");
            binding.tfCollection.getEditText().setText("");
        });
    }
}
