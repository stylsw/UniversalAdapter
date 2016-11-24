package com.fingertip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fingertip.library.ItemType;
import com.fingertip.library.UniversalAdapter;
import com.fingertip.library.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLv = (ListView) findViewById(R.id.mLv);

        List<Object> datas = new ArrayList<>();
        datas.add("item 1");
        datas.add("item 2");
        datas.add(R.mipmap.ic_launcher);
        datas.add("item 3");
        datas.add(R.mipmap.ic_launcher);
        datas.add("item 4");
        datas.add("item 5");
        datas.add(R.mipmap.ic_launcher);
        datas.add("item 6");
        datas.add("item 7");
        datas.add("item 8");
        datas.add(R.mipmap.ic_launcher);
        datas.add("item 9");

        ItemType[] itemTypes = new ItemType[]{new ItemType(R.layout.item,String.class),new ItemType(R.layout.item1,Integer.class)};
        mLv.setAdapter(new UniversalAdapter(MainActivity.this, datas, itemTypes) {


            @Override
            public void bindItemView(ViewHolder viewHolder, Object data, int itemLayoutId, int position) {
                switch (itemLayoutId) {
                    case R.layout.item:
                        String content = (String) data;
                        TextView tv = viewHolder.getView(R.id.tv);
                        tv.setText(content);
                        break;
                    case R.layout.item1:
                        int drawableId = (int) data;
                        ImageView iv = viewHolder.getView(R.id.iv);
                        iv.setImageResource(drawableId);
                        break;
                }
            }
        });

    }
}
