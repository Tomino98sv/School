package com.example.menucko;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static List<SongClass> list; //static to remember after leaving activity wrong way but onrestore won't work after leaving activity
    List<SongClass> favList;
    MyAdapter adapter;

    String songs[] = {"Hello","Bye","Alohha","DAVAJ","Strecaj","MERCY","bumbum","shalala","rakija","karotka"};
    String albums[] = {"blueneigh","cash","ema","face","heart","lips","madona","morelife","plague","strange"};
    int images[] = {R.drawable.blueneigh,R.drawable.cash,R.drawable.ema,R.drawable.face,R.drawable.heart,R.drawable.lips,R.drawable.madona,R.drawable.morelife,R.drawable.plague,R.drawable.strange};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity","onCreate start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        if (i.getSerializableExtra("favoriteList")!=null){
            favList = (List<SongClass>)i.getSerializableExtra("favoriteList");
        }

        if (favList == null){
            favList = new ArrayList<SongClass>();
        }

        if (list == null){
            System.out.println("creating list cause is null");
            list = new ArrayList<SongClass>();
            for (int a = 0;a<songs.length;a++){
                SongClass songClass = new SongClass(songs[a],albums[a],images[a]);
                list.add(songClass);
            }
        }

        listView = findViewById(R.id.listSongs);
        adapter = new MyAdapter(this,list);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
        Log.i("MainActivity","onCreate end");


    }

    class MyAdapter extends ArrayAdapter<SongClass> {
        //array adapter create view for each object in collection
        //when data is changed adapter rebuild the viewList
        Context context;
        List<SongClass> list;

        MyAdapter(Context c, List<SongClass> listSongs) {
            super(c, R.layout.song, R.id.textViewSong, listSongs);
            this.context = c;
            this.list = listSongs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View song = layoutInflater.inflate(R.layout.song, parent, false);
            ImageView images = song.findViewById(R.id.image);
            TextView songName = song.findViewById(R.id.textViewSong);
            TextView albumName = song.findViewById(R.id.textView2);

            images.setImageResource(list.get(position).getImageSource());
            songName.setText(list.get(position).getSongName());
            albumName.setText(list.get(position).getAlbum());

            return song;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.removeOpt:
                Toast.makeText(this,list.get(info.position).getSongName()+" remove",Toast.LENGTH_SHORT).show();
                list.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.addFavOpt:
                boolean allreadyAdded = false;
                for (SongClass song:favList) {
                    if (song.getSongName().equalsIgnoreCase(list.get(info.position).getSongName())){
                        allreadyAdded = true;
                        break;
                    }
                }
                if (allreadyAdded==false){
                    favList.add(list.get(info.position));
                    Toast.makeText(this,list.get(info.position).getSongName()+" added ToFavorite",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,list.get(info.position).getSongName()+" already added",Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.aboutOpt:
                Toast.makeText(this,"chacha toto este ne",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.songListNav){
            Toast.makeText(MainActivity.this,"you are here",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.favSongsNav){
            Intent favsongAct = new Intent(MainActivity.this,FavoriteSongsActiviy.class);
            favsongAct.putExtra("favoriteList", (Serializable) favList);
            startActivity(favsongAct);
            return false;
        }
            return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.i("MainActivity","onSaveInstanceState start");
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("ActualList",(Serializable)list);
        Log.i("MainActivity","onSaveInstanceState end");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("MainActivity","onRestoreInstanceState start");
        super.onRestoreInstanceState(savedInstanceState);
        list = (List<SongClass>) savedInstanceState.getSerializable("ActualList");
        adapter = new MyAdapter(this,list);
        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();     don't work this here cause object list is same only data in it have been changed....mayby
        Log.i("MainActivity","onRestoreInstanceState end");
    }

}


//
//"Inflating" a view means taking the layout XML and parsing it
//to create the view and viewgroup objects from the elements and
//their attributes specified within, and then adding the hierarchy of
//those views and viewgroups to the parent ViewGroup.
//
//When you call setContentView(),it attaches the views it creates from reading the XML to the activity.
//You can also use LayoutInflater to add views to another ViewGroup, which can be a useful tool in a lot of circumstances.