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
import com.example.buxpay.R

class VerifyCode : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_verify_code, container, false)

            // Submit Button

            val submitbtn = view.findViewById<Button>(R.id.submitbtn)

            submitbtn.setOnClickListener{

            val fragmentmanager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentmanager.beginTransaction()
            fragmentTransaction.replace(R.id.framelayout, SignUpFragment())
            fragmentTransaction.addToBackStack("SignUp")
            fragmentTransaction.commit()

            Toast.makeText(activity, "Please reister here " , Toast.LENGTH_SHORT).show()

        }

        ///  close button

        val closebtn = view.findViewById<ImageView>(R.id.close)

        closebtn.setOnClickListener{


            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Do You Already registered ?")
            builder.setMessage("If you registered then Please LogIn")
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton("Yes"){dialogInterface, which ->

                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.framelayout,  LogInFragment())
                fragmentTransaction.addToBackStack("SignUp")
                fragmentTransaction.commit()

                Toast.makeText(activity,"Thank you", Toast.LENGTH_SHORT).show()

            }
            builder.setNeutralButton("Cancel"){dialogInterface, which ->
                Toast.makeText(activity,"Please registered",Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(activity,"please registered with me !!", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        }

    return view
    }


}