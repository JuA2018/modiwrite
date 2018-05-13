package org.techtown.modi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DiaryList extends AppCompatActivity {
    ArrayList<Content> al = new ArrayList<Content>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarylist);

        al.add(new Content("2018 / 04.25", "오늘은 화창한 날", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.26", "오늘은 기분 별로", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.27", "오늘은 슬픔", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.28", "오늘은 평범", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.29", "오늘은 기분 좋음!", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 04.30", "애매한 기분.....", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));
        al.add(new Content("2018 / 05.01", "지금 너무 긴장됨", "일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다 일기내용입니다"));

        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.standardlist, al);

        ListView diarylist = (ListView) findViewById(R.id.diarylist);
        diarylist.setAdapter(adapter);

        diarylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SaveDiary.class);

                intent.putExtra("feel", al.get(position).feel);
                intent.putExtra("diary", al.get(position).diary);

                startActivity(intent);
            }
        });

    }

    class MyAdapter extends BaseAdapter { // 리스트 뷰의 어뎁터
        Context context;
        int layout;
        ArrayList<Content> al;
        LayoutInflater inf;
        View layoutview;
        public MyAdapter(Context context, int layout, ArrayList<Content> al) {
            this.context = context;
            this.layout = layout;
            this.al = al;
        }
        @Override
        public int getCount() {
            return al.size();
        }
        @Override
        public Object getItem(int position) {
            return al.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null) {
                layoutview = inf.from(context).inflate(layout, null);

                TextView days = (TextView) layoutview.findViewById(R.id.days);
                TextView feels = (TextView) layoutview.findViewById(R.id.feels);
                TextView diarys = (TextView) layoutview.findViewById(R.id.diarys);

                Content m = new Content();
                m = al.get(position);
                Log.d("MainActivity", al.get(position).toString());
                days.setText(m.day);
                Log.d("day", m.day.toString());
                feels.setText(m.feel);
                Log.d("feel", m.feel.toString());
                diarys.setText(m.diary);
                Log.d("diary", m.diary.toString());
            }
            return layoutview;
        }
    }

    class Content {
        String day = ""; // 날짜
        String feel = ""; // 기분표시
        String diary = ""; // 일기내용
        public Content(String day, String feel, String diary) {
            super();
            this.day = day;
            this.feel = feel;
            this.diary = diary;
        }
        public Content() {}
    }
}
