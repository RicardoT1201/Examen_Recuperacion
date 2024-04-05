package com.example.examen_recuperacion

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_recuperacion.adapter.TipAdapter
import com.example.examen_recuperacion.model.TipViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: TipViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TipAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TipViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TipAdapter()
        recyclerView.adapter = adapter

        viewModel.tips.observe(this, { tips ->
            adapter.setTips(tips)
        })

        findViewById<Button>(R.id.btnAddTip).setOnClickListener {
            showAddTipDialog()
        }

        findViewById<Button>(R.id.btnCalculateTip).setOnClickListener {
            val totalAmount = viewModel.calculateTotalAmount()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("totalAmount", totalAmount)
            startActivity(intent)
        }
    }

    private fun showAddTipDialog() {
        val builder = AlertDialog.Builder(this)
        val editText = EditText(this)
        editText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        builder.setTitle("Add Tip Amount")
        builder.setView(editText)
        builder.setPositiveButton("Add") { _, _ ->
            val amount = editText.text.toString().toDoubleOrNull() ?: return@setPositiveButton
            viewModel.addTip(amount)
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }
}
