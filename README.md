# tab-bar-view
TabBarView is very lightweight lib for Android implemented in Kotlin and it's based just on `View` class.

#Add dependency
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
   repositories {
     ...
     maven { url "https://jitpack.io" }
  }
}
```
Add the dependency:
```gradle
dependencies {
    compile 'com.github.mklimek:tab-bar-view:$RELEASE_VERSION'
}
```

Check $RELEASE_VERSION [here](https://github.com/mklimek/tab-bar-view/releases)

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
        //Change fragments here or... or something
    }
});
controller.setCurrentItem(0);
```


#How it looks like?
<a href="url"><img src="https://raw.githubusercontent.com/mklimek/tab-bar-view/master/screenshot.png" height="550" ></a>
