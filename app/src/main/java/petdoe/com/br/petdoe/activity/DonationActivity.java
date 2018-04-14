package petdoe.com.br.petdoe.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.gson.JsonObject;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.model.bo.OngBO;
import petdoe.com.br.petdoe.model.pojo.Doacao;
import petdoe.com.br.petdoe.model.pojo.Meta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mychelle Rocha on 02/04/2018.
 */
public class DonationActivity extends AppCompatActivity implements Callback<JsonObject> {
    private OngBO ongBO;
    private EditText mEdName;
    private EditText mEdValue;
    private RadioGroup mRadioGroup;
    private String formPayment;
    private int mIdMeta;
    private  AlertDialog alerta;;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_activity);
        mIdMeta =  getIntent().getIntExtra("META", 0);
        initComponnents();
        ongBO = OngBO.getInstance();
       // ongBO.se(idOng, this);
    }

    private void initComponnents(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_ong);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mEdName = (EditText) findViewById(R.id.txt_description_name);
        mEdValue = (EditText) findViewById(R.id.txt_description_amount);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.ticket:
                        formPayment = "boleto";
                        break;
                    case R.id.credit:
                        formPayment = "credito";
                        break;
                    case R.id.debit:
                        formPayment = "debito";
                        break;
                    default:
                        break;
                }
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSendDonation(final View view){
        Meta meta = new Meta();
        meta.setId(mIdMeta);
        Doacao doacao = new Doacao();
        doacao.setPagamentoEnum(formPayment);
        doacao.setNome(mEdName.getText().toString());
        doacao.setValor(mEdValue.getText().toString());
        doacao.setMeta(meta);
        if (TextUtils.isEmpty(mEdName.getText())) {
            mEdName.setError("Preencha o campo nome");
        }
        else if (TextUtils.isEmpty(mEdValue.getText())) {
            mEdValue.setError("Preencha o campo valor");
        }else{
            ongBO.sendDoacao(doacao, this);
        }


    }

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
          AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Doação");
        //define a mensagem
        builder.setMessage("Doação realizada com sucesso.");
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
               finish();
            }
        });

        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {

    }
}
