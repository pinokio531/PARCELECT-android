package com.jae_onion.sungminkim.jaeonion;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        navigationView = (NavigationView) findViewById(R.id.navigation_drawer);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CreateToolBar();
        }

        SettingNavigationDrawer();
    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void CreateToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_name);

    }

    public void SettingNavigationDrawer(){
        drawerLayout = (DrawerLayout) findViewById(R.id.mainbackground);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();

                int i = item.getItemId();

                switch (i){
                    case R.id.menu1:
                        Toast.makeText(MainActivity.this, "홈", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu2:
                        Toast.makeText(MainActivity.this, "공지사항", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu3:
                        startActivity(new Intent(MainActivity.this, ProductSendActivity.class));
                        Toast.makeText(MainActivity.this, "선물보내기", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu4:
                        startActivity(new Intent(MainActivity.this, ProductReceiveActivity.class));
                        Toast.makeText(MainActivity.this, "선물받기", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu5:
                        startActivity(new Intent(MainActivity.this, ShoppingActivity.class));
                        Toast.makeText(MainActivity.this, "쇼핑하기", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu6:
                        startActivity(new Intent(MainActivity.this, MypageActivity.class));
                        Toast.makeText(MainActivity.this, "마이페이지", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu7:
                        Toast.makeText(MainActivity.this, "고객센터", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu8:
                        Toast.makeText(MainActivity.this, "이용약관", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setCheckedItem(R.id.menu1);
    }
}
