package com.christian.togstudyapp.ui.activity.SignInActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.GoogleAuthProvider;

import com.christian.togstudyapp.databinding.ActivitySignInBinding;
import com.christian.togstudyapp.ui.activity.lessonlistactivity.LessonListActivity;
import com.christian.togstudyapp.ui.activity.WelcomeActivity.WelcomeActivity;
import com.christian.togstudyapp.R;
import com.christian.togstudyapp.Utils.ActivityNavigation;
import com.christian.togstudyapp.Utils.Injection;

/**
 * Created by Rick on 3/6/2018.
 */

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;

    Context context = SignInActivity.this;

    FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;

    public SignInActivity(GoogleSignInClient mGoogleSignInClient) {
        this.mGoogleSignInClient = mGoogleSignInClient;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initData();
    }

    private void initData() {

       // mAuth = Injection.providesAuthHelper().getAuthInstance();

        authUser();
        instantiateGoogle();
        googleSignInListener();

        binding.backButton.setOnClickListener(v -> {

            Intent intent = new Intent(SignInActivity.this, WelcomeActivity.class);
            startActivity(intent);
        });
    }

    private void authUser() {

        binding.signInButton.setOnClickListener(view -> {

            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();

            if (isStringNull(email) || isStringNull(password)) {

                if (checkEmail(email) && checkPassword(password)) {

                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignInActivity.this, task -> {

                                if (!task.isSuccessful()) {

                                    Toast.makeText(context, getString(R.string.auth_failed),
                                            Toast.LENGTH_SHORT).show();

                                } else {

                                    Intent intent = new Intent(SignInActivity.this, LessonListActivity.class);
                                    startActivity(intent);
                                }
                            });

                } else if (!checkEmail(email)) {

                    Toast.makeText(context, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show();

                } else if (!checkPassword(password)) {

                    Toast.makeText(context, getString(R.string.invalid_password), Toast.LENGTH_SHORT).show();
                }

            } else {

                Toast.makeText(context, getString(R.string.blankEditText), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isStringNull(String string) {

        return !string.equals("") && string.length() != 0;
    }

    //     Firebase provides basic security verification when authenticating however if you want to improve
//     it you might have to do this manually within your app
    private boolean checkEmail(String email) {

        return email.contains("@") && email.contains(".com");
    }

    private boolean checkPassword(String password) {

        return password.length() >= 6;
    }

    private void instantiateGoogle() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void googleSignInListener() {

        binding.googleSignin.setOnClickListener(v -> {

            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                assert account != null;
                firebaseAuthWithGoogle(account);

            } catch (ApiException e) {

                Toast.makeText(context, getString(R.string.auth_failed), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {

                        //take me to main page
                        Toast.makeText(context, "itworked", Toast.LENGTH_SHORT).show();

                        ActivityNavigation.getInstance(SignInActivity.this).takeToRandomTask();

                    } else {

                        Toast.makeText(context, getString(R.string.auth_failed), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
