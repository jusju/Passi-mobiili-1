package fi.softala.passi.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import fi.softala.passi.adapters.GroupAdapter;
import fi.softala.passi.R;
import fi.softala.passi.models.Kayttaja;
import fi.softala.passi.models.Ryhma;
import fi.softala.passi.network.PassiClient;
import fi.softala.passi.network.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RyhmatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ryhmat);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final Gson gson = new Gson();

        SharedPreferences mySharedPreferences = getSharedPreferences("konfiguraatio", Context.MODE_PRIVATE);

        String base = mySharedPreferences.getString("token", "");
        String tunnus = mySharedPreferences.getString("tunnus", "");

        PassiClient service =
                ServiceGenerator.createService(PassiClient.class, base);
        Call<Kayttaja> call = service.haeKayttaja(tunnus);

        call.enqueue(new Callback<Kayttaja>() {
            @Override
            public void onResponse(Call<Kayttaja> call, Response<Kayttaja> response) {
                final List<Ryhma> ryhmat = response.body().getRyhmat();
                RecyclerView.Adapter adapter = new GroupAdapter(getApplicationContext(), ryhmat, R.layout.button_layout, new GroupAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Ryhma ryhma) {
                        String ryhmaJSON = gson.toJson(ryhma);
                        Toast.makeText(getApplicationContext(), "Ryhmaid " + ryhma.getGroupID(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TehtavakortitActivity.class);
                        intent.putExtra("Group", ryhmaJSON);
                        startActivity(intent);
                    }
                });
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Kayttaja> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ryhmien haku epäonnistui" + t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }



}
