
[![Build Status](https://travis-ci.org/morhpt/Basic-Drawing-View.svg?branch=master)](https://travis-ci.org/morhpt/Basic-Drawing-View) [![Dependency Status](https://www.versioneye.com/user/projects/5ac9a96e0fb24f39bed6dd2c/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5ac9a96e0fb24f39bed6dd2c)  [![license](https://img.shields.io/github/license/morhpt/Basic-Drawing-View.svg)](https://github.com/morhpt/Basic-Drawing-View/blob/master/LICENSE)

# Android Basic Drawing View   
Drawing view library for Android    
  
### Screenshots

<img src="https://raw.githubusercontent.com/morhpt/Basic-Drawing-View/master/screenshots/ss0.png" width="360">
  
### Installation    
 Maven:  
```xml  
<dependency>  
    <groupId>com.morhpt.drawingview</groupId>
    <artifactId>drawingview</artifactId>
    <version>1.0.6</version>
    <type>pom</type>
</dependency>  
```  
  
Gradle:  
```gradle  
implementation 'com.morhpt.drawingview:drawingview:1.0.6'
```  
  
### Usage  
  
You can use the library either on Kotlin DSL or XML  
  
#### XML  
  
```xml  
<com.morhpt.drawingview.DrawingView   
  android:id="@+id/drawingView"
  android:layout_width="match_parent"  
  android:layout_height="match_parent" />  
```  

```kotlin
val drawingView = findViewById<DrawingView>(R.id.drawingView)
```  

#### Kotlin DSL  
  
```kotlin  
lateinit var mDrawingView: DrawingView

drawingView {
	drawView = this
}
```

### Methods

To get and set stroke size:
```kotlin
mDrawingView.stroke // returns float value
mDrawingView.stroke = 15f
```

To get and set color:
```kotlin
mDrawingView.color // returns int value
mDrawingView.color = Color.RED
```

To get and set style:
```kotlin
mDrawingView.style // returns Paint.Style value
mDrawingView.style = Paint.Style.STROKE
```

To get and set anti alias
```kotlin
mDrawingView.isAntiAlias // returns boolean value
mDrawingView.isAntiAlias = true
```

To get and set stroke join
```kotlin
mDrawingView.strokeJoin // returns Paint.Join value
mDrawingView.strokeJoin = Paint.Join.ROUND
```

To get bitmap of the view
```kotlin
mDrawingView.bitmap // returns bitmap
```

To set pixel or create a rectangle on a specific location
```kotlin
mDrawingView.setPixel(10f, 10f, false, true, RectF(x, y, x + 0.1f, y + 0.1f))
```

To refresh the view
```kotlin
mDrawingView.refresh()
```

To force refresh the view
```kotlin
mDrawingView.hardRefresh()
```

To clear the canvas
```kotlin
mDrawingView.clearCanvas()
```

## Licensing  
  
This project is open-source via the  [MIT License](https://github.com/morhpt/Basic-Drawing-View/blob/master/LICENSE).
