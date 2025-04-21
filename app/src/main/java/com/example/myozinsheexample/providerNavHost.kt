package com.example.myozinsheexample

import androidx.fragment.app.Fragment
import androidx.navigation.NavigatorProvider

fun Fragment.provideNavigationHost(): NavigationHostProvider? {
return try{
    activity as NavigationHostProvider
}catch (e: Exception){
    null
}
}
