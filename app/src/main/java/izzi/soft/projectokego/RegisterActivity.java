package izzi.soft.projectokego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.ImageFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import izzi.soft.projectokego.Model.User;
import izzi.soft.projectokego.dbhelper.DatabaseHelper;
import izzi.soft.projectokego.inputValidation.InputValidation;

public class RegisterActivity extends AppCompatActivity  {
    TextView textView;
    private final AppCompatActivity activity = RegisterActivity.this;
    Animation animation;
    public static Context contextmyfunction;

    DatabaseHelper db;


    private EditText textInputEditTextName;
    private EditText textInputEditTextPhone;
    private EditText textInputEditTextPassword;
    private EditText textInputEditTextConfirmPassword;
    private CardView btn;

    private AppCompatTextView appCompatTextViewLoginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textView = findViewById(R.id.txt);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/Nexa-XBold.otf");
        textView.setTypeface(typeface);
        db = new DatabaseHelper(this);




        textInputEditTextName = (EditText) findViewById(R.id.textInputEditTextNama);
        textInputEditTextPhone = (EditText) findViewById(R.id.textInputEditTextPhone);
        textInputEditTextPassword = (EditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (EditText) findViewById(R.id.textInputEditTextConfirmPassword);
        btn =  findViewById(R.id.register);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.textViewLinkLogin);
        appCompatTextViewLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = textInputEditTextPhone.getText().toString().trim();
                String value2 = textInputEditTextName.getText().toString().trim();
                String value3 = textInputEditTextPassword.getText().toString().trim();
                String value4 = textInputEditTextConfirmPassword.getText().toString().trim();
//                if (value1.equals("") ||value2.equals("") ||value3.equals("")){
//                    Toast.makeText(activity, "Fields are Empty", Toast.LENGTH_SHORT).show();
//                }

                if (value2.equals("")){
                    textInputEditTextName.setError("Silahkan Isi Nama anda terlebih dahulu");
                    textInputEditTextName.requestFocus();
                }   else  if (value1.equals("")){
                    textInputEditTextPhone.setError("Silahkan Isi Nomor anda terlebih dahulu");
                    textInputEditTextPhone.requestFocus();
                }
                else  if (value3.equals("")){
                    textInputEditTextPassword.setError("Silahkan Isi Password anda terlebih dahulu");
                    textInputEditTextPassword.requestFocus();
                }
                else  if (value4.equals("")){
                    textInputEditTextConfirmPassword.setError("Silahkan Isi Penyuasain Password anda terlebih dahulu");
                    textInputEditTextConfirmPassword.requestFocus();
                }
                else {
                if (value3.equals(value4)) {
                    boolean chkphone = db.checkPhone(value1);
                    if (chkphone == true) {
                        boolean insert = db.insert(value1, value2, value3);
                        if (insert == true) {
                            Toast.makeText(activity, "Register Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity, MainActivity.class);
                            startActivity(intent);

                            }
                        }
                    else {
                        Toast.makeText(activity, "Nomor Sudah Terpakai", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(activity, "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();


                }

                }



                }

        });









//    private void initObjects() {
//        inputValidation = new InputValidation(activity);
//        databaseHelper = new DatabaseHelper(activity);
//        user = new User();
//    }
//
//    private void initViews() {
//
//    }
//
//    private void initListeners() {
//        btn.setOnClickListener(this);
//        appCompatTextViewLoginLink.setOnClickListener(this);
//    }
//


    }










//        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextPhone, textInputLayoutPhone, getString(R.string.error_message_Number))) {
//            return;
//        }
//
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
//                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
//            return;
//        } if (textInputLayoutPassword.equals(textInputEditTextConfirmPassword)){
//            boolean -
//        }

    }
//
//    private void postDataToSQLite() {
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextPhone, textInputLayoutPhone, getString(R.string.error_message_Number))) {
//            return;
//        }
//
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
//                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
//            return;
//        }
//        if (!databaseHelper.checkUser(textInputEditTextPhone.getText().toString().trim())) {
//
//            user.setName(textInputEditTextName.getText().toString().trim());
//            user.setPhone(textInputEditTextPhone.getText().toString().trim());
//            user.setPassword(textInputEditTextPassword.getText().toString().trim());
//
//            databaseHelper.addUser(user);
//
//            // Snack Bar to show success message that record saved successfully
//            Toast.makeText(activity, "Registration Successful", Toast.LENGTH_SHORT).show();
//            emptyInputEditText();
//
//
//        }else {
//
//            Toast.makeText(activity, "Email Already Exists", Toast.LENGTH_SHORT).show();
//
//        }
//
//    }
//
//    private void emptyInputEditText() {
//        textInputEditTextName.setText(null);
//        textInputEditTextPhone.setText(null);
//        textInputEditTextPassword.setText(null);
//        textInputEditTextConfirmPassword.setText(null);
//    }

