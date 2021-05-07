package com.example.baumantablet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TabletActivity extends AppCompatActivity {

    CalendarView calendarView;

    BottomSheetBehavior bottomSheetBehavior;

    TextView weekDay;
    TextView dayOfMounth;
    TextView numberOfWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet);

        calendarView = findViewById(R.id.calendarView);
        ConstraintLayout bottomSheetLayout = findViewById(R.id.bottomSheetLayout);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);

        weekDay = findViewById(R.id.weekDay);
        dayOfMounth = findViewById(R.id.dayOfMounth);
        numberOfWeek = findViewById(R.id.numberOfWeek);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                weekDay.setText(String.valueOf(dayOfMonth));
                dayOfMounth.setText(String.valueOf(dayOfMonth));
                numberOfWeek.setText(String.valueOf(dayOfMonth));
            }
        });

//        new GetTavletAsycTask().execute();
    }

    private class GetTavletAsycTask extends AsyncTask<Void, Void, Void> {
        private static final String TAG = "GetTavletAsycTask";

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup
                        .connect("https://lks.bmstu.ru/schedule/2012e858-8610-11ea-876f-005056960017")
                        .get();

                Elements elements = doc.select("table.table tr");
                for (Element element : elements) {
                    Log.d(TAG, "doInBackground: " + element);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}