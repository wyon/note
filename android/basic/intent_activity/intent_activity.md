# [Intent Resolution](https://developer.android.com/guide/components/intents-filters.html#Resolution)

（翻译安卓官方文档）

当系统接收到一个用来启动某个activity的隐式Intent（implicit intent）时，系统会通过注册的intent filter筛选方式查找到最符合该intent的activity，比较intent和intent filter会通过下面三个方面：

+ intent的action
+ intent的data（包括URI和data type）
+ intent的category

下面的几节描述了，按照组件在app manifest.xml文件中声明的intent-filter，intent怎么找到最匹配最合适的组件（component(s)）。


## Action test

一个intent-filter可以**声明0个或多个**`<action>`元素来指定接受intent的哪些actions。

例如：

	<intent-filter>
		<action android:name="android.intent.action.EDIT" />
		<action android:name="android.intent.action.VIEW" />
		...
	</intent-filter>

1. **如果要通过这个filter的测试，Intent的action必须匹配filter的某个action。**
2. **如果filter不包含任何action，那么任何intent都不能通过该filter。**
3. **~~However, if an Intent does not specify an action, it will pass the test (as long as the filter contains at least one action).~~（在模拟器上测试的时候发现：如果intent不指定action，filter包含一条action，报出异常。）**

## Category test

一个intent-filter可以**声明0个或多个**`<category>`元素来指定接受intent的哪些categories。

例如：

	<intent-filter>
		<category android:name="android.intent.category.DEFAULT" />
		<category android:name="android.intent.category.BROWSABLE" />
	</intent-filter>
	

<table><tr><td bgcolor="yellow">
1. 只有当Intent请求中所有的Category与组件中某一个IntentFilter的<category>完全匹配时，才会让该 Intent请求通过测试，IntentFilter中多余的<category>声明并不会导致匹配失败。   
<font color="red">(filter.categorys containsAll intent.categorys)</font>

</td></tr><tr><td bgcolor="yellow">

2. Androi会向传递给`startActivity()`和`startActivityForResult()`的隐式Intent添加`CATEGORY_DEFAULT`category，所以如果想要通过某intent-filter测试，需要给该intent-filter添加defaualt category。
</td></tr></table>


## Data test

一个intent-filter可以**声明0个或多个**`<data>`元素来指定接受intent的哪些data。

例如：

	<intent-filter>
		<data android:mimeType="video/mpeg" android:scheme="http" ... />
		<data android:mimeType="audio/mpeg" android:scheme="http" ... />
		...
	</intent-filter>

每个`<data>`可以指定一个URI结构数据和一个data type（MIME media type）。有多个属性用来指定URI不同的部分：`scheme`,`host`,`port`,`path`。

	<scheme>://<host>:<port>/<path>
	
例如：

	content://com.example.project:200/floder/subfloder/etc
	
In this URI, the scheme is content, the host is com.example.project, the port is 200, and the path is folder/subfolder/etc.

<br/>
这些属性都是可选的，但是却存在线性依赖：

+ 如果`scheme`没有指定，`host`会被忽略
+ 如果`host`没有指定，`port`会被忽略
+ 如果`scheme`,`host`都没有指定，`path`会被忽略

当在比较filter和intent的URI时，只会比较filter URI的部分。例如：

+ 如果filter只指定了scheme，那么所有符合这个scheme的URI都通过测试。

+ 如果filter指定了scheme和authority而没有指定path，那么所有的有相同的scheme和authority的URI通过filter测试，URI的path部分会被忽略。

+ 如果filter指定了scheme、authority、path，那么只有具有相同的scheme、authority、path的URI能通过filter的测试。   
_（注意⚠：filter的path可以包含通配符 __*__ ，只需要部分匹配即可）_



<br/><br/><br/>



data mimeType:
a) 如果一个intent 没有指定URI 和 data type , 那么如果filter中也是同样，则通过测试，否则，不通过。

b) 如果一个iintent 有URI 但是没有 data type(或者是data type不能从uri中推断出来 ) 只能通过这样的filter: uri匹配, 并且不指定类型. 这种情况限于类似mailto:和tel:这样的不指定实际数据的uri.

c) 如果一个intent 包含 data type 但是没有 uri ,那么 filter中列出相同的data type 并且没有指定URI 则通过测试。

d) 如果一个intent包含一个URI 和data type （或者data type 可以从URI中推断出来），那么filter列出的有相同data type ，intent对象的uri要么和filter中的uri匹配，要么intent的uri为 content: or file: 并且filter不指定uri

如果一个Intent 可以通过多个activity或者filter的filter，那么用户将会被询问需要激活哪个组件。 如果一个都没有的话，将会抛出异常。

Common cases


这个规则是针对   规则d) ,它反映出组件可以从一个file或者content provider 获取本地数据。因此，filters 可以是设置data type并且没有必要明确的将 scheme 命名为 content: 和 file: 。

下面的 <data>元素，告诉android该组件可以从content provider中获取image data 并显示她。

<data android:mimeType="image/*" />

由于大部分可用的数据都是由content provider提供, 指定数据类型但不指定uri的filter是最常见的情况.

Another common configuration is filters with a scheme and a data type. For example, a <data> element like the following tells Android that the component can get video data from the network and display it:

设置了 scheme 和 data type是 另一个比较常见的配置是 。下面的 <data>元素，告诉android该组件可以从网上获取video并显示

<data android:scheme="http" android:type="video/*" />

考虑当用户在一个web page上点了一个链接后，浏览器应用程序做了什么。 它首先会试图去显示该数据（当做一个html页来处理）。如果它不能显示此数据，它会使用一个设置 scheme 和 data type 的隐式意图 去启动一个能显示此数据的activity。如果没有找到接受者，它会调用下载管理器去下载该数据，然后将其放在content provider的控制之下，这样很多activitys （那些之命名了datatype）可以处理该数据


---------------


---------------


下边文章为转载，原文地址：[http://blog.csdn.net/zhangjg_blog/article/details/10901293](http://blog.csdn.net/zhangjg_blog/article/details/10901293)

# Android系统中标准Intent的使用

## 一 Android系统用于Activity的标准Intent

1. 根据联系人ID显示联系人信息   

		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);   //显示联系人信息
		intent.setData(Uri.parse("content://contacts/people/492"));
		startActivity(intent);
		
2. 根据联系人ID显示拨号面板

		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_DIAL);  //显示拨号面板
		intent.setData(Uri.parse("content://contacts/people/492"));
		startActivity(intent);
		
3. 显示拨号面板， 并在拨号面板上将号码显示出来

		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);   
		intent.setData(Uri.parse("tel://15216448315"));
		startActivity(intent);
		
4. 显示拨号面板， 并在拨号面板上将号码显示出来

		Intent intent = new Intent();
		//显示拨号面板, 并在拨号面板上将号码显示出来
		intent.setAction(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel://15216448315"));
		startActivity(intent);
		

