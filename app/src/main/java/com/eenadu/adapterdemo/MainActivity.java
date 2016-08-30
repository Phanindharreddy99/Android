package com.eenadu.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {


    String[] day={"SUN","MON","THU","WED","THUR","FRI","SAT"};
    Integer[] num={android.R.drawable.alert_dark_frame,android.R.drawable.alert_light_frame,
     android.R.drawable.checkbox_off_background,android.R.drawable.ic_delete,
            android.R.drawable.ic_menu_report_image,
    android.R.drawable.ic_delete,
    android.R.drawable.ic_menu_report_image};

    ListView lv;

    List<DayNum> dayNumList;

    ArrayAdapter<String> arrayAdapter;


    Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        lv= (ListView) this.findViewById(R.id.lv);


        adapter=new Adapter(dayNumList);
        lv.setAdapter(adapter);



        //Adapter adapter=new Adapter(day,num);
       // lv.setAdapter(adapter);
        //arrayAdapter=new ArrayAdapter<String>(this,R.layout.inflate_day,R.id.tvday,day);

        //lv.setAdapter(arrayAdapter);



    }


    public class Adapter extends BaseAdapter
    {

        String[] days;
        Integer[] ids;

        List<DayNum> dayNumList;

        Adapter(List<DayNum> dayNumList)
        {

            this.dayNumList=dayNumList;
        }


        Adapter(String[] days,Integer[] ids)
        {

            this.days=days;
            this.ids=ids;
        }

        @Override
        public int getCount() {
            return dayNumList.size();
        }

        @Override
        public Object getItem(int i) {
            return dayNumList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {


            DayNum dayNum=dayNumList.get(i);
            ViewHolder viewHolder=null;
            if(view==null) {

                view = getLayoutInflater().inflate(R.layout.inflate_day, viewGroup, false);
                view.setTag(view);

               viewHolder=new ViewHolder(view);

            }else
            {
                view= (View) view.getTag();
                viewHolder=new ViewHolder(view);
            }

         //   tv.setText(days[i]);
           // iv.setImageResource(ids[i]);

              viewHolder.tv.setText(dayNum.getDays());
             viewHolder.iv.setImageResource(dayNum.getNum());


            viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                  //  dayNumList.remove(i);
                    DayNum dayNum1=new DayNum();
                    dayNum1.setDays("DAYs");
                    dayNum1.setNum(0);
                    dayNumList.add(dayNum1);
                    adapter.notifyDataSetChanged();

                }
            });

            return view;
        }

        public class ViewHolder
        {

            TextView tv;
            ImageView iv;
            LinearLayout linearLayout;
            public ViewHolder(View view)
            {
                 linearLayout = (LinearLayout) view.findViewById(R.id.llclick);
                 tv = (TextView) view.findViewById(R.id.tvday);
                 iv = (ImageView) view.findViewById(R.id.iv);

            }
        }
    }
}
