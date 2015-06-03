package com.buddhikajay.AutomatedSMSapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buddhika on 6/3/15.
 */
public class ScheduledMesseges extends Activity{

    MyAdaptor myAdaptor = null;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shceduled_messeges);

        displayListView();
        checkButtonClicked();
    }

    private void displayListView(){
        //Array List of Days
        ArrayList<Day> days = new ArrayList<Day>();
        days.add(new Day("Monday", 0,false));
        days.add(new Day("Tuesday", 1, false));
        days.add(new Day("Wednesday", 2, false));
        days.add(new Day("Thurseday", 3, false));
        days.add(new Day("Friday", 4, false));
        days.add(new Day("Saturday", 5, false));
        days.add(new Day("Sunday", 6, false));

    }

    private class MyAdaptor extends ArrayAdapter<Day>{

        private ArrayList<Day> days;

        public MyAdaptor(Context context, int textViewResourceId, ArrayList<Day> days) {
            super(context, textViewResourceId, days);
            this.days = new ArrayList<Day>();
            this.days.addAll(days);
        }

        public MyAdaptor(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public MyAdaptor(Context context, int textViewResourceId, Day[] objects) {
            super(context, textViewResourceId, objects);
        }

        public MyAdaptor(Context context, int resource, int textViewResourceId, Day[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public MyAdaptor(Context context, int textViewResourceId, List<Day> objects) {
            super(context, textViewResourceId, objects);
        }

        public MyAdaptor(Context context, int resource, int textViewResourceId, List<Day> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        private class ViewHolder{
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));
            if(convertView==null){
                final LayoutInflater vi =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.day_info, null);

                holder = new ViewHolder();
                holder.code = (TextView)convertView.findViewById(R.id.code);
                holder.name = (CheckBox)convertView.findViewById(R.id.checkbox);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CheckBox checkBox = (CheckBox) view;
                        Day day = (Day) checkBox.getTag();
                        Toast.makeText(getApplicationContext(), "Clicked on checkbox "+checkBox.getText()+" is "+checkBox.isChecked(), Toast.LENGTH_LONG).show();
                        day.setChecked(checkBox.isChecked());
                    }
                });
            }

            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Day day = days.get(position);
            holder.code.setText("("+day.getId());
            holder.name.setText(day.getName());
            holder.name.setChecked(day.isChecked());
            holder.name.setTag(day);

            return convertView;
        }
    }

    private void checkButtonClicked(){
        Button button = (Button)findViewById(R.id.findSelected);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer responseText = new StringBuffer();
                responseText.append("The followings were selected\n");
                ArrayList<Day> days = myAdaptor.days;
                for (int i=0; i<days.size();i++){
                    Day day = days.get(i);
                    if (day.isChecked()){
                        responseText.append("\n"+ day.getName());
                    }
                }

                Toast.makeText(getApplicationContext(), responseText, Toast.LENGTH_LONG).show();
            }
        });
    }

}
