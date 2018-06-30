package com.demo.teppei.appsflyerdemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context c;

    String[] names={"Men's T-Shirt","Men's shoe"};
    String[] goals={"10","20"};
    int[] images={R.drawable.tshirt,R.drawable.shoe};

    public CustomAdapter(Context ctx) {
        // TODO Auto-generated constructor stub

        this.c=ctx;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.length;
    }

    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return names[pos];
    }

    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.product, null);
        }

        //GET VIEWS
        TextView nameTxt=(TextView) convertView.findViewById(R.id.nameTv);
        TextView goalsTxt=(TextView) convertView.findViewById(R.id.goalsTv);
        ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);

        //SET DATA
        nameTxt.setText(names[pos]);
        goalsTxt.setText(goals[pos]);
        img.setImageResource(images[pos]);

        return convertView;
    }

}
