package com.example.fancylisttest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends ArrayAdapter<Person> {

    private Context context;
    private Person [] people;

    public PersonAdapter(Context context, Person [] people) {
        super(context, R.layout.row,people);

        this.context = context;
        this.people = people;
    }

    public View getView(int position, View view, ViewGroup group){

        View customView = View.inflate(this.context, R.layout.row, null);

        // get the components of custome view
        ImageView rowImageView   = customView.findViewById(R.id.imageView);
        TextView  titleTextView  = customView.findViewById(R.id.textView);
        TextView detailsTextView = customView.findViewById(R.id.textView1);

        //populate these components
        titleTextView.setText(this.people[position].getName());
        detailsTextView.setText(this.people[position].getPhone());

        // transform image name to image id
        String imageName = this.people[position].getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));

        int imageId = this.context.getResources().getIdentifier(imageName,"drawable",this.context.getPackageName());
        rowImageView.setImageResource(imageId);

        return customView;
    }

}
