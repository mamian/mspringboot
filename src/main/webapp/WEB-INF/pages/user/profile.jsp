<%-- 
    Document   : index
    Created on : 2016-7-5, 14:27:07
    Author     : mamian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户详情页</title>
        
        <style>
            .content{
                text-align: center;
                width: 100%;
                height: 90%;
            }
	</style>
    </head>
    <body>
        <div class="content">
            <h1>用户详情展示</h1>
            <table>
                <tr>
                    <td>用户id</td>
                    <td>${user.id}</td>
                </tr>
                <tr>
                    <td>用户名称</td>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <td>用户email</td>
                    <td>${user.email}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
