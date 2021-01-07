package com.example.convertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.doOnTextChanged
import com.example.convertor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //включаем переключатель Dark/light
        binding.themeSwitch.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        //переключатели
        binding.group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.distance -> {
                    binding.winOneHead.text = getString(R.string.one_header)
                    binding.winTwoHead.text = getString(R.string.two_header)
                    binding.winOneText.setText("")
                    binding.winTwoText.setText("")
                    binding.winOneText.hint = getString(R.string.hint)
                    binding.winTwoText.hint = getString(R.string.hint)


                }
                R.id.temperature -> {
                    binding.winOneHead.text = getString(R.string.cels_header)
                    binding.winTwoHead.text = getString(R.string.far_header)
                    binding.winOneText.setText("")
                    binding.winTwoText.setText("")
                    binding.winOneText.hint = getString(R.string.hint)
                    binding.winTwoText.hint = getString(R.string.hint)
                }
                R.id.parrot -> {
                    binding.winOneHead.text = getString(R.string.boa_header)
                    binding.winTwoHead.text = getString(R.string.par_header)
                    binding.winOneText.setText("")
                    binding.winTwoText.setText("")
                    binding.winOneText.hint = getString(R.string.hint)
                    binding.winTwoText.hint = getString(R.string.hint)
                }
            }
        }


        //тело приложения
        binding.winOneText.doOnTextChanged { text, _, _, _ ->
            if (binding.winOneText.hasFocus()) {
                if (binding.winOneText.text.toString().toIntOrNull() != null) {
                    when (binding.group.checkedRadioButtonId) {

                        R.id.distance -> {
                            val km = binding.winOneText.text.toString().toInt()
                            val result = km * 0.621371
                            binding.winTwoText.setText(result.toString())
                        }

                        R.id.temperature -> {
                            val cels = binding.winOneText.text.toString().toInt()
                            val result = (cels * (9 / 5)) + 32.0
                            binding.winTwoText.setText(result.toString())
                        }

                        R.id.parrot -> {
                            val boa = binding.winOneText.text.toString().toInt()
                            val result = boa * 38
                            binding.winTwoText.setText(result.toString())
                        }

                    }
                } else {binding.winTwoText.setText("0")}
            }
        }

        binding.winTwoText.doOnTextChanged { text, _, _, _ ->
            if (binding.winTwoText.hasFocus()) {
                if (binding.winTwoText.text.toString().toIntOrNull() != null) {
                    when (binding.group.checkedRadioButtonId) {

                        R.id.distance -> {
                            var m = binding.winTwoText.text.toString().toInt()
                            var result = 1.609 * m
                            binding.winOneText.setText(result.toString())
                        }

                        R.id.temperature -> {
                            var far = binding.winTwoText.text.toString().toInt()
                            var result = (far - 32.0) * (5.0 / 9.0)
                            binding.winOneText.setText(result.toString())
                        }

                        R.id.parrot -> {
                            var pars = binding.winTwoText.text.toString().toInt()
                            var result = pars / 38
                            binding.winOneText.setText(result.toString())
                        }

                    }
                } else {binding.winOneText.setText("0")}
            }
        }


    }





}



