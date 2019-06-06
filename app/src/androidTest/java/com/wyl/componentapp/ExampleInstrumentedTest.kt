package com.wyl.componentapp

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.wyl.componentapp.common.utils.ACache
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented testARouter, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under testARouter.
        val appContext = InstrumentationRegistry.getTargetContext()
//        assertEquals("com.wyl.componentapp", appContext.packageName)

        val mCache = ACache.get(appContext)
//        mCache.put("test_key1", "test value123")
//        mCache.put("test_key2", "test value", 10)//保存10秒，如果超过10秒去获取这个key，将为null
//        mCache.put("test_key3", "test value", 2 * ACache.TIME_DAY)//保存两天，如果超过两天去获取这个key，将为null
//        val value = mCache.getAsString("test_key1")
//        println("value = $value")

        val key1 = "bean"
//        mCache.put(key1, Bean("lisi", 18))
        println(mCache.getAsObject(key1) as Bean)
    }
}
