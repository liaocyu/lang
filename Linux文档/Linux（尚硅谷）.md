（前7集听听就好，大佬的传奇故事简直就是无敌爽文）

[3天搞定Linux，1天搞定Shell，清华学神带你通关（2022版）_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1WY4y1H7d3?share_source=copy_web&vd_source=86199a2693766e3e92fac59f5c8b155a)

（真心建议看视频，老师讲的很细，我这笔记记不到那么细致）

# Linux概述
:::info
### linux是什么
linux是一个操作系统（OS），和windows、MacOS一样	。
### 概述（当故事看看就好）
Linux内核最初只是芬兰人Linux Torvalds（李纳斯·托瓦兹）在赫尔辛基大学上学时处于个人爱好而编写的。高中时精通汇编语言，大学对Unix操作系统感兴趣，但Unix不开源，看不到，基于Minix(Unix的变种)开发，就仿写Unix诞生了Linux，并作出伟大的决定开源（开放源代码），后面有看不惯SVN收费，就自己写出了Git。
而关于Unix我们就要提到另两位大神Ken Thompson（肯·汤普森）和Dennis M. Ritchie（丹尼斯·利奇），前一位开创Unix操作系统，期间汇编语言写操作系统很烦就写出B语言，也就是C语言的前身;后一位完善了Unix操作系统，且在B语言的基础上写出了C语言。（大学必学语言，咯，这就是大神。）

Linux是一套免费使用和自由传播的类Unix操作系统，是一个基于POSIX和UNIX的多用户、多任务、支持多线程和多CPU的操作系统。Linux能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承 了Unix以网络为核心的设计思想，是一个性能稳定的多用户网络操作系统。
目前市面上较指明的发行版有：Ubunta、RedHat、CentOS，Debain、Fedora、SuSE、OpenSUSE。
## Linux和Windows区别
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/589/image-20220924195820555.png#crop=0&crop=0&crop=1&crop=1&id=vMELo&originHeight=690&originWidth=1442&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
:::

# Linux下载安装和虚拟机的下载安装
[***The CentOS Project***](https://www.centos.org/)

[**Linux操作系统CentOS下载地址**](http://isoredirect.centos.org/centos/7/isos/x86_64/)

（VMware下载官网，可试用）

https://www.vmware.com/cn/products/workstation-pro.htmlVMware

[**虚拟机-安装与使用（详细教程）_多加点辣也没关系的博客-CSDN博客_虚拟机怎么安装**](https://blog.csdn.net/xhmico/article/details/122505951?ops_request_misc=%7B%22request%5Fid%22%3A%22166389578616800180651835%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=166389578616800180651835&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-122505951-null-null.142^v50^control,201^v3^control_2&utm_term=虚拟机&spm=1018.2226.3001.4187)

激活密钥（通用批量永久激活许可） 16：ZF3R0-FHED2-M80TY-8QYGC-NPKYF 15：FC7D0-D1YDL-M8DXZ-CYPZE-P2AY6 12：ZC3TK-63GE6-481JY-WWW5T-Z7ATA 10：1Z0G9-67285-FZG78-ZL3Q2-234JG

> ## CentOS下载
> 在里面选择一个镜像网站[CentOS-7-x86_64-DVD-2009.iso](http://mirrors.aliyun.com/centos/7.9.2009/isos/x86_64/CentOS-7-x86_64-DVD-2009.iso)（我这个是阿里云的网站）
> 大家尽量下载centOS-7版本的，虽说有CentOS-8版本的但这个版本英年早逝不更新了。
>
> [**CentOS 7 即将停止维护！**](https://blog.csdn.net/yimaoya/article/details/125414497?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166521017016800180634469%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166521017016800180634469&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~baidu_landing_v2~default-3-125414497-null-null.142^v51^control,201^v3^control_2&utm_term=centOS&spm=1018.2226.3001.4187)
>
> (有时间可以看看，可当谈资)
> （下载好了ISO文件之后就是下载虚拟机了）
>
> ## 虚拟机VMware下载和Linux安装
> （大家自行网上搜索，我只提供参考链接，学习视频中有教可视化操作）
>
> [虚拟机VMware的详细安装教程_Y O U的博客-CSDN博客_vmware虚拟机安装](
> https://blog.csdn.net/weixin_48363519/article/details/125730181?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166520981016782414969034%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=166520981016782414969034&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~times_rank-2-125730181-null-null.142^v51^control,201^v3^control_2&utm_term=%E8%99%9A%E6%8B%9F%E6%9C%BAVMware%E4%B8%8B%E8%BD%BD%E5%92%8CLinux%E5%AE%89%E8%A3%85&spm=1018.2226.3001.4187)
>
> VMware虚拟机安装Linux教程(超详细)_七维大脑的博客-CSDN博客_vmware安装linux虚拟机
>
> [VMware虚拟机安装Linux教程(超详细)_七维大脑的博客-CSDN博客_vmware安装linux虚拟机](
> https://blog.csdn.net/weixin_52799373/article/details/124324077?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166520981016782414969034%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=166520981016782414969034&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~times_rank-5-124324077-null-null.142^v51^control,201^v3^control_2&utm_term=%E8%99%9A%E6%8B%9F%E6%9C%BAVMware%E4%B8%8B%E8%BD%BD%E5%92%8CLinux%E5%AE%89%E8%A3%85&spm=1018.2226.3001.4187)
>
> (安装好了之后，可能会有网络问题，可以看看网络配置)

# Linux文件目录
:::success
**Linux系统中一切皆文件**
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/01linux.png)
:::

| **目录** | **含义** |
| --- | --- |
| /bin | Binary的缩写，用来存二进制可执行文件，并且比较特殊的是/bin存放的是所有一般用户都能使用的可执行文件，如：cat、chmod、mv、mkdir、cd等常用指令 |
| /sbin | Super User的意思，存放一些只有root用户才有权限执行的可执行文件，如init,ip,mount等命令 |
| /boot | 主要存放开机时用到的引导文件，如linux内核文件和开机菜单与开机所有需要的配置文件 |
| /lib | library,存放着系统开机时所需的函数库以及/bin和/sbin目录下的命令会调用的函数库 |
| /lib64 | 存放相对于/lib中支持64位格式的函数库 |
| /etc | 配置文件、启动脚本等（etc)包含所有程序所需的配置文件以及系统的配置文件，如用户的账号密码文件，各个服务的起始文件等。也包含了用于启动/停止单个程序的启动和关闭shell脚本。一般来说，该目录下的文件属性是可以让用户查阅，但只有root管理员有权利修改 |
| /root | 系统管理员root的主目录 |
| /dev | device,任何设备都以文件的形式存放再这个目录中。例如硬盘、键盘、鼠标、光驱等各种设备文件。只要通过访问该目录的某个文件就相当于访问了对应的设备 |
| /home | 系统默认的用户的家目录，每当新建一个用户系统都会在这个目录下创建以该用户名为名称的目录作为该用户的家目录。 |
| /media | 存放可移除的媒体设备、如光盘，DVD等 |
| /mnt | mount，临时挂载的设备文件，临时安装目录，系统管理员可以挂载文件系统。时系统管理员临时安装文件的系统安装点。 |
| /opt | optional，可选的软件包，即第三方文件软件。我们可以将除了系统自带软件之外的其他软件安装到这个目录。 |
| /run | 最近一次开机后所产生的各项信息，如当前的用户和正在运行中的守护进程等。 |
| /srv | service,存放一些服务启动后所需的数据 |
| /proc | 特殊的动态目录，用以 维护系统的信息和状态，包括当前运行中进程（processes)信息。包含系统进程的相关信息，是一个虚拟的文件系统，包含有关正在运行的进程的信息，系统资源以文本信息形式存在。 |
| /sys | system,与/proc类似也是虚拟文件系统，存放系统核心与硬件相关信息管理设备文件。不占用硬件容量。 |
| /tmp | temporary, 存放系统运行过程中使用的一些临时文件，可以被所有就用户访问，系统重启时会清空该目录。 |
| /usr | 包含绝大部分所有用户（users)都能访问的应用程序和文件包含二进制文件，库文件。文档和二级程序的源代码。 |
| /var | 经常变化的（variable)文件，诸如日志或数据库等代表变量文件。在这个目录下可以找到内容可能增长的文件 |

# VI和VIM 编辑器
> VI是Unix操作系统和类Unix操作系统中最通用的文本编辑器。
> VIM编辑器是从V1从发展出来的一个_**性能更强大的文本编辑器**_。可以主动的以文字颜色辨别语法的正确性，方便程序设计。VIM与VI编辑器完全兼容。（比如vim会有颜色区分）
> 虚拟机中打开终端
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/02linux.png)
> **准备个测试数据**
> 1.拷贝/etc/profile 数据到/root 目录下
> [root@rabbitMQ100]# cp /etc/profile /root  		（复制/etc/profile文件到/root下，注意空格）
> [root@rabbitMQ100]# cd /root/			(跳转到root文件夹)
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/03linux.png)
> 可以进入练习操作
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/04linux.png)

## 一般模式Vi
> 以 vi 打开一个档案就直接进入一般模式了（这是默认的模式）。在这个模式中， 你可 
> 以使用『上下左右』按键来移动光标，你可以使用『删除字符』或『删除整行』来处理档 
> 案内容， 也可以使用『复制、粘贴』来处理你的文件数据。（用的不多）

| **语法** | **功能描述** |
| --- | --- |
| yy | 复制光标当前一行 |
| y数字y | 复制一段（从第几行到第几行） |
| y (shift + 4) | 复制当前光标到结尾的字符串 |
| p | 箭头移动到目的行粘贴 |
| u | 撤销上一步 |
| dd | 删除光标当前行 |
| d数字d | 删除光标（含）后多少行 |
| x | 剪切一个字母，相当于del |
| X | 剪切一个字母，相当于Backspace |
| w | 切换到下一个词 |
| e | 快速到下一个词尾 |
| d | 跳转到上一个词 |
| yw | 复制一个词 |
| dw | 删除一个词 |
| shift+6 | 移动到行头 |
| shift+4 | 移动到行尾 |
| gg | 移动到页头 |
| G /L | 移动到页尾 |
| 数字+shift+g | 移动到目标行 |

## 编辑模式Vim
> 在一般模式中可以进行删除、复制、粘贴等的动作，但是却无法编辑文件内容的！要 
> 等到你按下『i, I, o, O, a, A』等任何一个字母之后才会进入编辑模式。 
> 注意了！通常在Linux中，按下这些按键时，在画面的左下方会出现『INSERT或 REPLACE』的字样，此时才可以进行编辑。而如果要回到一般模式时， 则必须要按下 『Esc』这个按键即可退出编辑模式。
> **退出编辑模式 **按『Esc』键 退出编辑模式，之后所在的模式为一般模式。

| **按钮** | **功能** |
| --- | --- |
| i | 当前光标前 |
| a | 当前光标后 |
| o | 当前光标行的下一行 |
| I | 光标所在行最前 |
| A | 光标所在行租后 |
| O | 当前光标行的上一行 |

## 指令模式
> 在一般模式当中，输入『 : / ?』3个中的任何一个按钮，就可以将光标移动到最底下那 一行。
> 在这个模式当中， 可以提供你『搜寻资料』的动作，而读取、存盘、大量取代字符、 
> 离开 vi 、显示行号等动作是在此模式中达成的！

| **命令** | **功能** |
| --- | --- |
| :w | 保存 |
| :q | 退出 |
| :wq | 保存并退出 |
| :q! | 不保存强制退出 |
| /要查找的词 | n查找下一个，N往上查找 |
| :noh | 取消高亮显示 |
| :set nu | 显示行号 |
| :set nonu | 关闭显示行号 |
| :s /old/new | 替换当前行匹配到第一个old为new |
| :s /lod/new/g | 替换当前行匹配到所有old为new |
| :%s/old/new | 替换文档中每一行匹配到的第一个old为new |
| :%s/old/new/g | 替换文档中的所有的old为new 比较常用 |

## 模式间转换
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/05linux.png)![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/06linux.png)

# 网络配置（重点）
> ### VMware提供的三种链接方式
> #### 桥接模式
> 虚拟机直接连接外部物理网络的模式，主机起到了网桥的作用。这种模式下，虚拟机可
以直接访问外部网络，并且对外部网络是可见的。
> #### NAT模式
> 虚拟机和主机构建一个专用网络，并通过虚拟网格地址转换(NAT)设备对IP进行转
换。虚拟机通过共享主机IP可以访问外部网络，但外部网络无法访问虚拟机。
> #### 仅主机模式
> 虚拟机只与主机共享一个专用网络，与外部网络无法通信。

## 查看网络 IP 和 网关
> ### 查看虚拟网络编辑器
> ##### （下面应该都是配好了的，如果没有或没网的看下面的静态ip配置）
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/07linux.png)
> **修改虚拟网卡 Ip**
> **VMnet1是桥接模式**
> **VMnet8是NAT模式，路由模式**
> **VMnet0是主机模式（这里没哟）**
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/08linux.png)
> **查看网关**
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/09linux.png)
> **查看 windows 环境的中 VMnet8 网络配置**
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/10linux.png)
> **以上应该是当时我们选择NAT网络连接模式时就给我们自动配好的。**
> 这是我们可以去测试一下是否联网。
> ping www.baidu.com    
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/11linux.png)
> ping通了说明有网，Ctrl+C 结束。

