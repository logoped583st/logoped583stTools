package com.logoped583st.buildsrc.libraries

object AndroidLibraries {
    private const val androidxFragmentGroup = "androidx.fragment"
    private const val androidxFragmentModule = "fragment"
    private const val androidxFragmentKtxModule = "fragment-ktx"

    private const val androidxFragmentVersion = "1.2.5"

    private const val fragmentBindingDelegateGroup = "om.kirich1409.viewbindingpropertydelegate"
    private const val fragmentBindingDelegateModule = "viewbindingpropertydelegate"

    private const val fragmentBindingVersion = "1.4.0"

    val androidxFragmentLibrary = Library(androidxFragmentGroup, androidxFragmentModule, androidxFragmentVersion)
    val androidxFragmentKtxLibrary = Library(androidxFragmentGroup, androidxFragmentKtxModule, androidxFragmentVersion)
    val bindingDelegateLibrary = Library(fragmentBindingDelegateGroup, fragmentBindingDelegateModule, fragmentBindingVersion)

}