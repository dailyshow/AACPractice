package com.example.aacpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.aacpractice.databinding.ActivityMainBinding;
import com.example.aacpractice.databinding.ActivityViewmodelBinding;
import com.example.aacpractice.viewModel.CounterViewModel;

public class ViewModelActivity extends AppCompatActivity {
    ActivityViewmodelBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel);

        // 아래 코드를 작성하면 데이터가 변경되어도 알아서 라이프사이클을 참조해 갱신해서 보여주도록 해준다.
        mainBinding.setLifecycleOwner(this);

        final CounterViewModel viewModel = ViewModelProviders.of(this).get(CounterViewModel.class);

        // viewModel을 binding에 꽂아준다.
        mainBinding.setViewModel(viewModel);


        // livedata 추가하면 아래 코드는 필요 없어진다.
//        mainBinding.countTextView.setText(viewModel.counter.getValue() + "");

        // xml에서 onclick 속성을 사용하면 아래 코드도 없앨 수 있다.
/*        mainBinding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.increase();
                // livedata 추가하면 아래 코드는 필요 없어진다.
//                mainBinding.countTextView.setText(viewModel.counter.getValue() + "");
            }
        });*/

        // xml에서 onclick 속성을 사용하면 아래 코드도 없앨 수 있다.
/*        mainBinding.fabRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.decrease();
                // livedata 추가하면 아래 코드는 필요 없어진다.
//                mainBinding.countTextView.setText(viewModel.counter.getValue() + "");
            }
        });*/

        // xml에서 viewModel 값이 카운터에 표시되도록 변경하였기 때문에 아래 코드는 필요가 없어졌다.
        /*viewModel.counter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                // ui update 하는곳
                mainBinding.countTextView.setText(integer + "");
            }
        });*/
    }
}
