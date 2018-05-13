package org.techtown.modi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SaveDiary extends AppCompatActivity {

    TextView editfeel, editcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_diary);

        editfeel = findViewById(R.id.editfeel);
        editcontent = findViewById(R.id.editcontent);

        Intent intent = getIntent();
        editfeel.setText(intent.getStringExtra("feel"));
        editcontent.setText(intent.getStringExtra("diary"));
    }
}
