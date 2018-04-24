package com.exotrac.exobeacon

import android.util.Log

object Logger {

    fun d(tag: String, message: String) {
        if (!BuildConfig.DEBUG) return
        Log.d(tag, message)
    }

    fun d(tag: String, message: String, throwable: Throwable) {
        if (!BuildConfig.DEBUG) return
        Log.d(tag, message, throwable)
    }
    fun i(tag: String, message: String) {
        if (!BuildConfig.DEBUG) return
        Log.i(tag, message)
    }

    fun i(tag: String, message: String, throwable: Throwable) {
        if (!BuildConfig.DEBUG) return
        Log.i(tag, message, throwable)
    }

    fun e(tag: String, message: String) {
        if (!BuildConfig.DEBUG) return
        Log.e(tag, message)
    }

    fun e(tag: String, message: String, throwable: Throwable) {
        if (!BuildConfig.DEBUG) return
        Log.e(tag, message, throwable)
    }

    fun v(tag: String, message: String) {
        if (!BuildConfig.DEBUG) return
        Log.v(tag, message)
    }

    fun v(tag: String, message: String, throwable: Throwable) {
        if (!BuildConfig.DEBUG) return
        Log.v(tag, message, throwable)
    }

    fun w(tag: String, message: String) {
        if (!BuildConfig.DEBUG) return
        Log.w(tag, message)
    }

    fun w(tag: String, throwable: Throwable) {
        if (!BuildConfig.DEBUG) return
        Log.w(tag, throwable)
    }

    fun w(tag: String, message: String, throwable: Throwable) {
        if (!BuildConfig.DEBUG) return
        Log.w(tag, message, throwable)
    }
}