package com.pep.uplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.pep.android.VIEW_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        if (id == R.id.action_lm) {
            Intent intent = new Intent(this, LocalMusic.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_np) {
            Intent intent = new Intent(this, NowPlaying.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_st) {
            Intent intent = new Intent(this, Store.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void songClick(View v) {
        Intent intent;
        String vname;
        switch (v.getId()) {
            case R.id.lm_1:
                intent = new Intent(this, LocalMusic.class);
                vname = v.getResources().getResourceName(v.getId());
                intent.putExtra(EXTRA_MESSAGE, vname);
                startActivity(intent);
                break;
            case R.id.lm_2:
                intent = new Intent(this, LocalMusic.class);
                vname = v.getResources().getResourceName(v.getId());
                intent.putExtra(EXTRA_MESSAGE, vname);
                startActivity(intent);
                break;
            case R.id.lm_3:
                intent = new Intent(this, LocalMusic.class);
                vname = v.getResources().getResourceName(v.getId());
                intent.putExtra(EXTRA_MESSAGE, vname);
                startActivity(intent);
                break;
            case R.id.st_1:
                intent = new Intent(this, Store.class);
                vname = v.getResources().getResourceName(v.getId());
                intent.putExtra(EXTRA_MESSAGE, vname);
                startActivity(intent);
                break;
            case R.id.st_2:
                intent = new Intent(this, Store.class);
                vname = v.getResources().getResourceName(v.getId());
                intent.putExtra(EXTRA_MESSAGE, vname);
                startActivity(intent);
                break;
            case R.id.st_3:
                intent = new Intent(this, Store.class);
                vname = v.getResources().getResourceName(v.getId());
                intent.putExtra(EXTRA_MESSAGE, vname);
                startActivity(intent);
                break;
        }
    }
}
