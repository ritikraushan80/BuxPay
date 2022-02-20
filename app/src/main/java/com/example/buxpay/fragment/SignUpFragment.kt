package com.example.buxpay.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.airbnb.lottie.LottieAnimationView
import com.example.buxpay.R

class SignUpFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_sign_up, container, false)

//      Sign Up Button Click Listener

        val sgbtn = view.findViewById<Button>(R.id.sgupnbtn)

        sgbtn.setOnClickListener(){
            val fragmentManager:FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.framelayout, LogInFragment())
            fragmentTransaction.addToBackStack("LogIn")
            fragmentTransaction.commit()

            Toast.makeText(activity,"Thank you for registering ! Please LogIn again ", Toast.LENGTH_LONG).show()
        }

        ////// Sign Up to back LogIn Page

        val signupback = view.findViewById<ImageView>(R.id.sgback)

        signupback.setOnClickListener(){

            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Do you want to Exit")
            builder.setMessage("Back to LogIn")
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton("Exit"){dialogInterface, which ->
                val fragmentManager:FragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.framelayout, LogInFragment())
                fragmentTransaction.addToBackStack("LogIn").commit()

            }
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(activity, "Cancelled", Toast.LENGTH_SHORT).show()
            }
           val alertDialog : AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        return view
    }

}