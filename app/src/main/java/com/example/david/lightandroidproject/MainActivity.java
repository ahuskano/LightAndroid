package com.example.david.lightandroidproject;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.david.lightandroidproject.navigation.DemoDrawerActivity;
import com.example.david.lightandroidproject.navigation.DemoDrawerMenuActivity;
import com.example.david.lightandroidproject.navigation.DemoRecyclerActivity;
import com.example.david.lightandroidproject.navigation.DemoStandardActivity;
import com.example.david.lightandroidproject.navigation.DemoTabbedActivity;
import com.lightandroid.navigation.activity.LightActivity;

import butterknife.InjectView;
import butterknife.OnItemClick;

/**
 * Created by David on 16.11.2014..
 */
public class MainActivity extends LightActivity {

    String[] items = {"Standard activity", "Navigation drawer", "Tabs", "Navigation menu drawer", "RecyclerView and CardView", "Network (REST)"};
    @InjectView(R.id.list)
    ListView list;

    @Override
    public int provideLayoutRes() {
        return R.layout.layout_list;
    }

    @Override
    public void main() {
        list.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, items));
    }

    @OnItemClick(R.id.list)
    void onItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getBaseContext(), DemoStandardActivity.class));
                break;
            case 1:
                startActivity(new Intent(getBaseContext(), DemoDrawerActivity.class));
                break;
            case 2:
                startActivity(new Intent(getBaseContext(), DemoTabbedActivity.class));
                break;
            case 3:
                startActivity(new Intent(getBaseContext(), DemoDrawerMenuActivity.class));
                break;
            case 4:
                startActivity(new Intent(getBaseContext(), DemoRecyclerActivity.class));
                break;
            case 5:
                startActivity(new Intent(getBaseContext(), DemoNetworkActivity.class));
        }
    }
}
