package com.example.mckoy.itemsharing;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    private List<Item> mDataSource;

    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list_view_item, parent, false);
        }
        ImageView itemImage = (ImageView) convertView.findViewById(R.id.itemImage);
        TextView sellerName = (TextView) convertView.findViewById(R.id.sellerName);
        TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
        TextView itemPrice = (TextView) convertView.findViewById(R.id.price_of_item);
        Item item = getItem(position);

        Picasso.with(getContext()).load(item.getPhotourl()).into(itemImage);   //Picasso library helps to load the image in the ImageView
        sellerName.setText(item.getSellerName());
        itemName.setText(item.getItemName());
        itemPrice.setText("Price: $" + item.getPrice());
        return convertView;
    }
}

