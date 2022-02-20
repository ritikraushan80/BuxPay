package com.example.buxpay.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.buxpay.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_welcome, container, false)


        //////////////////////////  Floating Button ////////////////////////////////

        val floatbtn = view.findViewById<FloatingActionButton>(R.id.floatbtn)

        floatbtn.setOnClickListener(){

            val verifyCode = VerifyCode()
            val fragmentmanager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentmanager.beginTransaction()
            fragmentTransaction.replace(R.id.framelayout, verifyCode)
            fragmentTransaction.addToBackStack("OTP")
            fragmentTransaction.commit()

            Toast.makeText(activity, "Welcome to LogIn Page " , Toast.LENGTH_SHORT).show()


        }

        return view
    }


}