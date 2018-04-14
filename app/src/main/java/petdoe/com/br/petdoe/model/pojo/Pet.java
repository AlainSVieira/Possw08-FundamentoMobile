package petdoe.com.br.petdoe.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mychelle on 13/04/2018.
 */

public class Pet {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nome")
    @Expose
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
