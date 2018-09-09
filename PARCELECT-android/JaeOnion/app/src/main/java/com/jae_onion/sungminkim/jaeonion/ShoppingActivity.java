package com.jae_onion.sungminkim.jaeonion;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ShoppingActivity extends AppCompatActivity {

    ArrayList<ShoppingItem> shoppingList = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        shoppingList = new ArrayList<>();

        makeShoppingList();
    }

    public void makeShoppingList(){

        String macbook = "애플 맥북 프로 터치바 노트북 MPXW2KH/A\n" + "(i5-7267U 33.78cm 13형 Mac OS 8G SSD512G)";
        String robot = "스마트 로봇청소기 물걸레겸용 ARW-C100";
        String phonecase = "피앤씨컴퍼니 써클 젤리 핸드폰 케이스";
        String shoes = "필라(FILA) 디스럽터 2 (FS1HTA1071X)";
        String wallet = "닥스ACC 블랙 DD로고 가죽 반지갑 WBWA7F699BK";

        AddProductToList(getDrawable(R.drawable.shoppingcoupang), getDrawable(R.drawable.productmacbook),
                macbook,"2,090,000", "1,776,500", "15% 할인");
        AddProductToList(getDrawable(R.drawable.shoppinggsshop), getDrawable(R.drawable.productrobot),
                robot, "290,000", "261,000", "10% 할인");
        AddProductToList(getDrawable(R.drawable.shoppinggmarket), getDrawable(R.drawable.productphonecase),
                phonecase, "9,900", "8,910", "10% 할인");
        AddProductToList(getDrawable(R.drawable.shoppingcjmall), getDrawable(R.drawable.productshoes),
                shoes,"66,000","56,100", "15% 할인");
        AddProductToList(getDrawable(R.drawable.shoppingsinsege), getDrawable(R.drawable.productwallet),
                wallet, "65,000", "58,500", "10% 할인");
    }

    public void AddProductToList(Drawable dBrand, Drawable dProduct, String pContents, String oPrice, String sPrice, String sRate){

        ListView listView = (ListView) findViewById(R.id.shoppingListview);
        ShoppingItem shoppingItem = new ShoppingItem();

        shoppingItem.brand = dBrand;
        shoppingItem.product = dProduct;
        shoppingItem.contents = pContents;
        shoppingItem.originalPrice = oPrice;
        shoppingItem.salePrice = sPrice;
        shoppingItem.saleRate = sRate;
        shoppingList.add(shoppingItem);

        ShoppingListAdapter adapter = new ShoppingListAdapter(shoppingList);
        listView.setAdapter(adapter);

    }
}
