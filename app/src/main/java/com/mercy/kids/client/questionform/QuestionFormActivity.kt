package com.backup.myapplication

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mercy.kids.client.R

val list_reason = arrayOf("아이와 함께 놀기 위해", "아이의 인성교육을 위해", "상황별 동영상이 필요해서(양치,밥,잠자기 등)","아이를 달래기 위해","기타(유아 Tip,청소시간 등)")
val list_character_favorite = arrayOf("뽀로로", "핑크퐁", "캐리", "콩수니", "헬로카봇", "타요", "로보카폴리", "라바", "겨울왕국", "신비아파트", "디즈니", "미미")

class QuestionFormActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_form)


        val back_btn = findViewById<ImageButton>(R.id.home)
        back_btn.setOnClickListener {
            onBackPressed()
        }

        val edit_layout = findViewById<TextInputLayout>(R.id.textInputLayout)
        val edit_text = findViewById<TextInputEditText>(R.id.tv_name)

        edit_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(edit_text.text!!.length>100){
                    edit_layout.error = "최대 100자까지 입력할 수 있습니다."
                }else{
                    edit_layout.error = ""
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        val checkbox_layout_01 = findViewById<LinearLayout>(R.id.linear_checkbox)
        val checkbox_row_00 = findViewById<LinearLayout>(R.id.linear_checkbox_00)
        val checkbox_row_01 = findViewById<LinearLayout>(R.id.linear_checkbox_01)

        for(s in list_reason){
            val chk = CheckBox(this)
            chk.setText(s)
            chk.setTextColor(Color.parseColor("#205072"))
            chk.setPadding(0,0,0,10)
            chk.buttonTintList = ColorStateList.valueOf(Color.parseColor("#f9d302"))
            checkbox_layout_01.addView(chk)
        }

        var row = 0
        for(s in list_character_favorite){
            when(row){
                0->{
                    val chk = CheckBox(this)
                    chk.setText(s)
                    chk.setTextColor(Color.parseColor("#205072"))
                    chk.setPadding(0,0,0,10)
                    chk.buttonTintList = ColorStateList.valueOf(Color.parseColor("#f9d302"))
                    checkbox_row_00.addView(chk)
                    row = 1
                }
                1->{
                    val chk = CheckBox(this)
                    chk.setText(s)
                    chk.setTextColor(Color.parseColor("#205072"))
                    chk.setPadding(0,0,0,10)
                    chk.buttonTintList = ColorStateList.valueOf(Color.parseColor("#f9d302"))
                    checkbox_row_01.addView(chk)
                    row = 0
                }
            }
        }

        val tv_name = findViewById<TextInputEditText>(R.id.tv_name)
        val tv_age = findViewById<TextInputEditText>(R.id.tv_age)


        val btn_save = findViewById<Button>(R.id.btn_question_form_submit)
        btn_save.setOnClickListener {
            if(tv_name.text.isNullOrBlank() or tv_age.text.isNullOrBlank()){
                //알림창 생성

            }else{
                //저장

                onBackPressed()
            }
        }
    }

    fun setValidationForm(){

    }

    fun setEditTextValid(){

    }

    fun setCheckboxQuestion(){

    }
    //필수 항목 체크
    //
}