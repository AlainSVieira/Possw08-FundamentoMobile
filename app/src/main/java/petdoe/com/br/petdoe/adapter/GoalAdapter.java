package petdoe.com.br.petdoe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.adapter.holder.GoalHolder;

/**
 * Created by Home on 03/04/2018.
 */

public class GoalAdapter extends RecyclerView.Adapter<GoalHolder> {


    private final int[] images = {
            R.drawable.goal_1,
            R.drawable.goal_2,
            R.drawable.goal_3,
            R.drawable.goal_4,
            R.drawable.goal_5
    };

    private final String[] namesOng = {
            "Meta Animal Aninha",
            "Meta Animal Julio",
            "Meta Animal Totó",
            "Meta Animal Lelé",
            "Meta Animal Lolo"
    };

    private final Context mContext;


    public GoalAdapter(
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
    public GoalHolder onCreateViewHolder(final ViewGroup parent,
                                        final int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.goal_row, parent, false);
        GoalHolder viewHolder = new GoalHolder(view);

        return viewHolder;
    }

    /**
     * Inicia as view da lista.
     *
     * @param holder   ViewHoder contendo os componentes da view.
     * @param position posição da lista.
     */
    @Override
    public void onBindViewHolder(final GoalHolder holder,
                                 final int position) {
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