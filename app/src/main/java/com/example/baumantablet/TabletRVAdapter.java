package com.example.baumantablet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TabletRVAdapter extends RecyclerView.Adapter<TabletRVAdapter.TabletViewHolder> {

    ArrayList<TabletModel> tabletItems;

    public TabletRVAdapter(ArrayList<TabletModel> tabletItems) {
        this.tabletItems = tabletItems;
    }

    @NonNull
    @Override
    public TabletViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tablet_item, parent, false);
        TabletViewHolder tvh = new TabletViewHolder(view);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TabletViewHolder holder, int position) {
        TabletModel current = tabletItems.get(position);

        holder.subjectNameTextView.setText(current.getSubjectName());
        holder.lessonNumberTextView.setText(current.getLessonNum());
    }

    @Override
    public int getItemCount() {
        return tabletItems.size();
    }

    public class TabletViewHolder extends RecyclerView.ViewHolder {
        TextView subjectNameTextView;
        TextView lessonNumberTextView;

        public TabletViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectNameTextView = itemView.findViewById(R.id.subjectNameTextView);
            lessonNumberTextView = itemView.findViewById(R.id.lessonNumberTextView);
        }
    }
}
