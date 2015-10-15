package com.example.meiriq0717.gitexe;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.srain.cube.image.CubeImageView;
import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.image.impl.DefaultImageLoadHandler;
import in.srain.cube.util.LocalDisplay;

/**
 * Created by meiriq0717 on 2015/10/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MViewHolder> {

    private List<Map<String, String>> mList = new ArrayList<Map<String, String>>();
    private ImageLoader mImageLoader;
    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
        DefaultImageLoadHandler handler = new DefaultImageLoadHandler(mContext);
        //handler.setImageFadeIn(false);
        handler.setImageRounded(true, 50);
        handler.setLoadingImageColor(Color.YELLOW);
       // ImageLoaderFactory.setDefaultImageLoadHandler(handler);
        mImageLoader = ImageLoaderFactory.create(context, handler);
        //   mImageLoader.setImageLoadHandler(handler);
    }

    public void setDataList(List<Map<String, String>> list) {
        mList = list;
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlayout, null);

        return new MViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MViewHolder viewHolder, int i) {
        viewHolder.imageTitle.setText(mList.get(i).get("title"));
        viewHolder.cube_iv.loadImage(mImageLoader, mList.get(i).get("imageUrl"));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder {
        private CubeImageView cube_iv;
        private TextView imageTitle;

        public MViewHolder(View itemView) {
            super(itemView);
            cube_iv = (CubeImageView) itemView.findViewById(R.id.cube_iv);
            imageTitle = (TextView) itemView.findViewById(R.id.imageTitle);
        }
    }
}
