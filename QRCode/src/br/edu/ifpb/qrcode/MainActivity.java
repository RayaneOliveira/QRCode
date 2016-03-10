package br.edu.ifpb.qrcode;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultado);
        
        new IntentIntegrator(this).initiateScan();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        switch (requestCode) {
        
            case IntentIntegrator.REQUEST_CODE:
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                
                final String result = scanResult.getContents();
                
                if ((result != null)) {
                	
                	Toast.makeText(this, "Código: " + result, Toast.LENGTH_LONG).show();
                	
                	TextView textResult = (TextView) findViewById(R.id.textResultado);
                    textResult.setText(result);
                	
                } else {
                	
                	Toast.makeText(getBaseContext(), "Código inválido ou inexistente.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}

