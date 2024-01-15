package com.iesaguadulce.pmdmtarea2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.iesaguadulce.pmdmtarea2.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private NavController navController;

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
        navController = Navigation.findNavController(view);
        binding.tfAddress.setVisibility(View.INVISIBLE);
        ((MaterialAutoCompleteTextView) binding.tfCollection.getEditText()).setOnItemClickListener((parent, v, position, id) -> {
            binding.tfCollection.setError("");
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

        binding.btnRegisterNext.setOnClickListener(v -> {
            String name = binding.tfName.getEditText().getText().toString();
            String tlf = binding.tfTlf.getEditText().getText().toString();
            String collection = binding.tfCollection.getEditText().getText().toString();

            if (name.isEmpty()) {
                binding.tfName.setError("El nombre es obligatorio");
                return;
            }

            binding.tfName.setError("");

            if (tlf.isEmpty()) {
                binding.tfTlf.setError("El teléfono es obligatorio");
                return;
            }

            binding.tfTlf.setError("");

            if (tlf.length() != 9) {
                binding.tfTlf.setError("El teléfono debe tener 9 dígitos");
                return;
            }

            binding.tfTlf.setError("");

            if (collection.isEmpty()) {
                binding.tfCollection.setError("La información sobre recogida del pedido es obligatoria");
                return;
            }

            binding.tfCollection.setError("");

            if (binding.tfAddress.getVisibility() == View.VISIBLE) {
                String address = binding.tfAddress.getEditText().getText().toString();
                if (address.isEmpty()) {
                    binding.tfAddress.setError("La dirección es obligatoria");
                    return;
                }
            }

            binding.tfAddress.setError("");
            navController.navigate(R.id.action_registerFragment_to_burgerFragment);
        });
    }
}
