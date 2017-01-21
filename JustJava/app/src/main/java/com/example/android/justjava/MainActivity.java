/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 */
package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.content.Intent.*;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    private int quantity=0;
    private int pricePerCup=5;
    private int chocolate_price=2;
    private int cream_price=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(quantity);
    }

    /*
     *Creates the summary of the order
     */
    private String createOrderSummary(String customer_name,boolean whipped_cream_checked,boolean chocolate_cream_checked, int price){
        String ret=getString(R.string.body_line1,customer_name);
        ret+="\n"+getString(R.string.body_line2,whipped_cream_checked);
        ret+="\n"+getString(R.string.body_line3,chocolate_cream_checked);
        ret+="\n"+getString(R.string.quant,quantity);
        ret+="\n"+getString(R.string.total);
        ret+=NumberFormat.getCurrencyInstance().format(price);
        ret+="\n"+ getString(R.string.Thankyou);
        return ret;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        boolean whipped_cream_checked = ((CheckBox) findViewById(R.id.whipped_cream)).isChecked();
        boolean chocolate_cream_checked = ((CheckBox) findViewById(R.id.chocolate_cream)).isChecked();
        EditText edit=(EditText) findViewById(R.id.customerName);
        String customer_name= edit.getText().toString();
        int price=pricePerCup;
        if(whipped_cream_checked==true)price+=cream_price;
        if(chocolate_cream_checked==true)price+=chocolate_price;
        price=price*quantity;

        display(quantity);
        String msg=createOrderSummary(customer_name,whipped_cream_checked,chocolate_cream_checked,price);

        Intent EmailIntent =new Intent(ACTION_SENDTO);
        EmailIntent.setData(Uri.parse("mailto:"));
        String[] addresses=new String[2];
        addresses[0]=getString(R.string.email1);
        addresses[1]=getString(R.string.email2);
        EmailIntent.putExtra(EXTRA_EMAIL,addresses);
        EmailIntent.putExtra(EXTRA_SUBJECT,getString(R.string.subject,customer_name));
        EmailIntent.putExtra(EXTRA_TEXT,msg);
        if(EmailIntent.resolveActivity(getPackageManager())!=null){
            startActivity(EmailIntent);
        }

    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view){
        if(quantity<100)quantity++;
        else {
            Toast.makeText(this, getString(R.string.limitEXC), Toast.LENGTH_SHORT).show();
        }
        display(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view){
        if(quantity>0)quantity--;
        else{
            Toast.makeText(this,getString(R.string.orderMore),Toast.LENGTH_SHORT).show();
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



}