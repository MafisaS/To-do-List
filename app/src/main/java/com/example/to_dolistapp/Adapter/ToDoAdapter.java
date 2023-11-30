package com.example.to_dolistapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.to_dolistapp.MainActivity;
import com.example.to_dolistapp.Model.ToDoModel;
import com.example.to_dolistapp.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>
{
   private List<ToDoModel> toDoModelList;
   private MainActivity activity;

   public ToDoAdapter(MainActivity activity)
   {
       this.activity = activity;
   }

   public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
   {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.task_layout, parent, false);
       return new ViewHolder(itemView);
   }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
       ToDoModel item= toDoModelList.get(position);
       holder.task.setText(item.getTasks());
       holder.task.setChecked(toBoolean(item.getStatus()));
    }

    private Boolean toBoolean(int n)
    {
        return n!=0;
    }

    public void setTasks(List<ToDoModel> toDoList)
    {
        this.toDoModelList= toDoList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return toDoModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
   {
       CheckBox task;

       ViewHolder(View view)
   {
       super(view);
       task = itemView.findViewById(R.id.todo_checkbox);
   }
   }
}