## 静态IP配置
:::info
虚拟机使用HDCP设置，也就是上面虚拟网络编辑器里面的，这个会将IP自动分配给虚拟机，导致IP不固定（随机），而我们之后会去远程连接这个虚拟机，通过IP地址，so我们要固定这个IP，所谓静态IP配置。
设置静态ip（NAT模式）
需要修改文件/etc/sysconfig/network-scripts/ifcfg-ens33里的参数
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/12linux.png)
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/13linux.png)
a进入修改模式，标红的是需要修改的地方
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/14linux.png)
注意：IPADDR的值，192.168.1都是取自虚拟机中虚拟网络编辑器中子网地址的值（我这里借的图，没对应注意一下），最后的100是我自己取的，这个值可以取3~254之间的任意一个数值，建议大家也按照我这个取值为100，这样方便统一，后期和我在课堂中使用的都是一样的。
GATEWAY的值是取自虚拟网络编辑器中NAT设置里面的网关的值。
DNS1的值可填可不填，值与网管一直即可
编辑完后，按键盘 esc ，然后输入 :wq 回车即可。
**执行 service network restart 重启网络**
**ifconfig可看到编辑好了的静态ip（如果出现ifconfig不能用，建议重新安装Linux）**
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/15linux.png)
如果出现这种问题，执行这两条命令
systemctl stop NetworkManager
systemctl disable NetworkManager
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/16linux.png)

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/17linux.png)
**修改 IP 地址后可能会遇到的问题**
（1）物理机能 ping 通虚拟机，但是虚拟机 ping 不通物理机,一般都是因为物理机的 防火墙问题,把防火墙关闭就行 
（2）虚拟机能 Ping 通物理机,但是虚拟机 Ping 不通外网,一般都是因为 DNS 的设置有 问题
（3）虚拟机 Ping www.baidu.com 显示域名未知等信息,一般查看 GATEWAY 和 DNS 设 置是否正确 
（4）如果以上全部设置完还是不行，需要关闭 NetworkManager 服务 
 systemctl stop NetworkManager 关闭 
 systemctl disable NetworkManager 禁用 
（5)如果检查发现 systemctl status network 有问题 需要检查 ifcfg-ens33 

### 修改主机名
** 案例实操 **
（1）查看当前服务器主机名称 
hostname （功能描述：查看当前服务器的主机名称） 也就是我们之前创建时设置的主机名
[root@hadoop100 桌面]# hostname 
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/18linux.png)
（2）如果感觉此主机名不合适，我们可以进行修改。通过编辑/etc/hostname 文件 
[root@hadoop100 桌面]# vi /etc/hostname 
修改完成后重启生效。 
**5.3.2 修改 hosts 映射文件 （和以前设置localhost一样）**
**1）**修改 linux 的主机映射文件（hosts 文件） 
后续在 hadoop 阶段，虚拟机会比较多，配置时通常会采用主机名的方式配置， 比较简单方便。 不用刻意记 ip 地址。 
（1）打开/etc/hosts 
[root@hadoop100 桌面]# vim /etc/hosts 
添加如下内容 （这里是自己的ip）
192.168.48.100 hadoop100 
192.168.48.101 hadoop101 
192.168.48.102 hadoop102 
192.168.48.103 hadoop103 
（2）重启设备，重启后，查看主机名，已经修改成功 
**2）**修改 windows 的主机映射文件（hosts 文件） 自己的电脑，不是虚拟机
（1）进入 C:\Windows\System32\drivers\etc 路径 
（2)打开 hosts 文件并添加如下内容 
192.168.48.100 hadoop100 
192.168.48.101 hadoop101 
192.168.48.102 hadoop102 
192.168.48.103 hadoop103 
:::

# 远程连接
> 这里稍微提一下，后面会有具体教学。使用xshell连一下虚拟机
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/19linux.png)
> 然后就会让你输入用户和密码登录，然后就行了。
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/20linux.png)
> xftp也是一样的，在这里可以完成文件的互传
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/21linux.png)

# 系统管理
:::warning
 Linux中的进程和服务
计算机中，一个正在执行的程序或命令，被叫做“进程”(process)。
启动之后一只存在、常驻内存的进程，一般被称作“服务”(service)。
**systemctl （CentOS 7 版本-重点掌握） **
**1） 基本语法 **
systemctl start | stop | restart | status 
服务名 
**2） 经验技巧 **
查看服务的方法：/usr/lib/systemd/system 
[root@hadoop100 system]# pwd 		#查看路径
/usr/lib/systemd/system 
[root@hadoop100 init.d]# ls -al 
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/22linux.png)
**3）案例实操 **
（1）查看防火墙服务的状态 
[root@hadoop100 桌面]# systemctl status firewalld 
（2）停止防火墙服务 
[root@hadoop100 桌面]# systemctl stop firewalld 
（3）启动防火墙服务 
[root@hadoop100 桌面]# systemctl start firewalld 
（4）重启防火墙服务 
[root@hadoop100 桌面]# systemctl restart firewalld 
**6.5 systemctl 设置后台服务的自启配置 **
**1）基本语法 **
systemctl list-unit-files （功能描述：查看服务开机启动状态） 
systemctl disable service_name （功能描述：关掉指定服务的自动启动） 
systemctl enable service_name （功能描述：开启指定服务的自动启动） 
**2）案例实操 **
（1）开启/关闭 iptables(防火墙)服务的自动启动 
[root@hadoop100 桌面]# systemctl enable firewalld.service 
[root@hadoop100 桌面]# systemctl disable firewalld.service
**（CentOS 6)service 服务管理的大家可自行搜索。**
:::

## 系统运行级别
:::warning
**Linux 运行级别[CentOS 6]**
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/23linux.png)
**CentOS7 的运行级别简化为: **
multi-user.target 等价于原运行级别 3（多用户有网，无图形界面） 
graphical.target 等价于原运行级别 5（多用户有网，有图形界面）
**查看当前运行级别: **
systemctl get-default
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/24linux.png)
这里的graphica.target在inittab文件（以前centos6级别配置文件）里有说明，相当于级别5
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/25linux.png)
:::

## 防火墙**关闭和开启**
> **1） 临时关闭防火墙 **
> （1）查看防火墙状态 
> [root@hadoop100 桌面]# systemctl status firewalld 
> （2）临时关闭防火墙 
> [root@hadoop100 桌面]# systemctl stop firewalld 
> **2）开机启动时关闭防火墙 **
> （1）查看防火墙开机启动状态 
> [root@hadoop100 桌面]# systemctl enable firewalld.service 
> （2）设置开机时关闭防火墙 
> [root@hadoop100 桌面]# systemctl disable firewalld.service 

## **关机重启命令**
:::danger
在 linux 领域内大多用在服务器上，很少遇到关机的操作。毕竟服务器上跑一个服务是 永无止境的，除非特殊情况下，不得已才会关机。 
**1）基本语法 **
（1）sync （功能描述：将数据由内存同步到硬盘中） 
（2）halt （功能描述：停机，关闭系统，但不断电） 
（3）poweroff （功能描述：关机，断电） 
（3）reboot （功能描述：就是重启，等同于 shutdown -r now） 
（4）shutdown [选项] 时间 
shutdown -H 相当于--halt，停机 
shutdown -r		-r=reboot 重启
**2） 经验技巧 **
Linux 系统中为了提高磁盘的读写效率，对磁盘采取了 “预读迟写”操作方式。当用户 保存文件时，Linux 核心并不一定立即将保存数据写入物理磁盘中，而是将数据保存在缓 冲区中，等缓冲区满时再写入磁盘，这种方式可以极大的提高磁盘写入数据的效率。但是， 也带来了安全隐患，如果数据还未写磁盘时，系统掉电或者其他严重问题出现，则将导 致数据丢失。使用 sync 指令可以立即将缓冲区的数据写入磁盘。 
**3）案例实操 **
（1）将数据由内存同步到硬盘中 
[root@hadoop100 桌面]#sync 
（2）重启 
[root@hadoop100 桌面]# reboot 
（3）停机（不断电） 
[root@hadoop100 桌面]#halt 
（4）计算机将在 1 分钟后关机，并且会显示在登录用户的当前屏幕中 
[root@hadoop100 桌面]#shutdown -h 1        #‘This server will shutdown after 1 mins’ 
（5）立马关机（等同于 poweroff） 
[root@hadoop100 桌面]# shutdown -h now 
（6）系统立马重启（等同于 reboot） 
[root@hadoop100 桌面]# shutdown -r now
:::
# **man和help**
> **man 获得帮助信息**
> **基本语法 **
> man [命令或配置文件] （功能描述：获得帮助信息） 
> **案例实操 **
> 查看 ls 命令的帮助信息 
> [root@hadoop101 ~]# man ls
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/26linux.png)
> 查看cd 命令的帮助信息 
> [root@hadoop101 ~]# man cd
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/27linux.png)
> **help 获得 shell 内置命令的帮助信息**
> 一部分基础功能的系统命令是直接内嵌在 shell 中的，系统加载启动之后会随着 shell 一起加载，常驻系统内存中。这部分命令被称为“内置（built-in）命令”；相应的其它命令 被称为“外部命令”。 
> **基本语法 **
> help 命令（功能描述：获得 shell 内置命令的帮助信息） 
> **案例实操** 
> （1）查看 cd 命令的帮助信息 
> [root@hadoop101 ~]# help cd
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/28linux.png)
> 常用快捷键 
> ctrl + c 		停止进程
> ctrl+l 		清屏，等同于 clear；彻底清屏是：reset 
> 善于用 tab 键 		提示(更重要的是可以防止敲错) 
> 上下键 		查找执行过的命令 

# 文件目录类
（注意空格）
### **pwd	 显示当前工作目录的绝对路径 **
:::info
pwd:print working directory 打印工作目录 
**基本语法 **
pwd （功能描述：显示当前工作目录的绝对路径） 
**案例实操 **
（1）显示当前工作目录的绝对路径 
[root@hadoop101 ~]# pwd 
/root
:::
### ls 	列出目录的内容
:::info
ls:list 列出目录内容 
**基本语法 **
ls [选项] [目录或是文件] 
**选项说明 **
-a	 全部的文件，连同隐藏档( 开头为 . 的文件) 一起列出来(常用) 
-l 	长数据串列出，包含文件的属性与权限等等数据；(常用)等价于“ll” 
**显示说明 **
每行列出的信息依次是： 文件类型与权限、链接数、文件属主、文件属组、文件大小用byte 
来表示 建立或最近修改的时间 名字 
**案例实操 **
查看当前目录的所有内容信息 
[atguigu@hadoop101 ~]$ ls -l 
[atguigu@hadoop101 ~]$ ls -a 
[atguigu@hadoop101 ~]$ ls -la
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/29linux.png)![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/30linux.png)
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/31linux.png)
:::

### cd	 切换目录
:::info
cd:Change Directory 切换路径 
**基本语法 **
cd [参数]
**参数说明**
cd 绝对路径		 切换路径 
cd 相对路径		 切换路径 
cd ~或者 cd 		回到自己的家目录 
cd - 			回到上一次所在目录 
cd ..			 回到当前目录的上一级目录 
cd -P			 跳转到实际物理路径，而非快捷方式路径 
**案例实操**
（1）使用绝对路径切换到 root 目录 
[root@hadoop101 ~]# cd /root/ 
（2）使用相对路径切换到“公共的”目录 
[root@hadoop101 ~]# cd 公共的/ 
（3）表示回到自己的家目录，亦即是 /root 这个目录 
[root@hadoop101 公共的]# cd ~ 
（4）cd- 回到上一次所在目录 
[root@hadoop101 ~]# cd - 
（5）表示回到当前目录的上一级目录，亦即是 “
/root/公共的”的上一级目录的意思； 
[root@hadoop101 公共的]# cd ..
:::

### mkdir 	创建一个新的目录
> mkdir:Make directory 建立目录 
> **基本语法 **
> mkdir [选项] 要创建的目录 
> **选项说明 **
> -p 		创建多层目录 
> **案例实操 **
> （1）创建一个目录 
> [root@hadoop101 ~]# mkdir xiyou 
> [root@hadoop101 ~]# mkdir xiyou/mingjie 
> （2）创建一个多级目录 
> [root@hadoop101 ~]# mkdir -p xiyou/dssz/meihouwang 

### rmdir	 删除一个空的目录 
> rmdir:Remove directory 移除目录 
> **基本语法 **
> rmdir 要删除的空目录 
> **案例实操 **
> （1）删除一个空的文件夹
> [root@hadoop101 ~]# rmdir xiyou/dssz/meihouwang 

### touch	 创建空文件
> **基本语法 **
> touch 文件名称 
> **案例实操 **
> [root@hadoop101 ~]# touch xiyou/dssz/sunwukong.txt 

