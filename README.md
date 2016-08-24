# tab-bar-view
TabBarView for Android is implemented in Kotlin and is based just on `View` class.

#How to use it in Java?
add it in `onCreate()`:
```java
TabBarView bottomView = (TabBarView) findViewById(R.id.bottomBar);

TabBarController.TabBuilder tabBuilder = TabBarController.TabBuilder.INSTANCE;
List<TabBarController.Tab> tabs = tabBuilder
        .addTab("Home", ContextCompat.getDrawable(this, R.mipmap.home), ContextCompat.getDrawable(this, R.drawable.gray), ContextCompat.getDrawable(this, R.drawable.orange))
        .addTab("Stats", ContextCompat.getDrawable(this, R.mipmap.stats), ContextCompat.getDrawable(this, R.drawable.gray), ContextCompat.getDrawable(this, R.drawable.orange))
        .addTab("Info", ContextCompat.getDrawable(this, R.mipmap.info), ContextCompat.getDrawable(this, R.drawable.gray), ContextCompat.getDrawable(this, R.drawable.orange))
        .build();

TabBarController controller = new TabBarController(this, tabs, bottomView);
controller.setListener(new TabBarListener() {
    @Override
    public void pageHasBeenChanged(int position) {
        Log.d("Example", "current page: " + position);
    }
});
controller.setCurrentItem(0);
```


#How it looks like?

