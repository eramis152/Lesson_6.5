package com.example.lesson6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class FragmentTwo extends Fragment {

    private TextView messageTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        messageTextView = view.findViewById(R.id.message_text_view);

        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        viewModel.getMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String message) {
                if (message != null && !message.isEmpty()) {
                    messageTextView.setText(message);
                } else {
                    messageTextView.setText("");
                }
            }
        });

        return view;
    }
}
