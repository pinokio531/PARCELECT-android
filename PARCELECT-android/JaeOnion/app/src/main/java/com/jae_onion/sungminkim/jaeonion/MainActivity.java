package com.jae_onion.sungminkim.jaeonion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ArrayList<MainBannerItem> bannerList = null;
    private ViewPager viewPager;
    private LinearLayout indicator;
    private ImageView[] bannerIndicator = null;
    private long pressedtime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        navigationView = (NavigationView) findViewById(R.id.navigation_drawer);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CreateToolBar();
        }

        bannerList = new ArrayList<>();

        setBanner();
        first();
        pageChangeListener();
        ButtonFunction();
        SettingNavigationDrawer();
    }


    public void CreateToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        //default 함수로 toolbar 맨 왼쪽 아이콘이다. default 이미지는 뒤로가기 화살표 임.
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_name);

    }

    //drawer 아이콘 listener임.
    public void SettingNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.mainbackground);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();

                int i = item.getItemId();

                switch (i) {
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

    //특별히 붙이고 싶은 아이콘(찾기, :, 음성) 등을 넣고 싶을때 drawable.menu에서 정의하고 inflate 하면됨
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    //toolbar 에서 default를 포함 onCreaetOptionsMenu에서 inflate 한 아이콘들이 나타나고 이에 대한 리스너임
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: //default 버튼임(맨 왼쪽)
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //메인화면 돌아올때마다 항상 drawer 아이템이 home 화면을 체크하도록 함
    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setCheckedItem(R.id.menu1);
    }

    //버튼 리스너
    public void ButtonFunction() {
        FrameLayout bt_left1 = (FrameLayout) findViewById(R.id.bt_left);
        FrameLayout bt_left2 = (FrameLayout) findViewById(R.id.bt_left2);
        FrameLayout bt_right1 = (FrameLayout) findViewById(R.id.bt_right);
        FrameLayout bt_right2 = (FrameLayout) findViewById(R.id.bt_right2);

        bt_left1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_left2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_right1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //viewPager 동적 생성
    public void setBanner() {
        viewPager = (ViewPager) findViewById(R.id.viewpagerBanner);
        MainBannerItem mainBannerItem = new MainBannerItem();

        mainBannerItem.bannerImage = getDrawable(R.drawable.main_banenr);
        bannerList.add(mainBannerItem);
        bannerList.add(mainBannerItem);
        bannerList.add(mainBannerItem);
        bannerList.add(mainBannerItem);

        MainBannerAdapter adapter = new MainBannerAdapter(bannerList);
        viewPager.setAdapter(adapter);
    }

    //최초 indicator 설정(아무것도 클릭 안된 상태)
    public void first() {
        indicator = (LinearLayout) findViewById(R.id.indicatorLayout);
        bannerIndicator = new ImageView[bannerList.size()];

        final int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        final int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.setMargins(5, 0 ,5, 0);

        for (int i = 0; i < bannerList.size(); i++) {
            bannerIndicator[i] = new ImageView(this);
            bannerIndicator[i].setLayoutParams(params);
            bannerIndicator[i].setImageDrawable(getDrawable(R.drawable.circle_indicator));
            indicator.addView(bannerIndicator[i]);
        }

    }

    //viewpager 넘길 때마다 해당 position 뷰를 바꿈
    public void pageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < bannerList.size(); i++) {
                    bannerIndicator[i].setImageDrawable(getDrawable(R.drawable.circle_indicator));
                }
                bannerIndicator[position].setImageDrawable(getDrawable(R.drawable.circle_indicator_checked));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() >= pressedtime + 2000) {
            pressedtime = System.currentTimeMillis();
            Toast.makeText(this, " 한번 더 누르면 어플이 종료됩니다", Toast.LENGTH_SHORT).show();
            return;
        } else {
            super.onBackPressed();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            finish();
        }
    }
}

    /* inflater 연습 -> 이 function은 호출 시 마다 indicator 가 사라지고 다시 나타나는 단점이 있음

    // bannerIndicator 는 inflate한 view를 1.List<view> 에 담는다.

    private ArrayList<View> viewList;


    public void bannerIndicator(){
        indicator = (LinearLayout) findViewById(R.id.indicatorLayout);
        viewList = new ArrayList<>();

        for(int i=0; i<bannerList.size(); i++){
            View view;
            view = getLayoutInflater().inflate(R.layout.indicator_view, null);
            viewList.add(view);
        }
    }


    //SelectedIndicator는 checked시 설정되는 view를 inflate 하고, 해당 viewList[position]에 넣는다.

    public void SelectedIndicator(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                bannerIndicator();
                View checkedView = getLayoutInflater().inflate(R.layout.indicator_view_selected, null);
                viewList.set(position, checkedView);

                //viewList에 들어있는 view들을 position이 바뀔때마다 넣는다.

                for(position=0; position<bannerList.size(); position++){
                    indicator.addView(viewList.get(position));
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
} */
