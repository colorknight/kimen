​	KiMen(奇门)是一款基于表达式随机生成字符串的开源工具。可用于数据脱敏或系统测试时数据的仿真生成。其表达式借鉴了正则表达式的部分表示方式，如：

```
[a-zA-Z]{4}'1234'[a-zA-Z]{4}
```

​	该表达式由三部分组成，分别是：[a-zA-Z]{4}、'1234'和[a-zA-Z]{4}。[a-zA-Z]{4}描述了一个可变字符串，该字符串长度为4，可用字符范围为'a'到'z'和'A'到'Z'；'1234'描述了一个常量字符串，该字符串在进行字符串随机生成时保持不变。以下几个示例为由该表达式随机生成的字符串：

```
oOVj1234sCin
ygfj1234Zcdj
zpJM1234Zjmp
......
```

## KiMen表达式

​	Kimen表达式主要由两类任意多个基本的子表达式组成，格式如下：

```
(VariantStrExpr|ConstantStrExpr)+
```

#### VariantStrExpr

​	表示可变字符串。Kimen将根据该表达式随机生成字符串。其格式如下：

```
'['charset']''{'min[,max]'}'
```

​	[charset]中描述了进行字符串随机生成时可用的字符。可用字符集两端使用'[]'包围，其字符描述包括以下三种格式：

1. 字符：如：[abcd]，abcd四个字符间不需要任何分隔符。
2. 字符区间：[0-9]，0-9表示从数字0到数字9
3. 字符字典：[\\a]，\a表示一个名字为a的字典，Kimen中所有的字符集字典都以一个字符命名。其可用的命名字符的范围没有限制，理论上你可以使用除[\\|'|"]号外的任何一个字符为字典命名。字符字典主要用于可选字符范围较大，在表达式中展开不方便的情况。字符字典，可通过Kimen的开发接口进行注册，字符串生成器会动态装载字符字典。字符字典可以让Kimen表达式看起来更清爽一些。'\\'字符为转义字符，当碰到该字符时表示，其后面的字符是字典名。需要额外注意的是，当需要在表达式中使用'\\'字符时，需要用两个'\\\\'字符来表达。

​	{min,max}中描述了可变字符串的长度，min表示随机生成字符串时的最小长度; max表示随机生成字符串时的最大长度，max可选。当只有min值时，表示按照固定长度生成字符串。

#### ConstantStrExpr

​	表示常量字符串。常量字符串用于描述字符串随机生成时，信息相对固定的部分。其表达格式如下：

```
'str'|"str"
```

​	如表达式所示，其有两种常量字符串格式：

​	'str'使用[']号做为常量字符串的包围符，其内部可以是除[']号外的任意字符，当需要在常量字符串中使用'''字符时，可使用[\\']或[''] (两个连续单引号)两种格式表达。

​	"str"使用["]号做为常量字符串的包围符，其内部可以是除["]号外的任意字符，当需要在常量字符串中使用["]字符时，可使用[\\"]表达。

## KiMen代码示例

#### 随机变长字符串示例

```
    // 随机字符串表达式
    String expr = "[a-zA-Z]{4}'1234'[a-zA-Z]{4,8}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    // 构造字符串生成器
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    // 循环输出生成的字符串
    for (int i = 0; i < 10; i++) {
      System.out.println(stringGenerator.generate());
    }
```

生成结果

```
SKDZ1234ODPC
NUvi1234dkYFvaJ
fAQJ1234KXJsbR
evZz1234ZUIvaLm
uHpi1234UPHlZH
AXQB1234KfUCwd
PuoR1234BeRBrR
NudR1234RSqoZM
SYpf1234wxEumY
slZK1234RPviU
```

#### 字符字典示例

```
    // 随机字符串表达式
    String expr = "[a-zA-Z]{4}\"1234\"[\\a\\d]{4}";
    KimenBuilder kimenBuilder = new KimenBuilder();
    // 设置字符字典a
    kimenBuilder.addCharSet('a',"bcd");
    // 设置字符字典d
    kimenBuilder.addCharSet('d',"123");
    // 构造字符串生成器
    StringGenerator stringGenerator = kimenBuilder.buildKimen(expr);
    // 循环输出生成的字符串
    for (int i = 0; i < 10; i++) {
      System.out.println(stringGenerator.generate());
    }
```

生成结果

```
rVQk1234dc33
HReP1234dcd1
dEyi12342dd2
hmaT1234322b
irsl12343dd2
vNDx1234c3dd
pfeW1234dbc1
rvlV1234211b
vEzz12341cc3
ndWD123412bd
```

#### Maven坐标

```
<dependency>
    <groupId>org.datayoo.kimen</groupId>
    <artifactId>kimen</artifactId>
    <version>1.0.0</version>
</dependency>
```

