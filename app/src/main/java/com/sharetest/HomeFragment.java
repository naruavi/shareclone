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
public class HomeFragment extends Fragment {

    private TextView sendBtn;
    private TextView receiveBtn;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        findViews(view);
        setUpClickListeners();
    }

    private void setUpClickListeners(){
        sendBtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_send_btn));
        receiveBtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_receive_btn));
    }

    private void findViews(View view){
        sendBtn = view.findViewById(R.id.tv_send_btn);
        receiveBtn = view.findViewById(R.id.tv_receive_btn);
    }
}
