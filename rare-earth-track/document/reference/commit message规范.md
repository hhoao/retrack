## commit message规范

用什么规范？现在市面上比较流行的方案是约定式提交规范（Conventional Commits），它受到了==Angular==提交准则的启发，并在很大程度上以其为依据。约定式提交规范是一种基于提交消息的轻量级约定。它提供了一组用于创建清晰的提交历史的简单规则；这使得编写基于规范的自动化工具变得更容易。这个约定与SemVer相吻合，在提交信息中描述新特性、bug 修复和破坏性变更。它的 message 格式如下:`<类型>[可选的作用域]: <描述> [可选的正文] [可选的脚注] `

commit message格式如下：

```text
<type>(<scope>): <subject>
<body>
<BLANK LINE>
<footer>
```

填写完毕后，husky会调用commitlint对message进行格式校验，默认规定type及subject为必填项。

任何git commit指令的option都能用在 git cz指令上, 例如git cz -a

## Commit message规范在rrd-fe落地使用情况

针对团队目前使用的情况，我们讨论后拟定了commit message每一部分的填写规则。

## 1. type

type为必填项，用于指定commit的类型，约定了feat、fix两个主要type，以及docs、style、build、refactor、revert五个特殊type，其余type暂不使用。

```text
# 主要type
feat:     增加新功能
fix:      修复bug

# 特殊type
docs:     只改动了文档相关的内容
style:    不影响代码含义的改动，例如去掉空格、改变缩进、增删分号
build:    构造工具的或者外部依赖的改动，例如webpack，npm
refactor: 代码重构时使用
revert:   执行git revert打印的message

# 暂不使用type
test:     添加测试或者修改现有测试
perf:     提高性能的改动
ci:       与CI（持续集成服务）有关的改动
chore:    不修改src或者test的其余修改，例如构建过程或辅助工具的变动
```

当一次改动包括主要type与特殊type时，统一采用主要type。

## 2. scope

scope也为必填项，用于描述改动的范围，格式为项目名/模块名，例如：node-pc/common rrd-h5/activity，而we-sdk不需指定模块名。如果一次commit修改多个模块，建议拆分成多次commit，以便更好追踪和维护。

## 3. body

body填写详细描述，主要描述改动之前的情况及修改动机，对于小的修改不作要求，但是重大需求、更新等必须添加body来作说明。

## 4. break changes

break changes指明是否产生了破坏性修改，涉及break changes的改动必须指明该项，类似版本升级、接口参数减少、接口删除、迁移等。

## 5. affect issues

​	affect issues指明是否影响了某个问题。。

## 6. Example

![img](https://pic3.zhimg.com/v2-99219283f7a3b33d49d27ea5ee59fae6_b.jpg)

