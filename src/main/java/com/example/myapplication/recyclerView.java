package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class recyclerView extends AppCompatActivity {

    Button b1;

    private ArrayList<User> usersList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        b1 = findViewById(R.id.button5);
        b1.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent i = new Intent(recyclerView.this, SecondActivity.class);
                        startActivity(i);
                    }
                }
        );
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        usersList.add(new User("Barcelona - Barcelona is without a doubt Spain's cultural capital. The Catalonian city's urban sprawl is dotted with Antoni Gaudí's whimsical architecture, including La Sagrada Família, as well as museums carrying the masters, such as the Picasso Museum. You can also explore centuries-old neighborhoods like Barri Gòtic, which dates back to the Roman Empire. Don't forget to take advantage of the city's equally magnificent outdoor offerings, too, including Park Güell and La Barceloneta beach"));
        usersList.add(new User("Seville - This beautiful Andalusian city is awash with romantic allure. During the day, you'll find outdoor cafes along cobblestone streets and horse-drawn carriages meandering through pastel-colored plazas. And when night falls, flamenco dancing comes out in full force. This is the kind of place you should allow yourself to get lost in, but if you carve out time for popular sites such as the Plaza de España and the Real Alcázar, you won't be disappointed, either"));
        usersList.add(new User("Madrid - Of all the cities in Spain, Madrid is the one that knows how to show travelers the best time. The city's party-hard reputation is really all it's cracked up to be, but that's not all Spain's capital has going for it. Madrid is filled with varied, vibrant neighborhoods, plus stunning parks, enviable shopping and some of the best art institutions in Europe, including the world-renowned Prado Museum and the Thyssen-Bornemisza National Museum."));
        usersList.add(new User("Granada - Granada's Arabic influence makes this destination different from the rest of Spain. Thanks to its history as part of the Moorish Empire, Granada is home to tapas bars and flamenco venues that rub elbows with Moroccan tea cafes and Arab bathhouses. This confluence allows you to experience two cultures simultaneously. And you must make time to behold the breathtaking local treasures, including the Alhambra and Sierra Nevada National Park."));
        usersList.add(new User("Mallorca - Mallorca is easily one of Spain's greatest assets. This dreamy island getaway features beautiful beaches, picturesque small towns and outdoors pursuits that draw tourists in droves. Revel in the see-through blue waters of Playa de Muro and Cala Llombards, then hop in a car and drive around the striking mountains that make up Serra de Tramuntana, a UNESCO World Heritage Site. Make sure you spend your downtime taking leisurely strolls along the darling streets of Alcúdia's old town and by the water to admire the awe-inspiring Palma Cathedral."));
        usersList.add(new User("Bilbao - Although this northern Spanish city is best known for housing the Guggenheim, there's more to Bilbao than its famed museum. Bilbao sits in the middle of a beautiful valley, affording incredible views of the city and its rolling hills. Visit Casco Viejo (the city's old town) for delectable pintxos (Basque tapas) and to explore Parque Etxebarria, where you'll find some of Bilbao's best vistas. Or, ride the Funicular de Artxanda for even more spectacular panoramas. No visit would be complete without checking out the world-renowned Guggenheim and other local cultural institutions, such as the Museo de Bellas Artes de Bilbao."));
        usersList.add(new User("Ibiza - If you live to party, there's no better place to go than Ibiza. This Spanish island is known worldwide for its nightlife scene, so much so that people often say you must visit during the peak summer season. However, one look at Ibiza's natural offerings and you'll understand how this island stands on its own outside of its party-hardy reputation. Beaches here are so clear that you can see your feet touch the sand as they enter the ocean. Plus, the historical charm found in UNESCO World Heritage-listed Dalt Vila, Ibiza's old town, will certainly stop you in your tracks."));
        usersList.add(new User("Canary Islands - This cluster of Spanish islands located off the northwestern coast of Africa is one of Spain's premier beach destinations. In addition to sultry shorelines, the Canary Islands are also teeming with outdoor attractions that will make any adventurer swoon, including three national parks. In between hiking and relaxing on the beach, take some time to stroll the neighborhoods of Santa Cruz or Las Palmas to get a taste of local life."));
        usersList.add(new User("Valencia - Valencia stands out for offering a little taste of both the old and the new. You'll get to experience classic architecture at the Valencia Cathedral and the Plaza del Ayuntamiento, as well as modern sites like the City of Arts and Sciences and the Valencia Institute of Modern Art. After you've gotten your fill of the city, take a detour to breathe in some fresh air at the Albufera Natural Park or unwind at nearby beaches."));
        usersList.add(new User("San Sebastian - Situated along the northern coast, San Sebastian is one of the most underrated destinations in Spain. Locals understand its majesty and every summer flock to this beach destination for its breathtaking shorelines, hiker-friendly mountains and unmatched foodie scene that's world-famous for its pintxos. For a quintessentially Basque experience, travelers suggest pintxo bar hopping in the city's center, Parte Vieja, or signing up for a pintxos food tour"));
        usersList.add(new User("Alicante - Alicante is a great destination for those who want to beach it while still experiencing the hustle and bustle of city life. This city of more than 1 million residents offers plenty of life on and off the shore. To start, hit up Playa del Postiguet, which is located in the heart of the city, or Playa de San Juan, Alicante's most popular beach. For fun away from the sand, head to the Castillo de Santa Bárbara (which provides incredible city views), the vibrant neighborhood of Santa Cruz and cultural institutions like the Museo de Arte Contemporáneo de Alicante."));


    }
}