# FloatingActionButton
Yet another implementation of [Floating Action Button](http://www.google.com/design/spec/components/buttons.html#buttons-floating-action-button) for Android.

# Requirements
The Library requires Android **API Level 15+**.

# Demo
Watch a **[Demo Video](https://youtu.be/4jtDpmeod68)** on YouTube.

# Screenshots
![Main screen](/screenshots/main_screen.png) ![Menu closed](/screenshots/menu_closed.png) ![Menu default opened](/screenshots/menu_default_opened.png) ![Menu custom opened](/screenshots/menu_custom_opened.png) ![Menu mini opened](/screenshots/menu_mini_opened.png)

# Features
- Ripple effect on Android Lollipop devices
- Option to set custom normal/pressed/ripple colors
- Option to set custom shadow color and offsets
- Option to disable shadow for buttons and (or) labels
- Option to set custom animations
- Option to set custom icon drawable
- Support for **normal** `56dp` and **mini** `40dp` button sizes.

# Usage
Add a dependency to your `build.gradle`:
```
dependencies {
    compile 'com.github.clans:floatingactionbutton:1.0.0'
}
```
Add the `com.dmytrotarianyk.library.FloatingActionButton` to your layout XMl file.
```XML
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:fab="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity" />

    <com.dmytrotarianyk.library.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|right"
        android:layout_marginBottom="8dp"
        android:layout_marginRight="8dp"
        android:src="@drawable/ic_menu"
        fab:fab_colorNormal="@color/app_primary"
        fab:fab_colorPressed="@color/app_primary_pressed"
        fab:fab_colorRipple="@color/app_ripple"/>

</FrameLayout>
```
You can set an icon for the **FloatingActionButton** using `android:src` xml attribute. Use drawables of size `24dp` as specified by [guidlines](http://www.google.com/design/spec/components/buttons.html#buttons-floating-action-button). Icons of desired size can be generated with [Android Asset Studio](http://romannurik.github.io/AndroidAssetStudio/icons-generic.html).

Here are all the **FloatingActionMenu** xml attributes with thair default values which means that you don't have to set all of them:
```XML
<com.dmytrotarianyk.library.FloatingActionMenu
        android:id="@+id/menu"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:layout_marginRight="10dp"
        android:layout_marginBottom="10dp"
        android:layout_marginLeft="10dp"
        fab:menu_showShadow="true"
        fab:menu_buttonSpacing="0dp"
        fab:menu_labels_margin="0dp"
        fab:menu_labels_showAnimation="@anim/fab_slide_in_from_right"
        fab:menu_labels_hideAnimation="@anim/fab_slide_out_to_right"
        fab:menu_labels_paddingTop="4dp"
        fab:menu_labels_paddingRight="8dp"
        fab:menu_labels_paddingBottom="4dp"
        fab:menu_labels_paddingLeft="8dp"
        fab:menu_labels_padding="8dp"
        fab:menu_labels_textColor="#FFFFFF"
        fab:menu_labels_textSize="14sp"
        fab:menu_labels_cornerRadius="3dp"
        fab:menu_labels_colorNormal="#333333"
        fab:menu_labels_colorPressed="#444444"
        fab:menu_labels_colorRipple="#66FFFFFF"
        fab:menu_shadowColor="#66000000"
        fab:menu_colorNormal="#DA4336"
        fab:menu_colorPressed="#E75043"
        fab:menu_colorRipple="#99FFFFFF"
        fab:menu_animationDelayPerItem="50"
        fab:menu_icon="@drawable/fab_add"
        fab:menu_labels_singleLine="false"
        fab:menu_labels_ellipsize="none"
        fab:menu_labels_maxLines="-1"
        fab:menu_fab_size="normal"
        fab:menu_labels_style="@style/YourCustomLabelsStyle">

        <com.dmytrotarianyk.library.FloatingActionButton
            android:id="@+id/menu_item"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/ic_star"
            fab:menu_fab_size="mini" />

    </com.dmytrotarianyk.library.FloatingActionMenu>
```

# License
```
Copyright 2015 Dmytro Tarianyk

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```