### cp	 复制文件或目录
> **基本语法 **
> cp [选项] source dest （功能描述：复制source文件到dest） 
> **选项说明 **
> -r 		递归复制整个文件夹
> **参数说明**
> source 		源文件 
> dest 		目标文件 
> **经验技巧 **
> 强制覆盖不提示的方法：\cp 
> **案例实操 **
> （1）复制文件 
> [root@hadoop101 ~]# cp xiyou/dssz/suwukong.txt xiyou/mingjie/ 
> （2）递归复制整个文件夹 
> [root@hadoop101 ~]# cp -r xiyou/dssz/ ./

### rm 	  删除文件或目录
> **基本语法 **
> rm [选项] deleteFile 		（功能描述：递归删除目录中所有内容） 
> **选项说明 **
> -r 		递归删除目录中所有内容 
> -f 		强制执行删除操作，而不提示用于进行确认。 
> -v 		显示指令的详细执行过程 
> **案例实操 **
> （1）删除目录中的内容 
> [root@hadoop101 ~]# rm xiyou/mingjie/sunwukong.txt
> （2）递归删除目录中所有内容 
> [root@hadoop101 ~]# rm -rf dssz/

### mv 	    移动文件与目录或重命名 
> **基本语法 **
> （1）mv oldNameFile newNameFile （功能描述：重命名） 
> （2）mv /temp/movefile.txt /targetFolder （功能描述：移动文件,如果到了文件名则会重命名） 
> **案例实操 **
> （1）重命名 
> [root@hadoop101 ~]# mv xiyou/dssz/suwukong.txt xiyou/dssz/houge.txt 
> （2）移动文件 ()
> [root@hadoop101 ~]# mv xiyou/dssz/houge.txt /xiyou/

### cat 	  查看文件内容 
:::success
catch查看文件内容，从第一行开始显示。 
**基本语法 **
cat [选项] 要查看的文件 
**选项说明 **
-n 		显示所有行的行号，包括空行。
**经验技巧 **
一般查看比较小的文件，一屏幕能显示全的。
**案例实操 **
（1）查看文件内容并显示行号 
[atguigu@hadoop101 ~]$ cat -n houge.txt
:::
### more 	文件内容分屏查看器 
:::success
more 指令是一个基于 VI 编辑器的文本过滤器，它以全屏幕的方式按页显示文本文件 
的内容。more 指令中内置了若干快捷键，详见操作说明。 
**基本语法 **
more 要查看的文件 
**操作说明 **
空白键 (space) 		代表向下翻一页； 
Enter 				代表向下翻『一行』； 
q 					代表立刻离开 more ，不再显示该文件内容。 
Ctrl+F /F			向下滚动一屏
Ctrl+B/B 			返回上一屏 
= 					输出当前行的行号 
:f 					输出文件名和当前行的行号 
**案例实操 **
（1）采用more查看文件 
[root@hadoop101 ~]# more smartd.conf
:::
### less 	分屏显示文件内容
:::success
less 指令用来分屏查看文件内容，它的功能与 more 指令类似，但是比 more 指令更加 强大，支持各种显示终端。less 指令在显示文件内容时，并不是一次将整个文件加载之后 才显示，而是根据显示需要加载内容，对于显示大型文件具有较高的效率。 
**基本语法 **
less 要查看的文件 
**操作说明 **
空白键 					向下翻动一页； 
[pagedown] 			向下翻动一页 
[pageup] 				向上翻动一页； 
/字串 					向下搜寻『字串』的功能；n：向下查找；N：向上查找； 
?字串 					向上搜寻『字串』的功能；n：向上查找；N：向下查找； 
q 						离开 less 这个程序；
**经验技巧 **
用SecureCRT时[pagedown]和[pageup]可能会出现无法识别的问题。 
**案例实操 **
（1）采用less查看文件 
[root@hadoop101 ~]# less smartd.conf
:::
### echo  	输出内容到控制台
:::success
echo 输出内容到控制台 
**基本语法 **
echo [选项] [输出内容] 
选项： 
-e： 支持反斜线控制的字符转换 
\\ 		输出\本身 
\n 		换行符
\t 		制表符，也就是 Tab 键
**案例实操 **
[atguigu@hadoop101 ~]$ echo “hello\tworld” 
hello\tworld 	(没-e)
[atguigu@hadoop101 ~]$ echo -e “hello\tworld” 
hello world
:::
### head	 显示文件头部内容 
:::warning
head 用于显示文件的开头部分内容，默认情况下 head 指令显示文件的前 10 行内容。 
**基本语法 **
head 文件 （功能描述：查看文件头10行内容） 
head -n 5 文件 （功能描述：查看文件头5行内容，5可以是任意行数）
**选项说明**
-n<行数> 指定显示头部内容的行数 
**案例实操 **
（1）查看文件的头2行 
[root@hadoop101 ~]# head -n 2 smartd.conf
:::
**tail 		输出文件尾部内容 **
:::warning
tail 用于输出文件中尾部的内容，默认情况下 tail 指令显示文件的后 10 行内容。 
**基本语法 **
（1）tail 文件 （功能描述：查看文件尾部10行内容） 
（2）tail -n 5 文件 （功能描述：查看文件尾部5行内容，5可以是任意行数） 
（3）tail -f 文件 （功能描述：实时追踪该文档的所有更新） 
** 选项说明 **
-n<行数> 	输出文件尾部 n 行内容 
-f 	显示文件最新追加的内容，监视文件变化 
**案例实操 **
（1）查看文件尾 1 行内容 
[root@hadoop101 ~]# tail -n 1 smartd.conf 
（2）实时追踪该档的所有更新 
[root@hadoop101 ~]# tail -f houge.txt
:::
### > 	输出重定向和 >>    追加
:::warning
**基本语法 **
（1）ls -l > 文件 		（功能描述：列表的内容写入文件 a.txt 中（**覆盖写**））
（2）ls -al >> 文件 		（功能描述：列表的内容**追加**到文件 aa.txt 的末尾） 
（3）cat 文件 1 > 文件 2 		（功能描述：将文件 1 的内容覆盖到文件 2） 
（4）echo “内容” >> 文件
**案例实操 **
（1）将 ls 查看信息写入到文件中 
[root@hadoop101 ~]# ls -l>houge.txt 
（2）将 ls 查看信息追加到文件中 
[root@hadoop101 ~]# ls -l>>houge.txt 
（3）采用 echo 将 hello 单词追加到文件中 
[root@hadoop101 ~]# echo hello>>houge.txt
:::
### ln 	软链接
:::warning
软链接也称为符号链接，类似于 windows 里的快捷方式，有自己的数据块，主要存放 
了链接其他文件的路径。 
**基本语法 **
ln -s [原文件或目录] [软链接名] （功能描述：给原文件创建一个软链接） 
**经验技巧 **
删除软链接： rm -rf 软链接名，而不是 rm -rf 软链接名/ 
如果使用 rm -rf 软链接名/ 删除，会把软链接对应的真实目录下内容删掉 
查询：通过 ll 就可以查看，列表属性第 1 位是 l，尾部会有位置指向。 
**案例实操** 
（1）创建软连接 
[root@hadoop101 ~]# mv houge.txt xiyou/dssz/ 
[root@hadoop101 ~]# ln -s xiyou/dssz/houge.txt ./houzi 
[root@hadoop101 ~]# ll 
lrwxrwxrwx. 1 root 	root 	20 6 月 17 12:56 houzi -> xiyou/dssz/houge.txt 
（2）删除软连接(注意不要写最后的/) 
[root@hadoop101 ~]# rm -rf houzi 
（3）进入软连接实际物理路径 
[root@hadoop101 ~]# ln -s xiyou/dssz/ ./dssz 
[root@hadoop101 ~]# cd -P dssz/
:::
### history 		查看已经执行过历史命令
:::warning
**基本语法 **
history （功能描述：查看已经执行过历史命令）
history -c  	(清除已经执行过历史命令)
**案例实操** 
（1）查看已经执行过的历史命令 
[root@hadoop101 test1]# history
:::
# 时间日期类
### date 	**显示当前时间**
:::danger
**基本语法 **
（1）date 		（功能描述：显示当前时间） 
（2）date +%Y 		（功能描述：显示当前年份） 
（3）date +%m 		（功能描述：显示当前月份） 
（4）date +%d 		（功能描述：显示当前是哪一天） 
（5）date "+%Y-%m-%d %H:%M:%S" （	功能描述：显示年月日时分秒） 
**案例实操** 
（1）显示当前时间信息 
[root@hadoop101 ~]# date 
2022 年 06 月 19 日 星期一 20:53:30 CST 
（2）显示当前时间年月日 
[root@hadoop101 ~]# date +%Y%m%d 
20220619 
（3）显示当前时间年月日时分秒 
[root@hadoop101 ~]# date "+%Y-%m-%d %H:%M:%S" 
2017-06-19 20:54:58 
:::
### date 	显示非当前时间
:::danger
**基本语法 **
（1）date -d '1 days ago' （功能描述：显示前一天时间） 
（2）date -d '-1 days ago' （功能描述：显示明天时间） 
**案例实操 **
（1）显示前一天
[root@hadoop101 ~]# date -d '1 days ago' 
2022年 06 月 18 日 星期日 21:07:22 CST 
（2）显示明天时间 
[root@hadoop101 ~]#date -d '-1 days ago' 
2022 年 06 月 20 日 星期日 21:07:22 CST 
:::
### date 	设置系统时间	
:::danger
**基本语法 **
date -s 字符串时间 
**案例实操 **
（1）设置系统当前时间 
[root@hadoop101 ~]# date -s "2017-06-19 20:52:18" 
:::
### cal 		查看日历
:::danger
**基本语法 **
cal [选项] 	（功能描述：不加选项，显示本月日历） 
**选项说明 **
具体某一年 	显示这一年的日历 
-数字	显示当前月份附近的月份日历
**案例实操 **
（1）查看当前月的日历 
[root@hadoop101 ~]# cal 
（2）查看 2022 年的日历 
[root@hadoop101 ~]# cal 202
:::
# 用户管理命令
### useradd 添加新用户 
> **基本语法 **
> useradd 用户名 （功能描述：添加新用户） 
> useradd -g 组名 用户名 （功能描述：添加新用户到某个组） 
> **案例实操 **
> （1）添加一个用户 
> [root@hadoop101 ~]# useradd tangseng 
> [root@hadoop101 ~]#ll /home/

###  passwd 设置用户密码 
> **基本语法 **
> passwd 用户名 （功能描述：设置用户密码）
> **案例实操 **
> （1）设置用户的密码 
> [root@hadoop101 ~]# passwd tangseng 

### id 查看用户是否存在
> **基本语法 **
> id 用户名 
> **案例实操** 
> （1）查看用户是否存在 
> [root@hadoop101 ~]#id tangseng

### cat /etc/passwd 查看创建了哪些用户 
> **案例实操 **
> [root@hadoop101 ~]# cat /etc/passwd

### su 切换用户
> su: swith user 切换用户 
> **基本语法 **
> su 用户名称 （功能描述：切换用户，只能获得用户的执行权限，不能获得环境变量） 
> su - 用户名称 （功能描述：切换到用户并获得该用户的环境变量及执行权限） 
> **案例实操** 
> （1）切换用户 
> [root@hadoop101 ~]#su tangseng 
> [root@hadoop101 ~]#echo $PATH 
> /usr/lib64/qt-3.3/bin:/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin
> [root@hadoop101 ~]#exit 
> [root@hadoop101 ~]#su - tangseng 
> [root@hadoop101 ~]#echo $PATH 		(看查环境变量)
> /usr/lib64/qt3.3/bin:/usr/local/bin:/bin:/usr/bin:/usr/local/sbin:/usr/sbin:/sbin:/home/tangseng/bin

### userdel 	删除用户
> **基本语法 **
> （1）userdel 用户名 （功能描述：删除用户但保存用户主目录） 
> （2）userdel -r 用户名 （功能描述：用户和用户主目录，都删除） 
> **选项说明 **
> -r 		删除用户的同时，删除与用户相关的所有文件。
> **案例实操**
> （1）删除用户但保存用户主目录 
> [root@hadoop101 ~]#userdel tangseng 
> [root@hadoop101 ~]#ll /home/ 
> （2）删除用户和用户主目录，都删除 
> [root@hadoop101 ~]#useradd zhubajie 
> [root@hadoop101 ~]#ll /home/ 
> [root@hadoop101 ~]#userdel -r zhubajie 
> [root@hadoop101 ~]#ll /home/

### who 查看登录用户信息
> **基本语法 **
> （1）whoami 	（功能描述：显示自身用户名称） 
> （2）who am i 	（功能描述：显示登录用户的用户名以及登陆时间） 
> **案例实操 **
> （1）显示自身用户名称 
> [root@hadoop101 opt]# whoami 
> （2）显示登录用户的用户名 
> [root@hadoop101 opt]# who am i

