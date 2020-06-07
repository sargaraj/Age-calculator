package com.example.agecalculator

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agecalculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Handling button click
        binding.calculateAgeBtn.setOnClickListener {
            //get age from EditText
            val userDOB=ageEt.text.toString().trim()  //.trim() removes space from start and end of text
            //get current year
            val year:Int = Calendar.getInstance().get(Calendar.YEAR)
            // validate

            if(userDOB == "") { //if no value is entered
                Toast.makeText(this, "Please enter birth year", Toast.LENGTH_SHORT).show()
            }
            else if(userDOB > year.toString()) { //if entered year > current year
                Toast.makeText(this, "Entered year should be less than current year", Toast.LENGTH_SHORT).show()
            }
            else {
                //current year - entered year
                val myAge = year - userDOB.toInt() // year is int(Integer) value,but userDOB was string value so it should be converted to int
                // set the value of myAge to TextView
                myAgeTv.text = "Age is ${myAge.toString()}  Years!"
            }
        }
    }
}