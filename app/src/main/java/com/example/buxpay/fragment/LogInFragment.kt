package com.example.buxpay.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.buxpay.R
import com.example.buxpay.activity.HomeActivity
import com.google.android.material.button.MaterialButton

class LogInFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_log_in, container, false)

        val submitbtn = view.findViewById<Button>(R.id.loginbtn)

        submitbtn.setOnClickListener(){
            val homefragment = HomeActivity()

            startActivity(Intent(activity,homefragment::class.java))

            Toast.makeText(activity, "Welcome to my BuxPay " , Toast.LENGTH_SHORT).show()

        }

        /// If You New customer ------

        val sign = view.findViewById<TextView>(R.id.sign)

        sign.setOnClickListener{

            val fragmentmanager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentmanager.beginTransaction()
            fragmentTransaction.replace(R.id.framelayout, SignUpFragment())
            fragmentTransaction.addToBackStack("SignUp").commit()


            Toast.makeText(activity,"Please signUp",Toast.LENGTH_SHORT).show()

        }
        return view
    }


}