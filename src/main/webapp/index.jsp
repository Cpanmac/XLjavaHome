<%--
  Created by IntelliJ IDEA.
  User: 立
  Date: 4/30 0030
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">(function () {
        var calc = {
            /*
             函数，加法函数，用来得到精确的加法结果
             说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
             参数：arg1：第一个加数；arg2第二个加数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数）
             调用：Calc.Add(arg1,arg2,d)
             返回值：两数相加的结果
             */
            Add: function (arg1, arg2, d) {
                arg1 = arg1.toString(), arg2 = arg2.toString();
                var arg1Arr = arg1.split("."), arg2Arr = arg2.split("."), d1 = arg1Arr.length == 2 ? arg1Arr[1] : "", d2 = arg2Arr.length == 2 ? arg2Arr[1] : "";
                var maxLen = Math.max(d1.length, d2.length);
                var m = Math.pow(10, maxLen);
                var result = Number(((arg1 * m + arg2 * m) / m).toFixed(maxLen));
                var d = arguments[2];
                return typeof d === "number" ? Number((result).toFixed(d)) : result;
            },
            /*
             函数：减法函数，用来得到精确的减法结果
             说明：函数返回较为精确的减法结果。
             参数：arg1：第一个加数；arg2第二个加数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数
             调用：Calc.Sub(arg1,arg2)
             返回值：两数相减的结果
             */
            Sub: function (arg1, arg2) {
                return Calc.Add(arg1, -Number(arg2), arguments[2]);
            },
            /*
             函数：乘法函数，用来得到精确的乘法结果
             说明：函数返回较为精确的乘法结果。
             参数：arg1：第一个乘数；arg2第二个乘数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数)
             调用：Calc.Mul(arg1,arg2)
             返回值：两数相乘的结果
             */
            Mul: function (arg1, arg2) {
                var r1 = arg1.toString(), r2 = arg2.toString(), m, resultVal, d = arguments[2];
                m = (r1.split(".")[1] ? r1.split(".")[1].length : 0) + (r2.split(".")[1] ? r2.split(".")[1].length : 0);
                resultVal = Number(r1.replace(".", "")) * Number(r2.replace(".", "")) / Math.pow(10, m);
                return typeof d !== "number" ? Number(resultVal) : Number(resultVal.toFixed(parseInt(d)));
            },
            /*
             函数：除法函数，用来得到精确的除法结果
             说明：函数返回较为精确的除法结果。
             参数：arg1：除数；arg2被除数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数)
             调用：Calc.Div(arg1,arg2)
             返回值：arg1除于arg2的结果
             */
            Div: function (arg1, arg2) {
                var r1 = arg1.toString(), r2 = arg2.toString(), m, resultVal, d = arguments[2];
                m = (r2.split(".")[1] ? r2.split(".")[1].length : 0) - (r1.split(".")[1] ? r1.split(".")[1].length : 0);
                resultVal = Number(r1.replace(".", "")) / Number(r2.replace(".", "")) * Math.pow(10, m);
                return typeof d !== "number" ? Number(resultVal) : Number(resultVal.toFixed(parseInt(d)));
            },
            /*
             将数值四舍五入后格式化.
             @param num 数值(Number或者String)
             @param cent 要保留的小数位(Number)
             @param isThousand 是否需要千分位 0:不需要,1:需要(数值类型);
             @return 格式的字符串,如'1,234,567.45'
             @type String
             调用：Calc.FormatNumber(num,cent,isThousand)
             */
            FormatNumber: function formatNumber(num, cent, isThousand) {
                num = num.toString().replace(/\$|\,/g, '');
                if (isNaN(num))//检查传入数值为数值类型.
                    num = "0";
                if (isNaN(cent))//确保传入小数位为数值型数值.
                    cent = 0;
                cent = parseInt(cent);
                cent = Math.abs(cent);//求出小数位数,确保为正整数.
                if (isNaN(isThousand))//确保传入是否需要千分位为数值类型.
                    isThousand = 0;
                isThousand = parseInt(isThousand);
                if (isThousand < 0)
                    isThousand = 0;
                if (isThousand >= 1) //确保传入的数值只为0或1
                    isThousand = 1;
                sign = (num == (num = Math.abs(num)));//获取符号(正/负数)
//Math.floor:返回小于等于其数值参数的最大整数
                num = Math.floor(num * Math.pow(10, cent) + 0.50000000001);//把指定的小数位先转换成整数.多余的小数位四舍五入.
                cents = num % Math.pow(10, cent); //求出小数位数值.
                num = Math.floor(num / Math.pow(10, cent)).toString();//求出整数位数值.
                cents = cents.toString();//把小数位转换成字符串,以便求小数位长度.
                while (cents.length < cent) {//补足小数位到指定的位数.
                    cents = "0" + cents;
                }
                if (isThousand == 0) //不需要千分位符.
                    return (((sign) ? '' : '-') + num + '.' + cents);
//对整数部分进行千分位格式化.
                for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
                    num = num.substring(0, num.length - (4 * i + 3)) + ',' +
                            num.substring(num.length - (4 * i + 3));
                return (((sign) ? '' : '-') + num + '.' + cents);
            }
        };
        window.Calc = calc;
    }());</script>
</head>
<body>
测试111
</body>
</html>
