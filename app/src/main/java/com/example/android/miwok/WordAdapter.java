package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param wordList A List of word objects to display in a list
     */

    public WordAdapter(@NonNull Context context, @NonNull List<Word> wordList) {
        super(context, 0, wordList);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentword = getItem(position);

        TextView miworkText = (TextView) listItemView.findViewById(R.id.miwokText);
        miworkText.setText(currentword.getMiwokTranslation());

        TextView englishText = (TextView) listItemView.findViewById(R.id.englishText);
        englishText.setText(currentword.getDefaultTranslation());


        return listItemView;
    }


}
