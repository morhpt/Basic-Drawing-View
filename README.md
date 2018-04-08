
# Android Basic Drawing View   
Drawing view library for Android    
  
### Screenshots

![ss0](screenshots/ss0.png  | width=200)  
  
### Installation    
 Maven:  
```xml  
<dependency>  
	<groupId>com.morhpt.drawingview</groupId> 
	<artifactId>drawingview</artifactId> 
	<version>1.0.0</version> 
	<type>pom</type>
</dependency>  
```  
  
Gradle:  
```gradle  
implementation 'com.morhpt.drawingview:drawingview:1.0.0'  
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
lateinit var drawView: DrawingView

drawingView {
	drawView = this
}
```

### Methods

To get and set stroke size:
```kotlin
drawView.stroke // returns float value
drawView.stroke = 15f
```

To get and set color:
```kotlin
drawView.color // returns int value
drawView.color = Color.RED
```

To get and set style:
```kotlin
drawView.style // returns Paint.Style value
drawView.style = Paint.Style.STROKE
```

To get and set anti alias
```kotlin
drawView.isAntiAlias // returns boolean value
drawView.isAntiAlias = true
```

To get and set stroke join
```kotlin
drawView.strokeJoin // returns Paint.Join value
drawView.strokeJoin = Paint.Join.ROUND
```

To get bitmap of the view
```kotlin
drawView.bitmap // returns bitmap
```

To set pixel or create a rectangle on a specific location
```kotlin
drawView.setPixel(10f, 10f, false, true, RectF(x, y, x + 0.1f, y + 0.1f))
```

To refresh the view
```kotlin
drawView.refresh()
```

To force refresh the view
```kotlin
drawView.hardRefresh()
```

To clear the canvas
```kotlin
drawView.clearCanvas()
```

## Licensing  
  
This project is open-source via the  [MIT License](https://github.com/morhpt/Basic-Drawing-View/blob/master/LICENSE).
