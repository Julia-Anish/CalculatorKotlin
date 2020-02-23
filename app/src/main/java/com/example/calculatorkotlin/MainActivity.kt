package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar

import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{setTextFields("0")}
        btn_1.setOnClickListener{setTextFields("1")}
        btn_2.setOnClickListener{setTextFields("2")}
        btn_3.setOnClickListener{setTextFields("3")}
        btn_4.setOnClickListener{setTextFields("4")}
        btn_5.setOnClickListener{setTextFields("5")}
        btn_6.setOnClickListener{setTextFields("6")}
        btn_7.setOnClickListener{setTextFields("7")}
        btn_8.setOnClickListener{setTextFields("8")}
        btn_9.setOnClickListener{setTextFields("9")}


        add.setOnClickListener{setTextFields("+")}
        subtract.setOnClickListener{setTextFields("-")}
        multiply.setOnClickListener{setTextFields("*")}
        divide.setOnClickListener{setTextFields("/")}
        bracket1.setOnClickListener{setTextFields("(")}
        bracket2.setOnClickListener{setTextFields(")")}
        btn_dot.setOnClickListener{setTextFields(".")}

        AC.setOnClickListener{
            math_operation.text = "0"
            result_text.text = "0"
        }

        btn_back.setOnClickListener{
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length-1)

            result_text.text = ""
        }

        equal.setOnClickListener{
            //создаем объект на основе класса ExpressionBuilder загруженной библиотеки.В качестве парамета - данные строки с мат.действиями
            //функция build() инициализирует созданный объект
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                result_text.text = "$result" //функия высчитывает математическую операцию, которую мы передали в объект

            }catch (e:Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")  //отлавливаем ошибку и выводим ее в консоль
            }
        }

    }
    //добавляет в поле ввода некую строку
    fun setTextFields (str: String){
        if (result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }
}
