package com.codepath.popularphotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class InstagramPhotoAdapter extends ArrayAdapter<InstagramPhoto>{
    public InstagramPhotoAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, 0, objects);
    }

    private static class ViewHolder {
        TextView caption;
        TextView username;
        ImageView image;
        ImageView profilePhoto;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_photo, parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivPhoto);
            viewHolder.profilePhoto = (ImageView) convertView.findViewById(R.id.ivProfilePhoto);
            viewHolder.caption = (TextView) convertView.findViewById(R.id.tvCaption);
            viewHolder.username = (TextView) convertView.findViewById(R.id.tvUsername);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.caption.setText(photo.caption);
        viewHolder.username.setText(photo.username);
        viewHolder.image.setImageResource(0);
        viewHolder.profilePhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(viewHolder.image);
        Picasso.with(getContext()).load(photo.userProfileImageUrl).
                transform(new CircleTransform()).into(viewHolder.profilePhoto);

        return convertView;
    }
}
