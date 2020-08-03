package izzi.soft.projectokego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import izzi.soft.projectokego.dbhelper.DatabaseHelper;
import izzi.soft.projectokego.inputValidation.InputValidation;

public class MainActivity extends AppCompatActivity  {
    TextView textView;
    private final AppCompatActivity activity = MainActivity.this;




    private EditText textInputEditTextPhonee;
    private EditText textInputEditTextPasswordd;
    private CardView carddView;

    private AppCompatButton appCompatButtonLogin;

    private AppCompatTextView textViewLinkRegister;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        textView = findViewById(R.id.txt);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/Nexa-XBold.otf");
        textView.setTypeface(typeface);
        textInputEditTextPhonee= findViewById(R.id.textInputEditTextPhoneee);
        textInputEditTextPasswordd= findViewById(R.id.textInputEditTextPassworddd);

        textViewLinkRegister =  findViewById(R.id.textViewLinkRegister);
        textViewLinkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        carddView = findViewById(R.id.cardview);
        carddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valuee1 = textInputEditTextPhonee.getText().toString().trim();
                String valuee2 = textInputEditTextPasswordd.getText().toString().trim();

                boolean chkphone = databaseHelper.phonepass(valuee1, valuee2);

                if (valuee1.equals("")){
                    textInputEditTextPhonee.setError("Isi Nomor Anda Terlebih Dahulu");
                    textInputEditTextPhonee.requestFocus();
                }
                else if (valuee2.equals("")){

                    textInputEditTextPasswordd.setError("Password Masih Kosong");
                    textInputEditTextPasswordd.requestFocus();

                }
//                if (valuee1.equals("") || valuee2.equals("")){
//                    Toast.makeText(activity, "Fields are Empty", Toast.LENGTH_SHORT).show();
//
//                }

                else {
                    if (chkphone==true){
                    Toast.makeText(activity, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, DashboardActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(activity, "No telpon atau password Salah", Toast.LENGTH_SHORT).show();
                }

                }



            }
        });


    }


//    private void initObjects() {
//        databaseHelper = new DatabaseHelper(activity);
//        inputValidation = new InputValidation(activity);
//    }
//
//    private void initViews() {
//        textInputLayoutPhone =  findViewById(R.id.textInputLayoutEmail);
//        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
//
//        textInputEditTextPhone =  findViewById(R.id.textInputEditTextEmail);
//        textInputEditTextPassword =  findViewById(R.id.textInputEditTextPassword);
//
//        carddView = findViewById(R.id.cardview);
//        textViewLinkRegister =  findViewById(R.id.textViewLinkRegister);
//    }
//    private void initListeners() {
//        carddView.setOnClickListener(this);
//        textViewLinkRegister.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.cardview:
//                veriftySQlite();
//
//            case R.id.textViewLinkRegister:
//                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
//                startActivity(intent);
//                finish();
//        }
//
//    }
//
//    private void veriftySQlite() {
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextPhone, textInputLayoutPhone, getString(R.string.Salah))){
//            return;
//        } if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPhone, getString(R.string.Salah))){
//         return;
//        } if (databaseHelper.checkUser(textInputEditTextPhone.getText().toString().trim(), textInputEditTextPassword.getText().toString().trim())){
//            Intent accountsIntent = new Intent(activity, DashboardActivity.class );
//            startActivity(accountsIntent);
//            emptyInputEditText();
//
//        }
//        else {
//            Toast.makeText(activity,  getString(R.string.error_valid_email_password), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void emptyInputEditText() {
//        textInputEditTextPhone.setText(null);
//        textInputEditTextPassword.setText(null);
//    }
}