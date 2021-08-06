package com.senri.boot.common.api

import java.util.*

const val SC_OK_200 = 200
const val SC_INTERNAL_SERVER_ERROR_500 = 500
const val SC_NO_AUTHZ = 1001

data class Result<T>(
    val success: Boolean = true,
    val message: String = "操作成功!",
    val code: Int = SC_OK_200,
    val data: T? = null,
    val timestamp: Long = Date().time
)


fun <T> ok(data: T? = null, msg: String = "操作成功!", code: Int = SC_OK_200) =
    Result(data = data, message = msg, code = code)

fun <T> success(data: T? = null, msg: String = "操作成功!", code: Int = SC_OK_200) =
    Result(data = data, message = msg, code = code)

fun <T> error(msg: String = "操作失败!", code: Int = SC_INTERNAL_SERVER_ERROR_500) = Result<T>(message = msg, code = code)

fun <T> noAuth(msg: String) = error<T>(msg = msg, code = SC_NO_AUTHZ)