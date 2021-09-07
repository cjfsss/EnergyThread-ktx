package hos.thread

import hos.thread.executor.ThreadTaskExecutor

/**
 * <p>Title: Ok </p>
 * <p>Description:  </p>
 * <p>Company: www.mapuni.com </p>
 *
 * @author : 蔡俊峰
 * @date : 2020/7/21 21:48
 * @version : 1.0
 */



fun thread(): ThreadTaskExecutor {
    return ThreadTaskExecutor.getInstance()
}

fun <T> post(io: () -> T, main: (any: T) -> Unit) {
    postIo {
        val ioAny = io()
        postOnMain {
            main(ioAny)
        }
    }
}

fun postIo(run: () -> Unit) {
    thread().postIo { run() }
}

fun postDelayed(run: () -> Unit, delayMillis: Long): Boolean {
    return thread().postDelayed({ run() }, delayMillis)
}

fun postAtTime(runnable: Runnable, uptimeMillis: Long): Boolean {
    return thread().postAtTime(runnable, uptimeMillis)
}

fun postToMain(run: () -> Unit) {
    thread().postToMain { run() }
}

fun postOnMain(run: () -> Unit) {
    thread().postOnMain { run() }
}

fun isMainThread(): Boolean {
    return thread().isMainThread
}