[(10条消息) Gitlab使用教程---教你实习、工作如何做到如鱼得水_程序员面试之道的博客-CSDN博客_gitlab使用教程](https://blog.csdn.net/weixin_41563161/article/details/112003721?ops_request_misc=%7B%22request%5Fid%22%3A%22163577780716780366558418%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=163577780716780366558418&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-112003721.first_rank_v2_pc_rank_v29&utm_term=gitlab使用教程&spm=1018.2226.3001.4187)

```
查看远程分支
$ git branch -a

切换分支
$ git checkout 分支名

6.拉取项目

克隆 （第一次拉取）
git clone xxx


git pull  //获取当前分支的远程仓库下的文件

7.推送项目




在新文件夹里面连接远程仓库步骤 ：

1. git init(初始化)
2.连接 ： git remote add origin 仓库链接
如果在分支里面新加了文件 ：0.切换分支 ： git checkout 分支名
                         1.git add .
                         2.git commit -m "描述字段"
                         3.git push origin 分支名(推送代码到分支名)
                         4.切换到主分支进行合并 ： git checkout master
                         5.合并代码 ： git merge 分支名
                         6.合并代码后需要推送至主分支 ； git push origin master
3.推送 ： git push origin 分支名(或者是master)
4.查看所有分支 ： git branch -a
5.切换分支 ： git checkout 分支名
6.在本地创建新的分支并切换 ： git checkout -b 分支名
7.拉取 ： git pull 仓库链接(需要先进行切换分支)
```

[(10条消息) 新手如何在GItLab中进行推送和拉取_企鹅不该去银河怀疑人生-CSDN博客](https://blog.csdn.net/weixin_44663188/article/details/115345220?ops_request_misc=%7B%22request%5Fid%22%3A%22163584387816780274198871%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=163584387816780274198871&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-1-115345220.first_rank_v2_pc_rank_v29&utm_term=gitlab+拉去推送&spm=1018.2226.3001.4187)





[(10条消息) git gui怎么拉取项目代码_使用git在gitlab上拉取代码的方法_weixin_39986543的博客-CSDN博客](https://blog.csdn.net/weixin_39986543/article/details/111860927?ops_request_misc=&request_id=&biz_id=102&utm_term=gitlab 拉去推送 gitui&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-111860927.first_rank_v2_pc_rank_v29&spm=1018.2226.3001.4187)

```
4、现在我们就可以在git 工具下用git clone来克隆你想要操作的文件了，git clone 文件路径，

5、git pull就可以把你的代码拉下来了，现在你可以增删改查你的代码了。

6、代码修改完成了，你想把你的代码重新放到gitlab上去，执行命令 git add .，此处需要注意，add后面是“空格”和“.”，

7、添加完了需要提交 ，执行命令git commit -m ‘备注信息(提交的什么内容)‘，

8、此刻你可以将你的代码推送到远程仓库了，执行命令 git push，这样你的代码基本上就被重新放到了gitlab上了。
————————————————
版权声明：本文为CSDN博主「weixin_39986543」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_39986543/article/details/111860927
```





[(10条消息) gitlab本地代码推送到线上仓库，创建分支_longlong6682的博客-CSDN博客](https://blog.csdn.net/longlong6682/article/details/106820376?ops_request_misc=%7B%22request%5Fid%22%3A%22163584443616780265482741%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=163584443616780265482741&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-1-106820376.first_rank_v2_pc_rank_v29&utm_term=gitlab+创建分支+推送&spm=1018.2226.3001.4187)

[解决“fatal: 'origin' does not appear to be a git repository...” - 侧身左睡 - 博客园 (cnblogs.com)](https://www.cnblogs.com/xyfer1018/p/11493810.html)

[(10条消息) Git GUI如何汉化设置成中文？_u014723479的博客-CSDN博客_git gui 汉化](https://blog.csdn.net/u014723479/article/details/102869727)



推送 拉取步骤
https://zhuanlan.zhihu.com/p/96518956

https://blog.csdn.net/weixin_43553694/article/details/104118348?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522163612397216780269842542%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=163612397216780269842542&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-1-104118348.first_rank_v2_pc_rank_v29&utm_term=git%E5%A4%9A%E4%BA%BA%E5%8D%8F%E4%BD%9C%E5%BC%80%E5%8F%91%E6%B5%81%E7%A8%8B&spm=1018.2226.3001.4187
