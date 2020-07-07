package com.sharetest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sharingtest.R;
import com.sharetest.design.RationalePermissionRequest;
import com.sharetest.utils.AppUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFileFragment extends BaseFragment {

    private TextView nextBtn;

    private AlertDialog mOngoingRequest;

    public boolean requestRequiredPermissions(boolean killActivityOtherwise) {
        if (mOngoingRequest != null && mOngoingRequest.isShowing())
            return false;

        RationalePermissionRequest.PermissionRequest request = AppUtils.getReadPermission(requireContext());
        return (mOngoingRequest = RationalePermissionRequest.requestIfNecessary(requireActivity(),
                request, killActivityOtherwise)) == null;
    }

    public SelectFileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!AppUtils.checkRequiredPermission(requireContext(), AppUtils.getReadPermission(requireContext()).permission)){
            requestRequiredPermissions(true);
        }
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

    private void setUpClickListeners() {
        nextBtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.select_file_next_btn));
    }

    private void findView(View view) {
        nextBtn = view.findViewById(R.id.tv_nextBtn);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull
            int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (AppUtils.checkRequiredPermission(requireContext(), permissions[0])){

        } else {
            requestRequiredPermissions(true);
        }
    }
}
