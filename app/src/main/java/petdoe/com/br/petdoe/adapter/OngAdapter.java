package petdoe.com.br.petdoe.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.adapter.holder.OngHolder;
import petdoe.com.br.petdoe.model.pojo.Ong;

/**
 * Created by Mychelle Rocha on 02/04/2018.
 */
public class OngAdapter extends RecyclerView.Adapter<OngHolder> {
    private List<Ong> mListOng;


    private final int[] images = {
            R.drawable.ong_vida_animal,
            R.drawable.ong_cat,
            R.drawable.ong_vida,
            R.drawable.ong_sem_raca,
            R.drawable.ong_sos
    };

    private final String[] namesOng = {
            "Ong Vida Animal",
            "Ong gatos",
            "Ong Vida",
            "Ong Sem raça definida",
            "Ong SOS"
    };

    private final Context mContext;


    public OngAdapter(final Context context, final List<Ong> listOng) {
        this.mContext = context;
        this.mListOng = listOng;
    }

    /**
     * Infla a view utilisada no Recycleview.
     *
     * @param parent   view group.
     * @param viewType tipo da view.
     */
    @Override
    public OngHolder onCreateViewHolder(final ViewGroup parent,
                                        final int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.row_ong, parent, false);
        OngHolder viewHolder = new OngHolder(view);

        return viewHolder;
    }

    /**
     * Inicia as view da lista.
     *
     * @param holder   ViewHoder contendo os componentes da view.
     * @param position posição da lista.
     */
    @Override
    public void onBindViewHolder(final OngHolder holder,
                                 final int position) {
        OngHolder newsViewHolder = holder;
        holder.mImgOng.setImageDrawable(mContext.getDrawable(images[position]));
        holder.mNameOng.setText(namesOng[position]);
        holder.mNameOng.setText(mListOng.get(position).getNome());
        holder.mCardNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putLong("ID_ONG", mListOng.get(position).getId());
                final Intent intent = new Intent("petdoe.com.br.petdoe.DETAIL_ONG");
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }
    //   }



    /**
     * Retorna aquantidade de view que o adapter deve criar.
     * i
     *
     * @return quantidade de itens da lista.
     */
    @Override
    public int getItemCount() {
        return mListOng.size();
    }
}

