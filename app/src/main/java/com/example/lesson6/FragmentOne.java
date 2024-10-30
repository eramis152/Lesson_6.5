package com.example.lesson6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.widget.Button;

public class FragmentOne extends Fragment {

    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        Button buttonOne = view.findViewById(R.id.button_one);
        Button buttonTwo = view.findViewById(R.id.button_two);

        buttonOne.setOnClickListener(v -> viewModel.setMessage("Mensaje enviado"));

        buttonTwo.setOnClickListener(v -> viewModel.setMessage("Mensaje borrado"));

        return view;
    }
}
