# Android学习之路

原文地址：[Android学习之路](http://www.stormzhang.com/android/2014/07/07/learn-android-from-rookie/)


### Android基础

新手必须掌握的的知识点。

* [两分钟彻底让你明白Android Activity生命周期(图文)!](android/basic/activity_lifecycle/android_activity_life_cycle.md)   
Android实际开发中使用频率最高，必须要理解

* [Android四大基本组件介绍与生命周期](android/basic/basic_component/basic_component.md)   
Android四大基本组件，必须掌握，面试常问。
  
* [ListView的基本使用与优化](android/basic/listview/listview.md)   
ListView是所有控件中最常使用且对新手来说比较复杂的用法，各种Adapter的使用以及ListView的优化都是必须掌握的。  

* [Android系统用于Activity的标准Intent](android/basic/intent_activity/intent_activity.md)   
Intent解决了Android中四大组件的通讯，非常有用，这篇博客收集整理了系统的标准Intent

* [Android屏幕适配](android/basic/compatible_screens/compatible_screens.md)   
介绍一些Android屏幕适配的基础

* [Android中SQLite应用详解](android/basic/android_sqlite/android_sqlite.md)   
Android中的SQLite需要掌握，这篇博客很适合新手

* [Android Fragment完全解析](android/basic/android_fragment/android_fragment.md)   
3.0之后新加的Fragment，必须要掌握，目前使用的场景也是越来越普遍了

### Android中级

* [Android应用程序的生命周期](android/midlevel/android_application_lifecycle/android_application_lifecycle.md)   
Android的应用程序的生命周期需要理解，面试也是经常会被问的

* [__Android View框架概述，带你一步步深入了解View__](android/midlevel/view_inflate/view_inflate.md)   
View做为UI开发中最常用到的，必须要深入理解

* [ Android Service完全解析（上）](http://blog.csdn.net/guolin_blog/article/details/11952435)   
  [ Android Service完全解析（下）](http://blog.csdn.net/guolin_blog/article/details/9797169)   
Service作为Android四大组件之一，在每一个应用程序中都扮演着非常重要的角色

* [Android Gson](http://www.stormzhang.com/android/2014/05/22/android-gson/)   
  [FastJson](https://github.com/alibaba/fastjson)   
目前比较常用比较流行的数据格式就是json了

* [Android 布局优化](http://stormzhang.com/android/2014/04/10/android-optimize-layout/)   
Android开发中经常会用到xml布局，那么布局优化方面的知识更是需要掌握的了

* [Android中Intent传递对象的两种方法(Serializable,Parcelable)](http://blog.csdn.net/android_tutor/article/details/5740845)   
详细讲解了Android中Intent中如何传递对象

* [Android异步消息处理机制完全解析](http://blog.csdn.net/guolin_blog/article/details/9991569)   
Android开发中异步操作是经常使用的，必须理解掌握

* [Android AsyncTask完全解析](http://blog.csdn.net/guolin_blog/article/details/11711405)   
Android异步操作的另一种方法

* [Android Custom Loading](http://stormzhang.com/openandroid/2013/11/15/android-custom-loading/)   
很早的一个小demo，教你如何做一个App的Loading动画

### Android进阶

* [Android Gradle](http://stormzhang.com/android/2014/02/28/android-gradle/)   
Google官方Android新的构建系统，可以很方便的管理依赖、编译打包等

* [Android 性能优化](http://www.trinea.cn/android/android-performance-demo/)    
一系列的性能调优教程，让你的代码以及App更畅通！

* [一个完整的开源项目–9GAG](https://github.com/stormzhang/9GAG)   
一个开源客户端，教你使用Studio、Gradle以及一些流行的开源库快速开发一个不错的Android客户端

* [整理的Android开发资源](http://stormzhang.com/android/2014/06/05/android-awesome-resources/)   
自己整理的一些Android开发资源，包括开发、工具、设计等，相信会对你有用的

### Android设计

在开发一款Android App之前，你需要了解下Android平台的设计规范，这里有Google最新推出的Material Design中文翻译版

* [Material Design](http://design.1sters.com/)

### Android兼容库

在了解了设计规范准备着手开发你的App时，你还需要考虑你的App支持的版本，如果是全新的App，从目前的市场份额来看，建议直接支持4.0+，虽然2.3的份额仍然有一部分，但是这部分真正用来使用App的人又能有多少呢。当然如果你的公司必须要求支持2.x的版本，那么也不用担心，下面整理了几个满足你适配的一些兼容库:

* [ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock)    
大神JakeWharton的一个ActionBar的兼容库，支持在2.x版本使用ActionBar

* [ActionBar Compact](http://www.stormzhang.com/android/2013/12/13/android-actionbar-compact/)     
在这之前使用ActionBar基本都会使用上述JakeWharton的兼容库，但是目前Google有了自己的一套ActionBar兼容库，推荐使用ActionBar Compact，具体介绍及使用方法详见我的这篇博客

* [NineOldAndroids](http://nineoldandroids.com/)     
Android 3.0之前开放的一些新的动画api–Property Animation，大神JakeWharton的又一大作，可以让你在2.x版本的sdk可以使用属性动画.

* [Android Support V4](http://developer.android.com/reference/android/support/v4/app/package-summary.html)    
如果需要兼容2.x的版本，在使用如下类的时候你需要使用v4包下的，如Fragment, FragmentManager, FragmentActivity, FragmentPagerAdapter, CursorLoader, LoaderManager, AsyncTaskLoader


当然v4包下面除了以上还有一些新的控件你必须知道


* [Navigation Drawer(导航抽屉)](http://blog.chengyunfeng.com/?p=493)    
在这之前在Android上实现一个抽屉导航你可能会用到SlidingMenu开源库，如今你可以使用官方的DrawerLayout控件很容易实现

* [SlidingPaneLayout](http://my.oschina.net/summerpxy/blog/211835)     
SlidingPaneLayout是V4包中新添加的组件，可以实现两列面板的切换, 具体使用与效果见博客链接

* [SwipeRefreshLayout](https://github.com/stormzhang/SwipeRefreshLayoutDemo)    
SwipeRefreshLayout是Google在support v4 19.1版本的library更新的一个下拉刷新组件,使用起来很方便,可以很方便的实现Google Now的效果


### Android开发必知的一些开源库

说到开源库就不得不提[GitHub](https://github.com/)，只能说是目前最活跃的开源社区，不知道的赶紧去注册个账号使用起来，绝对是你快速提升技术的利器。

##### [Volley](https://android.googlesource.com/platform/frameworks/volley)

App开发中免不了要和服务端进行交互，而volley是Google官方推出的一个开源的网络通信库，它能使网络通信更简单，更快速。

* [Volley完全解析](http://blog.csdn.net/guolin_blog/article/details/17482095)
* [Android volley sample](https://github.com/stormzhang/AndroidVolley)

##### [ActiveAndroid](http://github.com/pardom/ActiveAndroid)

ActiveAndroid算是一个轻量级的ORM(对象关系映射(Object Relation Mapping))框架，简单地通过如save()和delete()等方法来做到增删改查等操作。

* [ActiveAndroid–Android轻量级ORM框架](http://stormzhang.com/openandroid/android/sqlite/2013/12/20/android-orm-tools-activeandroid/)

##### [Retrofit](http://square.github.io/retrofit/)

Retrofit和Java领域的ORM概念类似，ORM把结构化数据转换为Java对象，而Retrofit 把REST API返回的数据转化为Java对象方便操作。同时还封装了网络代码的调用。

* [Retrofit – Java(Android) 的REST 接口封装类库](http://blog.chengyunfeng.com/?p=491)

##### [Android-Universal-Image-Loader](https://github.com/nostra13/Android-Universal-Image-Loader)

Android-Universal-Image-Loader是一个强大的开源图片异步加载库，该项目的目的是提供一个可重复使用的仪器为异步图像加载，缓存和显示。

* [Android-Universal-Image-Loader](http://stormzhang.com/android/openandroid/2013/12/01/android-universal-image-loader/)

### [Android开源项目分类汇总](https://github.com/Trinea/android-open-project)
非常全面的GitHub开源项目汇总，不需要重复发明轮子，尽情遨游在开源世界里吧
