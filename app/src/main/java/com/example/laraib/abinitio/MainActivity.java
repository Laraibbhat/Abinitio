package com.example.laraib.abinitio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import static com.example.laraib.abinitio.R.drawable.calender;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        initializeAction();
        setupListView();

    }

    private void setupUIViews() {
        toolbar=(Toolbar)findViewById(R.id.tbMain);
        listView=(ListView)findViewById(R.id.lvMain);
    }

    private void initializeAction() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Abinitio 2k19");
    }

    private void setupListView()
    {
        String[] title = getResources().getStringArray(R.array.Title);
        String[] description  = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,title,description);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title,description,click;
        private String[] titlearray,descriptionarray;
        private ImageView imageView;

        public SimpleAdapter(Context context,String[] title,String[] description)
        {
            mcontext = context;
            titlearray = title;
            descriptionarray = description;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titlearray.length;
        }

        @Override
        public Object getItem(int i) {
            return titlearray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

       @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view ==null)
            {
                view = layoutInflater.inflate(R.layout.item_activity__main,null);
            }

            title=(TextView)view.findViewById(R.id.tvTitle);
            imageView=(ImageView)view.findViewById(R.id.ivMain);
            description=(TextView)view.findViewById(R.id.tvDescription);
            click=(TextView)view.findViewById(R.id.tvClick);

            if (titlearray[i].equalsIgnoreCase("Timetable")){
                title.setText("Timetable");
                description.setText("Description 1");
                imageView.setImageResource(R.drawable.calender);
            }else if (titlearray[i].equalsIgnoreCase("Departments")){
                title.setText("Departments");
                description.setText("Description 2");
                imageView.setImageResource(R.drawable.book);
            }else if (titlearray[i].equalsIgnoreCase("Coordinators")){
                title.setText("Coodinators");
                description.setText("Description 3");
                imageView.setImageResource(R.drawable.contact);
            }else if (titlearray[i].equalsIgnoreCase("Settings")){
                title.setText("Settings");
                description.setText("Description 4");
                imageView.setImageResource(R.drawable.settings);
            }

            return view;
        }
    }



}


