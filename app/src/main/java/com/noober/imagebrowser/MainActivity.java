package com.noober.imagebrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.noober.image.ImageBrowser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageBrowser imageBrowser = findViewById(R.id.imageBrowser);
        List<String> list = new ArrayList<>();
        list.add("http://img1.imgtn.bdimg.com/it/u=3920398476,1501488149&fm=27&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=3920398476,1501488149&fm=27&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=3920398476,1501488149&fm=27&gp=0.jpg");list.add("http://img1.imgtn.bdimg.com/it/u=3920398476,1501488149&fm=27&gp=0.jpg");
        //test1
        imageBrowser.setImageList(list);
    }
}
