package uz.exemple.less6_task4_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less6_task4_java.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    ArrayList<String> arrayList;

    public MainAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType ==2){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main2,parent,false);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main1,parent,false);
        }
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if ((position+1)%5 * 2 == 0){
            return 2;
        }else {
            return 1;
        }
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }
    }
}
