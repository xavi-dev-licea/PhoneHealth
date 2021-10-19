package com.xavidev.phonehealth.utils

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.text.SimpleDateFormat
import java.util.*


private const val DATE_PATTERN = "dd-MM-yyyy"

fun SimpleDateFormat.formatWithDatePattern(date: Calendar): String = format(date.time)

fun Date.toPatternString(context: Context?): String {
    val dateTimeFormat =
        SimpleDateFormat(DATE_PATTERN, context?.getCurrentLocale() ?: Locale.getDefault())
    return dateTimeFormat.format(this)
}

fun String.toCalendar(context: Context?): Calendar {
    val date: Calendar = Calendar.getInstance()
    val dateFormat =
        SimpleDateFormat(DATE_PATTERN, context?.getCurrentLocale() ?: Locale.getDefault())
    date.time = dateFormat.parse(this)!!
    return date
}

fun Context.getCurrentLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        resources.configuration.locales[0]
    } else {
        resources.configuration.locale
    }
}

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun FragmentActivity.isFragmentVisible(tag: String): Boolean {
    val fragment = supportFragmentManager.findFragmentByTag(tag)
    return fragment != null && fragment.isVisible
}

fun FragmentActivity.isFragmentInBackStack(tag: String): Boolean {
    val fragment = supportFragmentManager.findFragmentByTag(tag)
    return fragment != null
}

fun FragmentActivity.getFragmentByTag(tag: String): Fragment =
    supportFragmentManager.findFragmentByTag(tag)!!

fun FragmentActivity.addFragment(
    clazz: Class<out Fragment>,
    tag: String,
    parentViewId: Int,
    addToBackStack: Boolean,
    args: Bundle?
) {
    val transaction = supportFragmentManager.beginTransaction()
    try {
        val fragment = clazz.newInstance()
        fragment.arguments = args
        transaction.replace(parentViewId, fragment, tag)
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.commit()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun FragmentActivity.addFragment(
    clazz: Class<out Fragment>,
    tag: String,
    parentView: View,
    addToBackStack: Boolean,
    args: Bundle?
) {
    addFragment(clazz, tag, parentView.id, addToBackStack, args)
}

fun FragmentActivity.showDialog(clazz: Class<out DialogFragment>, tag: String, args: Bundle?) {
    val transaction = supportFragmentManager.beginTransaction()
    try {
        val fragment = clazz.newInstance()
        fragment.arguments = args
        transaction.add(fragment, tag)
        transaction.commit()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Context.getScreenSize(): IntArray {
    val size = IntArray(2)
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = windowManager.defaultDisplay
    val point = Point()
    display.getSize(point)
    size[0] = point.x
    size[1] = point.y
    return size
}