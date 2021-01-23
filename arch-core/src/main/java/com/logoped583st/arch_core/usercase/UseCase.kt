package com.logoped583st.arch_core.usercase

interface UseCase<I, O> {
    fun execute(input: I): O
}