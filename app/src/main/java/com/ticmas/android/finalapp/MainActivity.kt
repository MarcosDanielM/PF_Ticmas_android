package com.ticmas.android.finalapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.ticmas.android.finalapp.databinding.ActivityMainBinding
import com.ticmas.android.finalapp.view.ComparisonViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: ComparisonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()
            mainViewModel.compareTexts(text1, text2)
        }


        mainViewModel.resultLiveData.observe(this, Observer { areEqual ->
            val resultText = if (areEqual) "Los textos son iguales" else "Los textos son diferentes"
            binding.resultTextView.text = resultText

            val colorRes = if (areEqual) R.color.green else R.color.red
            val textColor = ContextCompat.getColor(this, colorRes)
            binding.resultTextView.setTextColor(textColor)
        })

    }
}
