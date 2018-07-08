package com.aliaksandramolchan.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class ContentPreviewActivity extends AppCompatActivity {
    private String[] content = new String[]{};
    private int sectionPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_preview);

        choosePreview();

        ListView listView = (ListView) findViewById(R.id.contentList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, content);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ContentActivity.class);
                intent.putExtra(Extras.START_CONTENT_KEY, i);
                intent.putExtra(Extras.SECTION_KEY, sectionPosition);
                startActivity(intent);
            }
        });

    }

    private void choosePreview() {
        Intent intent = getIntent();
        sectionPosition = intent.getExtras().getInt(Extras.START_PREVIEW_KEY);

        switch (sectionPosition) {
            case 0:
                content = getResources().getStringArray(R.array.fish);
                break;
            case 1:
                content = getResources().getStringArray(R.array.insects);
                break;
            case 2:
                content = getResources().getStringArray(R.array.mammals);
                break;
            case 3:
                content = getResources().getStringArray(R.array.reptiles);
                break;
            case 4:
                content = getResources().getStringArray(R.array.birds);
                break;
            case 5:
                content = getResources().getStringArray(R.array.spiders);
                break;
        }
    }
}
