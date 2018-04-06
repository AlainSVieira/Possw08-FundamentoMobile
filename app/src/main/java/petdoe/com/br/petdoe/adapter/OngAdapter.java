package petdoe.com.br.petdoe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.adapter.holder.OngHolder;

/**
 * Created by Mychelle Rocha on 02/04/2018.
 */
public class OngAdapter extends RecyclerView.Adapter<OngHolder> {


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


    public OngAdapter(
            final Context context) {

        this.mContext = context;


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
        return 5;
    }
}

