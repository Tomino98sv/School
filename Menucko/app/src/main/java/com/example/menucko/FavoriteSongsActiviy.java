package com.example.menucko;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import java.util.List;

public class FavoriteSongsActiviy extends AppCompatActivity {

    List<SongClass> favList;
    ListView listView;
    MyAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_song);
        Intent i = getIntent();
        favList = (List<SongClass>)i.getSerializableExtra("favoriteList");
        listView = findViewById(R.id.favListView);

        adapter = new MyAdapter(this,favList);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
        Log.i("FavoriteSongsActiviy","onCreate");

    }

    class MyAdapter extends ArrayAdapter<SongClass> {

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.favSongsNav){
            Toast.makeText(FavoriteSongsActiviy.this,"you are here",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.songListNav){
            Intent songListAct = new Intent(FavoriteSongsActiviy.this,MainActivity.class);
            songListAct.putExtra("favoriteList", (Serializable) favList);
            startActivity(songListAct);
            return false;
        }
            return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("ActualPopList",(Serializable)favList);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        favList = (List<SongClass>)savedInstanceState.getSerializable("ActualPopList");
        adapter = new MyAdapter(this,favList);
        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();     don't work this here cause object list is same only data in it have been changed....mayby
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
        menu.removeItem(R.id.addFavOpt);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.removeOpt:
                Toast.makeText(this,favList.get(info.position).getSongName()+" remove",Toast.LENGTH_SHORT).show();
                favList.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.aboutOpt:
                Toast.makeText(this,"chacha toto este ne",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
