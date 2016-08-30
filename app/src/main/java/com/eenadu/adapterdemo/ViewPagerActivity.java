package com.eenadu.adapterdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by phanindhar reddy .v on 8/28/2016.
 */
public class ViewPagerActivity extends AppCompatActivity {

    ViewPager viewPager;

    TabLayout tabLayout;

    CirclePageIndicator cv;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        viewPager= (ViewPager) this.findViewById(R.id.viewpager);
         tabLayout= (TabLayout) findViewById(R.id.tab);
        cv= (CirclePageIndicator) this.findViewById(R.id.cv);
      //  viewPager.setAdapter(new Adapter());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(10);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                Log.e("posi",position+"");


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        cv.setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }






    public class Adapter extends PagerAdapter
    {


        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            View v=getLayoutInflater().inflate(R.layout.pager_inflate,null);

            LinearLayout llbg= (LinearLayout) v.findViewById(R.id.llbg);


            switch (position)
            {

                case 0:
                    llbg.setBackgroundColor(Color.RED);
                    break;

                case 1:
                    llbg.setBackgroundColor(Color.BLACK);
                    break;

                default:
                    break;


            }
            container.addView(v);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    public class FragmentAdapter extends FragmentStatePagerAdapter
    {


        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

          if(position==0)
            return new MyFragment();
            else
              return new MyFragment2();
        }

        @Override
        public int getCount() {
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return "page1";
                case 1:
                    return "page2";
                default:
                    break;

            }
            return null;
        }
    }



    public static class MyFragment extends Fragment
    {

       LinearLayout llbg;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
           View v= inflater.inflate(R.layout.pager_inflate,container,false);
            return v;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            llbg= (LinearLayout) view.findViewById(R.id.llbg);





        }
    }


    public static class MyFragment2 extends Fragment
    {

        LinearLayout llbg;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v= inflater.inflate(R.layout.pager_inflate2,container,false);
            return v;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            llbg= (LinearLayout) view.findViewById(R.id.llbg);





        }
    }

}
