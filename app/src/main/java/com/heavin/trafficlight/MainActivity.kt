package com.heavin.trafficlight

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.heavin.trafficlight.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lightButton.setOnClickListener { view: View ->
            updateLight()
        }
    }

    private var isStop = true
    private var isWait = false
    private var isGo = false

    @SuppressLint("ResourceAsColor")
    private fun updateLight() {
        if (isStop) {
            isStop = false
            isGo = true

            binding.lightButton.setText(R.string.go_button_text)
            binding.lightButton.setBackgroundTintList(getColorStateList(R.color.green))

            binding.redLight.visibility = View.INVISIBLE
            binding.greenLight.visibility = View.VISIBLE
        }
        else if (isGo) {
            isGo = false
            isWait = true

            binding.lightButton.setText(R.string.wait_button_text)
            binding.lightButton.setBackgroundTintList(getColorStateList(R.color.yellow))

            binding.greenLight.visibility = View.INVISIBLE
            binding.yellowLight.visibility = View.VISIBLE
        }
        else {
            isWait = false
            isStop = true

            binding.lightButton.setText(R.string.stop_button_text)
            binding.lightButton.setBackgroundTintList(getColorStateList(R.color.red))

            binding.yellowLight.visibility = View.INVISIBLE
            binding.redLight.visibility = View.VISIBLE
        }
    }
}