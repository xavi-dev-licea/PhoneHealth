package com.xavidev.phonehealth.utils

import android.content.Context
import android.widget.Toast

object Extensions {

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


}