<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Facturacion</title>

    <style>
        div {
            text-align: center;
        }

        h1 {
            text-align: center;
            background: #00002E;
            color:#6098FF;
        }
        body {
            background: #00002E;
            color:#6098FF;
            font-family: Graphik,-apple-system,system-ui,"Segoe UI",Roboto,Oxygen,Ubuntu,Cantarell,"Fira Sans","Droid Sans","Helvetica Neue",sans-serif;
            font-size:16px;
        }
    </style>
</head>
<body>

<div>
    <h1>Factura Generada</h1>
    <pre>${factura.generarDetalle()}</pre>
</div>

</body>
</html>