### sudo 设置普通用户具有 root 权限
> **添加 atguigu 用户，并对其设置密码。 **
> [root@hadoop101 ~]#useradd atguigu 
> [root@hadoop101 ~]#passwd atguigu 
> **修改配置文件 **
> [root@hadoop101 ~]#vi /etc/sudoers 
> 修改 /etc/sudoers 文件，找到下面一行(91 行)，在 root 下面添加一行，如下所示： 
> ## Allow root to run any commands anywhere 
> root 	ALL=(ALL) 	ALL 
> atguigu 	ALL=(ALL) 	ALL 
> 或者配置成采用 sudo 命令时，不需要输入密码 
> ## Allow root to run any commands anywhere 
> root 	ALL=(ALL) 	ALL 
> atguigu 	ALL=(ALL) 	NOPASSWD:ALL 
> 修改完毕，现在可以用 atguigu 帐号登录，然后用命令 sudo ，即可获得 root 权限进行 操作。
> **案例实操 **
> （1）用普通用户在/opt 目录下创建一个文件夹 
> [atguigu@hadoop101 opt]$ sudo mkdir module 
> [root@hadoop101 opt]# chown atguigu:atguigu module/

### usermod 修改用户
> **基本语法 **
> usermod -g 用户组 用户名
> **选项说明 **
> -g 		修改用户的初始登录组，给定的组必须存在。默认组 id 是 1。 
> **案例实操 **
> （1）将用户加入到用户组 
> [root@hadoop101 opt]# usermod -g root zhubajie

# 用户组管理命令
:::tips
每个用户都有一个用户组（文件夹），系统可以对一个用户组中的所有用户进行集中管理。不同 Linux 系统对用户组的规定有所不同， 如Linux下的用户属于与它同名的用户组，这个用户组在创建用户时同时创建。 用户组的管理涉及用户组的添加、删除和修改。组的增加、删除和修改实际上就是对 /etc/group文件的更新。
:::
### groupadd 新增组
:::tips
**基本语法 **
groupadd 组名 
**案例实操 **
（1）添加一个xitianqujing组 
[root@hadoop101 opt]#groupadd xitianqujing
:::
### groupdel 删除组
:::tips
**基本语法 **
groupdel 组名 
**案例实操** 
（1）删除xitianqujing组 
[root@hadoop101 opt]# groupdel xitianqujing
:::
### groupmod 修改组
:::tips
**基本语法 **
groupmod -n 新组名 老组名 
**选项说明 **
-n<新组名> 		指定工作组的新组名 
**案例实操 **
（1）修改atguigu组名称为atguigu1 
[root@hadoop101 ~]#groupadd xitianqujing
[root@hadoop101 ~]# groupmod -n xitian xitianqujing
:::
### cat /etc/group 查看创建了哪些组
:::tips
**基本操作 **
[root@hadoop101 atguigu]# cat /etc/group
:::
# 文件权限类
### 文件属性
:::info
Linux系统是一种典型的多用户系统，不同的用户处于不同的地位，拥有不同的权限。 
为了保护系统的安全性，Linux系统对不同的用户访问同一文件（包括目录文件）的权限做 了不同的规定。在Linux中我们可以使用ll或者ls -l命令来显示一个文件的属性以及文件所属 的用户和组。
**从左到右的 10 个字符表示**
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/32linux.png)
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/33linux.png)
如果没有权限，就会出现减号[ - ]而已。从左至右用0-9这些数字来表示:
（1)0 首位表示类型 
在Linux中第一个字符代表这个文件是目录、文件或链接文件等等 

- 代表文件 
d 代表目录 
l 链接文档(link file)； 
（2）第1-3位确定属主（该文件的所有者）拥有该文件的权限。---User 
（3）第4-6位确定属组（所有者的同组用户）拥有该文件的权限，---Group 
（4）第7-9位确定其他用户拥有该文件的权限 ---Other 
### rwx 作用文件和目录的不同解释
（1）作用到目录： 
[ r ]代表可读(read): 可以读取，ls查看目录内容 
[ w ]代表可写(write): 可以修改，目录内创建+删除+重命名目录 
[ x ]代表可执行(execute):可以进入该目录
（2）作用到文件： 
[ r ]代表可读(read): 可以读取，查看 
[ w ]代表可写(write): 可以修改，但是不代表可以删除该文件，删除一个文件的前 提条件是对该文件所在的目录有写权限，才能删除该文件
[ x ]代表可执行(execute):可以被系统执行
**案例实操**
[root@hadoop101 ~]# ll 
总用量 104 
-rw-------. 	1 root root 1248 1 月 8 17:36 anaconda-ks.cfg 
drwxr-xr-x. 	2 root root 4096 1 月 12 14:02 dssz 
lrwxrwxrwx. 1 root root 20 1 月 12 14:32 houzi -> xiyou/dssz/houge.tx
文件基本属性介绍
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/34linux.png)
（1）如果查看到是文件：链接数指的是硬链接个数。 
（2)如果查看的是文件夹：链接数指的是子文件夹个数。
:::

### chmod 改变权限
:::info
**基本语法**
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/35linux.png)
第一种方式变更权限 
chmod [{ugoa}{+-=}{rwx}] 文件或目录
u:所有者 g:所有组 o:其他人 a:所有人(u、g、o 的总和)
第二种方式变更权限 
chmod [mode=421 ] [文件或目录]
x=1		w=2	xw=3	r=4		xr=5	wr=6	rwx=7
(用了二进制的表达方式	x=1=001	w=2=010	xr=5=101	rwx=7=111)
**案例实操**
（1）修改文件使其所属主用户具有执行权限 
[root@hadoop101 ~]# cp xiyou/dssz/houge.txt ./ 
[root@hadoop101 ~]# chmod u+x houge.txt 
（2）修改文件使其所属组用户具有执行权限 
[root@hadoop101 ~]# chmod g+x houge.txt 
（3）修改文件所属主用户执行权限,并使其他用户具有执行权限 
[root@hadoop101 ~]# chmod u-x,o+x houge.txt 
（4）采用数字的方式，设置文件所有者、所属组、其他用户都具有可读可写可执行权 限。
[root@hadoop101 ~]# chmod 777 houge.txt 
（5)修改整个文件夹里面的所有文件的所有者、所属组、其他用户都具有可读可写可 
执行权限。 
[root@hadoop101 ~]# chmod -R 777 xiyou/
:::

### chown 改变所有者
:::info
**基本语法 **
chown [选项] [最终用户] [文件或目录] 		（功能描述：改变文件或者目录的所有 者）
**选项说明 **
-R 		递归操作 (特殊)
**案例实操 **
（1）修改文件所有者 
[root@hadoop101 ~]# chown atguigu houge.txt 
[root@hadoop101 ~]# ls -al 
-rwxrwxrwx. 1 atguigu root 551 5 月 23 13:02 houge.txt
（2）递归改变文件所有者和所有组 
[root@hadoop101 xiyou]# ll 
drwxrwxrwx. 2 root root 4096 9 月 3 21:20 xiyou 
[root@hadoop101 xiyou]# chown -R atguigu:atguigu xiyou/ 
[root@hadoop101 xiyou]# ll 
drwxrwxrwx. 2 atguigu atguigu 4096 9 月 3 21:20 xiyou
:::
### chgrp 改变所属组
:::info
**基本语法 **
chgrp [最终用户组] [文件或目录] 	（功能描述：改变文件或者目录的所属组） 
**案例实操 **
（1）修改文件的所属组
[root@hadoop101 ~]# chgrp root houge.txt 
[root@hadoop101 ~]# ls -al 
-rwxrwxrwx. 1 atguigu root 551 5 月 23 13:02 houge.txt
:::
# 搜索查找类 
### find 查找文件或者目录
> find 	指令将从指定目录向下递归地遍历其各个子目录，将满足条件的文件显示在终端。
> **基本语法 **
> find [搜索范围] [选项] 
> **选项说明**
> -name<查询方式>	 按照指定的文件名查找模式查找文件 
> -user<用户名> 		查找属于指定用户名所有文件 
> -size<文件大小> 	按照指定的文件大小查找文件,单位为: 
> **b **—— 块（512 字节） 
> **c **—— 字节 
> **w **—— 字（2 字节） 
> **k **—— 千字节 
> **M **—— 兆字节 
> **G **—— 吉字节
> **案例实操 **
> （1）按文件名：根据名称查找/目录下的filename.txt文件。 
> [root@hadoop101 ~]# find xiyou/ -name "*.txt" 
> （2）按拥有者：查找/opt目录下，用户名称为-user的文件 
> [root@hadoop101 ~]# find xiyou/ -user atguigu 
> （3）按文件大小：在/home目录下查找大于200m的文件（+n 大于 -n小于 n等于） 
> [root@hadoop101 ~]find /home -size +204800

### locate 快速定位文件路径
> locate 指令利用事先建立的系统中所有文件名称及路径的 locate 数据库实现快速定位给 定的文件。Locate 指令无需遍历整个文件系统，查询速度较快。为了保证查询结果的准确 度，管理员必须定期新 locate 时刻。 
> **基本语法 **
> locate 搜索文件 
> **经验技巧 **
> 由于 locate 指令基于数据库进行查询，所以第一次运行前，必须使用 updatedb 指令创 建 locate 数据库。 
> **案例实操**
> （1）查询文件夹 
> [root@hadoop101 ~]# updatedb 
> [root@hadoop101 ~]#locate tmp

### grep 过滤查找及“|”管道符
> 管道符，“|”，表示将前一个命令的处理结果输出传递给后面的命令处理 
> **基本语法 **
> grep 选项 查找内容 源文件 
> **选项说明**
> -n 		显示匹配行及行号。
> **案例实操 **
> （1）查找某文件在第几行 
> [root@hadoop101 ~]# ls | grep -n test

# 压缩和解压类
### gzip/gunzip 压缩
:::success
**基本语法 **
gzip 文件 	（功能描述：压缩文件，只能将文件压缩为*.gz 文件） 
gunzip 文件.gz 	（功能描述：解压缩文件命令） 
**经验技巧 **
（1）只能压缩文件不能压缩目录 
（2）不保留原来的文件 
（3）同时多个文件会产生多个压缩包 
**案例实操 **
（1）gzip压缩 
[root@hadoop101 ~]# ls 
test.java 
[root@hadoop101 ~]# gzip houge.txt 
[root@hadoop101 ~]# ls 
houge.txt.gz 
（2）gunzip解压缩文件 
[root@hadoop101 ~]# gunzip houge.txt.gz 
[root@hadoop101 ~]# ls 
houge.txt
:::
### zip/unzip 压缩
:::success
**基本语法 **
zip [选项] XXX.zip 将要压缩的内容 		（功能描述：压缩文件和目录的命令）
unzip [选项] XXX.zip 			（功能描述：解压缩文件）
**选项说明**
zip 选项 
-r 		压缩目录
unzip 选项 
-d<目录> 		指定解压后文件的存放目录
**经验技巧**
zip 压缩命令在windows/linux都通用，可以压缩目录且保留源文件。
**案例实操** 
（1）压缩 houge.txt 和bailongma.txt，压缩后的名称为mypackage.zip 
[root@hadoop101 opt]# touch bailongma.txt 
[root@hadoop101 ~]# zip mypackage.zip houge.txt bailongma.txt 
adding: houge.txt (stored 0%) 
adding: bailongma.txt (stored 0%) 
[root@hadoop101 opt]# ls 
houge.txt bailongma.txt mypackage.zip 
（2）解压 mypackage.zip 
[root@hadoop101 ~]# unzip mypackage.zip 
Archive: houma.zip 
extracting: houge.txt 
extracting: bailongma.txt 
[root@hadoop101 ~]# ls 
houge.txt bailongma.txt mypackage.zip 
（3）解压mypackage.zip到指定目录-d 
[root@hadoop101 ~]# unzip mypackage.zip -d /opt 
[root@hadoop101 ~]# ls /opt/
:::
### tar 打包
:::success
**基本语法 **
tar [选项] XXX.tar.gz 将要打包进去的内容 		（功能描述：打包目录，压缩后的 文件格式.tar.gz）
**选项说明**
-c 		产生.tar 打包文件 
-v 		显示详细信息 
-f 		指定压缩后的文件名 
-z 		打包同时压缩 
-x 		解包.tar 文件 
-C 		解压到指定目录
**案例实操**
（1）压缩多个文件 
[root@hadoop101 opt]# tar -zcvf houma.tar.gz houge.txt bailongma.txt 
houge.txt 
bailongma.txt 
[root@hadoop101 opt]# ls 
houma.tar.gz houge.txt bailongma.txt 
（2）压缩目录 
[root@hadoop101 ~]# tar -zcvf xiyou.tar.gz xiyou/ 
xiyou/ 
xiyou/mingjie/ 
xiyou/dssz/ 
xiyou/dssz/houge.txt 
（3）解压到当前目录 
[root@hadoop101 ~]# tar -zxvf houma.tar.gz 
（4）解压到指定目录 
[root@hadoop101 ~]# tar -zxvf xiyou.tar.gz -C /opt 
[root@hadoop101 ~]# ll /opt/
:::
# 磁盘查看和分区类
### du 查看文件和目录占用的磁盘空间
:::warning
du: disk usage 磁盘占用情况 
**基本语法 **
du 目录/文件 （功能描述：显示目录下每个子目录的磁盘使用情况） 
**选项说明**
-h 					以人们较易阅读的 GBytes, MBytes, KBytes 等格式自行显示； 
-a 					不仅查看子目录大小，还要包括文件 
-c 					显示所有的文件和子目录大小后，显示总和 
-s 					只显示总和 
--max-depth=n 		指定统计子目录的深度为第 n 层 
**案例实操 **
（1）查看当前用户主目录占用的磁盘空间大小 
[root@hadoop101 ~]# du -sh 
166M .
:::
### df 查看磁盘空间使用情况
:::warning
df: disk free 空余磁盘 
**基本语法 **
df 选项 		（功能描述：列出文件系统的整体磁盘使用量，检查文件系统的磁盘空间占 用情况） 
**选项说明**
-h 		以人们较易阅读的 GBytes, MBytes, KBytes 等格式自行显示；
**案例实操 **
（1）查看磁盘使用情况 
[root@hadoop101 ~]# df -h 
Filesystem 		Size 	Used 	Avail 	Use% 	Mounted on 
/dev/sda2 		15G 	3.5G 	11G	 26%	 / 
tmpfs 			939M 	224K 	939M 	1% 		/dev/shm 
/dev/sda1 		190M 	39M 	142M	 22% 	/boot
:::
### lsblk 查看设备挂载情况
:::warning
**基本语法 **
lsblk 	（功能描述：查看设备挂载情况）
**选项说明**
-f 		查看详细的设备挂载情况，显示文件系统信息
:::
### mount/umount 挂载/卸载
:::warning
对于Linux用户来讲，不论有几个分区，分别分给哪一个目录使用，它总归就是一个根 目录、一个独立且唯一的文件结构。 
Linux中每个分区都是用来组成整个文件系统的一部分，它在用一种叫做“挂载”的处理 方法，它整个文件系统中包含了一整套的文件和目录，并将一个分区和一个目录联系起来， 要载入的那个分区将使它的存储空间在这个目录下获得。
:::
**挂载前准备（必须要有光盘或者已经连接镜像文件）**
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/36linux.png)![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/37linux.png)
:::warning
**基本语法 **
mount [-t vfstype] [-o options] device dir 		（功能描述：挂载设备） 
umount 设备文件名或挂载点 					（功能描述：卸载设备）
**参数说明**
:::
| -t vfstype | 指定文件系统的类型，通常不必指定。mount 会自动选择正确的类 
型。常用类型有： 
光盘或光盘镜像：iso9660 
DOS fat16 文件系统：msdos 
Windows 9x fat32 文件系统：vfat 
Windows NT ntfs 文件系统：ntfs 
Mount Windows 文件网络共享：smbfs 
UNIX(LINUX) 文件网络共享：nfs |
| --- | --- |
| -o options | 主要用来描述设备或档案的挂接方式。常用的参数有： 
loop：用来把一个文件当成硬盘分区挂接上系统 
ro：采用只读方式挂接设备 
rw：采用读写方式挂接设备 
iocharset：指定访问文件系统所用字符集 |
| device | 要挂接(mount)的设备 |
| dir | 设备在系统上的挂接点(mount point) |

