package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    public ImageView imageView;

    public ArrayList<Integer> testArray = new ArrayList<Integer>();

    int[] imageArray = {
            R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5,
            R.drawable.image_6, R.drawable.image_7, R.drawable.image_8, R.drawable.image_9, R.drawable.image_10,
            R.drawable.image_11, R.drawable.image_12, R.drawable.image_13, R.drawable.image_14, R.drawable.image_15,
            R.drawable.image_16, R.drawable.image_17, R.drawable.image_18, R.drawable.image_19, R.drawable.image_20,
            R.drawable.image_21, R.drawable.image_22, R.drawable.image_23, R.drawable.image_24, R.drawable.image_25,
            R.drawable.image_26, R.drawable.image_27, R.drawable.image_28, R.drawable.image_29, R.drawable.image_30,
            R.drawable.image_31, R.drawable.image_32, R.drawable.image_33, R.drawable.image_34, R.drawable.image_35,
            R.drawable.image_36, R.drawable.image_37, R.drawable.image_38, R.drawable.image_39, R.drawable.image_40,
            R.drawable.image_41, R.drawable.image_42, R.drawable.image_43, R.drawable.image_44, R.drawable.image_45,
            R.drawable.image_46, R.drawable.image_47, R.drawable.image_48, R.drawable.image_49, R.drawable.image_50,
            R.drawable.image_51, R.drawable.image_52, R.drawable.image_53, R.drawable.image_54, R.drawable.image_55,
            R.drawable.image_56, R.drawable.image_57, R.drawable.image_58, R.drawable.image_59, R.drawable.image_60
            };
/*
* R.drawable.image_31, R.drawable.image_32, R.drawable.image_33, R.drawable.image_34, R.drawable.image_35,
            R.drawable.image_36, R.drawable.image_37, R.drawable.image_38, R.drawable.image_39, R.drawable.image_40,
            R.drawable.image_41, R.drawable.image_42, R.drawable.image_43, R.drawable.image_44, R.drawable.image_45,
            R.drawable.image_46, R.drawable.image_47, R.drawable.image_48, R.drawable.image_49, R.drawable.image_50,
            R.drawable.image_51, R.drawable.image_52, R.drawable.image_53, R.drawable.image_54, R.drawable.image_55,
            R.drawable.image_56, R.drawable.image_57, R.drawable.image_58, R.drawable.image_59, R.drawable.image_60,

* */

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
/*
        context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_photos, parent, false);
        }

        imageView = (ImageView) convertView.findViewById(R.id.imageview);
        imageView.setImageResource(imageArray[position]);

        return convertView;
*/
        context = parent.getContext();
        if (null != convertView)
            imageView = (ImageView)convertView;
        else {
            //---------------------------------------------------------------
            // GridView 뷰를 구성할 ImageView 뷰의 비트맵을 정의합니다.
            // 그리고 그것의 크기를 320*240으로 줄입니다.
            // 크기를 줄이는 이유는 메모리 부족 문제를 막을 수 있기 때문입니다.

            Bitmap bmp
                    = BitmapFactory.decodeResource(context.getResources(), imageArray[position]);
            bmp = Bitmap.createScaledBitmap(bmp, 320, 240, false);

            //---------------------------------------------------------------
            // GridView 뷰를 구성할 ImageView 뷰들을 정의합니다.
            // 뷰에 지정할 이미지는 앞에서 정의한 비트맵 객체입니다.

            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);

            imageView.setImageBitmap(bmp);

            //---------------------------------------------------------------
            // 지금은 사용하지 않는 코드입니다.

            //imageView.setMaxWidth(320);
            //imageView.setMaxHeight(240);
            //imageView.setImageResource(imageIDs[position]);

            //---------------------------------------------------------------
            // 사진 항목들의 클릭을 처리하는 ImageClickListener 객체를 정의합니다.
            // 그리고 그것을 ImageView의 클릭 리스너로 설정합니다.
        }

        return imageView;
    }
}
