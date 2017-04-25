package com.ma.chasheng.chalutong.utils;
import android.graphics.Color;

import com.ma.chasheng.chalutong.R;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.Util;

/**
 * Created by 哈士奇爱吃苹果 on 2016/12/27.
 */

public class BuilderManger {
    private static int[] imageResources = new int[]{
            R.drawable.bat,
            R.drawable.bear,
            R.drawable.bee,
            R.drawable.butterfly,
            R.drawable.cat,
            R.drawable.deer,
            R.drawable.dolphin,
//            R.drawable.eagle,
//            R.drawable.horse,
//            R.drawable.owl,
//            R.drawable.peacock,
//            R.drawable.pig,
//            R.drawable.rat,
//            R.drawable.snake,
//            R.drawable.squirrel
    };
    private static int imageResourceIndex = 0;

    public static int getImageResource() {
        if (imageResourceIndex >= imageResources.length) imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }

    private static String[] textResources = new String[]{
         "资质提交","我的信息","发布商品","商品管理","订单管理","审核结果","我的店铺"
    };

    public static String getTextResource() {
        if (imageResourceIndex >= imageResources.length) imageResourceIndex = 0;
        return textResources[imageResourceIndex++];
    }



    static TextInsideCircleButton.Builder getTextInsideCircleButtonBuilder() {
        return new TextInsideCircleButton.Builder()
                .normalImageRes(getImageResource())
                .normalTextRes(R.string.text_inside_circle_button_text_normal);
    }

    static TextInsideCircleButton.Builder getSquareTextInsideCircleButtonBuilder() {
        return new TextInsideCircleButton.Builder()
                .isRound(false)
                .shadowCornerRadius(Util.dp2px(10))
                .buttonCornerRadius(Util.dp2px(10))
                .normalImageRes(getImageResource())
                .normalTextRes(R.string.text_inside_circle_button_text_normal);
    }

    static TextInsideCircleButton.Builder getTextInsideCircleButtonBuilderWithDifferentPieceColor() {
        return new TextInsideCircleButton.Builder()
                .normalImageRes(getImageResource())
                .normalTextRes(R.string.text_inside_circle_button_text_normal)
                .pieceColor(Color.WHITE);
    }

}
