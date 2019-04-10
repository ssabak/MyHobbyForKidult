package com.hobby.kidult.myhobbyforkidult.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hobby.kidult.myhobbyforkidult.R;
import com.hobby.kidult.myhobbyforkidult.data.Ps4Game;

import java.util.ArrayList;

public class Ps4GameListAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<Ps4Game> mPs4GamesList;
    int mLayout;

    public Ps4GameListAdapter(Context pContext, int pLayout, ArrayList<Ps4Game> pPs4GamesList) {
        mContext = pContext;
        mInflater = (LayoutInflater) pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPs4GamesList = pPs4GamesList;
        mLayout = pLayout;
    }

    @Override
    public int getCount() {
        return mPs4GamesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPs4GamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ps4GameItem_ViewHolder holder;

        if(convertView == null) {
            convertView = mInflater.inflate(mLayout, parent, false);
            holder = new Ps4GameItem_ViewHolder();

            holder.tv_Game_Name = (TextView) convertView.findViewById(R.id.tv_Game_Name);
            holder.tv_Game_Price = (TextView) convertView.findViewById(R.id.tv_Game_Price);

            holder.tv_Game_Buy_Date = (TextView) convertView.findViewById(R.id.tv_Game_Buy_Date);

            holder.tv_Game_Condition = (TextView) convertView.findViewById(R.id.tv_Game_Condition);
            holder.tv_Game_OpenYN = (TextView) convertView.findViewById(R.id.tv_Game_OpenYN);
            holder.tv_Game_EndingYN = (TextView) convertView.findViewById(R.id.tv_Game_EndingYN);
            holder.tv_Game_RentYN = (TextView) convertView.findViewById(R.id.tv_Game_RentYN);

            convertView.setTag(holder);
        } else {
            holder = (Ps4GameItem_ViewHolder) convertView.getTag();
        }

        holder.tv_Game_Name.setText(mPs4GamesList.get(position).getGameName());
        holder.tv_Game_Price.setText(mPs4GamesList.get(position).getGameName());

        holder.tv_Game_Buy_Date.setText(mPs4GamesList.get(position).getGameName());

        holder.tv_Game_Condition.setText(mPs4GamesList.get(position).getGameName());
        holder.tv_Game_OpenYN.setText(mPs4GamesList.get(position).getGameName());
        holder.tv_Game_EndingYN.setText(mPs4GamesList.get(position).getGameName());
        holder.tv_Game_RentYN.setText(mPs4GamesList.get(position).getGameName());

        return convertView;
    }

    class Ps4GameItem_ViewHolder {
        TextView tv_Game_Name;
        TextView tv_Game_Price;

        TextView tv_Game_Buy_Date;

        TextView tv_Game_Condition;
        TextView tv_Game_OpenYN;
        TextView tv_Game_EndingYN;
        TextView tv_Game_RentYN;
    }


}
