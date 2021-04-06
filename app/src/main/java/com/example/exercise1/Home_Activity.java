package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    SearchView searchView;

    private ListView list;
    private com.example.exercise1.ListViewAdapter adapter;
    String[] listNama;
    public  static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listNama = new String[]{"Inayah","Ilham","Eris",
        "Fikri","Maul","Intan","Vina","Gita","Vian","Lutfi"};
        list=  findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();
        for (int i=0;i<listNama.length;i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new com.example.exercise1.ListViewAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a",nama.trim());
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(com.example.exercise1.Home_Activity.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnView:
                intent = new Intent(getApplicationContext(), com.example.exercise1.ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnomor:
                String nama = bundle.getString("a");
                switch(nama)
                {
                    case "Inayah":
                        Toast.makeText(getApplicationContext(),"081234567890",Toast.LENGTH_LONG).show();
                        break;
                    case "Ilham":

                        Toast.makeText(getApplicationContext(),"082345678901",Toast.LENGTH_LONG).show();
                        break;
                    case "Eris":

                        Toast.makeText(getApplicationContext(),"083456789012",Toast.LENGTH_LONG).show();
                        break;
                    case "Fikri":

                        Toast.makeText(getApplicationContext(),"084567890123",Toast.LENGTH_LONG).show();
                        break;
                    case "Maul":

                        Toast.makeText(getApplicationContext(),"085678901234",Toast.LENGTH_LONG).show();
                        break;
                    case "Intan":

                        Toast.makeText(getApplicationContext(),"086789012345",Toast.LENGTH_LONG).show();
                        break;
                    case "Vina":

                        Toast.makeText(getApplicationContext(),"087890123456",Toast.LENGTH_LONG).show();
                        break;
                    case "Gita":

                        Toast.makeText(getApplicationContext(),"088901234567",Toast.LENGTH_LONG).show();
                        break;
                    case "Lutfi":

                        Toast.makeText(getApplicationContext()," 089012345678",Toast.LENGTH_LONG).show();
                        break;
                    case "Vian":

                        Toast.makeText(getApplicationContext(),"080123456789",Toast.LENGTH_LONG).show();
                        break;
                }
        }
        return false;
    }
}