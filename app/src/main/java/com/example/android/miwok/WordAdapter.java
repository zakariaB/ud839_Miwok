package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import static android.R.attr.resource;

/*
* {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link AndroidFlavor} objects.
* */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mcolorId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *  @param context        The current context. Used to inflate the layout file.
     * @param wordList A List of word objects to display in a list
     * @param colorId
     */

    public WordAdapter(@NonNull Context context, @NonNull List<Word> wordList, int colorId) {
        super(context, 0, wordList);
        mcolorId = colorId;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            listItemView.findViewById(R.id.layout_text).setBackgroundColor(ContextCompat.getColor(getContext(), mcolorId));
        }

        Word currentword = getItem(position);

        TextView miworkText = (TextView) listItemView.findViewById(R.id.miwokText);
        miworkText.setText(currentword.getMiwokTranslation());

        TextView englishText = (TextView) listItemView.findViewById(R.id.englishText);
        englishText.setText(currentword.getDefaultTranslation());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if (currentword.hasImage()){
            image.setImageResource(currentword.getImageResourceId());
            image.setVisibility(View.VISIBLE);

        }else {
            image.setVisibility(View.GONE);
        }



        return listItemView;
    }


}
