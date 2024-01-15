package com.ismalel.eldenringchecklist.domain

interface BaseUseCase<in P, out R> {
    suspend operator fun invoke(params: P): R
}