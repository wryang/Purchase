Purchase
========

基于分布式组件技术(CORBA, JMI, DCOM, Web Service, and Message Queue), 对多个异构系统进行集成。

团购管理系统A、 团购网站系统B、短信系统C、零售商系统D 以及银行系统E的实现原型。
现通过上述的五种分布式组件技术来实现这5个系统之间的业务交互

5个系统的实现原型已经给出,只要求实现异构系统之间的交互,不要求对系统的实现细节进行了解或修改 ;

![Add Library Project](http://dl.dropbox.com/u/91146904/weibao/SI_Architecture.png)

简单实现一次团购商品从发布、购 买到领取的整个业务流程:

- 发布团购

![Distribution](http://dl.dropbox.com/u/91146904/weibao/SI_Distribution.png)

- 查询团购

![Check out](http://dl.dropbox.com/u/91146904/weibao/SI_Check.png)

- 购买团购

![Purchase](http://dl.dropbox.com/u/91146904/weibao/SI_Purchase.png)

- 领取团购商品

![Get Stuff](http://dl.dropbox.com/u/91146904/weibao/SI_Get.png)

银行系统
----------

银行系统使用 C++实现,对应的静态链接库前缀为 BankSystem1,头文件为 BankSystem.h。
需要实现的是分别利用 Message Queue 和 DCOM 技术分别暴露银行系 统的两个方法,参考的 Main.cpp 如下(创建项目时使用 C++空项目即可):

``````C++
#include "BankSystem.h"
#pragma comment(lib, "BankSystem_vc10_mtd.lib")
int main(int args, char** argv)
{
// TODO: use Message Queue to expose the transfer method as a service // TODO: use DCOM to expose the history method as a service
return 0;
}

``````

零售商系统
----------

零售商系统也是使用 C++实现,对应的动态链接库前缀为 RetailSystem,头文件为 RetailSystem.h,需要使用 DCOM 技术连接银行系统,使用 CORBA 连接团购管理系统。

`````C++
#include "RetailSystem.h"
class RemoteBankSystem : public BankSystem
{
public:
    list<record> listHistory(string account, string password)
    {
// TODO: adapt to a remote procedure call to the bank system
} };
`````

`````C++
#include "RetailSystem.h"
class RemoteGroupPurchaseManagementSystem : public GroupPurchaseManagementSystem {
public:
bool publishGroupPurchaseItem(string sellerSecretKey, string productName, string introduction, double price, int limit)
{
    }
    bool confirmPurchase(string sellerSecretKey, string confirm)
    {
// TODO: adapt to a remote procedure call to the group purchase management system
} };
```````

``````C++
#include "RetailSystem.h"
#pragma comment(lib, "RetailSystem_vc10_mtd.lib")
int main(int args, char** argv)
{
RemoteBankSystem bank; RemoteGroupPurchaseManagementSystem gpms;
// TODO: adapt to a remote procedure call to the group purchase management system
return launchRetailSystem(&gpms, &bank);
}
``````

短信系统
----------

短信系统是使用 Java 实现的,对应的 Java 包为 ShortMessageNotificationSystem.jar, 需要使用 WebService 技术将该系统接口暴露给团购管理系统

``````Java
package assignment3;
public interface ShortMessageSender {
boolean sendMessage(String receiver, String msg);
}
`````

团购管理系统
----------

团购管理系统同样使用 Java 实现,对应的 Java 包为 GroupPurchaseManagementSystem.jar,需要使用 CORBA 和 RMI 技术分别将他的方法暴露给零售商系统和团购网站系统,并且需要使用 WebService 方法调用短信系统,使 用 Message Queue 的方法连接银行系统。

``````Java
package assingment3;
import java.util.List;
public interface GroupPurchaseManagementSystem {
boolean confirmPurchase(String sellerSecretKey, String confirm);
List<GroupPurchaseItem> listGroupPurchase();
boolean publishGroupPurchaseItem(String sellerSecretKey, String productName, String introduction, double price, int limit);
boolean submitPurchase(String itemId, String bankAccount, String password, String phone);
}
```````
在获得团购管理系统的实例之前,需要先实现银行系统的远程调用代理,接口如下:
``````Java
package assingment3;
public interface BankSystem {
boolean transfer(String account, String password, String target, double amount);
}
``````
创建两个系统的远程调用代理,并且获得团购管理系统的实例:
``````Java
GroupPurchaseManagementSystem instance = GroupPurchaseManagementSystemFactory .createGroupPurchaseManagementSystem(messageSender, bankSystem);
``````

团购网站系统
----------

团购网站系统也是使用 Java 实现,在实现其原型系统时,为了更方便作业的开发,使 用了 swing 桌面程序代替应有的网站,对应的 Java 包为 GroupPurchaseWeb.jar,并且 使用到了 external-libs 中的 appframework-1.0.3.jar 以及 swing-worker-1.1.jar。学生需要 使用 RMI 技术连接管理系统

在启动团购网站系统之前,需要先实现团购管理系统的远 程调用代理类

`````Java
package assignment3;
import java.util.List;
public interface GroupPurchaseManagementSystem {
List<GroupPurchaseItem> listGroupPurchase();
boolean submitPurchase(String itemId, String bankAccount, String password, String phone);
}
`````

最后通过GroupPurchaseWeb.launch(gpms);即可启动团购网站系统

![Start up](http://dl.dropbox.com/u/91146904/weibao/SI_Startup.png)

![Purchase](http://dl.dropbox.com/u/91146904/weibao/SI_Purchase_View.png)





