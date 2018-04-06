package petdoe.com.br.petdoe.adapter.holder;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import petdoe.com.br.petdoe.R;

/**
 * Created by Mychelle Rocha on 02/04/2018.
 */
public class OngHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final TextView mNameOng;

    public final CardView mCardNews;

    public final ImageView mImgOng;





    public OngHolder(View itemView) {
        super(itemView);
        mCardNews = (CardView) itemView.findViewById(R.id.card_ong);
        mImgOng = (ImageView) itemView.findViewById(R.id.img_ong);
        mNameOng = (TextView) itemView.findViewById(R.id.txt_name);

        itemView.setOnClickListener(this);
        mCardNews.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.card_ong:
                final Intent intent = new Intent("petdoe.com.br.petdoe.DETAIL_ONG");
                v.getContext().startActivity(intent);
                break;
            default:

                break;
        }
    }


}
