package com.example.aacpractice;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.aacpractice.databinding.FragmentSeekbarBinding;
import com.example.aacpractice.viewModel.VmShareViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeekbarFragment extends Fragment {


    public SeekbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seekbar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final VmShareViewModel viewModel = ViewModelProviders.of(requireActivity()).get(VmShareViewModel.class);

        final FragmentSeekbarBinding binding = DataBindingUtil.bind(view);
        binding.setLifecycleOwner(requireActivity());
        binding.setViewModel(viewModel);

        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewModel.progress.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // xml에 data로 variable 만들어서 progress에 값을 넣어줬기 때문에 아래에서 만들었던
        // 옵저브는 없어도 된다.
/*        viewModel.progress.observe(requireActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.seekbar.setProgress(integer);
            }
        });*/
    }
}
