package com.sharetest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sharingtest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFileFragment extends Fragment {

    private TextView nextBtn;

    public SelectFileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_file, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
        setUpClickListeners();
    }

    private void setUpClickListeners(){
        nextBtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.select_file_next_btn));
    }

    private void findView(View view){
        nextBtn = view.findViewById(R.id.tv_nextBtn);
    }
}
