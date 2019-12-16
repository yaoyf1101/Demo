package com.yaoyifei.demo.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yaoyifei.demo.MainActivity;
import com.yaoyifei.demo.R;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditTextAndTextViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditTextAndTextViewFragment extends BlankFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    Button btn_show;
    EditText name,pwd_number,pwd_text;
    TextView tv_show;

    public EditTextAndTextViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    public static EditTextAndTextViewFragment newInstance(String param1) {
        EditTextAndTextViewFragment fragment = new EditTextAndTextViewFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_edittext, container, false);
//        rootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
//            @Override
//            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//                if (bottom - oldBottom < -1) {
//                    //软键盘弹上去了,动态设置高度为0
//                    //MainActivity.mTabRadioGroup.setVisibility(View.GONE);
//                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
//                            0);
//                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//                    MainActivity.mTabRadioGroup.setLayoutParams(params);
//                } else if (bottom - oldBottom > 1) {
//                    //软键盘弹下去了，动态设置高度，恢复原先控件高度
//                    //MainActivity.mTabRadioGroup.setVisibility(View.VISIBLE);
//                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
//                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//                    MainActivity.mTabRadioGroup.setLayoutParams(params);
//                }
//            }
//        });
        name = rootView.findViewById(R.id.editText_name);
        pwd_number = rootView.findViewById(R.id.editText_number);
        pwd_text = rootView.findViewById(R.id.editText_text);
        tv_show = rootView.findViewById(R.id.textView_show);
        btn_show = rootView.findViewById(R.id.child);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "name:"+name.getText().toString()+", pwd_number:"+pwd_number.getText().toString()+", pwd_text:"+pwd_text.getText().toString();
                tv_show.setVisibility(View.VISIBLE);
                tv_show.setText(str);
            }
        });
        return rootView;
    }

}
