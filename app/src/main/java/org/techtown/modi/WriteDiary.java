package org.techtown.modi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class WriteDiary extends AppCompatActivity {

    TextView textsize;
    EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionbar = getSupportActionBar();

        actionbar.setIcon(R.drawable.backbutton) ;
        actionbar.setDisplayUseLogoEnabled(true) ;
        actionbar.setDisplayShowHomeEnabled(true) ;
        actionbar.setTitle("   일기작성");


        setContentView(R.layout.activity_writediary);

        textsize = (TextView) findViewById(R.id.textsize);
        content = (EditText) findViewById(R.id.editcontent);

        content.addTextChangedListener(new TextWatcher() {
            String str;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { //입력하기 전
                str = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { //입력되는 텍스트에 변화가 있을 때
                textsize.setText(String.valueOf(s.length()));
            }

            @Override
            public void afterTextChanged(Editable s) { //입력이 끝났을 때

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.writeactionbar_confirm, menu) ;

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //여기다가 확인 버튼 눌렸을때 DB에 저장시키는 내용 적으면됨
        return super.onOptionsItemSelected(item);
    }
}




