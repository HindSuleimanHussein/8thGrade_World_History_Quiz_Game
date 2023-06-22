package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class MainActivity3 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        MyListData[] listData = new MyListData[]{
                new MyListData("The religions in both Mesopotamia and " +
                        "ancient Egypt were polytheistic, meaning they believed in " +
                        "multiple gods and goddesses, and were based on nature. Both " +
                        "civilizations had gods of the sky, earth, freshwater, " +
                        "and the sun, as well as gods devoted to human emotions and the underworld." +
                        "As well as has developed distinct systems of written language ", R.drawable.first),
                new MyListData("The teachings of Daoism state that since people " +
                        "are generally incapable of self-governance, the least government " +
                        "is the best government. As a result, followers of Daoism would " +
                        "be most likely to agree with the statement \"Government intrusiveness " +
                        "should be kept to a minimum”.", R.drawable.second),
                new MyListData("During the Paleolithic period, humans grouped together " +
                        "in small societies such as bands and subsisted by gathering plants and fishing, " +
                        "hunting or scavenging wild animals. Additionally humans would create artistic cave drawings", R.drawable.third),
                new MyListData("Buddhism developed in reaction to the established religion" +
                        " in India at the time—Hinduism (Brahminism).", R.drawable.fourth),
                new MyListData("Meroe became a major trading power mainly because of its natural iron deposits. " +
                        "With such vast amounts of readily available iron at their disposal, the Kush, " +
                        "having developed their own smelting techniques, managed to produce a variety of " +
                        "iron goods that they could use for trading with other cultures.", R.drawable.fifth),
                new MyListData("In 286 CE, Emperor Diocletian decided to divide Rome into two sections " +
                        "to try and stabilize the empire.", R.drawable.sixth),



        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyAdapter adapter = new MyAdapter(this, listData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // saving my data in shared preferences by converting it into string representation using gson
        Gson gson = new Gson();
        String json = gson.toJson(listData);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("myListData", json);
        editor.apply();
    }
}
