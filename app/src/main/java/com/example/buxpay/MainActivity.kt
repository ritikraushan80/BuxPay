package com.example.buxpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buxpay.fragment.WelcomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            replaceFragment(WelcomeFragment())

    }

    private fun replaceFragment(fragment: WelcomeFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()


    }
}