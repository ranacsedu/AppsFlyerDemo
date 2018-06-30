package com.demo.teppei.appsflyerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //GET PASSED DATA
        Intent i=getIntent();
        pos=i.getExtras().getInt("Position");

        //GET VIEWS
        final CustomAdapter adapter=new CustomAdapter(this);
        final ImageView img=(ImageView) findViewById(R.id.imageView1);
        final TextView nameTv=(TextView)findViewById(R.id.nameTxt);
        final TextView goalTv=(TextView) findViewById(R.id.goalTxt);

        //SET DATA
        img.setImageResource(adapter.images[pos]);
        nameTv.setText(adapter.names[pos]);
        goalTv.setText(adapter.goals[pos]);

        Button nextBtn=(Button) findViewById(R.id.button1);
        //NEXT CLICKED
        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                int position=pos+1;

                //set data
                img.setImageResource(adapter.images[position]);
                nameTv.setText("Name: "+adapter.names[position]);
                goalTv.setText("Goals: "+adapter.goals[position]);

                if(!(position>=adapter.getCount()-1))
                {
                    pos +=1;
                }else
                {
                    pos = -1;
                }

            }
        });



    }
}
