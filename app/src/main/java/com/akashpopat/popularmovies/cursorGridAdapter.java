package com.akashpopat.popularmovies;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.akashpopat.popularmovies.database.MoviesColumns;
import com.squareup.picasso.Picasso;

/**
 * Created by akash on 22/2/16.
 */
public class cursorGridAdapter extends CursorAdapter {
    Context mContext;

    public cursorGridAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

        mContext = context;

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, 750));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        return  imageView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        view.setTag(Util.cursorToJsonObj(cursor));
        //Loading image from below url into imageView
        Picasso picasso = Picasso.with(mContext);
        picasso.load(cursor.getString(MoviesColumns.COL_POSTER))

                .into((ImageView) view);
    }

}

