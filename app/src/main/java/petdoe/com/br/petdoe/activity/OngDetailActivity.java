package petdoe.com.br.petdoe.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.model.bo.OngBO;
import petdoe.com.br.petdoe.model.pojo.Ong;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mychelle on 03/04/2018.
 */

public class OngDetailActivity extends AppCompatActivity implements Callback<JsonObject> {
    private OngBO ongBO;
    private long idOng;
    private TextView mTxtName;
    private TextView mTxtAbout;
    private TextView mTxtCnpj;
    private TextView mTxtAddress;
    private TextView mTxtPhone;
    private TextView mTxtEmail;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ong_detail);
        initComponents();
        idOng = getIntent().getLongExtra("ID_ONG", 0);
        ongBO = OngBO.getInstance();
        ongBO.getOng(idOng, this);
    }

    public void initComponents(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_ong);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTxtName = (TextView) findViewById(R.id.txt_description_name);
        mTxtAbout = (TextView) findViewById(R.id.txt_description_about);
        mTxtCnpj = (TextView) findViewById(R.id.txt_description_cnpj);
        mTxtAddress = (TextView) findViewById(R.id.txt_description_address);
        mTxtPhone = (TextView) findViewById(R.id.txt_description_phone);
        mTxtEmail = (TextView) findViewById(R.id.txt_description_email);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        Gson gson = new Gson();
        Ong ong = gson.fromJson(response.body(), Ong.class);
        setValues(ong);

    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {

    }

    public void setValues(final Ong ong){
        mTxtName.setText(ong.getNome());
        mTxtAbout.setText(ong.getSobre());
        mTxtCnpj.setText(ong.getCnpj());
        mTxtAddress.setText(ong.getEndereco());
        mTxtEmail.setText(ong.getEmail());
        mTxtPhone.setText(ong.getTelefone());

    }

}
