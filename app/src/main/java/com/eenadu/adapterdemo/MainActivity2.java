package com.eenadu.adapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    String[] day={"SUN","MON","THU","WED","THUR","FRI","SAT"};
    Integer[] num={android.R.drawable.alert_dark_frame,android.R.drawable.alert_light_frame,
     android.R.drawable.checkbox_off_background,android.R.drawable.ic_delete,
            android.R.drawable.ic_menu_report_image,
    android.R.drawable.ic_delete,
    android.R.drawable.ic_menu_report_image};

    RecyclerView rv;

    List<DayNum> dayNumList;

    ArrayAdapter<String> arrayAdapter;


    Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dayNumList=new ArrayList<>();
        for(int i=0;i<day.length;i++)
        {

            DayNum dayNum=new DayNum();
            dayNum.setDays(day[i]);
            dayNum.setNum(num[i]);
            dayNumList.add(dayNum);
            Log.e("day",day[i]+"i value"+i+"integer"+num[i]);


        }

        for(int i=0;i<day.length;i++)
        {

            Log.e("day",""+num[i]);
        }

        rv= (RecyclerView) this.findViewById(R.id.rv);

       // rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new GridLayoutManager(this,2));
        adapter=new Adapter();
        rv.setAdapter(adapter);


       // adapter=new Adapter(dayNumList);
        //lv.setAdapter(adapter);



        //Adapter adapter=new Adapter(day,num);
       // lv.setAdapter(adapter);
        //arrayAdapter=new ArrayAdapter<String>(this,R.layout.inflate_day,R.id.tvday,day);

        //lv.setAdapter(arrayAdapter);



    }

    public  class Adapter extends RecyclerView.Adapter<Adapter.VH>
    {


        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=getLayoutInflater().inflate(R.layout.inflate_day,parent,false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(VH holder, final int position) {


            DayNum dayNum=dayNumList.get(position);
            holder.tv.setText(dayNum.getDays());
            holder.iv.setImageResource(dayNum.getNum());
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    dayNumList.remove(position);
                    DayNum dayNum1=new DayNum();
                    dayNum1.setDays("DAYs");
                    dayNum1.setNum(0);
                    dayNumList.add(dayNum1);
                    adapter.notifyDataSetChanged();

                }
            });


        }

        @Override
        public int getItemCount() {
            return dayNumList.size();
        }

        public class  VH extends RecyclerView.ViewHolder
        {


            TextView tv;
            ImageView iv;
            LinearLayout linearLayout;
            public VH(View view)
            {
                super(view);
                linearLayout = (LinearLayout) view.findViewById(R.id.llclick);
                tv = (TextView) view.findViewById(R.id.tvday);
                iv = (ImageView) view.findViewById(R.id.iv);

            }

        }

    }
}
