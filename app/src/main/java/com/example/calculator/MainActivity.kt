package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {

    var StringBuilder = StringBuilder()

    //For 0 to 9 Button
    lateinit var btn0:AppCompatButton
    lateinit var btn1:AppCompatButton
    lateinit var btn2:AppCompatButton
    lateinit var btn3:AppCompatButton
    lateinit var btn4:AppCompatButton
    lateinit var btn5:AppCompatButton
    lateinit var btn6:AppCompatButton
    lateinit var btn7:AppCompatButton
    lateinit var btn8:AppCompatButton
    lateinit var btn9:AppCompatButton

    //For Operator Buttons
    lateinit var btnAC:AppCompatButton
    lateinit var btnmod:AppCompatButton
    lateinit var btndiv:AppCompatButton
    lateinit var btnmul:AppCompatButton
    lateinit var btnsub:AppCompatButton
    lateinit var btnadd:AppCompatButton
    lateinit var btnequal:AppCompatButton

    //For Dot Button
    lateinit var btndot:AppCompatButton

    //For EditText

    lateinit var edtDisplay:EditText

    var LEFT_HAND_DIGITS:Double=0.0

    var RIGHT_HAND_DIGITS:Double=0.0

    var Operator:Char = ' '


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //For 0 to 9 Buttons
        btn0 = findViewById(R.id.btn_0)
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
        btn4 = findViewById(R.id.btn_4)
        btn5 = findViewById(R.id.btn_5)
        btn6 = findViewById(R.id.btn_6)
        btn7 = findViewById(R.id.btn_7)
        btn8 = findViewById(R.id.btn_8)
        btn9 = findViewById(R.id.btn_9)

        //For Operator Buttons
        btnAC = findViewById(R.id.btn_clear)
        btnmod = findViewById(R.id.btn_module)
        btndiv = findViewById(R.id.btn_division)
        btnmul = findViewById(R.id.btn_multiplication)
        btnsub = findViewById(R.id.btn_substraction)
        btnadd = findViewById(R.id.btn_addition)
        btnequal = findViewById(R.id.btn_equal)
        //For Dot Button
        btndot = findViewById(R.id.btn_dot)

        //For Edit Text
        edtDisplay = findViewById(R.id.edtDisplay)





    }

    override fun onStart() {
        super.onStart()

        OperatorInitialize()
        DigitInitialize()
        actionInitialize()




    }

    fun DigitInitialize()
    {
        btn0.setOnClickListener {
            digitDisplay("0")
        }
        btn1.setOnClickListener {
            digitDisplay("1")
        }
        btn2.setOnClickListener {
            digitDisplay("2")
        }
        btn3.setOnClickListener {
            digitDisplay("3")
        }
        btn4.setOnClickListener {
            digitDisplay("4")
        }
        btn5.setOnClickListener {
            digitDisplay("5")
        }
        btn6.setOnClickListener {
            digitDisplay("6")
        }
        btn7.setOnClickListener {
            digitDisplay("7")
        }
        btn8.setOnClickListener {
            digitDisplay("8")
        }
        btn9.setOnClickListener {
            digitDisplay("9")
        }
        btndot.setOnClickListener {
            digitDisplay(".")
        }
    }
    fun digitDisplay(digit:String)
    {
        StringBuilder.append(digit)
        edtDisplay.setText(StringBuilder)
    }

    fun setDigitToLeftHand(ope:Char)
    {
        LEFT_HAND_DIGITS = StringBuilder.toString().toDouble()
        StringBuilder.clear()
        edtDisplay.setText(" ")
        Operator = ope
        Log.d("MainActivity","LEFT HAND VALUE: $LEFT_HAND_DIGITS and Operator: $Operator")
    }

    fun OperatorInitialize()
    {
        btnadd.setOnClickListener {
            setDigitToLeftHand('A')
        }
        btnmul.setOnClickListener {
            setDigitToLeftHand('M')
        }
        btndiv.setOnClickListener {
            setDigitToLeftHand('D')
        }
        btnsub.setOnClickListener {
            setDigitToLeftHand('S')
        }
        btnmod.setOnClickListener {
            setDigitToLeftHand('O')
        }
    }





    fun actionInitialize()
    {
        btnequal.setOnClickListener {
            RIGHT_HAND_DIGITS = StringBuilder.toString().toDouble()
            StringBuilder.clear()

            when(Operator)
            {
                'A' ->{
                    var add = LEFT_HAND_DIGITS + RIGHT_HAND_DIGITS
                    edtDisplay.setText(add.toString())
                    StringBuilder.append(add)
                    Log.d("MainActivity","LEFT: $LEFT_HAND_DIGITS , RIGHT: $RIGHT_HAND_DIGITS , OPERATOR: $Operator , New Number: $StringBuilder")
                }

                'M' ->{
                    var mul = LEFT_HAND_DIGITS * RIGHT_HAND_DIGITS
                    edtDisplay.setText(mul.toString())
                    StringBuilder.append(mul)
                    Log.d("MainActivity","LEFT: $LEFT_HAND_DIGITS , RIGHT: $RIGHT_HAND_DIGITS , OPERATOR: $Operator , New Number: $StringBuilder")
                }

                'D' ->{
                    var div = LEFT_HAND_DIGITS / RIGHT_HAND_DIGITS
                    edtDisplay.setText(div.toString())
                    StringBuilder.append(div)
                    Log.d("MainActivity","LEFT: $LEFT_HAND_DIGITS , RIGHT: $RIGHT_HAND_DIGITS , OPERATOR: $Operator , New Number: $StringBuilder")
                }

                'S' ->{
                    var sub = LEFT_HAND_DIGITS - RIGHT_HAND_DIGITS
                    edtDisplay.setText(sub.toString())
                    StringBuilder.append(sub)
                    Log.d("MainActivity","LEFT: $LEFT_HAND_DIGITS , RIGHT: $RIGHT_HAND_DIGITS , OPERATOR: $Operator , New Number: $StringBuilder")
                }

                'O' ->{
                    var mod = LEFT_HAND_DIGITS % RIGHT_HAND_DIGITS
                    edtDisplay.setText(mod.toString())
                    StringBuilder.append(mod)
                    Log.d("MainActivity","LEFT: $LEFT_HAND_DIGITS , RIGHT: $RIGHT_HAND_DIGITS , OPERATOR: $Operator , New Number: $StringBuilder")
                }


            }
        }

        btnAC.setOnClickListener {
            StringBuilder.clear()
            edtDisplay.setText(" ")
        }
    }

}