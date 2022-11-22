package com.example.myapplication.ui.home;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.model.user.User;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;
    private final User user = new User();
    private MutableLiveData<Integer> currentStreakDaysLiveData;

    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
        Resources res = getResources();
        HomeViewModel homeViewModel =
            new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getText().observe(getViewLifecycleOwner(), binding.textHome::setText);

        // Display current streak days
        currentStreakDaysLiveData = new MutableLiveData<>();
        currentStreakDaysLiveData.setValue(user.getCurrentStreakDays());
        currentStreakDaysLiveData.observe(getViewLifecycleOwner(),
            currentStreakDays -> binding.currentStreakDays.setText(
                String.format(res.getString(R.string.currentStreakDaysDisplay),
                    currentStreakDays)));

        // Initialize Buttons
        ImageButton incrementStreakButton = root.findViewById(
            R.id.incrementStreakButton);
        incrementStreakButton.setOnClickListener(this);
        ImageButton resetStreakButton = root.findViewById(R.id.resetStreakButton);
        resetStreakButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.incrementStreakButton) {
            user.incrementCurrentStreakDays();
        } else if (view.getId() == R.id.resetStreakButton) {
            user.resetCurrentStreakDays();
        }
        currentStreakDaysLiveData.setValue(user.getCurrentStreakDays());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}