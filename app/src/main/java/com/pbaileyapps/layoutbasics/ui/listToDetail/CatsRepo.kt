package com.pbaileyapps.layoutbasics.ui.listToDetail

import android.content.Context
import com.pbaileyapps.layoutbasics.R

object PuppyAdoptionRepo {

    fun getCat(
        catId: Int,
        context: Context
    ): Cats = getCatsList(context).find {
        it.catId == catId
    }!!

    fun getCatsList(context: Context) = listOf(
        Cats(
            1,
            R.drawable.item_image_lulu,
            context.getString(R.string.cat_name_lulu),
            context.getString(R.string.cat_description_lulu),
            context.getString(R.string.cat_about_lulu),
        ),
        Cats(
            2,
            R.drawable.item_image_lala,
            context.getString(R.string.cat_name_lala),
            context.getString(R.string.cat_description_lala),
            context.getString(R.string.cat_about_lala),
        ),
        Cats(
            3,
            R.drawable.item_image_dd,
            context.getString(R.string.cat_name_dd),
            context.getString(R.string.cat_description_dd),
            context.getString(R.string.cat_about_dd),
        ),
        Cats(
            4, R.drawable.item_image_tt,
            context.getString(R.string.cat_name_tt),
            context.getString(R.string.cat_description_tt),
            context.getString(R.string.cat_about_tt),
        ),
        Cats(
            5,
            R.drawable.item_image_chuchu,
            context.getString(R.string.cat_name_chuchu),
            context.getString(R.string.cat_description_chuchu),
            context.getString(R.string.cat_about_chuchu),
        ),
        Cats(
            6,
            R.drawable.item_image_coco,
            context.getString(R.string.cat_name_coco),
            context.getString(R.string.cat_description_coco),
            context.getString(R.string.cat_about_coco),
        ),
        Cats(
            7,
            R.drawable.item_image_momo,
            context.getString(R.string.cat_name_momo),
            context.getString(R.string.cat_description_momo),
            context.getString(R.string.cat_about_momo),
        )
    )
}