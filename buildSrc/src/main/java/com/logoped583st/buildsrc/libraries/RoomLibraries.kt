package com.logoped583st.buildsrc.libraries

object RoomLibraries {

    private const val roomGroup = "androidx.room"
    private const val roomModule = "room-runtime"
    private const val roomKaptModule = "room-compiler"
    private const val roomRxModule = "room-rxjava3"

    private const val roomVersion = "2.3.0-beta01"

    val roomLibrary = Library(roomGroup, roomModule, roomVersion)
    val roomCompilerLibrary = Library(roomGroup, roomKaptModule, roomVersion)
    val roomRxJavaLibrary = Library(roomGroup, roomRxModule, roomVersion)
}