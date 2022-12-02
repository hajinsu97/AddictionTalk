package com.addictiontalk.ui.logs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.addictiontalk.databinding.FragmentLogBinding;
import com.addictiontalk.model.user.CravingLog;
import java.util.ArrayList;
import java.util.Arrays;

public class LogFragment extends Fragment {

    private FragmentLogBinding binding;
    private final CravingLog cravingLog = new CravingLog();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        LogViewModel logViewModel = new ViewModelProvider(this).get(LogViewModel.class);

        binding = FragmentLogBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Setup TextWatchers for each EditText in the log
        ArrayList<EditText> editTextList = new ArrayList<>(
            Arrays.asList(binding.editTextDate, binding.editTextLocation, binding.editTextCraving,
                binding.editTextCost));
        for (EditText editText : editTextList) {
            editText.addTextChangedListener(new CravingLogTextWatcher(cravingLog, editText));
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}