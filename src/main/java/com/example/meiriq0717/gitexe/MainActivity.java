package com.example.meiriq0717.gitexe;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitle("haha.png");
        mToolbar.setSubtitle("hehe.jpg");
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);

        setSupportActionBar(mToolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyview);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        initData();
        adapter = new RecyclerViewAdapter(MainActivity.this);
        adapter.setDataList(list);
        recyclerView.setAdapter(adapter);

    }

    private void initData() {

        for (int i = 0; i < Images.imageUrls.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("title", "imagesTitle" + i);
            map.put("imageUrl", Images.imageUrls[i]);
            list.add(map);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
