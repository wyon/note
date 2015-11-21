本篇文章为转载，原文地址[android应用开发全程实录-你有多熟悉listview？](http://www.cnblogs.com/noTice520/archive/2011/12/05/2276379.html)

# android应用开发全程实录-你有多熟悉listview？

今天给大家带来《android应用开发全程实录》中关于listview和adapter部分。包括listview基本使用，listview的优化等。

我们经常会在应用程序中使用列表的形式来展现一些内容，所以学好ListView是非常必需的。ListView也是Android中比较难以使用的控件，这节内容就将详细解读ListView的用法。

一个ListView通常有两个职责。

1. 将数据填充到界面。
2. 处理用户的选择点击等操作。

第一点很好理解，ListView就是实现这个功能的。第二点也不难做到，在后面的学习中读者会发现，这非常简单。

一个ListView的创建需要3个元素。

1. ListView中的每一列View。
2. 填入View中的数据或图片。
3. 连接数据与ListView的适配器。

也就是说，要使用ListView，首先要了解什么是适配器。适配器是一个连接数据和AdapterView（ListView就是一个典型的AdapterView，后面还会学习其他的）的桥梁，通过它能能有效的实现数据与AdapterView的分离设置，使AdapterView与数据的绑定更加简便，修改更加方便。

Android中提供了很多的Adapter，下表中列出了常用的几个：

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |