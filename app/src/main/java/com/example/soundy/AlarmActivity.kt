package com.example.soundy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.format.DateFormat.is24HourFormat
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext

class AlarmActivity : AppCompatActivity() {

    /* 알람 시간 디폴트값 , 알람 시간 저장 시 저장된 값이 디폴트가 되게 */
    private var hour = 7
    private var minute = 0

    lateinit var edtHour : EditText
    lateinit var edtMinute : EditText
    lateinit var rgTime : RadioGroup
    lateinit var rbAm : RadioButton
    lateinit var rbPm : RadioButton
    lateinit var btnSave : Button
    lateinit var btnBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        edtHour = findViewById(R.id.editTime)
        edtMinute = findViewById(R.id.editMinute)
        rgTime = findViewById(R.id.rgTime)
        rbAm = findViewById(R.id.rbAm)
        rbPm = findViewById(R.id.rbPm)
        btnSave = findViewById(R.id.btnSave)
        btnBack = findViewById(R.id.btnBack)

        /* 저장 버튼 클릭 시 */
        btnSave.setOnClickListener {
            hour = edtHour.text.toString().toInt()
            minute = edtMinute.text.toString().toInt()

            when(rgTime.checkedRadioButtonId){
                R.id.rbPm -> hour = hour + 12
            }

            /* 알림 기능 추가해야함 */

            Toast.makeText(this@AlarmActivity, "$hour 시 $minute 분 저장되었습니다.", Toast.LENGTH_SHORT).show()
        }

        /* 뒤로 가기 버튼 클릭 시
        btnBack.setOnClickListener {
            val intent = Intent(this, 이전 액티비티::class.java)
            startActivity(intent)
        } */

    }
}