package com.example.smaik.fragmentproj;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.smaik.fragmentproj.adapters.ProductAdapter;
import com.example.smaik.fragmentproj.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddProducts();
        Fragment productDescriptionFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_product_description);
        RecyclerView recyclerView = findViewById(R.id.fp_products_rv);
        ProductAdapter productAdapter = new ProductAdapter(productList, getApplicationContext(), productDescriptionFragment);
        recyclerView.setAdapter(productAdapter);

    }
    private void AddProducts()
    {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone", "Useless Mobile Device", 100));
        productList.add(new Product(2, "Cat", "The cutest creature", 150));
        productList.add(new Product(3, "Notebook", "It knows everything", 200));
        productList.add(new Product(4, "Hard drive", "I hope u still need it", 250));
        productList.add(new Product(5, "Bag", "Try to go without it", 300));
    }

}
