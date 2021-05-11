package com.example.baumantablet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.ArrayList;
import java.util.Calendar;

public class TabletActivity extends AppCompatActivity {
    private static final String TAG = "TabletActivity";

    CalendarView calendarView;

    BottomSheetBehavior bottomSheetBehavior;

    TextView weekDay;
    TextView dayOfMounth;
    TextView numberOfWeek;

    Calendar calendar;

    RecyclerView tabletRV;
    TabletRVAdapter tabletRVAdapter;

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

        calendar = Calendar.getInstance();
        setSelectedData(calendar);

        ArrayList<TabletModel> items = new ArrayList<>();
        items.add(new TabletModel("Линейна алгебра и аналитическая геометрия", "2"));
        items.add(new TabletModel("Линейна алгебра и аналитическая геометрия", "2"));
        items.add(new TabletModel("Линейна алгебра и аналитическая геометрия", "3"));
        items.add(new TabletModel("Линейна алгебра и аналитическая геометрия", "4"));

        tabletRV = findViewById(R.id.recyclerView);
        tabletRVAdapter = new TabletRVAdapter(items);
        tabletRV.setLayoutManager(new LinearLayoutManager(this));
        tabletRV.setAdapter(tabletRVAdapter);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                calendar.set(year, month, dayOfMonth);
                setSelectedData(calendar);

            }
        });


//        new GetTavletAsycTask().execute();
    }

    public void setSelectedData(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int numOfWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        Log.d(TAG, "setSelectedData: " + numOfWeek);
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                weekDay.setText("Понедельник,");
                break;
            case Calendar.TUESDAY:
                weekDay.setText("Вторник,");
                break;
            case Calendar.WEDNESDAY:
                weekDay.setText("Среда,");
                break;
            case Calendar.THURSDAY:
                weekDay.setText("Четверг,");
                break;
            case Calendar.FRIDAY:
                weekDay.setText("Пятница,");
                break;
            case Calendar.SATURDAY:
                weekDay.setText("Суббота,");
                break;
            case Calendar.SUNDAY:
                weekDay.setText("Воскресенье,");
                break;
        }

        if (numOfWeek <= 23 && numOfWeek >= 7) numberOfWeek.setText(String.valueOf(numOfWeek-6));
        else if (numOfWeek>=36) numberOfWeek.setText(String.valueOf(numOfWeek-35));
        else numberOfWeek.setText("0");
        dayOfMounth.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));

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