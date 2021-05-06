package com.example.navigator.navigator

object ScreensStack {

    private var backStackHistory = mutableListOf<Screens>()

    // Add screen in stack
    fun addScreen(screen: Screens) {
        backStackHistory.add(screen)
    }

    // Add screen in stack
    fun addScreens(screen: Array<out Screens>) {
        backStackHistory.addAll(screen)
    }

    // Remove screen from stack
    fun removeScreen(screen: Screens) {
        val tempScreens = backStackHistory
        tempScreens.forEach {
            backStackHistory.remove(it)
        }
    }

    // Remove last screen from history
    fun removeLast(){
        backStackHistory.removeAt(backStackHistory.size - 1)
    }

    // Check is screen exists in history
    fun isScreenExists(screen: Screens): Boolean {
        return backStackHistory.indexOf(screen) != -1
    }

    // Remove all screens
    fun removeAllScreens() {
        backStackHistory = ArrayList()
    }

    // Get previous screen
    fun getPreviousScreen(currentScreen: Screens): Screens? {
        val currentIndex = backStackHistory.lastIndexOf(currentScreen)
        if (currentIndex < 0 || currentIndex - 1 < 0) return null
        return backStackHistory[currentIndex - 1]
    }

    fun getScreenByFragmentClass(fragmentClassName: String?): Screens? {

        backStackHistory.forEach {
            if(it.fragmentClass.name == fragmentClassName){
                return it
            }
        }

        return null
    }
}