:::warning
**案例实操 **
（1）挂载光盘镜像文件 
[root@hadoop101 ~]# mkdir /mnt/cdrom/ 		建立挂载点 
[root@hadoop101 ~]# mount -t iso9660 /dev/cdrom /mnt/cdrom/ 		设备/dev/cdrom 挂载到 挂载点 ： /mnt/cdrom 中 
[root@hadoop101 ~]# ll /mnt/cdrom/ 
（2）卸载光盘镜像文件 
[root@hadoop101 ~]# umount /mnt/cdrom

**设置开机自动挂载 （一般不设置）**
[root@hadoop101 ~]# vi /etc/fstab
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/38linux.png)
:::

### fdisk 分区
:::danger
**基本语法 **
fdisk -l 				（功能描述：查看磁盘分区详情） 
fdisk 硬盘设备名 		（功能描述：对新增硬盘进行分区操作） 
**选项说明**
-l 		显示所有硬盘的分区列表 
**经验技巧 **
该命令必须在 root 用户下才能使用
**功能说明 **
（1）Linux 分区 
Device：分区序列 
Boot：引导 
Start：从X磁柱开始 
End：到Y磁柱结束 
Blocks：容量 
Id：分区类型ID 
System：分区类型 
（2）分区操作按键说明 
m：显示命令列表 
p：显示当前磁盘分区 
n：新增分区 
w：写入分区信息并退出 
q：不保存分区信息直接退出
**案例实操 **
（1）查看系统分区情况 
[root@hadoop101 /]# fdisk -l 
Disk /dev/sda: 21.5 GB, 21474836480 bytes 
255 heads, 63 sectors/track, 2610 cylinders 
Units = cylinders of 16065 * 512 = 8225280 bytes 
Sector size (logical/physical): 512 bytes / 512 bytes 
I/O size (minimum/optimal): 512 bytes / 512 bytes 
Disk identifier: 0x0005e654 
Device		 Boot 	Start 	End 	Blocks 		Id 		System
/dev/sda1 	* 		1 		26 		204800		83 		Linux 
Partition 1 does not end on cylinder boundary. 
/dev/sda2 			26 		1332 	10485760 	83		 Linux 
/dev/sda3 			1332 	1593 	2097152 	82		 Linux swap / Solaris
:::
# 进程管理类
> 进程是正在执行的一个程序或命令，每一个进程都是一个运行的实体，都有自己的地 址空间，并占用一定的系统资源。

### ps 查看当前系统进程状态
> ps:process status 进程状态
> **基本语法 **
> ps aux | grep xxx 	（功能描述：查看系统中所有进程） 
> ps -ef | grep xxx 		（功能描述：可以查看子父进程之间的关系） 
> **选项说明**
> a 		列出带有终端的所有用户的进程 
> x 		列出当前用户的所有进程，包括没有终端的进程 
> u 		面向用户友好的显示风格 
> -e 		列出所有进程 
> -u 		列出某个用户关联的所有进程 
> -f 		显示完整格式的进程列表
> **功能说明 **
> （1）ps aux 显示信息说明 
> USER：该进程是由哪个用户产生的 
> PID：进程的 ID 号 
> %CPU：该进程占用 CPU 资源的百分比，占用越高，进程越耗费资源； 
> %MEM：该进程占用物理内存的百分比，占用越高，进程越耗费资源； 
> VSZ：该进程占用虚拟内存的大小，单位 KB； 
> RSS：该进程占用实际物理内存的大小，单位 KB； 
> TTY：该进程是在哪个终端中运行的。对于 CentOS 来说，tty1 是图形化终端， tty2-tty6 是本地的字符界面终端。pts/0-255 代表虚拟终端。 
> STAT：进程状态。常见的状态有：R：运行状态、S：睡眠状态、T：暂停状态、 Z：僵尸状态、s：包含子进程、l：多线程、+：前台显示 
> START：该进程的启动时间
> TIME：该进程占用 CPU 的运算时间，注意不是系统时间 
> COMMAND：产生此进程的命令名
> （2）ps -ef 显示信息说明 
> UID：用户 ID 
> PID：进程 ID 
> PPID：父进程 ID 
> C：CPU 用于计算执行优先级的因子。数值越大，表明进程是 CPU 密集型运算， 执行优先级会降低；数值越小，表明进程是 I/O 密集型运算，执行优先级会提高 
> STIME：进程启动的时间 
> TTY：完整的终端名称 
> TIME：CPU 时间 
> CMD：启动进程所用的命令和参数
> **经验技巧 **
> 如果想查看进程的 CPU 占用率和内存占用率，可以使用 aux; 
> 如果想查看进程的父进程 ID 可以使用 ef; 
> **案例实操 **
> [root@hadoop101 datas]# ps aux
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/39linux.png)
> [root@hadoop101 datas]# ps -ef
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/40linux.png)

### kill 终止进程
> **基本语法 **
> kill [选项] 进程号 		（功能描述：通过进程号杀死进程） 
> killall 进程名称 		（功能描述：通过进程名称杀死进程，也支持通配符，这在系统因负载过大而变得很慢时很有用,没事别用）
> **选项说明**
> -9 		表示强迫进程立即停止
> **案例实操 **
> （1）杀死浏览器进程 
> [root@hadoop101 桌面]# kill -9 5102 
> （2）通过进程名称杀死进程 
> [root@hadoop101 桌面]# killall firefox

### pstree 查看进程树
> **基本语法 **
> pstree [选项] 
> **选项说明**
> p 		显示进程的 PID 
> -u 		显示进程的所属用户
> **案例实操 **
> （1）显示进程 pid 
> [root@hadoop101 datas]# pstree -p 
> （2）显示进程所属用户 
> [root@hadoop101 datas]# pstree -u 

### top 实时监控系统进程状态
> **基本命令 **
> top [选项] 

**选项说明**

| -d 秒数  | 指定 top 命令每隔几秒更新。默认是 3 秒在 top 命令的交互模式当 中可以执行的命令 |  |
| --- | --- | --- |
| -i 
 | 使 top 不显示任何闲置或者僵死进程。  |  |
| -p  | 通过指定监控进程 ID 来仅仅监控某个进程的状态。 |  |

**操作说明（实时中操作）**

| P  | 以 CPU 使用率排序，默认就是此项  |  |
| --- | --- | --- |
| M  | 以内存的使用率排序 |  |
| N  | 以 PID 排序 |  |
| q  | 退出 top |  |

**查询结果字段解释**
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/41linux.png)
（1）第一行信息为任务队列信息	（下面这些看看就好)

| top -15:10:34 | 系统当前时间 |
| --- | --- |
| up 46 min | 系统的运行时间，本机已经运行 46 分钟 |
| 2 users | 当前登录了两个用户 |
| load average: 0.07, 0.04, 0.05 | 系统在之前 1 分钟，5 分钟，15 分钟的平均负载。一般认为小于 1 时，负载较小。如果大于 1，系统已经超出负荷。 |

(2)第二行为进程信息

| Tasks: 229 total | 系统中的进程总数 |
| --- | --- |
| 1 running  | 正在运行的进程数 |
| 288 sleeping | 睡眠的进程 |
| 0 stopped | 正在停止的进程 |
| 0 zombie | 僵尸进程。如果不是 0，需要手工检查僵尸进程 |

(3)第三行为 CPU 信息

| Cpu(s): 2.0%us | 用户模式占用的 CPU 百分比 |
| --- | --- |
| 0.4%sy | 系统模式占用的 CPU 百分比 |
| 0.0%ni | 改变过优先级的用户进程占用的 CPU 百分比 |
| 97.6%id | 空闲 CPU 的 CPU 百分比 |
| 0.0%wa | 等待输入/输出的进程的占用 CPU 百分比 |
| 0.0%hi | 硬中断请求服务占用的 CPU 百分比 |
| 0.0%si | 软中断请求服务占用的 CPU 百分比 |
| 0.0%st | st（Steal time）虚拟时间百分比。就是当有虚拟 机时，虚拟 CPU 等待实际 CPU 的时间百分比。 |

(4)第四行为物理内存信息

| KiB Mem 3861288 total | 物理内存的总量，单位 KB |
| --- | --- |
| 1590728 free | 空闲的物理内存数量，我们使用的是虚拟机，有 1590728 B 的空 闲内存了 |
| 872868 used | 已经使用的物理内存数量 |
| 1397692 buff/cache | 作为缓冲的内存数量 |

（5）第五行为交换分区（swap）信息

| Swap: 2097148 total | 交换分区（虚拟内存）的总大小 |
| --- | --- |
| 2097148 free | 空闲交换分区的大小 |
| 0 used | 已经使用的交互分区的大小 |
| 2724684 avail Mem | 作为缓存的交互分区的大小 |

第六行上面有写过，就是没有作图。
> **案例实操 **
> [root@hadoop101 atguigu]# top -d 1 
> [root@hadoop101 atguigu]# top -i 
> [root@hadoop101 atguigu]# top -p 2575 
> 执行上述命令后，可以按 P、M、N 对查询出的进程结果进行排序。

### netstat 显示网络状态和端口占用信息
> **基本语法 **
> netstat -anp | grep 进程号 	（功能描述：查看该进程网络信息） 
> netstat –nlp | grep 端口号 	（功能描述：查看网络端口号占用情况） 
> **选项说明**
> -a 		显示所有正在监听（listen）和未监听的套接字（socket） 
> -n 		拒绝显示别名，能显示数字的全部转化成数字 
> -l 		仅列出在监听的服务状态 
> -p 		表示显示哪个进程在调用
> **案例实操 **
> （1）通过进程号查看sshd进程的网络信息
> [root@rabbitmq100 ~]# netstat -anp | grep sshd
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/42linux.png)
> （2）查看某端口号是否被占用
> [root@rabbitmq100 ~]# netstat -nltp | grep 22
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/43linux.png)

