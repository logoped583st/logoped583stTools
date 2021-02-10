package com.logoped583st.buildsrc.libraries

object AndroidLibraries {


    private const val androidxActivityGroup = "androidx.activity"
    private const val androidxActivityModule = "activity"
    private const val androidxActivityKtxModule = "activity-ktx"
    private const val androidxActivityVersion = "1.1.0"

    val androidxActivityLibrary = Library(androidxActivityGroup, androidxActivityModule, androidxActivityVersion)
    val androidxActivityKtxLibrary = Library(androidxActivityGroup, androidxActivityKtxModule, androidxActivityVersion)

    private const val androidxAppCompatGroup = "androidx.appcompat"
    private const val androidxAppCompatModule = "appcompat"
    private const val androidxAppCompatResourceModule = "appcompat-resources"
    private const val androidxAppCompatVersion = "1.2.0"

    val androidxAppCompatLibrary = Library(androidxAppCompatGroup, androidxAppCompatModule, androidxAppCompatVersion)
    val androidxAppCompatResourcesLibrary = Library(androidxAppCompatGroup, androidxAppCompatResourceModule, androidxAppCompatVersion)

    private const val androidxFragmentGroup = "androidx.fragment"
    private const val androidxFragmentModule = "fragment"
    private const val androidxFragmentKtxModule = "fragment-ktx"

    private const val androidxFragmentVersion = "1.2.5"

    private const val fragmentBindingDelegateGroup = "com.kirich1409.viewbindingpropertydelegate"
    private const val fragmentBindingDelegateModule = "viewbindingpropertydelegate"

    private const val fragmentBindingVersion = "1.4.1"

    val androidxFragmentLibrary = Library(androidxFragmentGroup, androidxFragmentModule, androidxFragmentVersion)
    val androidxFragmentKtxLibrary = Library(androidxFragmentGroup, androidxFragmentKtxModule, androidxFragmentVersion)
    val bindingDelegateLibrary = Library(fragmentBindingDelegateGroup, fragmentBindingDelegateModule, fragmentBindingVersion)

}