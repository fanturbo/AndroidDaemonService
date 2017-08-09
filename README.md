# AndroidDaemonService
### 第一种方式
白色保活：使Service置为前台显示来提权

### 第二种方式
灰色保活：它是利用系统的漏洞来启动一个前台的Service进程，与普通的启动方式区别在于，它不会在系统通知栏处出现一个Notification，看起来就如同运行着一个后台Service进程一样。这样做带来的好处就是，用户无法察觉到你运行着一个前台进程（因为看不到Notification）,但你的进程优先级又是高于普通后台进程的
具体代码中分为<api18和>api18两种情况

其他辅助手段有：
- 借助AlarmManager 发送唤醒广播来促使挂掉的UI进程重新启动起来
- 双Service守护互相拉起
- 使用ProcessBuilder或者Runtime创建一个新的进程
- BroadCastReceiver 监听系统广播（7.0以后禁止掉了，当然，比如小米魅族早禁掉了）
并且在 BroadCastReceiver中启动Service

- .借助系统Service 比如说NotificationListenerService
- so注入系统进程 compile 'com.coolerfall:android-app-daemon:1.2.0'

### 第三种方式
黑色保活：
KFC外带全家桶

参考链接：

http://blog.csdn.net/aigestudio/article/details/51348408

http://www.jianshu.com/p/63aafe3c12af#

https://github.com/Coolerfall/Android-AppDaemon

https://github.com/D-clock/AndroidDaemonService

https://github.com/Marswin/MarsDaemon

https://segmentfault.com/a/1190000006251859#articleHeader1

> 本库代码不是所谓万能不死的黑科技实现，旨在提供更合理的进程保活方式。

另外，个人也并不喜欢所谓的万能不死进程保活方式。原因大致有二：

- 不死的进程是不可能存在的（个人认为），Google不可能让你在Android平台上为所欲为；
- 流氓方式的进程保活只会搞坏整个 Android 生态环境，对所有 Android 平台开发者或其他利益相关者百害而无一利；

## 最新更新（编辑于2016-04-20）

- 修复一些机型上的bug；

- 验证了华为机子上手Q和微信白名单问题；**有童鞋问，在华为的机子上发现微信UI进程退到后台，oom_adj的值一点都没有变，问是不是有什么黑科技在其中。为此，我稍稍验证了一下，验证方式就是把当前工程的包名改成手机QQ的，编译运行在华为的机子上，发现我的进程怎么杀也都是不死的，退到后台oom_adj的值同样不发生变化，而恢复原来的包名就不行了。so，你懂的！你想试试的话，可以下载我已经编译好的包，验证一下是否和我一致**

1. [手Q包名apk](notes/AndroidDaemonService-debug（伪装手Q）.apk)
2. [普通包名apk](notes/AndroidDaemonService-debug（普通）.apk)

详细文章请看 http://www.jianshu.com/p/63aafe3c12af
