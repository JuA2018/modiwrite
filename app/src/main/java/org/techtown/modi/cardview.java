package org.techtown.modi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class cardview extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

        rv = (RecyclerView) findViewById(R.id.diarylist);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }

    class Person {
        String day;
        String feel;
        String content;

        Person(String day, String feel, String content) {
            this.day = day;
            this.feel = feel;
            this.content = content;
        }
    }

    private List<Person> person;

    private void datalist() {
        person = new ArrayList<>();
        person.add(new Person("2018/05/10", "오늘은 꿀꿀함", "일기 내용입니다."));
        person.add(new Person("2018/05/11", "오늘은 기분좋음", "일기 내용입니다."));
        person.add(new Person("2018/05/12", "오늘은 이상함", "일기 내용입니다."));
        person.add(new Person("2018/05/13", "오늘은 느낌이 좋음", "일기 내용입니다."));
        person.add(new Person("2018/05/14", "오늘은 모르겠음", "일기 내용입니다."));
        person.add(new Person("2018/05/15", "오늘은 슬픔", "일기 내용입니다."));
        person.add(new Person("2018/05/16", "오늘은 무서움", "일기 내용입니다."));
    }

    List<Person> persons;

    void RVAdapter(List<Person> persons) {
        this.persons = persons;
    }

    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

        public RVAdapter(List<Person> persons) {
        }

        @NonNull
        @Override
        public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
            PersonViewHolder pvh = new PersonViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(@NonNull PersonViewHolder viewHolder, int p) { //실질적인 내용 넣어줌
            viewHolder.days.setText(person.get(p).day);
            viewHolder.feels.setText(person.get(p).feel);
            viewHolder.contents.setText(person.get(p).content);
        }

        @Override
        public int getItemCount() {
            return persons.size();
        }

        @Override
        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

        public class PersonViewHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView days, feels, contents;

            public PersonViewHolder(View itemView) {
                super(itemView);
                cv = (CardView) findViewById(R.id.card);
                days = (TextView) findViewById(R.id.days);
                feels = (TextView) findViewById(R.id.feels);
                contents = (TextView) findViewById(R.id.contents);
            }
        }
    }
    }
