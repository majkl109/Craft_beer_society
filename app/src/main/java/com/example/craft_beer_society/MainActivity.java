package com.example.craft_beer_society;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements CustomAdapter.onItemClicked{

  private RecyclerView recyclerView;
  private CustomAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      recyclerView = findViewById(R.id.recycler);
      recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
      adapter = new CustomAdapter();
      adapter.setData(generateBeers());
      recyclerView.setAdapter(adapter);
      adapter.setListener(this);
  }


  private ArrayList<BeerData> generateBeers(){

      ArrayList<BeerData> data = new ArrayList<>();
      data.add(new BeerData("Plavuša i Neposlušna", "https://www.agroklub.com/prehrambena-industrija/zadruzno-pivo-svi-bi-plavusu-i-neposlusnu-iz-brloga/46591/", "https://www.antenazadar.hr/wp-content/uploads/2018/03/plavusa-1.jpg"));
      data.add(new BeerData("Bura brew", "https://www.burabrew.hr/our-roots-1", "https://image.dnevnik.hr/media/images/920x695/Apr2018/61487390.jpg"));
      data.add(new BeerData("Baltazar", "http://www.pivovara-medvedgrad.hr/beer/baltazar/","https://1.bp.blogspot.com/-z25wkIWHEns/WPRmioH4fCI/AAAAAAAADUQ/o-d8nSntMKEW35hrrDY9oEVgkpCJNAG6ACLcB/s1600/IMG_3470.JPG"));


      return data;
  }
  @Override
  public void onItemClicked(BeerData item, int position){
      Toast.makeText(this, "Beer clicked" + item.getTitle(), Toast.LENGTH_SHORT).show();
  }
}


/**
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = findViewById(R.id.list);
        ArrayList<BeerData> arrayList = new ArrayList<>();
        arrayList.add(new BeerData("Plavuša i Neposlušna", "https://www.agroklub.com/prehrambena-industrija/zadruzno-pivo-svi-bi-plavusu-i-neposlusnu-iz-brloga/46591/", "https://www.antenazadar.hr/wp-content/uploads/2018/03/plavusa-1.jpg"));
        arrayList.add(new BeerData("Bura brew", "https://www.burabrew.hr/our-roots-1", "https://image.dnevnik.hr/media/images/920x695/Apr2018/61487390.jpg"));
        arrayList.add(new BeerData("Baltazar", "http://www.pivovara-medvedgrad.hr/beer/baltazar/","https://1.bp.blogspot.com/-z25wkIWHEns/WPRmioH4fCI/AAAAAAAADUQ/o-d8nSntMKEW35hrrDY9oEVgkpCJNAG6ACLcB/s1600/IMG_3470.JPG"));
        CustomAdapter customAdapter = new CustomAdapter(arrayList, this);
        list.setAdapter(customAdapter);
    }
}
*/