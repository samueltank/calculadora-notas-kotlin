package br.senai.ctlnotas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer().schedule(2000) { openActivity() };
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent);
        finish();
    }
}

