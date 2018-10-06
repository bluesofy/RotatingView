# RotatingView
[ ![Download](https://api.bintray.com/packages/blueyuki/maven/RotatingView/images/download.svg) ](https://bintray.com/blueyuki/maven/RotatingView/_latestVersion)

ImageView结合Animation对无限旋转的简单实现，做成组件只是为了使用方便。


## 效果图 Preview
![](https://github.com/bluesofy/RotatingView/blob/master/preview/preview.gif)


## 使用说明 Usage
- 添加依赖
```gradle
implementation 'cn.byk.pandora:rotatingview:1.0.0'
```

- XML布局引用，其他的属性和方法的使用同**ImageView**
```java
<cn.byk.pandora.rotatingview.RotatingView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher"
        rv:circles="15"
        rv:duration="6000"
        rv:infinity="true"/>
```

- 自定义属性说明

| 属性名 | 用途 |
| ---- | ---- |
| duration | 旋转持续总时间，单位毫秒 |
| circles  | 旋转圈数，可以根据旋转速率算出来 |
| infinity | 是否无限执行动画 |


## 更多 More
哪天心血来潮了会添加一些自定义插值器来玩玩。


### 联系方式  Support or Contact
E-Mail: bluesofy@qq.com / bluesofy@live.cn
