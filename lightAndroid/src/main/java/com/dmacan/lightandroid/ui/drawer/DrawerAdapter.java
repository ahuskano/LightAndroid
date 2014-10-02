package com.dmacan.lightandroid.ui.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmacan.lightandroid.R;
import com.dmacan.lightandroid.util.LightFont;

import java.util.List;

/**
 * Created by David on 17.8.2014..
 */
public class DrawerAdapter extends BaseAdapter {

    private int TAG_KEY = 4;
    private List<DrawerItem> items;
    private Context context;
    private DrawerListener listener;
    private int activePosition = -1;

    public DrawerAdapter(List<DrawerItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public void setListener(DrawerListener listener) {
        this.listener = listener;
    }

    public void setActivePosition(int activePosition) {
        this.activePosition = activePosition;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof DrawerItemSimple)
            return DrawerItem.Type.SIMPLE;
        else if (getItem(position) instanceof DrawerItemCategory)
            return DrawerItem.Type.PROFILE;
        else if (getItem(position) instanceof DrawerItemHeading)
            return DrawerItem.Type.HEADING;
        else
            return DrawerItem.Type.CATEGORY;
    }

    @Override
    public int getViewTypeCount() {
        return TAG_KEY;
    }

    @Override
    public boolean isEnabled(int position) {
        return (getItem(position) instanceof DrawerItemSimple || getItem(position) instanceof DrawerItemHeading);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public DrawerItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerItem item = getItem(position);
        if (item instanceof DrawerItemSimple)
            convertView = displayDrawerItemSimple(convertView, (DrawerItemSimple) item);
        else if (item instanceof DrawerItemCategory)
            convertView = displayDrawerItemCategory(convertView, (DrawerItemCategory) item);
        else if (item instanceof DrawerItemHeading)
            convertView = displayDrawerItemHeading(convertView, (DrawerItemHeading) item);
        else
            convertView = displayDrawerItemProfile(convertView, (DrawerItemProfile) item);
        convertView.setTag(R.id.txtDrawerItemSimpleIcon, activePosition);
        if (position == activePosition)
            listener.onActiveViewChanged(convertView);
        return convertView;
    }

    private View displayDrawerItemSimple(View v, DrawerItemSimple item) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.drawer_item_simple, null, false);
        TextView icon = (TextView) v.findViewById(R.id.txtDrawerItemSimpleIcon);
        icon.setText(item.getIcon());
        //Iconify.addIcons(icon);
        LightFont.setFont(icon);
        ((TextView) v.findViewById(R.id.txtDrawerItemSimpleLabel)).setText(item.getLabel());
        return v;
    }

    private View displayDrawerItemCategory(View v, DrawerItemCategory category) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.drawer_item_category, null, false);
        ((TextView) v.findViewById(R.id.txtDrawerItemCategoryLabel)).setText(category.getLabel());
        return v;
    }

    private View displayDrawerItemProfile(View v, DrawerItemProfile profile) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.drawer_item_profile, null, false);
        ((TextView) v.findViewById(R.id.txtDrawerItemProfileLabel)).setText(profile.getLabel());
        ImageView img = (ImageView) v.findViewById(R.id.imgDrawerItemProfile);
        return v;
    }

    private View displayDrawerItemHeading(View v, DrawerItemHeading heading) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.drawer_item_heading, null, false);
        ((TextView) v.findViewById(R.id.txtDrawerItemProfileLabel)).setText(heading.getLabel());
        ImageView img = (ImageView) v.findViewById(R.id.imgDrawerItemProfile);
        img.setBackgroundColor(heading.getColor());
        img.setImageDrawable(heading.getImage());
        return v;
    }

    public interface DrawerListener {
        void onActiveViewChanged(View v);
    }


}
