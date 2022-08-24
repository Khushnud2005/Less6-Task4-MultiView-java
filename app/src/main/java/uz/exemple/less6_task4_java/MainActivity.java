package uz.exemple.less6_task4_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import uz.exemple.less6_task4_java.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView  recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0;i<40;i++){
            arrayList.add("Item "+ i);
        }
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position+1)%5 * 2 == 0){
                    return 2;
                }else {
                    return 1;
                }

            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MainAdapter(arrayList));
    }
}