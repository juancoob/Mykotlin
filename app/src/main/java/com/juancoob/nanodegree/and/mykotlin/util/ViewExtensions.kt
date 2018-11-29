package com.juancoob.nanodegree.and.mykotlin.util

import android.content.Context
import android.view.View

/**
 * This is an example which shows how to use extension properties
 *
 * Created by Juan Antonio Cobos Obrero on 29/11/18.
 */

val View.ctx: Context
    get() = context