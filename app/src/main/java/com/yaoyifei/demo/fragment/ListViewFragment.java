package com.yaoyifei.demo.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yaoyifei.demo.MyListAdapter;
import com.yaoyifei.demo.MyListViewData;
import com.yaoyifei.demo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListViewFragment extends BlankFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    private ListView myList;
    private MyListAdapter myListAdapter;
    private List<MyListViewData> mData = new ArrayList<>();
    private Integer[] imgData = {R.drawable.penghua1,R.drawable.penghua2,
            R.drawable.penghua3,R.drawable.penghua4,
            R.drawable.penghua5,R.drawable.mianbao1,R.drawable.mianbao2};

    public ListViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    public static ListViewFragment newInstance(String param1) {
        ListViewFragment fragment = new ListViewFragment();
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
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_listview, container, false);
        myList = rootView.findViewById(R.id.myList);
        myListAdapter = new MyListAdapter(this, R.layout.adapter_lv, mData);
        myList.setAdapter(myListAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyListViewData myListViewData = mData.get(i);
                Toast.makeText(getContext(),myListViewData.getItemText(),Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    private void initData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int j = 0;
                for (int i = 1; i <= 15; i++){
                    if (j == imgData.length - 1){
                        j = 0;
                    }
                    String str = "item " + i;
                    MyListViewData myListViewData = new MyListViewData(str,imgData[j]);
                    j++;
                    mData.add(myListViewData);
                }
            }
        }).start();
    }

}
