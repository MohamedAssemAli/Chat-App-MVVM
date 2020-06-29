package com.assem.chat_app_mvvm.util

import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup


fun validateNotEmpty(editText: EditText): Boolean {
    return editText.text.toString().isBlank()
}

fun validateUsername(editText: EditText): Boolean {
    return editText.text.length >= 3
}

fun validateLocation(editText: EditText): Boolean {
    return editText.text.toString().isNotEmpty()
}

fun validateEmail(editText: EditText): Boolean {
    return editText.text.toString()
        .matches(Regex("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"))
}

fun validatePhone(editText: EditText): Boolean {
    return editText.text.toString().matches(Regex("^[+\\d{3}]?\\d{11,20}$"))
}

fun validatePassword(editText: EditText): Boolean {
    return editText.text.toString().length >= 6
}

fun validateNumber(editText: EditText): Boolean {
    return editText.text.toString().matches(Regex("^[0-9]*$"))
}

fun validateSignedNumber(editText: EditText): Boolean {
    return editText.text.toString().matches(Regex("[+-]?([0-9]*[.])?[0-9]+\n"))
}

fun validateCheckBox(checkBox: CheckBox): Boolean {
    return checkBox.isChecked
}

fun validateRadioGroup(radioGroup: RadioGroup): Boolean {
    return radioGroup.checkedRadioButtonId != -1
}