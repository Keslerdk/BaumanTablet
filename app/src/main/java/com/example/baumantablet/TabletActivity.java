package com.example.baumantablet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TabletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet);

        new GetTavletAsycTask().execute();
    }

    private class GetTavletAsycTask  extends AsyncTask<Void, Void, Void> {
        private static final String TAG = "GetTavletAsycTask";
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup
                        .connect("https://lks.bmstu.ru/schedule/2012e858-8610-11ea-876f-005056960017")
                        .get();

                Elements elements = doc.select("table.table tr");
                for (Element element : elements) {
                    Log.d(TAG, "doInBackground: "+ element);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}