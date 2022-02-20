package com.example.buxpay.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.example.buxpay.MainActivity
import com.example.buxpay.R
import com.example.buxpay.fragment.*
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tool_bar = findViewById<Toolbar>(R.id.tool_bar)
        val drawer_layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)


        setSupportActionBar(tool_bar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this, drawer_layout, tool_bar,
            R.string.drawer_open, R.string.drawer_close
        )


        {


            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                setTitle(R.string.app_name)

            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.drawer_close)
            }


        }
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.hframelayout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        //////////////////////// navigation view //////////////////////////

        nav_view.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    loadHome(HomeFragment())
                    true

                }
                R.id.profile ->{
                    loadProfile(ProfileFragment())
                    true
                }
                R.id.payment -> {
                    loadPayments(PaymentsFragment())
                    true

                }
                R.id.invite -> {
                    val intent = Intent(Intent.ACTION_VIEW)
                    startActivity(Intent.createChooser(intent,"Share With"))
                    true
                }
                R.id.log_out ->{
                   startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.help ->{
                    loadhelp(HelpFragment())
                    true
                }
             R.id.help ->{
                 aboutUs(AboutFragment())
                 true
             }

                else -> super.onOptionsItemSelected(item)
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }


    }

    fun loadHome(homeFragment: HomeFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.hframelayout, homeFragment)
        fragmentTransaction.commit()
    }
    fun loadPayments(payFragment: PaymentsFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.hframelayout, payFragment)
        fragmentTransaction.commit()
    }
//    fun loadlogout(loginfragment: LogInFragment){
//        val ft = supportFragmentManager. beginTransaction()
//        ft.replace(R.id.framelayout, loginfragment)
//        ft.commit()
//    }
    fun loadProfile(profile: ProfileFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.hframelayout, profile)
        ft.commit()
    }
    fun loadhelp(helpme: HelpFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.hframelayout, helpme)
        ft.commit()
    }
    fun aboutUs(aboutus : AboutFragment){
       val ft = supportFragmentManager.beginTransaction()
       ft.replace(R.id.hframelayout, aboutus)
       ft.commit()
    }


}