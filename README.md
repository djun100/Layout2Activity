Layout2Activity
===============

由layout布局文件自动生成activity代码<br>
约定：需要转换为Java代码的组件的id必须以m开头，如mBtnLogin<br>
还在手写private Button btnxxxx吗？<br>
还在手写btnxxxx=(Button)findViewById(R.id.btnxxxx);?<br>
太out了！<br>
在用注解框架？自定义注解？手写@InjectView(R.id.btnxxxx)?这样就觉得自己高级了吗？<br>
赶快试试这个工具吧！<br>
不用担心注解的低效率，不用担心注解错类型后找bug找半天找不到的困惑，只要是有规律的重复代码都可以这样扩展这个工具，欢迎大家一起来！
