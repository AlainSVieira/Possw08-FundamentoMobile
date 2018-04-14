package petdoe.com.br.petdoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.model.bo.OngBO;
import petdoe.com.br.petdoe.model.pojo.Meta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mychelle on 03/04/2018.
 */

public class GoalDetailActivity extends AppCompatActivity implements Callback<JsonObject> {

    private OngBO ongBO;
    private long idMeta;
    private TextView mTxtNameOng;
    private TextView mTxtPet;
    private TextView mTxtMeta;
    private TextView mTxtABout;
    private Meta mMeta;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_detail);
        initComponents();
        idMeta = getIntent().getLongExtra("ID_META", 0);
        ongBO = OngBO.getInstance();
        ongBO.getMeta(idMeta, this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_ong);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void initComponents(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_ong);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTxtNameOng = (TextView) findViewById(R.id.txt_name_ong_description);
        mTxtPet = (TextView) findViewById(R.id.txt_name_description);
        mTxtMeta = (TextView) findViewById(R.id.txt_about_goal);
        mTxtABout = (TextView) findViewById(R.id.txt_description_about);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onDonation(final View view){
        Bundle bundle = new Bundle();
       bundle.putInt("META", mMeta.getId());
        final Intent intent = new Intent("petdoe.com.br.petdoe.DONATION_ACTIVITY");
        intent.putExtras(bundle);
        startActivity(intent);
    }





    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        Gson gson = new Gson();
        mMeta = gson.fromJson(response.body(), Meta.class);
        setValues();
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {

    }

    public void setValues(){
        mTxtNameOng.setText(mMeta.getIdOng().getNome());
        mTxtPet.setText(mMeta.getIdPet().getNome());
        mTxtMeta.setText(String.valueOf(mMeta.getValor()));
        mTxtABout.setText(mMeta.getSobre());


    }
}
