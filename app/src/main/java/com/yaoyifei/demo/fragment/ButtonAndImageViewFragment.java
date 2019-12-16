package com.yaoyifei.demo.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.yaoyifei.demo.R;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ButtonAndImageViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ButtonAndImageViewFragment extends BlankFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    Button btn_pre,btn_next;
    ImageView imageView;
    int position = 0;
    private Integer[] imgData = {R.drawable.penghua1,R.drawable.penghua2,
            R.drawable.penghua3,R.drawable.penghua4,
            R.drawable.penghua5,R.drawable.mianbao1,R.drawable.mianbao2};

    public ButtonAndImageViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    public static ButtonAndImageViewFragment newInstance(String param1) {
        ButtonAndImageViewFragment fragment = new ButtonAndImageViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SHOW_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_button, container, false);
        imageView = rootView.findViewById(R.id.imageView);
        imageView.setImageResource(imgData[position]);
        btn_pre = rootView.findViewById(R.id.parent);
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0){
                    position = imgData.length -1;
                } else {
                    position--;
                }
                imageView.setImageResource(imgData[position]);
            }
        });
        btn_next = rootView.findViewById(R.id.child);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == imgData.length - 1){
                    position = 0;
                } else {
                    position++;
                }
                imageView.setImageResource(imgData[position]);
            }
        });
        return rootView;
    }

}
