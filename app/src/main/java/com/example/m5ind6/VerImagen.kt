package com.example.m5ind6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.m5ind6.databinding.ItemFragmentBinding

class VerImagen: AppCompatActivity(){
private lateinit var  mBinding: ItemFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ItemFragmentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)



        val nombre=intent.getStringExtra("nombre")
        val descripcion=intent.getStringExtra("descripcion")
        val imagen=intent.getStringExtra("url")


        mBinding.itemNombre.setText(nombre)
        mBinding.itemDescripcion.setText(descripcion)


        Glide.with(this)
            .load(imagen)
            .into(mBinding.itemImagen)


    }
}