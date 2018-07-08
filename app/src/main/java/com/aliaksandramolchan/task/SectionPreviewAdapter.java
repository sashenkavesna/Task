package com.aliaksandramolchan.task;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class SectionPreviewAdapter extends BaseAdapter {
    private Integer[] images = {
            R.drawable.fish, R.drawable.dragonfly, R.drawable.deer, R.drawable.alligator,
            R.drawable.duck, R.drawable.spider};
    private String[] sections;
    private Context context;

    public SectionPreviewAdapter(Context context) {
        this.context = context;
        sections = context.getResources().getStringArray(R.array.sections);
    }

    @Override
    public int getCount() {
        return sections.length;
    }

    @Override
    public Object getItem(int i) {
        return sections[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        if (view != null) {
            grid = view;
        } else {
            grid = new View(context);
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.cell, viewGroup, false);
        }

        ImageView imageView = grid.findViewById(R.id.CellImage);
        imageView.setImageResource(images[i]);

        TextView textView = grid.findViewById(R.id.CeellText);
        textView.setText(sections[i]);

        return grid;
    }
}