# crontab 系统定时任务
### crontab 服务管理
:::info
重新启动 crond 服务 
[root@hadoop101 ~]# systemctl restart crond
:::
### crontab 定时任务
:::info
**基本语法 **
crontab [选项] 
**选项说明**
-e 		编辑 crontab 定时任务 
-l 		查询 crontab 任务 
-r 		删除当前用户所有的 crontab 任务
参数说明 
[root@hadoop101 ~]# crontab -e 
（1）进入 crontab 编辑界面。会打开 vim 编辑你的工作。
语法：	* * * * * 执行的任务
第一个“*” 		一小时当中的第几分钟 	0-59 分钟
第二个“*” 		一天当中的第几小时 		0-23 小时
第三个“*” 		一个月当中的第几天 		1-31 天
第四个“*” 		一年当中的第几月 		1-12 月
第五个“*” 		一周当中的星期几 		0-7 （ 0 和 7 都 代 表 星 期 日）
1.特殊符号
* 		代表任何时间。比如第一个“*”就代表一小时中每分钟 都执行一次的意思。 
， 		代表不连续的时间。比如“0 8,12,16 * * * 命令”，就代表 在每天的 8 点 0 分，12 点 0 			分，16 点 0 分都执行一次命令 
- 		代表连续的时间范围。比如“0 5 * * 1-6 命令”，代表在 周一到周六的凌晨 5 点 0 分执行			命令 
*/n 		代表每隔多久执行一次。比如“*/10 * * * * 命令”，代 表每隔 10 分钟就执行一遍命令
2.栗子，特定时间执行命令
45 22 * * * 命令 
每天 22 点 45 分执行命令 
0 17 * * 1 命令 
每周 1 的 17 点 0 分执行命令 
0 5 1,15 * * 命令 
每月 1 号和 15 号的凌晨 5 点 0 分执行命令 
40 4 * * 1-5 命令 
每周一到周五的凌晨 4 点 40 分执行命令 
*/10 4 * * * 命令 
每天的凌晨 4 点，每隔 10 分钟执行一次命令 
0 0 1,15 * 1 命令 
每月 1 号和 15 号，每周 1 的 0 点 0 分都会执行命令。注 意：星期几和几号最好不要同时出现，因为他们定义的都 是天。非常容易让管理员混乱。
**案例实操 **
（1）每隔 1 分钟，向/root/bailongma.txt 文件中添加一个 11 的数字，然后退出编辑就行了，停止就执行删除命令。
*/1 * * * * /bin/echo ”11” >> /root/bailongma.txt
:::
# 软件包管理
### RPM
:::info
**RPM 概述 **
RPM（RedHat Package Manager），RedHat软件包管理工具，类似windows里面的setup.exe 
是Linux这系列操作系统里面的打包安装工具，它虽然是RedHat的标志，但理念是通用的。 
RPM包的名称格式 
Apache-1.3.23-11.i386.rpm 
- “apache” 软件名称 
- “1.3.23-11”软件的版本号，主版本和此版本 
- “i386”是软件所运行的硬件平台，Intel 32位处理器的统称 
- “rpm”文件扩展名，代表RPM包
:::
### RPM 查询命令（rpm -qa）
:::info
**基本语法 **
rpm -qa 	（功能描述：查询所安装的所有 rpm 软件包） 
**经验技巧 **
由于软件包比较多，一般都会采取过滤。rpm -qa | grep rpm软件包 
**案例实操 **
（1）查询firefox软件安装情况 
[root@hadoop101 Packages]# rpm -qa |grep firefox 
firefox-45.0.1-1.el6.centos.x86_64 
:::
### RPM 卸载命令（rpm -e）
:::info
**基本语法 **
（1）rpm -e RPM软件包 
（2） rpm -e --nodeps 软件包
-e 				卸载软件包 
--nodeps 		卸载软件时，不检查依赖。这样的话，那些使用该软件包的软件在此之后可能就					不能正常工作了。
:::
### RPM 安装命令（rpm -ivh）
:::info
**基本语法 **
rpm -ivh RPM 包全名
**选项说明**
-i 				install，安装 
-v 				--verbose，显示详细信息 
-h 				--hash，进度条 
--nodeps 		安装前不检查依赖
**案例实操 **
（1）安装firefox软件 
[root@hadoop101 Packages]# pwd 
/run/media/root/CentOS 7 x86_64/Packages 
[root@hadoop101 Packages]# rpm -ivh firefox-45.0.1-1.el6.centos.x86_64.rpm 
warning: firefox-45.0.1-1.el6.centos.x86_64.rpm: Header V3 RSA/SHA1 
Signature, key ID c105b9de: NOKEY 
Preparing... 	########################################### [100%] 
1:firefox 	########################################### [100%]
:::
### YUM 仓库配置
:::info
**YUM 概述**
YUM（全称为 Yellow dog Updater, Modified）是一个在 Fedora 和 RedHat 以及 CentOS 中的Shell 前端软件包管理器。基于 RPM 包管理，能够从指定的服务器自动下载 RPM 包 并且安装，可以自动处理依赖性关系，并且一次安装所有依赖的软件包，无须繁琐地一次 次下载、安装。
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/44linux.png)
:::

### YUM 的常用命令
:::info
**基本语法 **
yum [选项] [参数] 
**选项说明**
-y 		对所有提问都回答“yes”
**参数说明**
install 				安装 rpm 软件包 
update 				更新 rpm 软件包 
check-update 		检查是否有可用的更新 rpm 软件包 
remove 			删除指定的 rpm 软件包 
list 					显示软件包信息 
clean 				清理 yum 过期的缓存 
deplist 				显示 yum 软件包的所有依赖关系
**案例实操实操 **
（1）采用 yum 方式安装 firefox 
[root@hadoop101 ~]#yum -y install firefox
:::
### 修改网络 YUM 源
:::info
默认的系统 YUM 源，需要连接国外 apache 网站，网速比较慢，可以修改关联的网络 YUM 源为国内镜像的网站，比如网易 163,aliyun 等 
**1）**安装 wget, wget 用来从指定的 URL 下载文件 
[root@hadoop101 ~] yum install wget 
**2）**在/etc/yum.repos.d/目录下，备份默认的 repos 文件, 
[root@hadoop101 yum.repos.d] pwd 
/etc/yum.repos.d 
[root@hadoop101 yum.repos.d] cp CentOS-Base.repo 
CentOS-Base 
.repo.backup 
**3）**下载网易 163 或者是 aliyun 的 repos 文件,任选其一，如图 8-2 
[root@hadoop101 yum.repos.d] wget 
http://mirrors.aliyun.com/repo/Centos-7.repo //阿里云 
[root@hadoop101 yum.repos.d] wget 
http://mirrors.163.com/.help/CentOS7-Base-163.repo //网易 163
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/45linux.png)
**4）**使用下载好的 repos 文件替换默认的 repos 文件 
例如:用 CentOS7-Base-163.repo 替换 CentOS-Base.repo 
[root@hadoop101 yum.repos.d]# mv CentOS7-Base-163.repo 
CentOS-Base.repo 
**5）**清理旧缓存数据，缓存新数据 
[root@hadoop101 yum.repos.d]#yum clean all 
[root@hadoop101 yum.repos.d]#yum makecache 
yum makecache 就是把服务器的包信息下载到本地电脑缓存起来 
**6)**测试 
[root@hadoop101 yum.repos.d]# yum list | grep firefox 
[root@hadoop101 ~]#yum -y install firefox
:::

# **克隆虚拟机**
### 克隆
:::success
从现有虚拟机(关机状态)克隆出新虚拟机，右键选择管理=>克隆
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/46linux.png)
点击下一步，选择虚拟机中的当前状态，选择创建完整克隆
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/47linux.png)
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/48linux.png)
设置虚拟机名称及存储位置，等等等……等待克隆完成
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/49linux.png)
:::

### 开机修改系统相关配置
:::success
注意: 使用 root 用户。 
**1）**修改 vim /etc/sysconfig/network-scripts/ifcfg-ens33 ,修改 IP 地址,
vim /etc/sysconfig/network-scripts/ifcfg-eth0
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/50linux.png)
**2）**修改 /etc/hostname ,修改主机名,
vim /etc/hostname
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/51linux.png)
完成。
:::

# Shell
## shell概述
:::warning
（不是Xshell工具）
![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/shayu931/52linux.png)

### Linux 提供的 Shell 解析器有
[atguigu@hadoop101 ~]$ cat /etc/shells 
/bin/sh 
/bin/bash 
/usr/bin/sh 
/usr/bin/bash 
/bin/tcsh 
/bin/csh
### bash 和 sh 的关系
[atguigu@hadoop101 bin]$ ll | grep bash 	
-rwxr-xr-x. 	1 root root 941880 5 月 11 2016 bash 
lrwxrwxrwx. 1 root root 		4 5 月 27 2017 sh -> bash
### Centos 默认的解析器是 bash
[atguigu@hadoop101 bin]$ echo $SHELL 
/bin/bash
:::
# Shell 脚本入门
> ### 脚本格式
> 脚本以#!/bin/bash 开头（指定解析器）
> ### 第一个 Shell 脚本：helloworld.sh
> （1）需求：创建一个 Shell 脚本，输出 helloworld
> [atguigu@hadoop101 shells]$ touch helloworld.sh 
> [atguigu@hadoop101 shells]$ vim helloworld.sh 
> 在 helloworld.sh 中输入如下内容 
> #!/bin/bash 
> echo "helloworld"
> （2）脚本的常用执行方式
> 第一种：采用 bash 或 sh+脚本的相对路径或绝对路径（不用赋予脚本+x 权限）sh+脚本的相对路径 
> [atguigu@hadoop101 shells]$ sh ./helloworld.sh 
> Helloworld
> sh+脚本的绝对路径 
> [atguigu@hadoop101 shells]$ sh /home/atguigu/shells/helloworld.sh 
> helloworld
> bash+脚本的相对路径 
> [atguigu@hadoop101 shells]$ bash ./helloworld.sh 
> Helloworld
> bash+脚本的绝对路径 
> [atguigu@hadoop101 shells]$ bash /home/atguigu/shells/helloworld.sh 
> Helloworld
> 第二种：采用输入脚本的绝对路径或相对路径执行脚本（必须具有可执行权限+x） 
> ①首先要赋予 helloworld.sh 脚本的+x 权限 
> [atguigu@hadoop101 shells]$ chmod +x helloworld.sh 
> ②执行脚本 
> 相对路径 
> [atguigu@hadoop101 shells]$ ./helloworld.sh 
> Helloworld 
> 绝对路径 
> [atguigu@hadoop101 shells]$ /home/atguigu/shells/helloworld.sh 
> Helloworld
> 注意：第一种执行方法，本质是 bash 解析器帮你执行脚本，所以脚本本身不需要执行权限。第二种执行方法，本质是脚本需要自己执行，所以需要执行权限。
> 
> 【了解】第三种：在脚本的路径前加上“.”或者 source
> ①有以下脚本 
> [atguigu@hadoop101 shells]$ cat test.sh 
> #!/bin/bash 
> A=5 
> echo $A 
> ②分别使用 sh，bash，./ 和 . 的方式来执行，结果如下：
> [atguigu@hadoop101 shells]$ bash test.sh 
> [atguigu@hadoop101 shells]$ echo $A 
> 
> [atguigu@hadoop101 shells]$ sh test.sh 
> [atguigu@hadoop101 shells]$ echo $A 
> 
> [atguigu@hadoop101 shells]$ ./test.sh 
> [atguigu@hadoop101 shells]$ echo $A 
> 
> [atguigu@hadoop101 shells]$ . test.sh 
> [atguigu@hadoop101 shells]$ echo $A 
> 5
> 原因： 
> 前两种方式都是在当前 shell 中打开一个子 shell 来执行脚本内容，当脚本内容结束，则 子 shell 关闭，回到父 shell 中。 
> 第三种，也就是使用在脚本路径前加“.”或者 source 的方式，可以使脚本内容在当前 shell 里执行，而无需打开子 shell！这也是为什么我们每次要修改完/etc/profile 文件以后，需 要 source 一下的原因。 
> 开子 shell 与不开子 shell 的区别就在于，环境变量的继承关系，如在子 shell 中设置的 当前变量，父 shell 是不可见的。 

