# shapeView
轻松为各种控件添加阴影，圆角，状态等

<img src="https://tiebapic.baidu.com/forum/pic/item/b90e7bec54e736d10d31bb1ec6504fc2d5626981.jpg" width="350px">  <img src="https://tiebapic.baidu.com/forum/pic/item/37d12f2eb9389b506addd744d835e5dde7116e81.jpg" width="350px">
  <img src="https://tiebapic.baidu.com/forum/pic/item/dbb44aed2e738bd4f2390cdce48b87d6267ff9c7.jpg" width="350px">  <img src="https://tiebapic.baidu.com/forum/pic/item/cc11728b4710b912a1b8c1e89efdfc03924522ae.jpg" width="350px">

### 依赖

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
	dependencies {
	        implementation 'com.github.jingzz:jzwidget:1.1.0'
	}
```
### 可使用控件包括：ShapeLinearLayout、ShapeRelativeLayout、ShapeFrameLayout、ShapeConstraintLayout、ShapeView、ShapeTextView、ShapeEditText、ShapeButton、ShapeCheckedTextView
### xml添加状态
```
    <com.jingzz.shapeView.widget.ShapeView
        android:layout_width="80dp"
        android:layout_height="120dp"
        android:layout_marginEnd="24dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="@+id/view15"
        app:shape_backgroundColor="@color/blue"
        app:shape_gradientColors="@array/rainbow_color"
        app:shape_gradientOrientation="TL_BR"
        app:shape_gradientType="sweep"
        app:shape_isOver="true"
        app:shape_strokeColor="@color/orange"
        app:shape_strokeDash="10dp"
        app:shape_strokeGap="4dp"
        app:shape_strokeWidth="4dp" 
	/>
```
自定义属性太多，可以参考：(https://github.com/jingzz1/shapeView/blob/master/shapeView/src/main/res/values/attrs.xml) 

### 动态修改
每个自定义属性都有setXX方法可以动态修改
```
        shapeView.setShapeBackgroundColor(背景色)
            .setShapeOver(是否圆形)
            .setShapeStrokeColor(边框颜色)
            .setShapeStrokeWidth(边框宽度)
            .setShapeShadowColor(阴影颜色)
            .setShapeShadowSize(阴影大小)
                ……
            .shapeCreate() //最后调用shapeCreate方法保存修改
```

### EditText添加图标和点击事件
```
可在xml定义，也可以动态修改
    <com.jingzz.shapeView.widget.ShapeEditText
        ……
        app:shape_backgroundColor="@color/white"
        app:shape_strokeWidth="2dp"
        app:shape_strokeColor="@color/orange"
        app:shape_radius="23dp"
        android:paddingStart="25dp"
        android:paddingEnd="25dp"
        android:drawableLeft="@mipmap/ic_launcher"
        app:shape_drawableLeft_width="30dp"
        app:shape_drawableLeft_height="30dp"
        android:drawableRight="@mipmap/ic_launcher"
        app:shape_drawableRight_height="60dp"
        app:shape_drawableRight_width="60dp"
        android:drawableTop="@mipmap/ic_launcher"
        app:shape_drawableTop_height="50dp"
        app:shape_drawableTop_width="25dp"
        android:drawableBottom="@mipmap/ic_launcher"
        app:shape_drawableBottom_width="50dp"
        app:shape_drawableBottom_height="25dp"/>
```
监听点击事件
```
        edit.setOnIconClickListener { view, clickType ->
            //clickType 0：左 1:上 2:右 3:下
            when(clickType){
                0 -> Toast.makeText(this,"点击了左边图标",Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this,"点击了上边图标",Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this,"点击了右边图标",Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this,"点击了下边图标",Toast.LENGTH_SHORT).show()
            }
        }
```
