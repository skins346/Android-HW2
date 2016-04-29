
package com.example.user.androidhw2;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 Program to show Functions(timetable, tip calculator, calculator).
 Author: Kim Young Song.
 E-mail Address: infall346@gmail.com.
 Programming homework #2
 Last Changed: April 27, 2016
 */
public class MainActivity extends Activity {
    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;

    static SharedPreferences sh_Pref;
    static SharedPreferences.Editor toEdit;
    static int logOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sh_Pref = getSharedPreferences("a", MODE_PRIVATE);
        toEdit = sh_Pref.edit();

        if(sh_Pref.contains("Password") == false )
           sharedPrefernces();//When entered at first, set password by default value ("0000")

        if(logOn != 1)
          startActivity(new Intent(this, LoginActivity.class)); //call Login Activity
        else
           logOn = 0;

        mListView = (ListView) findViewById(R.id.mList);
        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        //add items to adapter
        mAdapter.addItem(getResources().getDrawable(R.drawable.time),
                "Time Table");
        mAdapter.addItem(getResources().getDrawable(R.drawable.tip),
                "Tip Calculator");
        mAdapter.addItem(getResources().getDrawable(R.drawable.calculator),
                "Mini Calculator");
         mAdapter.addItem(getResources().getDrawable(R.drawable.change),
                "Change Password");

        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ListData mData = mAdapter.mListData.get(position);
                if(position== 0)
                    startActivity(new Intent(MainActivity.this,Description1.class));   //Initiate TimetableActivity
                else if(position == 1)
                    startActivity(new Intent(MainActivity.this,Description2.class));   //Initiate TipCalculatorActivity
                else if(position == 2)
                    startActivity(new Intent(MainActivity.this, Description3.class));  //Initiate MiniCalculatorActivity
                else
                    startActivity(new Intent(MainActivity.this,ChangePsActivity.class));  //Initiate ChangePsActivity
            }
        });
    }

    //In this method, set password as "0000"
    public void sharedPrefernces() {
        toEdit.putString("Password", "0000");
        toEdit.commit();
    }

    private class ViewHolder {
        public ImageView mIcon;
        public TextView mText;
    }

    //This listviewadapter exists for adding items(time table, tip calculator..)
    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<ListData> mListData = new ArrayList<ListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // add item(image , title)
        public void addItem(Drawable icon, String mTitle){
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;
            mListData.add(addInfo);
        }

        //override getView method
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_item, null);

                holder.mIcon = (ImageView) convertView.findViewById(R.id.mImage);
                holder.mText = (TextView) convertView.findViewById(R.id.mText);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            ListData mData = mListData.get(position);

            if (mData.mIcon != null) {
                holder.mIcon.setVisibility(View.VISIBLE);
                holder.mIcon.setImageDrawable(mData.mIcon);
            }else{
                holder.mIcon.setVisibility(View.GONE);
            }

            holder.mText.setText(mData.mTitle);

            return convertView;
        }
    }
}
