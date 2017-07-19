    package com.example.android.justjava;

    import android.content.Intent;
    import android.icu.text.NumberFormat;
    import android.net.Uri;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    /**
     * This app displays an order form to order coffee.
     */
    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        /**
         * This method is called when the order button is clicked.
         */
        public void submitOrder(View view) {
            TextView quantityText = (TextView) findViewById(R.id.quantity_text_view);
            CheckBox whippedBox = (CheckBox) findViewById(R.id.toppbox);
            CheckBox chocoBox = (CheckBox) findViewById(R.id.toppbox2);
            EditText nameText = (EditText) findViewById(R.id.name);
            try {
                int quantity = Integer.valueOf(quantityText.getText().toString());
                int price = calculatePrice(quantity, 5, whippedBox.isChecked(), chocoBox.isChecked());
                String msg = createOrderSummary(nameText.getText().toString(), whippedBox.isChecked(),
                        chocoBox.isChecked(), quantity, price);
                emailMessage(msg, nameText.getText().toString());
            } catch (Exception e) {
                Log.d("DEBUG:", "Invalid value for quantity");
            }
        }

        /**
         * This method is called when the increment button is clicked.
         */
        public void increment(View view) {
            TextView quantityText = (TextView) findViewById(R.id.quantity_text_view);
            try {
                int quantity = Integer.valueOf(quantityText.getText().toString());
                if(++quantity > 100) {
                    displayQuantity(100);
                    Toast.makeText(getApplicationContext(),
                            "You can not input more than 100 coffees",
                            Toast.LENGTH_LONG).show();
                } else {
                    displayQuantity(quantity);
                }
            } catch (Exception e) {
                Log.d("DEBUG:", "Invalid value for quantity");
            }
        }

        /**
         * This method is called when the decrement button is clicked.
         */
        public void decrement(View view) {
            TextView quantityText = (TextView) findViewById(R.id.quantity_text_view);
            try {
                int quantity = Integer.valueOf(quantityText.getText().toString());
                if(--quantity < 1) {
                    displayQuantity(1);
                    Toast.makeText(getApplicationContext(),
                            "You can not input less than 1 coffee",
                            Toast.LENGTH_LONG).show();
                } else {
                    displayQuantity(quantity);
                }
            } catch (Exception e) {
                Log.d("DEBUG:", "Invalid value for quantity");
            }
        }

        /**
         * This method displays the given quantity value on the screen.
         */
        private void displayQuantity(int quantity) {
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            quantityTextView.setText("" + quantity);
        }

        /**
         *  This method displays the given text on screen
         */
        private void displayMessage(String message) {
            TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
            orderSummaryTextView.setText(message);
        }

        /**
         *  Calculates the price of orders
         *
         *  @param quantity quantity of products
         *  @param price price of each quantity
         *
         *  @return price times quantity
         */
        private int calculatePrice(int quantity,
                                   int price,
                                   boolean whippedCream,
                                   boolean choco) {
            int total = price;
            if(whippedCream)
                total += 1;
            if(choco)
                total += 2;

            return (total * quantity);
        }

        /**
         * Create the summary message to be displayed
         *
         * @param name of the person ordering
         * @param quantity of the products
         * @param price is the total price = price_per_quantity * quantity
         * @return summary message
         */
        private String createOrderSummary(String name,
                                          boolean addCream,
                                          boolean addChoco,
                                          int quantity,
                                          int price) {
            return "Name: " + name + "\n"
                    + "Add whipped cream? " + (addCream ? "true" : "false") + "\n"
                    + "Add chocolate? " + (addChoco ? "true" : "false") + "\n"
                    + "Quantity: " + quantity + "\n"
                    + "Total: " + price + "\n"
                    + "Thank You!";
        }

        /**
         * Sends summary as email via Intent
         * @param msg to be sent
         */
        private void emailMessage (String msg, String name) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for: " + name);
            intent.putExtra(Intent.EXTRA_TEXT, msg);
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    }
