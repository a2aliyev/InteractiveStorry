package com.example.aydinaliyev.interactivestorry.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aydinaliyev.interactivestorry.R;
import com.example.aydinaliyev.interactivestorry.model.Page;
import com.example.aydinaliyev.interactivestorry.model.Story;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private final Story story = new Story();
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if(name == null || name.isEmpty()){
            name = "Default";
        }
        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        loadPage(1);

        Log.d(TAG, name);
    }

    private void loadPage(int i) {
        Page page = story.getPage(i);
        Drawable img = ContextCompat.getDrawable(this,page.getImageId());
        storyImageView.setImageDrawable(img);
    }
}
