package com.satyajit.booklist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BooksAdapter extends ArrayAdapter<Books> {

    public BooksAdapter(Activity context, ArrayList<Books> bookList){
        super(context,0,bookList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list, parent, false);
        }
        Books currentBook = getItem(position);
        TextView bookNames = (TextView) listItemView.findViewById(R.id.text_viewBook);
        bookNames.setText(currentBook.getmBookName());

        TextView desc = (TextView) listItemView.findViewById(R.id.description_views);
        desc.setText(currentBook.getmDescription());

        ImageView bookImage = (ImageView) listItemView.findViewById(R.id.image_viewa);

        TextView authorName = (TextView) listItemView.findViewById(R.id.author_view);
        authorName.setText(currentBook.getmAuthor());


        return listItemView;
    }
}
