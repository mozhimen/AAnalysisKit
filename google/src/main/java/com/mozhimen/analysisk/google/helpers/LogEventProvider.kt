package com.mozhimen.analysisk.google.helpers

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.ParametersBuilder
import com.google.firebase.analytics.ktx.logEvent
import com.mozhimen.analysisk.google.cons.CLogEvent
import com.mozhimen.analysisk.google.cons.CLogParam
import com.mozhimen.kotlin.elemk.commons.IExt_Listener

/**
 * @ClassName LogEventProvider
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
class LogEventProvider(private val _firebaseAnalytics: FirebaseAnalytics?) {
    fun screenView(screenName: String, content: String) {
        logEvent(CLogEvent.SCREEN_VIEW) {
            param(CLogParam.SCREEN_NAME, screenName)
//            param(CLogParam.SCREEN_CLASS, screenClass)
            param(CLogParam.CONTENT, content)
        }
    }

    fun screenView(screenName: String, content: String, block: IExt_Listener<ParametersBuilder>) {
        logEvent(CLogEvent.SCREEN_VIEW) {
            param(CLogParam.SCREEN_NAME, screenName)
            param(CLogParam.CONTENT, content)
            block()
        }
    }

    fun selectItem(itemId: String, itemName: String, contentType: String) {
        logEvent(CLogEvent.SELECT_ITEM) {
            param(CLogParam.ITEM_ID, itemId)
            param(CLogParam.ITEM_NAME, itemName)
            param(CLogParam.CONTENT_TYPE, contentType)
        }
    }

    ////////////////////////////////////////////////////////////////////

    fun logEvent(name: String, map: Map<String, String>) {
        logEvent(name) {
            for ((t, u) in map.entries) {
                param(t, u)
            }
        }
    }

    //自定义事件
    fun logEvent(name: String, block: IExt_Listener<ParametersBuilder>) {
        _firebaseAnalytics?.logEvent(name, block)
    }
}