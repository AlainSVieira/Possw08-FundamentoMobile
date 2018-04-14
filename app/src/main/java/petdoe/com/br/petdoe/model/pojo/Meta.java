package petdoe.com.br.petdoe.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mychelle on 13/04/2018.
 */

public class Meta implements Serializable{
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("idOng")
    @Expose
    private Ong idOng;
    @SerializedName("idPet")
    @Expose
    private Pet idPet;
    @SerializedName("dataCria\u00c3\u00a7\u00c3\u00a3o")
    @Expose
    private Object dataCriaO;
    @SerializedName("valor")
    @Expose
    private int valor;
    @SerializedName("sobre")
    @Expose
    private String sobre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ong getIdOng() {
        return idOng;
    }

    public void setIdOng(Ong idOng) {
        this.idOng = idOng;
    }

    public Pet getIdPet() {
        return idPet;
    }

    public void setIdPet(Pet idPet) {
        this.idPet = idPet;
    }

    public Object getDataCriaO() {
        return dataCriaO;
    }

    public void setDataCriaO(Object dataCriaO) {
        this.dataCriaO = dataCriaO;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

}
