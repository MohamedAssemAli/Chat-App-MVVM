package com.assem.chat_app_mvvm.data.models


/**
 * Created by Mohamed Assem on 24-Jun-20.
 * mo7mad.assim@gmail.com
 */

data class ChatMessage(
    private var sender: String,
    private var receiver: String,
    private var message: String
)
