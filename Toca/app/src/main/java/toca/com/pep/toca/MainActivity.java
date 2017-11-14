package toca.com.pep.toca;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.app.Activity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.CardInfo;
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

public class MainActivity extends AppCompatActivity {

    private boolean clickTransaction = false;
    public View latestLocalMusic;
    public View latestStore;
    private PaymentsClient mPaymentsClient;

    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 53;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPaymentsClient = Wallet.getPaymentsClient(this, new Wallet.WalletOptions.Builder()
                                        .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
                                        .build());

        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                selectedFragment = Home.newInstance();
                                break;
                            case R.id.navigation_np:
                                selectedFragment = NowPlaying.newInstance();
                                break;
                            case R.id.navigation_lm:
                                if(!clickTransaction) {
                                    selectedFragment = LocalMusic.newInstance();
                                }
                                break;
                            case R.id.navigation_st:
                                selectedFragment = Store.newInstance();
                                break;
                        }

                        if(!clickTransaction) {
                            Log.i("MainActivity:", "fragment transaction onCreate");
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.content, selectedFragment);
                            transaction.commit();
                        }
                        clickTransaction = false;
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, Home.newInstance());
        transaction.commit();
    }

    public void songClick(View v) {
        switch (v.getId()) {
            case R.id.lm_1:
                lmTransaction(v);
                break;
            case R.id.lm_2:
                lmTransaction(v);
                break;
            case R.id.lm_3:
                lmTransaction(v);
                break;
            case R.id.st_1:
                stTransaction(v);
                break;
            case R.id.st_2:
                stTransaction(v);
                break;
            case R.id.st_3:
                stTransaction(v);
                break;
        }
    }

    public void npTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        clickTransaction = true;

        NowPlaying f = new NowPlaying();
        Bundle b = new Bundle();

        if (latestLocalMusic != null) {
            b.putString("resource", latestLocalMusic.getResources().getResourceName(latestLocalMusic.getId()));
            f.setArguments(b);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, f);
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_np);
    }

    public void lmTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        // TODO: pass resource ID
        clickTransaction = true;

        LocalMusic f = new LocalMusic();
        Bundle b = new Bundle();

        if (v != null) {
            b.putString("resource", v.getResources().getResourceName(v.getId()));
            f.setArguments(b);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, f);
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_lm);

        latestLocalMusic = v;
    }

    public void stTransaction(View v) {
        // TODO: try to not create a new instance for each fragment call
        clickTransaction = true;

        Store f = new Store();
        Bundle b = new Bundle();

        if (v != null) {
            b.putString("resource", v.getResources().getResourceName(v.getId()));
            f.setArguments(b);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, f);
        transaction.commit();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_st);

        latestStore = v;
    }

    public void buyTransaction(View v) {
        // TODO: call external payment API

        PaymentDataRequest request = createPaymentDataRequest();
        if (request != null) {
            AutoResolveHelper.resolveTask(
                    mPaymentsClient.loadPaymentData(request),
                    MainActivity.this,
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
