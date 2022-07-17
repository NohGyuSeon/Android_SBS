package com.example.example02;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//

public class ColorButtonFragment extends Fragment implements View.OnClickListener{

    // Callback Interface 정의
    //  해당 Fragment 를 호출하는 Activity 가 반드시 구현해야할 Interface
    public interface OnBackgroundChangListener {
        public abstract void setBackgroundForFrame(int color);
    }

    OnBackgroundChangListener listener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Context : 실행 중인 Activity 의 상위 클래스
        if(context instanceof OnBackgroundChangListener) {
            listener = (OnBackgroundChangListener) context;
        }else {
            throw new ClassCastException(context.toString() + " must implement OnBackgroundChangListener");
        }
    }

    Button redButton, greenButton, blueButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_color_button, container, false);
        redButton = root.findViewById(R.id.fragment_button_red);
        greenButton = root.findViewById(R.id.fragment_button_green);
        blueButton = root.findViewById(R.id.fragment_button_blue);

        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {

        int color = 0;
        if(view.getId() == R.id.fragment_button_red)
            color = Color.RED;
        else if(view.getId() == R.id.fragment_button_green)
            color = Color.GREEN;
        else if(view.getId() == R.id.fragment_button_blue)
            color = Color.BLUE;
        else return;

        MainActivity activity = (MainActivity)getActivity();
        activity.setBackgroundForFrame(color);

        listener.setBackgroundForFrame(color);
    }
}