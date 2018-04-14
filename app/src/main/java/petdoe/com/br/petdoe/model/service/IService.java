package petdoe.com.br.petdoe.model.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import petdoe.com.br.petdoe.model.pojo.Doacao;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Mychelle on 19/02/2018.
 * Serviço responsável por buscar as notícias no servidor
 */

public interface IService {


    /**
     * busca o workshop ativo
     * @return
     */
    @GET("ong/")
    Call<JsonArray> listAllOng();

    /**
     * servico que busca as noticias
     * @return
     */
    @GET("meta/")
    Call<JsonArray> listAllMeta();


    /**
     * busca o carrocel de imagens da noticia
     * @return
     */
    @GET("meta/{id}")
    Call<JsonObject> getMeta(@Path("id") String id);

    /**
     * busca as imagens da galeria de noticias
     * @return
     */
    @GET("ong/{id}")
    Call<JsonObject> getOng(@Path("id") String id);



    @POST("doador/")
    Call<JsonObject> sendDoacao(@Body Doacao doacao);


}
