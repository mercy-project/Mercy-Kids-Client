package com.backup.myapplication

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mercy.kids.client.R

val list_reason = arrayOf("아이와 함께 놀기 위해", "아이의 인성교육을 위해", "상황별 동영상이 필요해서(양치,밥,잠자기 등)","아이를 달래기 위해","기타(유아 Tip,청소시간 등)")
val list_character_favorite = arrayOf("뽀로로", "핑크퐁", "캐리", "콩수니", "헬로카봇", "타요", "로보카폴리", "라바", "겨울왕국", "신비아파트", "디즈니", "미미")
val tmp_answer = Array<String>(5,{ item->""})
val question_form_answer = mutableMapOf<String,String>()
val question_form_list = arrayOf("이용대상","사용자명","나이","이유","선호하는 캐릭터")

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
        val edit_text = findViewById<TextInputEditText>(R.id.text_name)

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

        val cb_layout_reason = findViewById<LinearLayout>(R.id.layout_question_form_reason)
        val cb_layout_favorite_row1 = findViewById<LinearLayout>(R.id.layout_question_form_favorite_character_01)
        val cb_layout_favorite_row2 = findViewById<LinearLayout>(R.id.layout_question_form_favorite_character_02)

        val checked_reason = ArrayList<String>()
        val checked_favorite = ArrayList<String>()

        for(s in list_reason){
            val chk = CheckBox(this)
            chk.setText(s)
            chk.setTextColor(Color.parseColor("#205072"))
            chk.setPadding(0,0,0,10)
            chk.buttonTintList = ColorStateList.valueOf(Color.parseColor("#f9d302"))
            chk.setOnClickListener {
                if(chk.isChecked) checked_reason.add(chk.text as String)
                else checked_reason.remove(chk.text as String)
            }
            cb_layout_reason.addView(chk)
        }

        var row = 0
        for(s in list_character_favorite){
            val chk = CheckBox(this)
            chk.setText(s)
            chk.setTextColor(Color.parseColor("#205072"))
            chk.setPadding(0,0,0,10)
            chk.buttonTintList = ColorStateList.valueOf(Color.parseColor("#f9d302"))
            chk.setOnClickListener {
                if(chk.isChecked) checked_favorite.add(chk.text as String)
                else checked_favorite.remove(chk.text as String)
            }

            when(row){

                0->{
                    cb_layout_favorite_row1.addView(chk)
                    row = 1
                }
                1->{
                    cb_layout_favorite_row2.addView(chk)
                    row = 0
                }
            }
        }

        val rg_00 = findViewById<RadioGroup>(R.id.rg_question_form_00)
        val tv_name = findViewById<TextInputEditText>(R.id.text_name)
        val tv_age = findViewById<TextInputEditText>(R.id.text_age)

        fun isQuestionAnswerValid(): Boolean{
            if(tv_name.text.isNullOrBlank() or tv_age.text.isNullOrBlank() or (checked_reason.size <1) or (checked_favorite.size <3)) return false
            return true
        }


        val btn_save = findViewById<Button>(R.id.btn_question_form_submit)
        btn_save.setOnClickListener {
            tmp_answer[0] = findViewById<RadioButton>(rg_00.checkedRadioButtonId).text.toString()
            tmp_answer[1] = tv_name.text.toString()
            tmp_answer[2] = tv_age.text.toString()
            tmp_answer[3] = checked_reason[0]
            tmp_answer[4] = checked_favorite[0]
            if(isQuestionAnswerValid()){
                //save
                var i = 0
                for(k in question_form_list){
                    question_form_answer.put(k, tmp_answer[i])
                    i++
                }
                onBackPressed()

            }else{
                //알림창 생성
                val builder = AlertDialog.Builder(this)
                    .setTitle("아직 프로필이 완성되지 않았습니다. 확인해주세요.")
                    .setMessage("")
                    .setPositiveButton("확인"){
                     dialogInterface, i ->
                    }
                    .show()

            }
        }


    }



    fun setEditTextValid(){

    }

    fun setCheckboxQuestion(){

    }
    //필수 항목 체크
    //
}