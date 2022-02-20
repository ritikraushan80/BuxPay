package com.example.buxpay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.buxpay.R
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener


class HomeFragment : Fragment() {

       var sampleImages = intArrayOf(
        R.drawable.image1,
        R.drawable.images5,
        R.drawable.image2,
        R.drawable.image4,
        R.drawable.image3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=  inflater.inflate(R.layout.fragment_home, container, false)

        ///////////////////// Top carousel /////////////////////////

        val carousel = view.findViewById<CarouselView>(R.id.carousel) as CarouselView
        carousel.setPageCount(sampleImages.size)


    val  imageListener: ImageListener = object :ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            Picasso.get().load(sampleImages[position]).into(imageView)
        }

    }

        carousel.setImageListener(imageListener)

        ///////////////////////// End Carousel ////////////////////////////

        val endCarousel = view.findViewById<CarouselView>(R.id.end_carousel)
        endCarousel.setPageCount(sampleImages.size)


        val  endImageListener: ImageListener = object :ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView?) {
                Picasso.get().load(sampleImages[position]).into(imageView)
            }

        }

        endCarousel.setImageListener(endImageListener)
        return view
    }



}