package com.mozhimen.analysisk.umeng

import android.content.Context
import com.mozhimen.kotlin.lintk.optins.OApiInit_InApplication
import com.umeng.analytics.MobclickAgent
import com.umeng.analytics.MobclickAgent.PageMode

/**
 * @ClassName UmengStatistics
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/12/26
 * @Version 1.0
 */
@OApiInit_InApplication
object AnalysisKUmengMgr {

    fun setPageCollectionModeManual() {
        setPageCollectionMode(PageMode.MANUAL)
    }

    fun setPageCollectionMode(pageMode: PageMode) {
        MobclickAgent.setPageCollectionMode(pageMode)
    }

    /**
     * 如果您调用kill或者exit之类的方法杀死进程，或者双击back键会杀死进程，请务必在此之前调用onKillProcess方法，用来保存统计数据。
     * public static void onKillProcess(Context context);
     */

    fun onKillProcess(context: Context) {
        MobclickAgent.onKillProcess(context)
    }
}