# 变量
## 系统预定义变量
:::danger
### 常用系统变量 
$HOME、$PWD、$SHELL、$USER 等
（1）查看系统变量的值 
[atguigu@hadoop101 shells]$ echo $HOME 
/home/atguigu 
（2）显示当前 Shell 中所有变量：set 
[atguigu@hadoop101 shells]$ set 
BASH=/bin/bash 
BASH_ALIASES=() 
BASH_ARGC=() 
BASH_ARGV=()
### 自定义变量
**基本语法 **
（1）定义变量：变量名=变量值，注意，=号前后不能有空格 
（2）撤销变量：unset 变量名
（3）声明静态变量：readonly 变量，注意：不能 unset
**变量定义规则 **
（1）变量名称可以由字母、数字和下划线组成，但是不能以数字开头，环境变量名建议大写。 
（2）等号两侧不能有空格 
（3）在 bash 中，变量默认类型都是字符串类型，无法直接进行数值运算。 
（4）变量的值如果有空格，需要使用双引号或单引号括起来。
### 案例实操
（1）定义变量 A 
[atguigu@hadoop101 shells]$ A=5 
[atguigu@hadoop101 shells]$ echo $A 
5
（2）给变量 A 重新赋值 
[atguigu@hadoop101 shells]$ A=8 
[atguigu@hadoop101 shells]$ echo $A 
8 
（3）撤销变量 A 
[atguigu@hadoop101 shells]$ unset A 
[atguigu@hadoop101 shells]$ echo $A 
（4）声明静态的变量 B=2，不能 unset 
[atguigu@hadoop101 shells]$ readonly B=2 
[atguigu@hadoop101 shells]$ echo $B 
2 
[atguigu@hadoop101 shells]$ B=9 
-bash: B: readonly variable
（5）在 bash 中，变量默认类型都是字符串类型，无法直接进行数值运算 
[atguigu@hadoop102 ~]$ C=1+2 
[atguigu@hadoop102 ~]$ echo $C 
1+2 
（6）变量的值如果有空格，需要使用双引号或单引号括起来 
[atguigu@hadoop102 ~]$ D=I love banzhang 
-bash: world: command not found 
[atguigu@hadoop102 ~]$ D="I love banzhang" 
[atguigu@hadoop102 ~]$ echo $D 
I love banzhang 
（7）可把变量提升为全局环境变量，可供其他 Shell 程序使用 
export 变量名 
[atguigu@hadoop101 shells]$ vim helloworld.sh 
在 helloworld.sh 文件中增加 echo $B 
#!/bin/bash 
echo "helloworld" 
echo $B
[atguigu@hadoop101 shells]$ ./helloworld.sh 
Helloworld 
发现并没有打印输出变量 B 的值。 
[atguigu@hadoop101 shells]$ export B 
[atguigu@hadoop101 shells]$ ./helloworld.sh 
helloworld 
2 
:::
## 特殊变量
### $n
> #### 基本语法 
> $n （功能描述：n 为数字，$0 代表该脚本名称，$1-$9 代表第一到第九个参数，十以 上的参数，十以上的参数需要用大括号包含，如${10}）
> **案例实操 **
> [atguigu@hadoop101 shells]$ touch parameter.sh 
> [atguigu@hadoop101 shells]$ vim parameter.sh 
> #!/bin/bash 
> echo '==========$n==========' 
> echo $0 
> echo $1 
> echo $2 
> 
> [atguigu@hadoop101 shells]$ chmod 777 parameter.sh 
> [atguigu@hadoop101 shells]$ ./parameter.sh cls xz 
> ==========$n========== 
> ./parameter.sh 
> cls 
> xz

### $#
> **基本语法 **
> $# （功能描述：获取所有输入参数个数，常用于循环,判断参数的个数是否正确以及 加强脚本的健壮性）。
> **案例实操 **
> [atguigu@hadoop101 shells]$ vim parameter.sh 
> #!/bin/bash 
> echo '==========$n==========' 
> echo $0 
> echo $1 
> echo $2 
> echo '==========$#==========' 
> echo $# 
> [atguigu@hadoop101 shells]$ chmod 777 parameter.sh 
> [atguigu@hadoop101 shells]$ ./parameter.sh cls xz 
> ==========$n========== 
> ./parameter.sh 
> cls
> xz 
> ==========$#========== 
> 2

### $*、$@
> **基本语法 **
> $* （功能描述：这个变量代表命令行中所有的参数，$*把所有的参数看成一个整体） 
> $@ （功能描述：这个变量也代表命令行中所有的参数，不过$@把每个参数区分对待）
> **案例实操 **
> [atguigu@hadoop101 shells]$ vim parameter.sh 
> #!/bin/bash 
> echo '==========$n==========' 
> echo $0 
> echo $1 
> echo $2 
> echo '==========$#==========' 
> echo $# 
> echo '==========$*==========' 
> echo $* 
> echo '==========$@==========' 
> echo $@ 
> [atguigu@hadoop101 shells]$ ./parameter.sh a b c d e f g 
> ==========$n========== 
> ./parameter.sh 
> a 
> b 
> ==========$#========== 
> 7 
> ==========$*========== 
> a b c d e f g 
> ==========$@========== 
> a b c d e f g

### $？
> **基本语法 **
> $？ （功能描述：最后一次执行的命令的返回状态。如果这个变量的值为 0，证明上一 个命令正确执行；如果这个变量的值为非 0（具体是哪个数，由命令自己来决定），则证明 上一个命令执行不正确了。）
> **案例实操 **
> 判断 helloworld.sh 脚本是否正确执行 
> [atguigu@hadoop101 shells]$ ./helloworld.sh 
> hello world 
> [atguigu@hadoop101 shells]$ echo $? 
> 0

# 运算符
> **基本语法**
> “$((运算式))” 或 “$[运算式]”
> **案例实操： **
> 计算（2+3）* 4 的值 
> [atguigu@hadoop101 shells]# S=$[(2+3)*4] 
> [atguigu@hadoop101 shells]# echo $S

# 条件判断
> **基本语法 **
> （1）test condition 
> （2）[ condition ]（注意 condition 前后要有空格） 
> 注意：条件非空即为 true，[ atguigu ]返回 true，[ ] 返回 false。
> **常用判断条件 **
> （1）两个整数之间比较 
> -eq 等于（equal） 
> -ne 不等于（not equal） 
> -lt 小于（less than） 
> -le 小于等于（less equal） 
> -gt 大于（greater than） 
> -ge 大于等于（greater equal） 
> 注：如果是字符串之间的比较 ，用等号“=”判断相等；用“!=”判断不等。 
> （2）按照文件权限进行判断
> -r 有读的权限（read） 
> -w 有写的权限（write） 
> -x 有执行的权限（execute） 
> （3）按照文件类型进行判断 
> -e 文件存在（existence） 
> -f 文件存在并且是一个常规的文件（file） 
> -d 文件存在并且是一个目录（directory）
> **案例实操 **
> （1）23 是否大于等于 22 
> [atguigu@hadoop101 shells]$ [ 23 -ge 22 ] 
> [atguigu@hadoop101 shells]$ echo $? 
> 0 
> （2）helloworld.sh 是否具有写权限 
> [atguigu@hadoop101 shells]$ [ -w helloworld.sh ] 
> [atguigu@hadoop101 shells]$ echo $? 
> 0
> （3）/home/atguigu/cls.txt 目录中的文件是否存在 
> [atguigu@hadoop101 shells]$ [ -e /home/atguigu/cls.txt ] 
> [atguigu@hadoop101 shells]$ echo $? 
> 1 
> （4）多条件判断（&& 表示前一条命令执行成功时，才执行后一条命令，|| 表示上一 条命令执行失败后，才执行下一条命令） 
> [atguigu@hadoop101 ~]$ [ atguigu ] && echo OK || echo notOK 
> OK 
> [atguigu@hadoop101 shells]$ [ ] && echo OK || echo notOK 
> notOK

# 流程控制（重点）
### if 判断
> #### 基本语法 
> （1）单分支 
> if [ 条件判断式 ];then 
> 程序 
> fi 
> 或者 
> if [ 条件判断式 ] 
> then 
> 程序 
> fi 
> （2）多分支 
> if [ 条件判断式 ] 
> then 
> 程序 
> elif [ 条件判断式 ] 
> then 
> 程序 
> else 
> 程序 
> fi 
> 注意事项： 
> ①[ 条件判断式 ]，中括号和条件判断式之间必须有空格 
> ②if 后要有空格
> **案例实操 **
> 输入一个数字，如果是 1，则输出 banzhang zhen shuai，如果是 2，则输出 cls zhen mei， 如果是其它，什么也不输出。 
> [atguigu@hadoop101 shells]$ touch if.sh 
> [atguigu@hadoop101 shells]$ vim if.sh
> #!/bin/bash 
> if [ $1 -eq 1 ] 
> then 
> echo "banzhang zhen shuai" 
> elif [ $1 -eq 2 ] 
> then 
> echo "cls zhen mei" 
> fi 
> [atguigu@hadoop101 shells]$ chmod 777 if.sh 
> [atguigu@hadoop101 shells]$ ./if.sh 1 
> banzhang zhen shuai

### case 语句
> **基本语法 **
> case $变量名 in 
> "值 1"） 
> 如果变量的值等于值 1，则执行程序 1 
> ;; 
> "值 2"） 
> 如果变量的值等于值 2，则执行程序 2 
> ;; 
> …省略其他分支… 
> *） 
> 如果变量的值都不是以上的值，则执行此程序 
> ;; 
> esac
> 注意事项： 
> （1）case 行尾必须为单词“in”，每一个模式匹配必须以右括号“）”结束。 
> （2）双分号“**;;**”表示命令序列结束，相当于 java 中的 break。 
> （3）最后的“*）”表示默认模式，相当于 java 中的 default。

### for 循环
> **基本语法 1**
> for (( 初始值;循环控制条件;变量变化 )) 
> do 
> 程序 
> done
> **案例实操 **
> 从 1 加到 100 
> [atguigu@hadoop101 shells]$ touch for1.sh 
> [atguigu@hadoop101 shells]$ vim for1.sh 
> #!/bin/bash 
> sum=0 
> for((i=0;i<=100;i++)) 
> do 
> sum=$[$sum+$i] 
> done 
> echo $sum 
> [atguigu@hadoop101 shells]$ chmod 777 for1.sh 
> [atguigu@hadoop101 shells]$ ./for1.sh 
> 5050
> **基本语法 2 **
> for 变量 in 值 1 值 2 值 3… 
> do 
> 程序 
> done
> **案例实操 **
> （1）打印所有输入参数 
> [atguigu@hadoop101 shells]$ touch for2.sh 
> [atguigu@hadoop101 shells]$ vim for2.sh 
> #!/bin/bash 
> #打印数字 
> for i in cls mly wls 
> do 
> echo "ban zhang love $i" 
> done 
> [atguigu@hadoop101 shells]$ chmod 777 for2.sh 
> [atguigu@hadoop101 shells]$ ./for2.sh 
> ban zhang love cls 
> ban zhang love mly
> ban zhang love wls
> （2）比较$*和$@区别 
> $*和$@都表示传递给函数或脚本的所有参数，不被双引号“”包含时，都以$1 $2 …$n 的形式输出所有参数。
> [atguigu@hadoop101 shells]$ touch for3.sh 
> [atguigu@hadoop101 shells]$ vim for3.sh 
> #!/bin/bash 
> echo '=============$*=============' 
> for i in $* 
> do 
> echo "ban zhang love $i" 
> done 
> echo '=============$@=============' 
> for j in $@ 
> do 
> echo "ban zhang love $j" 
> done 
> [atguigu@hadoop101 shells]$ chmod 777 for3.sh 
> [atguigu@hadoop101 shells]$ ./for3.sh cls mly wls 
> =============$*============= 
> banzhang love cls 
> banzhang love mly 
> banzhang love wls 
> =============$@============= 
> banzhang love cls 
> banzhang love mly 
> banzhang love wls
> 当它们被双引号“”包含时，$*会将所有的参数作为一个整体，以“$1 $2 …$n”的形式输 
> 出所有参数；$@会将各个参数分开，以“$1” “$2”…“$n”的形式输出所有参数。
> [atguigu@hadoop101 shells]$ vim for4.sh 
> #!/bin/bash 
> echo '=============$*=============' 
> for i in "$*" 
> #$*中的所有参数看成是一个整体，所以这个 for 循环只会循环一次 
> do 
> echo "ban zhang love $i" 
> done 
> echo '=============$@=============' 
> for j in "$@" 
> #$@中的每个参数都看成是独立的，所以“$@”中有几个参数，就会循环几次 
> do 
> echo "ban zhang love $j" 
> done 
> [atguigu@hadoop101 shells]$ chmod 777 for4.sh 
> [atguigu@hadoop101 shells]$ ./for4.sh cls mly wls 
> =============$*============= 
> banzhang love cls mly wls 
> =============$@============= 
> banzhang love cls 
> banzhang love mly
> banzhang love wls

### while 循环
> **基本语法 **
> while [ 条件判断式 ] 
> do 
> 程序 
> done
> **案例实操 **
> 从 1 加到 100 
> [atguigu@hadoop101 shells]$ touch while.sh 
> [atguigu@hadoop101 shells]$ vim while.sh 
> #!/bin/bash 
> sum=0 
> i=1 
> while [ $i -le 100 ] 
> do 
> sum=$[$sum+$i] 
> i=$[$i+1] 
> done 
> echo $sum 
> [atguigu@hadoop101 shells]$ chmod 777 while.sh 
> [atguigu@hadoop101 shells]$ ./while.sh 
> 5050

