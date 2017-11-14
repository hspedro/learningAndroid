package com.pep.uplay;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.CardRequirements;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.TransactionInfo;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;

import java.util.Arrays;

public class Store extends AppCompatActivity {

    private PaymentsClient mPaymentsClient;
    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 53;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        mPaymentsClient = Wallet.getPaymentsClient(this, new Wallet.WalletOptions.Builder()
                .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
                .build());

        try {
            // Set image
            Intent intent = getIntent();
            String res = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
                    .replace("id", "drawable");

            String text = res.replace("drawable", "string");
            String idRes = res.split("/")[1];
            String resDrawable;
            switch(idRes) {
                case "st_1":
                    resDrawable = res.replace("st_1", "paramore");
                    text = text.replace("st_1", "text_paramore");
                    break;
                case "st_2":
                    resDrawable = res.replace("st_2", "jcole");
                    text = text.replace("st_2", "text_jcole");
                    break;
                case "st_3":
                    resDrawable = res.replace("st_3", "metallica");
                    text = text.replace("st_3", "text_metallica");
                    break;
                default:
                    resDrawable = res;
                    break;
            }

            // Set image resource
            ImageView iView = findViewById(R.id.st_star);
            int id = getResources().getIdentifier(resDrawable, null, null);
            iView.setImageResource(id);

            Log.i("Store", "text: " + text);
            // Set text resource
            TextView tView = findViewById(R.id.text_st);
            id = getResources().getIdentifier(text, null, null);
            tView.setText(id);


        } catch (Exception e) {
            if (getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE) == null) {
                Log.i("Store:", "bundle is null again...");
            } else {
                Log.i("Store:", "we better run bro");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_lm) {
            Intent intent = new Intent(this, LocalMusic.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_np) {
            Intent intent = new Intent(this, NowPlaying.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buyTransaction(View v) {
        // TODO: call external payment API

        PaymentDataRequest request = createPaymentDataRequest();
        if (request != null) {
            AutoResolveHelper.resolveTask(
                    mPaymentsClient.loadPaymentData(request),
                    Store.this,
                    // LOAD_PAYMENT_DATA_REQUEST_CODE is a constant value
                    // you define.
                    LOAD_PAYMENT_DATA_REQUEST_CODE);
        }
    }

    private void isReadyToPay(View v) {
        IsReadyToPayRequest request = IsReadyToPayRequest.newBuilder()
                .addAllowedPaymentMethod(WalletConstants.PAYMENT_METHOD_CARD)
                .addAllowedPaymentMethod(WalletConstants.PAYMENT_METHOD_TOKENIZED_CARD)
                .build();
        Task<Boolean> task = mPaymentsClient.isReadyToPay(request);
        task.addOnCompleteListener(
                new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        try {
                            boolean result = task.getResult(ApiException.class);
                            if (result) {
                                // Show Google as payment option
                            } else {
                                // Hide Google as payment option
                            }
                        } catch (ApiException e) {
                            Log.i("MainActivity:", "ApiException");
                        }
                    }
                });
    }

    private PaymentDataRequest createPaymentDataRequest() {
        PaymentDataRequest.Builder request =
                PaymentDataRequest.newBuilder()
                        .setTransactionInfo(
                                TransactionInfo.newBuilder()
                                        .setTotalPriceStatus(WalletConstants.TOTAL_PRICE_STATUS_FINAL)
                                        .setTotalPrice("0.99")
                                        .setCurrencyCode("USD")
                                        .build())
                        .addAllowedPaymentMethod(WalletConstants.PAYMENT_METHOD_CARD)
                        .addAllowedPaymentMethod(WalletConstants.PAYMENT_METHOD_TOKENIZED_CARD)
                        .setCardRequirements(
                                CardRequirements.newBuilder()
                                        .addAllowedCardNetworks(
                                                Arrays.asList(
                                                        WalletConstants.CARD_NETWORK_AMEX,
                                                        WalletConstants.CARD_NETWORK_DISCOVER,
                                                        WalletConstants.CARD_NETWORK_VISA,
                                                        WalletConstants.CARD_NETWORK_MASTERCARD))
                                        .build());

        PaymentMethodTokenizationParameters params =
                PaymentMethodTokenizationParameters.newBuilder()
                        .setPaymentMethodTokenizationType(
                                WalletConstants.PAYMENT_METHOD_TOKENIZATION_TYPE_PAYMENT_GATEWAY)
                        .addParameter("gateway", "yourGateway")
                        .addParameter("gatewayMerchantId", "yourMerchantIdGivenFromYourGateway")
                        .build();

        request.setPaymentMethodTokenizationParameters(params);
        return request.build();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case LOAD_PAYMENT_DATA_REQUEST_CODE:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        PaymentData paymentData = PaymentData.getFromIntent(data);
                        String token = paymentData.getPaymentMethodToken().getToken();
                        break;
                    case Activity.RESULT_CANCELED:
                        break;
                    case AutoResolveHelper.RESULT_ERROR:
                        Status status = AutoResolveHelper.getStatusFromIntent(data);
                        // Log the status for debugging.
                        // Generally, there is no need to show an error to
                        // the user as the Google Payment API will do that.
                        break;
                    default:
                        // Do nothing.
                }
                break;
            default:
                // Do nothing.
        }
    }
}
