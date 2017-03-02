<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<script>
    window.onload = function() {
        /**
         * 响应XML数据
         */
        document.getElementById("bt1").onclick = function() {
            var xmlHttp = getXMLHttpRequest();
            xmlHttp.onreadystatechange = function() {
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    alert("服务器响应结果：" + xmlHttp.responseXML);
                }
            };
            // 建立GET方式的请求连接
            // 一些浏览器（例如：IE）在发送相同的请求时，不会再发送请求，而是从缓存中返回数据：所以要加时间戳使每次的请求不同
            xmlHttp.open("GET", "${pageContext.request.contextPath}/responseXmlServlet?time=" + new Date().getTime());
            // 发送请求体
            xmlHttp.send(null);
        };

        /**
         * 响应JSON数据
         */
        document.getElementById("bt2").onclick = function() {
            var xmlHttp = getXMLHttpRequest();
            xmlHttp.onreadystatechange = function() {
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    alert("服务器响应结果：" + xmlHttp.responseText);
                }
            };
            // 建立POST方式的请求连接
            xmlHttp.open("POST", "${pageContext.request.contextPath}/responseJsonServlet?time=" + new Date().getTime());
            // 发送请求体
            xmlHttp.send("key=value");
        };
    };

    /**
     * 获取XMLHttpRequest对象
     */
    function getXMLHttpRequest() {
        var xmlHttp;
        try {
            // All browsers except IE5 and IE6
            xmlHttp = new XMLHttpRequest();
        }catch(e) {
            try {
                // IE
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            }catch(e) {
                try {
                    // IE with older system libraries
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }catch(e) {
                    alert("您的浏览器不支持AJAX！");
                    return null;
                }
            }
        }
        return xmlHttp;
    }
</script>
<body>
    <input type="button" id="bt1" value="响应XML数据"/>
    <input type="button" id="bt2" value="响应JSON数据"/>
</body>
</html>
