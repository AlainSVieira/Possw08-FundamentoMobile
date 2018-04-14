package petdoe.com.br.petdoe.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mychelle on 13/04/2018.
 */

public class Doacao {

    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("valor")
    @Expose
    private String valor;
    @SerializedName("pagamentoEnum")
    @Expose
    private String pagamentoEnum;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("dateDoacao")
    @Expose
    private String dateDoacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPagamentoEnum() {
        return pagamentoEnum;
    }

    public void setPagamentoEnum(String pagamentoEnum) {
        this.pagamentoEnum = pagamentoEnum;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getDateDoacao() {
        return dateDoacao;
    }

    public void setDateDoacao(String dateDoacao) {
        this.dateDoacao = dateDoacao;
    }
}
