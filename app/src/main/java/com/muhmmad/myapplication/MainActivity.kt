package com.muhmmad.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Calendar
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSelect = findViewById<TextView>(R.id.tv_select)
        val tvSelected = findViewById<TextView>(R.id.tv_selected_date)
        val tvDays = findViewById<TextView>(R.id.tv_age_days)
        val tvMinutes = findViewById<TextView>(R.id.tv_age_minutes)

        tvSelect.setOnClickListener {
            val calendar = Calendar.getInstance()

            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    tvSelected.text = "$year - ${month + 1} - $dayOfMonth"
                    tvDays.text = getDays(
                        calendar.get(Calendar.YEAR),
                        year,
                        calendar.get(Calendar.MONTH),
                        month,
                        calendar.get(Calendar.DAY_OF_MONTH),
                        dayOfMonth
                    ).toString()

                    tvMinutes.text = (getDays(
                        calendar.get(Calendar.YEAR),
                        year,
                        calendar.get(Calendar.MONTH),
                        month,
                        calendar.get(Calendar.DAY_OF_MONTH),
                        dayOfMonth
                    ) * 1440).toString()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

    }

    fun getDays(
        currentYear: Int,
        selectedYear: Int,
        currentMonth: Int,
        selectedMonth: Int,
        currentDay: Int,
        selectedDay: Int
    ): Int {

        val years = currentYear - selectedYear
        val months = currentMonth - selectedMonth
        val days = currentDay - selectedDay

        return ((years * 365.25) + (months * 30) + days).roundToInt()
    }
}