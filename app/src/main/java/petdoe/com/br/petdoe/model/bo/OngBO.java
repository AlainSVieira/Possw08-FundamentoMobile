package petdoe.com.br.petdoe.model.bo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import petdoe.com.br.petdoe.application.MyApplication;
import petdoe.com.br.petdoe.model.pojo.Doacao;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Mychelle on 13/04/2018.
 */

public class OngBO {
    public MyApplication app = MyApplication.getInstance();
    private static OngBO instance = null;
    public static synchronized OngBO getInstance(){
        if (instance == null){
            instance = new OngBO();
        }
        return instance;
    }

    public void listOng(Callback<JsonArray> callback){
        app.setupRetrofit();
        Call<JsonArray> request = app.getService().listAllOng();
        request.enqueue(callback);
       // return null;
    }

    public void listMeta(Callback<JsonArray> callback){
        app.setupRetrofit();
        Call<JsonArray> request = app.getService().listAllMeta();
        request.enqueue(callback);
    }

    public void getOng(long id, Callback<JsonObject> callback){
        String idOng = String.valueOf(id);
        app.setupRetrofit();
        Call<JsonObject> request = app.getService().getOng(idOng);
        request.enqueue(callback);
    }

    public void getMeta(long id, Callback<JsonObject> callback){
        String idMeta = String.valueOf(id);
        app.setupRetrofit();
        Call<JsonObject> request = app.getService().getMeta(idMeta);
        request.enqueue(callback);
    }

    public void sendDoacao(Doacao doacao,  Callback<JsonObject> callback){

        app.setupRetrofit();
        Call<JsonObject> request = app.getService().sendDoacao(doacao);
        request.enqueue(callback);
    }


}
