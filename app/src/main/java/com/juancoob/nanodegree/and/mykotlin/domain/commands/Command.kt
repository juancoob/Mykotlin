package com.juancoob.nanodegree.and.mykotlin.domain.commands

/**
 * Created by Juan Antonio Cobos Obrero on 3/11/18.
 */
interface Command<out T> {
    fun execute(): T
}