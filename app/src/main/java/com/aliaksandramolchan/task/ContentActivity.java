package com.aliaksandramolchan.task;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class ContentActivity extends AppCompatActivity {

    private String text;
    private int imgId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);

        TextView textView = (TextView) findViewById(R.id.contentText);
        ImageView imageView = (ImageView) findViewById(R.id.contentImage);

        chooseContent();

        if (text != null) {
            textView.setText(text);
            imageView.setImageResource(imgId);
        }

    }

    private void chooseContent() {
        Intent intent = getIntent();
        int section = intent.getExtras().getInt(Extras.SECTION_KEY);

        switch (section) {
            case 0:
                prepareContent(R.array.fish, R.array.drawable_array_fish);
                break;
            case 1:
                prepareContent(R.array.insects, R.array.drawable_array_insects);
                break;
            case 2:
                prepareContent(R.array.mammals, R.array.drawable_array_mammals);
                break;
            case 3:
                prepareContent(R.array.reptiles, R.array.drawable_array_reptiles);
                break;
            case 4:
                prepareContent(R.array.birds, R.array.drawable_array_birds);
                break;
            case 5:
                prepareContent(R.array.spiders, R.array.drawable_array_spiders);
                break;
        }
    }

    private void prepareContent(int textId, int imgId) {
        Intent intent = getIntent();
        int position = intent.getExtras().getInt(Extras.START_CONTENT_KEY);
        text = getResources().getStringArray(textId)[position];
        TypedArray imgArray = getResources().obtainTypedArray(imgId);
        this.imgId = imgArray.getResourceId(position, -1);
        imgArray.recycle();
    }
}
