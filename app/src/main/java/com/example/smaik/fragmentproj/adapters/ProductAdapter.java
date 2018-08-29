package com.example.smaik.fragmentproj.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smaik.fragmentproj.R;
import com.example.smaik.fragmentproj.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<Product> products;
    Context context;
    Fragment productDescriptionFragment;

    public ProductAdapter(List<Product> productList, Context context, Fragment itemFragment) {
        products = productList;
        this.context = context;
        productDescriptionFragment = itemFragment;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new ProductViewHolder(layoutInflater.inflate(R.layout.products, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        Product product = products.get(i);
        productViewHolder.name.setText(product.getName());
        productViewHolder.name.setTag(product.getId());
        productViewHolder.itemView.setBackgroundColor(R.drawable.back);
        productViewHolder.name.setOnClickListener(view -> {
            ((TextView) productDescriptionFragment.getView().findViewById(R.id.item_name_tv)).setText(product.getName());
            ((TextView) productDescriptionFragment.getView().findViewById(R.id.item_description_tv)).setText(product.getDescription());
            ((TextView) productDescriptionFragment.getView().findViewById(R.id.item_price_tv)).setText("Price:" + String.valueOf(product.getPrice()));
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.prod_name_tv);
        }
    }


}
