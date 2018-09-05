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

        AddProductToList(getDrawable(R.drawable.shoppingcoupang), getDrawable(R.drawable.productmacbook), "설명","8000", "7000", "51%");
        AddProductToList(getDrawable(R.drawable.shoppinggsshop), getDrawable(R.drawable.productrobot), "설명", "707070", "17387", "13%");
        AddProductToList(getDrawable(R.drawable.shoppinggmarket), getDrawable(R.drawable.productphonecase), "설명", "707070", "17387", "13%");
        AddProductToList(getDrawable(R.drawable.shoppingcjmall), getDrawable(R.drawable.productshoes), "설명", "707070", "17387", "13%");
        AddProductToList(getDrawable(R.drawable.shoppingsinsege), getDrawable(R.drawable.productwallet), "설명", "707070", "17387", "13%");
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
