# 简介

## 已包含基础方法：

1.SessionUser 是Session的格式。读取过程在AuthService.currentUser
2.AuthService 见注释
3.随机数产生方法 RandomCharUtil.java
  getRandomNumberUpperLetterChar(int)即生成一串包含大写字母和数字的随机数，长度用形参int指定
4.isAuthenticated 方法可判断是否已经登录/是否登录超时。具体见注释。

## 编码规范

1.所有的Controller中，除了登录注册和找回密码以外，其他函数中先调用authService.isAuthenticated(response);
2.所有函数接受HttpServletResponse response参数。用@Param指定参数名、参数类型、参数默认值。
3.参数不需要限制POST或GET。上线时再指定POST/GET方法。
