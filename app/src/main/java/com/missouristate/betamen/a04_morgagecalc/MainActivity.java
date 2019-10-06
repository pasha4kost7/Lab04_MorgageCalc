package com.missouristate.betamen.a04_morgagecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateView();
    }

    private void updateView() {
        TextView amountTV = findViewById(R.id.tv_Amount);                                  //get data from Main View
        amountTV.setText(mortgage.getFormattedAmount());                                   // do math in the Mortgage
        TextView yearsTV = findViewById(R.id.tv_Years);
        yearsTV.setText(" " + mortgage.getYears());
        TextView rateTV = ( TextView ) findViewById( R.id.tv_Rate );
        rateTV.setText( 100 * mortgage.getRate( ) + "%" );
        TextView monthlyTV = ( TextView ) findViewById( R.id.tv_MontlyPayment );
        monthlyTV.setText( mortgage.formattedMonthlyPayment( ) );
        TextView totalTV = ( TextView ) findViewById( R.id.tv_TotalPayment );
        totalTV.setText( mortgage.formattedTotalPayment( ) );
    }

    public void modifyData(View view) {
        Intent myIntent = new Intent(this, DataActivity.class);             // createds new Intent and sends it to DataActivity class
        this.startActivity(myIntent);                                                     // start activity
        overridePendingTransition(R.anim.slide_from_left, 0);                    //slides from left when Modify button pressed on MainActivity
    }
}
