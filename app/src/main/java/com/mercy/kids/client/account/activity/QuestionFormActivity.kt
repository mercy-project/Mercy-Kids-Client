package com.backup.myapplication

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mercy.kids.client.R

val listReason = arrayOf("아이와 함께 놀기 위해", "아이의 인성교육을 위해", "상황별 동영상이 필요해서(양치,밥,잠자기 등)","아이를 달래기 위해","기타(유아 Tip,청소시간 등)")
val listCharacterFavorite = arrayOf("뽀로로", "핑크퐁", "캐리", "콩수니", "헬로카봇", "타요", "로보카폴리", "라바", "겨울왕국", "신비아파트", "디즈니", "미미")
val questionFormAnswer = mutableMapOf<String,Any>()
val questionFormList = arrayOf("이용대상","사용자명","나이","이유","선호하는 캐릭터")

class QuestionFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_form)


        val backBtn = findViewById<ImageButton>(R.id.home)
        backBtn.setOnClickListener {
            onBackPressed()
        }

        val editLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
        val editText = findViewById<TextInputEditText>(R.id.text_name)

        editText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(editText.text!!.length>100){
                    editLayout.error = "최대 100자까지 입력할 수 있습니다."
                }else{
                    editLayout.error = ""
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        val cbLayoutReason = findViewById<LinearLayout>(R.id.layout_question_form_reason)
        val cbLayoutFavoriteRow1 = findViewById<LinearLayout>(R.id.layout_question_form_favorite_character_01)
        val cbLayoutFavoriteRow2 = findViewById<LinearLayout>(R.id.layout_question_form_favorite_character_02)

        val checkedReason = ArrayList<String>()
        val checkedFavorite = ArrayList<String>()

        for(s in listReason){
            val chk = CheckBox(this)
            chk.setText(s)
            chk.setTextColor(Color.parseColor("#205072"))
            chk.setPadding(0,0,0,10)
            chk.buttonTintList = ColorStateList.valueOf(Color.parseColor("#f9d302"))
            chk.setOnClickListener {
                if(chk.isChecked) checkedReason.add(chk.text as String)
                else checkedReason.remove(chk.text as String)
            }
            cbLayoutReason.addView(chk)
        }

        var row = 0
        for(s in listCharacterFavorite){
            val chk = CheckBox(this)
            chk.setText(s)
            chk.setTextColor(Color.parseColor("#205072"))
            chk.setPadding(0,0,0,10)
            chk.buttonTintList = ColorStateList.valueOf(Color.parseColor("#f9d302"))
            chk.setOnClickListener {
                if(chk.isChecked) checkedFavorite.add(chk.text as String)
                else checkedFavorite.remove(chk.text as String)
            }

            when(row){

                0->{
                    cbLayoutFavoriteRow1.addView(chk)
                    row = 1
                }
                1->{
                    cbLayoutFavoriteRow2.addView(chk)
                    row = 0
                }
            }
        }

        val rg00 = findViewById<RadioGroup>(R.id.rg_question_form_00)
        val tvName = findViewById<TextInputEditText>(R.id.text_name)
        val tvAge = findViewById<TextInputEditText>(R.id.text_age)

        fun isQuestionAnswerValid(): Boolean{
            if(tvName.text.isNullOrBlank() or tvAge.text.isNullOrBlank() or (checkedReason.size <1) or (checkedFavorite.size <3)) return false
            return true
        }


        val btn_save = findViewById<Button>(R.id.btn_question_form_submit)
        btn_save.setOnClickListener {
            if(isQuestionAnswerValid()){
                //save
                for(k in questionFormList){
                    when(k) {
                        questionFormList[0] -> {
                            questionFormAnswer.put(k, findViewById<RadioButton>(rg00.checkedRadioButtonId).text.toString())
                        }
                        questionFormList[1] -> {
                            questionFormAnswer.put(k, tvName.text.toString())
                        }
                        questionFormList[2] -> {
                            questionFormAnswer.put(k, tvAge.text.toString())
                        }
                        questionFormList[3] -> {
                            questionFormAnswer.put(k, checkedReason)
                        }
                        questionFormList[4] -> {
                            questionFormAnswer.put(k, checkedFavorite)
                        }
                    }
                }
                Log.d("Question_Form", "$questionFormAnswer")
            }else{
                //알림창 생성
                val builder = AlertDialog.Builder(this)
                    .setTitle("미응답 문항 존재")
                    .setMessage("아직 프로필이 완성되지 않았습니다. 확인해주세요.")
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