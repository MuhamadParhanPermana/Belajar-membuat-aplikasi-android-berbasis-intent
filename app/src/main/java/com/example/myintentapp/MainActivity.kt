package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindah: Button = findViewById(R.id.btn_pindah)
        btnPindah.setOnClickListener(this)
        val btnPindahData: Button = findViewById(R.id.btn_pindah_data)
        btnPindahData.setOnClickListener(this)
        val btnPindahObjek: Button = findViewById(R.id.btn_pindah_objek)
        btnPindahObjek.setOnClickListener(this)
        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_pindah -> {
                val pindahIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(pindahIntent)
            }
            R.id.btn_pindah_data -> {
                val pindahIntentData = Intent(this@MainActivity, MoveWithData::class.java)
                pindahIntentData.putExtra(MoveWithData.EXTRA_NAME, "Fahmi")
                pindahIntentData.putExtra(MoveWithData.EXTRA_AGE, 19)
                startActivity(pindahIntentData)
            }
            R.id.btn_pindah_objek -> {
                val person = Person(
                    "Farhan",
                    "muhamadparhanpermana71@gmail.com",
                    19,
                    "Bandung"
                )
                val pindahIntentObjek = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                pindahIntentObjek.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(pindahIntentObjek)
            }
            R.id.btn_dial_number -> {
                val noHp = "085158190402"
                val pindahIntentDial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$noHp"))
                startActivity(pindahIntentDial)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (requestCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}