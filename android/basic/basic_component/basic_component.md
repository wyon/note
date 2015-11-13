本篇文章为转载，原文地址：[Android四大基本组件介绍与生命周期](http://www.cnblogs.com/bravestarrhu/archive/2012/05/02/2479461.html)

# Android四大基本组件介绍与生命周期

Android四大基本组件分别是[`Activity`](#activity)，`Service服务`，`ContentProvider内容提供者`，[`BroadcastReceiver广播接收者`](#broadcastreceiver)

### **一：了解四大基本组件**

#### [Activity](id:activity):

应用程序中，一个Activity通常就是一个单独的屏幕，它上面可以显示一些控件也可以监听处、理用户的事件并做出响应。

Activity之间通过`Intent`进行通信。

在Intent的描述结构中，有两个最重要的部分：__动作和动作对应的数据__。

典型的动作类型有：MAIN（activity 的门户）,VIEW,PICK,EDIT等。而动作对应的数据则以URI的形式进行表述。例如：要查看一个人的联系方式，你需要创建一个动作类型为VIEW的Intent，以及一个表示这个人的URI。

与之有关系的一个类叫`IntentFilter`，相对于Intent是一个有效的做某事的请求，一个intentfilter则用于描述一个activity(或者IntentReceiver)，能够操作哪些Intent。一个acitivity如果要显示一个人的联系方式时，需要声明一个IntentFilter，这个IntentFilter要知道怎么去处理VIEW动作和表示一个人的URI。

IntentFilter需要在`AndroidManifest.xml`中定义。通过解析各种Intent，从一个屏幕导航到另一个屏幕是很简单的。当向前导航时，activity将会调用`startActivity(Intent myIntent)`方法。然后，系统会在所有安装的应用程序中定义的IntentFilter中查找，找到最匹配`myIntent`的IntentFilter对应的Activity。新的Activity接到myIntent的通知后，开始运行。

**当`startActivity`方法被调用将触发解析`myIntent`的动作，这个机制提供了两个关键的好处：**

+ **Activities能够重复利用从其他组件中以Intent的形式产生的一个请求；**
+ **Activities可以在任何时候被一个具有相同的IntentFilter的新的Activity取代。**

AndroidManifest文件中含有如下过滤器的Activity组件为默认启动类，当程序启动时，系统自动调用它
	
	<intent-filter>
		<action android:name="android.intent.action.MAIN" />
		<category android:name="android.intent.category.LAUNCHER" />
	</intent-filter>
	
#### [BroadcastReceiver广播接收器](id:broadcastreceiver)：

你的应用可以使用它对外部事件进行过滤只对感兴趣的外部事件（如当电话呼入时，或者数据网络可用时）进行接收并做出响应。广播接收器没有界面，但是它可以启动一个Activity或者Service来处理它接收的消息，或用NotificationManager来通知用户。通知可以用多种方式来吸引用户的注意力－闪动背光、震动、播放声音等。一般来说，是在通知栏上放一个持久的图标，用户可以打开它并获取消息。

**广播类型**

+ 普通广播<p>
  　　通过`Context.sendBroadcast(Intent myIntent)`发送的。
+ 有序广播<p>
  　　通过`Context.sendOrderedBroadcast(intent, receiverPermission)`发送的，~~该方法第二个参数决定该广播的级别，级别数值是在－1000到1000之间，值越大，发送的优先级越高~~（关于第二个参数receiverPermission此处的描述有误，API文档描述是：(optional) String naming a permissions that a receiver must hold in order to receive your broadcast. If null, no permission is required.）；广播接收者接收广播的级别（可通过intentfilter中的priority进行设置，设为2147483647时优先级最高），同级别接受的先后是随机的，再到级别低的接受收到广播，高级别的或同级别先接受到广播的可以通过`abortBroadcast()`方法截断广播使其他接收者无法收到该广播。
+ ~~异步广播~~（此处译为"_持久广播_ " | "_粘性广播_ " 较好）<p>
　　通过`Context.sendStickyBroadcast(Intent myIntent)`