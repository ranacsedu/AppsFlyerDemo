package com.demo.teppei.appsflyerdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.demo.teppei.appsflyerdemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ListView lv;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        lv=(ListView)view.findViewById(R.id.listView1);

        //ADAPTER
        CustomAdapter adapter=new CustomAdapter(getContext());
        lv.setAdapter(adapter);

        //EVENTS
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub

                Intent i=new Intent(getContext(), DetailActivity.class);

                //PASS INDEX OR POS
                i.putExtra("Position", pos);
                startActivity(i);

            }
        });

        return view;
    }

}
