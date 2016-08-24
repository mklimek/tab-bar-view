package com.mklimek.library

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.widget.TextView
import org.w3c.dom.Text


class BottomTabBarController(context: Context, val tabs: List<Tab>, val bottomTabBarView: BottomTabBarView) {

    private var current = 0

    private var listener: BottomTabBarListener? = null

    init{
        val inflater = LayoutInflater.from(context)
        for(tab in tabs){
            val textView = inflater.inflate(R.layout.bottom_tab_bar_item, bottomTabBarView, false) as TextView
            styleItem(tab, textView)
            textView.setOnClickListener { setCurrentItem(tabs.indexOf(tab)) }
            bottomTabBarView.addView(textView)
        }
    }

    private fun styleItem(tab: Tab, textView: TextView) {
        textView.text = tab.title
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundResource(tab.backgroundId)
        textView.setCompoundDrawablesWithIntrinsicBounds(0, tab.iconId, 0, 0)
    }

    fun getTabsAsTextViews(): List<TextView>{
        var children = mutableListOf<TextView>()
        tabs.forEach {
            children.add(bottomTabBarView.getChildAt(tabs.indexOf(it)) as TextView)
        }
        return children
    }

    fun setListener(listener: BottomTabBarListener){
        this.listener = listener
    }

    fun setCurrentItem(currentItem: Int) {
        current = currentItem
        tabs.filter { tabs.indexOf(it) != current }.forEach {
            val child = bottomTabBarView.getChildAt(tabs.indexOf(it))
            child.setBackgroundResource(it.backgroundId)
        }
        val selectedTab = tabs.first { tabs.indexOf(it) == current }
        val selectedChild = bottomTabBarView.getChildAt(tabs.indexOf(selectedTab))
        selectedChild.setBackgroundResource(selectedTab.backgroundSelectedId)

        listener?.pageHasBeenChanged(current)
    }

    object TabBuilder{

        private var tabs = mutableListOf<Tab>()

        fun addTab(title: String, iconId: Int, backgroundId: Int, backgroundSelectedId: Int): TabBuilder{
            tabs.add(Tab(title, iconId, backgroundId, backgroundSelectedId))
            return this
        }

        fun build(): List<Tab>{
            return tabs
        }
    }

    class Tab(val title: String, val iconId: Int, val backgroundId: Int, val backgroundSelectedId: Int){
    }

}

