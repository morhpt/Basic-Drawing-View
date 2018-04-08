# Android Basic Drawing View  

Drawing view library for Android  

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
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

#### Kotlin DSL

```kotlin
drawingView()
```