# read 读取控制台输入
:::info
**基本语法 **
read (选项) (参数) 
①选项： 
-p：指定读取值时的提示符； 
-t：指定读取值时等待的时间（秒）如果-t 不加表示一直等待 
②参数 
变量：指定读取值的变量名
**案例实操 **
提示 7 秒内，读取控制台输入的名称 
[atguigu@hadoop101 shells]$ touch read.sh 
[atguigu@hadoop101 shells]$ vim read.sh 
#!/bin/bash 
read -t 7 -p "Enter your name in 7 seconds :" NN 
echo $NN
[atguigu@hadoop101 shells]$ ./read.sh 
Enter your name in 7 seconds : atguigu 
atguigu
:::
# 函数
## 系统函数
### basename
:::info
**基本语法 **
basename [string / pathname] [suffix] 	（功能描述：basename 命令会删掉所有的前 缀包括最后一个（‘/’）字符，然后将字符串显示出来。 
basename 可以理解为取路径里的文件名称 
选项： 
suffix 为后缀，如果 suffix 被指定了，basename 会将 pathname 或 string 中的 suffix 去掉。
**案例实操 **
截取该/home/atguigu/banzhang.txt 路径的文件名称。 
[atguigu@hadoop101 shells]$ basename /home/atguigu/banzhang.txt 
banzhang.txt 
[atguigu@hadoop101 shells]$ basename /home/atguigu/banzhang.txt .txt 
banzhang
:::
### dirname
:::info
**基本语法 **
dirname 文件绝对路径 
（功能描述：从给定的包含绝对路径的文件名中去除文件名 
（非目录的部分），然后返回剩下的路径（目录的部分）） 
dirname 可以理解为取文件路径的绝对路径名称 
**案例实操 **
获取 banzhang.txt 文件的路径。 
[atguigu@hadoop101 ~]$ dirname /home/atguigu/banzhang.txt 
/home/atguigu
:::
## 自定义函数
:::info
**基本语法 **
[ function ] funname[()] 
{ 
Action; 
[return int;] 
}
**经验技巧 **
（1）必须在调用函数地方之前，先声明函数，shell 脚本是逐行运行。不会像其它语言一 
样先编译。 
（2）函数返回值，只能通过$?系统变量获得，可以显示加：return 返回，如果不加，将 
以最后一条命令运行结果，作为返回值。return 后跟数值 n(0-255)
**案例实操 **
计算两个输入参数的和。 
[atguigu@hadoop101 shells]$ touch fun.sh 
[atguigu@hadoop101 shells]$ vim fun.sh 
#!/bin/bash 
function sum() 
{ 
s=0 
s=$[$1+$2] 
echo "$s" 
} 
read -p "Please input the number1: " n1; 
read -p "Please input the number2: " n2; 
sum $n1 $n2; 
[atguigu@hadoop101 shells]$ chmod 777 fun.sh 
[atguigu@hadoop101 shells]$ ./fun.sh 
Please input the number1: 2 
Please input the number2: 5 
7
:::
# 正则表达式入门
> 正则表达式使用单个字符串来描述、匹配一系列符合某个语法规则的字符串。在很多文 本编辑器里，正则表达式通常被用来检索、替换那些符合某个模式的文本。在 Linux 中，grep， sed，awk 等文本处理工具都支持通过正则表达式进行模式匹配。

## 常规匹配
> 一串不包含特殊字符的正则表达式匹配它自己，例如： 
> [atguigu@hadoop101 shells]$ cat /etc/passwd | grep atguigu 
> 就会匹配所有包含 atguigu 的行。

## 常用特殊字符
### 特殊字符：^
> ^ 匹配一行的开头，例如： 
> [atguigu@hadoop101 shells]$ cat /etc/passwd | grep ^a 
> 会匹配出所有以 a 开头的行

### 特殊字符：$
> $ 匹配一行的结束，例如 
> [atguigu@hadoop101 shells]$ cat /etc/passwd | grep t$ 
> 会匹配出所有以 t 结尾的行

### 特殊字符：.
> . 匹配一个任意的字符，例如 
> [atguigu@hadoop101 shells]$ cat /etc/passwd | grep r..t 
> 会匹配包含 rabt,rbbt,rxdt,root 等的所有行

### 特殊字符：*
> * 不单独使用，他和上一个字符连用，表示匹配上一个字符 0 次或多次，例如 
> [atguigu@hadoop101 shells]$ cat /etc/passwd | grep ro*t 
> 会匹配 rt, rot, root, rooot, roooot 等所有行

### 字符区间（中括号）：[ ] 
> [ ] 表示匹配某个范围内的一个字符，例如 
> [6,8]------匹配 6 或者 8 
> [0-9]------匹配一个 0-9 的数字 
> [0-9]*------匹配任意长度的数字字符串 
> [a-z]------匹配一个 a-z 之间的字符 
> [a-z]* ------匹配任意长度的字母字符串 
> [a-c, e-f]-匹配 a-c 或者 e-f 之间的任意字符 
> [atguigu@hadoop101 shells]$ cat /etc/passwd | grep r[a,b,c]*t 
> 会匹配 rt,rat, rbt, rabt, rbact,rabccbaaacbt 等等所有行

### 特殊字符：\
> \ 表示转义，并不会单独使用。由于所有特殊字符都有其特定匹配模式，当我们想匹配 
> 某一特殊字符本身时（例如，我想找出所有包含 '$' 的行），就会碰到困难。此时我们就要 
> 将转义字符和特殊字符连用，来表示特殊字符本身，例如 
> [atguigu@hadoop101 shells]$ cat /etc/passwd | grep ‘a\$b’ 
> 就会匹配所有包含 a$b 的行。注意需要使用单引号将表达式引起来。

# 文本处理工具
## cut
> cut 的工作就是“剪”，具体的说就是在文件中负责剪切数据用的。cut 命令从文件的每 一行剪切字节、字符和字段并将这些字节、字符和字段输出。
> **基本用法**
> cut [选项参数] filename 
> 说明：默认分隔符是制表符
> **选项参数说明 **
> 选项参数 		功能 
> -f 				列号，提取第几列 
> -d 				分隔符，按照指定分隔符分割列，默认是制表符“\t” 
> -c 				按字符进行切割 后加加 n 表示取第几列 比如 -c 1
> **案例实操 **
> （1）数据准备 
> [atguigu@hadoop101 shells]$ touch cut.txt 
> [atguigu@hadoop101 shells]$ vim cut.txt 
> dong shen 
> guan zhen 
> wo wo 
> lai lai 
> le le
> （2）切割 cut.txt 第一列 
> [atguigu@hadoop101 shells]$ cut -d " " -f 1 cut.txt 
> dong 
> guan 
> wo 
> lai 
> le 
> （3）切割 cut.txt 第二、三列 
> [atguigu@hadoop101 shells]$ cut -d " " -f 2,3 cut.txt 
> shen 
> zhen 
> wo 
> lai 
> le
> （4）在 cut.txt 文件中切割出 guan 
> [atguigu@hadoop101 shells]$ cat cut.txt |grep guan | cut -d " " -f 1 
> guan
> （5）选取系统 PATH 变量值，第 2 个“：”开始后的所有路径： 
> [atguigu@hadoop101 shells]$ echo $PATH 
> /usr/local/bin:/usr/bin:/usr/local/sbin:/usr/sbin:/home/atguigu/.local/bin:/ 
> home/atguigu/bin
> [atguigu@hadoop101 shells]$ echo $PATH | cut -d ":" -f 3- 
> /usr/local/sbin:/usr/sbin:/home/atguigu/.local/bin:/home/atguigu/bin 
> （6）切割 ifconfig 后打印的 IP 地址 
> [atguigu@hadoop101 shells]$ ifconfig ens33 | grep netmask | cut -d " " -f 10 
> 192.168.111.101

## awk 
> 一个强大的文本分析工具，把文件逐行的读入，以空格为默认分隔符将每行切片，切开 的部分再进行分析处理。
> **基本用法 **
> awk [选项参数] ‘/pattern1/{action1} /pattern2/{action2}...’ filename 
> pattern：表示 awk 在数据中查找的内容，就是匹配模式 
> action：在找到匹配内容时所执行的一系列命令
> **选项参数说明 **
> 选项参数 		功能 
> -F 				指定输入文件分隔符 
> -v 				赋值一个用户定义变量
> **案例实操 **
> （1）数据准备 
> [atguigu@hadoop101 shells]$ sudo cp /etc/passwd ./ 
> passwd 数据的含义 
> 用户名:密码(加密过后的):用户 id:组 id:注释:用户家目录:shell 解析器 
> （2）搜索 passwd 文件以 root 关键字开头的所有行，并输出该行的第 7 列。 
> [atguigu@hadoop101 shells]$ awk -F : '/^root/{print $7}' passwd 
> /bin/bash 
> （3）搜索 passwd 文件以 root 关键字开头的所有行，并输出该行的第 1 列和第 7 列， 中间以“，”号分割。 
> [atguigu@hadoop101 shells]$ awk -F : '/^root/{print $1","$7}' passwd 
> root,/bin/bash 
> 注意：只有匹配了 pattern 的行才会执行 action。 
> （4）只显示/etc/passwd 的第一列和第七列，以逗号分割，且在所有行前面添加列名 user， shell 在最后一行添加"dahaige，/bin/zuishuai"。 
> [atguigu@hadoop101 shells]$ awk -F : 'BEGIN{print "user, shell"} {print $1","$7} 
> END{print "dahaige,/bin/zuishuai"}' passwd 
> user, shell 
> root,/bin/bash 
> bin,/sbin/nologin 
> 。。。 
> atguigu,/bin/bash 
> dahaige,/bin/zuishuai
> 注意：BEGIN 在所有数据读取行之前执行；END 在所有数据执行之后执行。
> （5）将 passwd 文件中的用户 id 增加数值 1 并输出 
> [atguigu@hadoop101 shells]$ awk -v i=1 -F : '{print $3+i}' passwd 
> 1 
> 2 
> 3 
> 4
> **awk 的内置变量 **
> 变量 			说明 
> FILENAME 		文件名 
> NR 				已读的记录数（行号） 
> NF 				浏览记录的域的个数（切割后，列的个数）
> **案例实操 **
> （1）统计 passwd 文件名，每行的行号，每行的列数 
> [atguigu@hadoop101 shells]$ awk -F : '{print "filename:" FILENAME ",linenum:" 
> NR ",col:"NF}' passwd 
> filename:passwd,linenum:1,col:7 
> filename:passwd,linenum:2,col:7 
> filename:passwd,linenum:3,col:7 
> ... 
> （2）查询 ifconfig 命令输出结果中的空行所在的行号 
> [atguigu@hadoop101 shells]$ ifconfig | awk '/^$/{print NR}' 
> 9 
> 18 
> 26 
> （3）切割 IP 
> [atguigu@hadoop101 shells]$ ifconfig ens33 | awk '/netmask/ {print $2}' 
> 192.168.6.101

# 综合应用案例
## 归档文件
:::success
实际生产应用中，往往需要对重要数据进行归档备份。 
需求：实现一个每天对指定目录归档备份的脚本，输入一个目录名称（末尾不带/）， 
将目录下所有文件按天归档保存，并将归档日期附加在归档文件名上，放在/root/archive 下。 
这里用到了归档命令：tar 
后面可以加上-c 选项表示归档，加上-z 选项表示同时进行压缩，得到的文件后缀名 为.tar.gz。 
脚本实现如下：
#!/bin/bash 
# 首先判断输入参数个数是否为 1
if [ $# -ne 1 ] 
then 
echo "参数个数错误！应该输入一个参数，作为归档目录名" 
exit 
fi 
# 从参数中获取目录名称 
if [ -d $1 ] 
then 
echo 
else 
echo 
echo "目录不存在！" 
echo 
exit 
fi 
DIR_NAME=$(basename $1) 
DIR_PATH=$(cd $(dirname $1); pwd) 
# 获取当前日期 
DATE=$(date +%y%m%d) 
# 定义生成的归档文件名称 
FILE=archive_${DIR_NAME}_$DATE.tar.gz 
DEST=/root/archive/$FILE 
# 开始归档目录文件 
echo "开始归档..." 
echo 
tar -czf $DEST $DIR_PATH/$DIR_NAME 
if [ $? -eq 0 ] 
then 
echo 
echo "归档成功！" 
echo "归档文件为：$DEST" 
echo 
else 
echo "归档出现问题！" 
echo 
fi 
exit
:::
## 发送消息
:::success
我们可以利用 Linux 自带的 mesg 和 write 工具，向其它用户发送消息。 
需求：实现一个向某个用户快速发送消息的脚本，输入用户名作为第一个参数，后面直 
接跟要发送的消息。脚本需要检测用户是否登录在系统中、是否打开消息功能，以及当前发 
送消息是否为空。 
脚本实现如下：
#!/bin/bash 
login_user=$(who | grep -i -m 1 $1 | awk '{print $1}') 
if [ -z $login_user ] 
then 
echo "$1 不在线！" 
echo "脚本退出.." 
exit 
fi 
is_allowed=$(who -T | grep -i -m 1 $1 | awk '{print $2}') 
if [ $is_allowed != "+" ] 
then 
echo "$1 没有开启消息功能" 
echo "脚本退出.." 
exit 
fi 
if [ -z $2 ] 
then 
echo "没有消息发出" 
echo "脚本退出.." 
exit 
fi 
whole_msg=$(echo $* | cut -d " " -f 2- ) 
user_terminal=$(who | grep -i -m 1 $1 | awk '{print $2}') 
echo $whole_msg | write $login_user $user_terminal 
if [ $? != 0 ] 
then 
echo "发送失败！" 
else 
echo "发送成功！" 
fi 
exit
:::
