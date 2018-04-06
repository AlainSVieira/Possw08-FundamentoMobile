package petdoe.com.br.petdoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import petdoe.com.br.petdoe.R;

/**
 * Created by Home on 03/04/2018.
 */

public class GoalDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_ong);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onDonation(final View view){
        final Intent intent = new Intent("petdoe.com.br.petdoe.DONATION_ACTIVITY");
        startActivity(intent);
    }

}
